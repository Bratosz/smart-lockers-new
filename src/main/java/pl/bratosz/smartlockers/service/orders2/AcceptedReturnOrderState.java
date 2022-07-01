package pl.bratosz.smartlockers.service.orders2;

import pl.bratosz.smartlockers.service.orders.toreturn.ReturnOrderStatus;

public class AcceptedReturnOrderState implements MyReturnOrderState {
    @Override
    public ReturnOrderStatus getStatus() {
        return ReturnOrderStatus.PENDING_FOR_RETURN;
    }

    @Override
    public void updateState(MyReturnOrder order) {

    }

    @Override
    public void updateClothes
}
