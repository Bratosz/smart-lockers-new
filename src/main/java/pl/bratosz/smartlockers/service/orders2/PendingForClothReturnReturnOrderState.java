package pl.bratosz.smartlockers.service.orders2;

import pl.bratosz.smartlockers.model.clothes.ClothDestination;
import pl.bratosz.smartlockers.service.orders.toreturn.ReturnOrderStatus;

public class PendingForClothReturnReturnOrderState implements MyReturnOrderState {

    public PendingForClothReturnReturnOrderState() {
    }

    @Override
    public ReturnOrderStatus getStatus() {
        return ReturnOrderStatus.PENDING_FOR_RETURN;
    }

    @Override
    public void updateState(MyReturnOrder order) {
        order.actualState = new ReturnedReturnOrderState();
    }

    @Override
    public void updateCloth(MyCloth cloth, MyUser user) {
        ClothDestination newDestination = ClothDestination.FOR_WITHDRAW;
        MyClothStatusHistory actualStatus = MyClothStatusHistory.create(newDestination, cloth, user);
        cloth.updateStatusHistory(actualStatus);
    }
}
