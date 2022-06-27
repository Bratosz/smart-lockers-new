package pl.bratosz.smartlockers.service.orders.toreturn;

import pl.bratosz.smartlockers.model.orders.ExchangeStrategy;
import pl.bratosz.smartlockers.service.orders.MainClothesOrder;

public class ClothToReturnPendingForAssignmentState implements ClothToReturnState {

    @Override
    public ClothToReturnStatus getStatus() {
        return ClothToReturnStatus.PENDING_FOR_ASSIGNMENT;
    }

    @Override
    public void updateState(MainClothesOrder mainOrder, ClothReturnOrder o) {
        ExchangeStrategy exchangeStrategy = mainOrder.getExchangeStrategy();
        switch(exchangeStrategy) {
            case PIECE_FOR_PIECE:
                o.setState(new ClothToReturnPendingForReturnState());
                break;
            case RELEASE_BEFORE_RETURN:
                o.setState(new ClothToReturnPendinForClothesReleaseState());
        }
    }
}
