package pl.bratosz.smartlockers.service.orders.toreturn;

import pl.bratosz.smartlockers.exception.MyException;
import pl.bratosz.smartlockers.model.users.User;
import pl.bratosz.smartlockers.service.orders.ClothDomain;
import pl.bratosz.smartlockers.service.orders.MainClothesOrder;

import java.util.LinkedList;
import java.util.List;

public class ClothReturnOrder {

    private ClothToReturnState actualState;
    private MainClothesOrder mainOrder;
    private ClothToReturnStatus status;
    private List<ClothToReturnOrderStatusExtended> statusHistory;
    private ClothDomain clothToReturn;

    public static ClothReturnOrder create(ClothDomain c, MainClothesOrder m, User u) {
        ClothReturnOrder returnOrder = new ClothReturnOrder();
        returnOrder.mainOrder = m;
        returnOrder.createStatus(u);
        returnOrder.setClothToReturn(c);
        return returnOrder;
    }

    public void update(ClothDomain cloth, User user) {
        try {
            updateState(cloth);
            updateStatus(user);
            updateMainOrder()
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    private void updateState(ClothDomain cloth) throws MyException {
        actualState.updateStateByCloth(cloth, this);
    }

    public void update(User u) {
        updateState();
        updateStatus(u);
        updateCloth();
    }

    private void updateState() {
        actualState.updateState(mainOrder, this);
    }

    private void updateStatus(User u) {
        ClothToReturnStatus status = actualState.getStatus();
        if(statusHistory == null) statusHistory = new LinkedList<>();
        statusHistory.add(ClothToReturnOrderStatusExtended.create(status, u));

    }

    private void setClothToReturn(ClothDomain c) {
        clothToReturn = c;
        c.setReturnOrder(this);
    }

    private void createStatus(User u) {

    }

    private ClothReturnOrder() {
        this.actualState = new ClothToReturnPendingForAssignmentState();
    }

    void setState(ClothToReturnState s) {
        actualState = s;
    }
}
