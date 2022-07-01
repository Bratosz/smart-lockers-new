package pl.bratosz.smartlockers.service.orders.mainorder;

import pl.bratosz.smartlockers.service.orders.toreturn.state.ClothReturnOrder;

import java.util.List;

import static pl.bratosz.smartlockers.service.orders.toreturn.ReturnOrderStatus.RETURNED;

public class RealizedState implements MainOrderState {

    @Override
    public MainOrderStatus getStatus() {
        return MainOrderStatus.REALIZED_BUT_PENDING_FOR_CLOTH_RETURN;
    }

    @Override
    public void updateState(MainClothesOrder o) {
        List<ClothReturnOrder> returnOrders = o.getReturnOrders();
        if (isFinalized(returnOrders)) {
            o.setActualState(new FinalizedState());
        }
    }
    
    private boolean isFinalized(List<ClothReturnOrder> returnOrders) {
        return returnOrders.stream().allMatch(o -> o.getStatus().equals(RETURNED));
    }


}

