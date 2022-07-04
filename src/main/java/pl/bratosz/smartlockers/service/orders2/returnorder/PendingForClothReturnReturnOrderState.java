package pl.bratosz.smartlockers.service.orders2.returnorder;

import pl.bratosz.smartlockers.model.clothes.ClothDestination;
import pl.bratosz.smartlockers.service.orders.toreturn.ReturnOrderStatus;

import pl.bratosz.smartlockers.service.orders2.MyCloth;
import pl.bratosz.smartlockers.service.orders2.MyClothStatusHistory;
import pl.bratosz.smartlockers.service.orders2.MyUser;

public class PendingForClothReturnReturnOrderState implements MyReturnOrderState {
    private final MyReturnOrder order;

    public PendingForClothReturnReturnOrderState(MyReturnOrder order) {
        this.order = order;
    }

    @Override
    public ReturnOrderStatus getStatus() {
        return ReturnOrderStatus.PENDING_FOR_RETURN;
    }

    @Override
    public void updateState() {
        order.actualState = new ReturnedReturnOrderState(order);
    }

    @Override
    public void updateCloth(MyUser user) {
        MyCloth cloth = order.getCloth();
        ClothDestination newDestination = ClothDestination.FOR_WITHDRAW;
        MyClothStatusHistory actualStatus = MyClothStatusHistory.create(newDestination, cloth, user);
        cloth.updateStatusHistory(actualStatus);
    }
}
