package pl.bratosz.smartlockers.service.orders2.returnorder;

import pl.bratosz.smartlockers.service.orders.toreturn.ReturnOrderStatus;
import pl.bratosz.smartlockers.service.orders2.MyCloth;
import pl.bratosz.smartlockers.service.orders2.MyUser;

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
