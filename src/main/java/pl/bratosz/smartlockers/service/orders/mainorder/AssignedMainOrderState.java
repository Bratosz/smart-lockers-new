package pl.bratosz.smartlockers.service.orders.mainorder;

import pl.bratosz.smartlockers.service.orders.torelease.ClothReleaseOrder;
import pl.bratosz.smartlockers.service.orders.toreturn.state.ClothReturnOrder;

import java.util.List;

import static pl.bratosz.smartlockers.service.orders.toreturn.ReturnOrderStatus.RETURNED;

public class AssignedMainOrderState implements MainOrderState {

    @Override
    public MainOrderStatus getStatus() {
        return MainOrderStatus.ASSIGNED;
    }

    @Override
    public void updateReturnOrders() {

    }

    @Override
    public void updateState(MainClothesOrder o) {
        List<ClothReleaseOrder> releaseOrders = o.getReleaseOrders();
        List<ClothReturnOrder> returnOrders = o.getReturnOrders();
        if(isFinalized(releaseOrders, returnOrders)) {
            o.setActualState(new FinalizedState());
        } else if(isRealized(releaseOrders)) {
            o.setActualState(new RealizedState());
        }
    }

    private boolean isFinalized(List<ClothReleaseOrder> releaseOrders, List<ClothReturnOrder> returnOrders) {
        return returnOrders.stream().allMatch(o -> o.getStatus().equals(RETURNED)) && isRealized(releaseOrders);
    }

    private boolean isRealized(List<ClothReleaseOrder> releaseOrders) {
        return true;
    }
}
