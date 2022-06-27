package pl.bratosz.smartlockers.service.orders.toreturn;

import pl.bratosz.smartlockers.service.orders.MainClothesOrder;

public class ClothToReturnPendinForClothesReleaseState implements ClothToReturnState {
    @Override
    public ClothToReturnStatus getStatus() {
        return null;
    }

    @Override
    public void updateState(MainClothesOrder mainOrder, ClothReturnOrder u) {

    }
}
