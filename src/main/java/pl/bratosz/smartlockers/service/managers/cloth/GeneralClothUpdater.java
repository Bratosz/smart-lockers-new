package pl.bratosz.smartlockers.service.managers.cloth;

import pl.bratosz.smartlockers.model.Employee;
import pl.bratosz.smartlockers.model.Position;
import pl.bratosz.smartlockers.model.clothes.Cloth;
import pl.bratosz.smartlockers.service.ClothService;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;


public class GeneralClothUpdater {
    private List<Cloth> priorClothes;
    private List<Cloth> actualClothes;
    private List<Cloth> assignedClothes;
    private List<Cloth> beforeReleaseClothes;
    private List<Cloth> withdrawnedClothes;
    private List<Cloth> recentlyAddedClothes;
    private SingleClothUpdater singleClothUpdater;
    private Employee employee;
    private boolean isRotational;
    private ClothService clothService;
    private static LocalDate INITIAL_DATE = LocalDate.of(1970, 1, 1);

    public GeneralClothUpdater(
            List<Cloth> priorClothes,
            List<Cloth> actualClothes,
            Employee employee,
            ClothService clothService) {
        this.employee = employee;
        this.isRotational = employeeIsRotational(employee);
        this.clothService = clothService;
        this.priorClothes = priorClothes;
        this.actualClothes = actualClothes;
        this.assignedClothes = popAssignedClothesFromPriorToAssigned();
        this.beforeReleaseClothes = popBeforeReleaseClothesFromPriorClothes();
        this.withdrawnedClothes = popWithdrawnedClothesFromPriorClothes();
        this.recentlyAddedClothes = popRecentlyAddedClothesFromActualClothes();
        this.singleClothUpdater = new SingleClothUpdater(clothService);
    }

    public void update() {
        updateWashedClothes();
        updateAssignedClothes();
        updateRecentlyAddedClothes();
        updateBeforeReleaseClothse();
        updateWithdrawnClothes();
    }

    private void updateWashedClothes() {
        priorClothes.forEach(pc -> pc.setLastWashing(actualClothes.stream()
                .filter(ac -> ac.equals(pc))
                .findFirst().get().getLastWashing()));
        clothService.getClothesRepository().saveAll(priorClothes);
    }

    private void updateBeforeReleaseClothse() {
        beforeReleaseClothes.forEach(bc -> {
            if(clothIsRecentlyReleased(bc)) {
                Cloth recentlyReleasedCloth = popByEquals(bc, actualClothes);
                singleClothUpdater.updateReleasedCloth(bc, recentlyReleasedCloth);
            }
        });
    }
    
    private void updateAssignedClothes() {
        List<Cloth> clothesToRemove = new LinkedList<>();
        assignedClothes.forEach(c -> {
            if (clothIsRecentlyAdded(c)) {
                Cloth recentlyAddedCloth = popByCompare(c, recentlyAddedClothes);
                singleClothUpdater.updateAssignedCloth(c, recentlyAddedCloth);
            } else {
                clothesToRemove.add(c);
            }
        });
        assignedClothes.removeAll(clothesToRemove);
    }

    private void updateRecentlyAddedClothes() {
        recentlyAddedClothes.forEach(c -> {
            c.setEmployee(employee);
            c.setRotational(isRotational);
        });
        clothService.getClothesRepository().saveAll(recentlyAddedClothes);
    }

    private void updateWithdrawnClothes() {
        withdrawnedClothes.forEach(c -> {
            singleClothUpdater.updateWithdrawnCloth(c);
        });
    }


    private Cloth popByCompare(Cloth cloth, List<Cloth> from) {
        Cloth popped = from.stream()
                .filter(c -> c.compareTo(cloth) == 0)
                .findFirst()
                .get();
        from.remove(popped);
        return popped;
    }

    private Cloth popByEquals(Cloth cloth, List<Cloth> from) {
        Cloth popped = from.stream()
                .filter(c -> c.equals(cloth))
                .findFirst()
                .get();
        from.remove(popped);
        return popped;
    }

    private boolean clothIsRecentlyAdded(Cloth cloth) {
        return recentlyAddedClothes.stream()
                .anyMatch(c -> c.compareTo(cloth) == 0);
    }

    private boolean clothIsRecentlyReleased(Cloth bc) {
        return actualClothes.stream()
                .filter(ac -> ac.equals(bc))
                .anyMatch(ac -> ac.getReleaseDate().isAfter(INITIAL_DATE));

    }

    private List<Cloth> popBeforeReleaseClothesFromPriorClothes() {
        List<Cloth> beforeReleaseClothes = new LinkedList<>();
        List<Cloth> clothesToRemove = new LinkedList<>();
        priorClothes.forEach(c -> {
            if (c.getReleaseDate().equals(INITIAL_DATE)) {
                clothesToRemove.add(c);
                beforeReleaseClothes.add(c);
            }
        });
        priorClothes.removeAll(clothesToRemove);
        clothesToRemove.clear();
        return beforeReleaseClothes;
    }

    private List<Cloth> popAssignedClothesFromPriorToAssigned() {
        List<Cloth> assignedClothes = new LinkedList<>();
        List<Cloth> clothesToRemove = new LinkedList<>();
        priorClothes.forEach(c -> {
            if (c.getBarcode() == 0) {
                clothesToRemove.add(c);
                assignedClothes.add(c);
            }
        });
        priorClothes.removeAll(clothesToRemove);
        return assignedClothes;
    }

    private List<Cloth> popWithdrawnedClothesFromPriorClothes() {
        List<Cloth> deletedClothes = new LinkedList<>();
        List<Cloth> clothesToRemove = new LinkedList<>();
        priorClothes.forEach(c -> {
            if (!actualClothes.contains(c)) {
                clothesToRemove.add(c);
                deletedClothes.add(c);
            }
        });
        priorClothes.removeAll(clothesToRemove);
        return deletedClothes;
    }

    private List<Cloth> popRecentlyAddedClothesFromActualClothes() {
        List<Cloth> newClothes = new LinkedList<>();
        List<Cloth> clothesToRemove = new LinkedList<>();
        actualClothes.forEach(c -> {
            if (!priorClothes.contains(c)) {
                clothesToRemove.add(c);
                newClothes.add(c);
            }
        });
        actualClothes.removeAll(clothesToRemove);
        return newClothes;
    }

    private boolean employeeIsRotational(Employee employee) {
        Position position = employee.getPosition();
        if (position != null && position.getName().equals("ROTACJA"))
            return true;
        else
            return false;
    }

}


