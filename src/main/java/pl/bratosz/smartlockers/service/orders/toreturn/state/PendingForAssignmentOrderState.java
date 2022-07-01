package pl.bratosz.smartlockers.service.orders.toreturn.state;

import pl.bratosz.smartlockers.model.orders.ExchangeStrategy;
import pl.bratosz.smartlockers.service.orders.mainorder.MainClothesOrder;
import pl.bratosz.smartlockers.service.orders.toreturn.ReturnOrderStatus;

public class PendingForAssignmentOrderState implements ReturnOrderState {

    @Override
    public ReturnOrderStatus getStatus() {
        return ReturnOrderStatus.PENDING_FOR_ASSIGNMENT;
    }

    @Override
    public void updateState(MainClothesOrder mainOrder, ClothReturnOrder o) {
        ExchangeStrategy exchangeStrategy = mainOrder.getExchangeStrategy();
        switch(exchangeStrategy) {
            case PIECE_FOR_PIECE:
                o.setState(new PendingForReturnState());
                break;
            case RELEASE_BEFORE_RETURN:
                o.setState(new PendingForClothesReleaseState());
        }
    }
}
