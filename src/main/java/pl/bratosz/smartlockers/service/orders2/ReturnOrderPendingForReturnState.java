package pl.bratosz.smartlockers.service.orders2;

import pl.bratosz.smartlockers.service.orders.toreturn.ReturnOrderStatus;

public class ReturnOrderPendingForReturnState implements MyReturnOrderState {
    private MyReturnOrder returnOrder;

    public ReturnOrderPendingForReturnState(MyReturnOrder myReturnOrder) {
        this.returnOrder = myReturnOrder;
    }

    @Override
    public ReturnOrderStatus getStatus() {
        return ReturnOrderStatus.PENDING_FOR_RETURN;
    }

    @Override
    public void updateState() {
        returnOrder.state = new ReturnOrderReturnedState(returnOrder);
    }

    @Override
    public void updateCloth(MyCloth cloth) {

    }
}
