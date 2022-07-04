package pl.bratosz.smartlockers.service.orders2.returnorder;

import pl.bratosz.smartlockers.model.clothes.ClothDestination;
import pl.bratosz.smartlockers.model.clothes.ClothStatus;
import pl.bratosz.smartlockers.service.orders.toreturn.ReturnOrderStatus;
import pl.bratosz.smartlockers.service.orders2.*;

import static pl.bratosz.smartlockers.service.orders.toreturn.ReturnOrderStatus.*;

public class FinalizedReturnOrderState implements MyReturnOrderState {
    private final MyReturnOrder order;

    public FinalizedReturnOrderState(MyReturnOrder order) {
        this.order = order;
    }

    @Override
    public ReturnOrderStatus getStatus() {
        return FINALIZED;
    }

    @Override
    public void updateState() {
    }

    @Override
    public void updateCloth(MyCloth cloth, MyUser user) {
        ClothStatus status = ClothStatus.WITHDRAWN;
        ClothDestination destination = ClothDestination.UNKNOWN;
        MyClothStatusHistory statusHistory = MyClothStatusHistory.create(
                status, destination, cloth, user);
        cloth.updateStatusHistory(statusHistory);
    }
}
