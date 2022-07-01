package pl.bratosz.smartlockers.service.orders.toreturn.state;

import pl.bratosz.smartlockers.service.orders.mainorder.MainClothesOrder;
import pl.bratosz.smartlockers.service.orders.toreturn.ReturnOrderStatus;

public class PendingForClothesReleaseState implements ReturnOrderState {
    @Override
    public ReturnOrderStatus getStatus() {
        return null;
    }

    @Override
    public void updateState(MainClothesOrder mainOrder, ClothReturnOrder u) {

    }
}
