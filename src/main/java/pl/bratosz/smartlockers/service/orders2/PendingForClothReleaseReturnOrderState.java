package pl.bratosz.smartlockers.service.orders2;

import pl.bratosz.smartlockers.service.orders.toreturn.ReturnOrderStatus;

public class PendingForClothReleaseReturnOrderState implements MyReturnOrderState {

    @Override
    public ReturnOrderStatus getStatus() {
        return ReturnOrderStatus.PENDING_FOR_CLOTH_RELEASE;
    }

    @Override
    public void updateState(MyReturnOrder order) {
        order.actualState = new PendingForClothReturnReturnOrderState();
    }

    @Override
    public void updateCloth(MyCloth cloth, MyUser user) {

    }
}
