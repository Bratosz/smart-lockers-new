package pl.bratosz.smartlockers.service.orders.mainorder;

import pl.bratosz.smartlockers.service.orders.mainorder.MainClothesOrder;
import pl.bratosz.smartlockers.service.orders.mainorder.MainOrderState;
import pl.bratosz.smartlockers.service.orders.mainorder.MainOrderStatus;

public class FinalizedState implements MainOrderState {

    @Override
    public MainOrderStatus getStatus() {
        return MainOrderStatus.FINALIZED;
    }

    @Override
    public void updateState(MainClothesOrder mainOrder) {

    }
}
