package pl.bratosz.smartlockers.service.orders2;

import pl.bratosz.smartlockers.model.clothes.Cloth;
import pl.bratosz.smartlockers.model.clothes.ClothDestination;
import pl.bratosz.smartlockers.model.clothes.ClothStatus;
import pl.bratosz.smartlockers.model.orders.ExchangeStrategy;
import pl.bratosz.smartlockers.service.orders.toreturn.ReturnOrderStatus;

import static pl.bratosz.smartlockers.model.clothes.ClothDestination.*;
import static pl.bratosz.smartlockers.model.clothes.ClothStatus.*;

public class ReturnedReturnOrderState implements MyReturnOrderState {
    private final MyReturnOrder order;

    public ReturnedReturnOrderState(MyReturnOrder order) {
        this.order = order;
    }

    @Override
    public ReturnOrderStatus getStatus() {
        return ReturnOrderStatus.RETURNED;
    }

    @Override
    public void updateState(MyReturnOrder order) {
        order.actualState = new FinalizedReturnOrderState();
    }

    @Override
    public void updateCloth(MyCloth cloth, MyUser user) {
        ExchangeStrategy exchangeStrategy = order.getExchangeStrategy();
        ClothStatus clothStatus = ACCEPTED;
        ClothDestination clothDestination = ClothDestination.UNKNOWN;
        switch (exchangeStrategy) {
            case PIECE_FOR_PIECE:
                clothDestination = FOR_EXCHANGE;
            case RELEASE_BEFORE_RETURN:
                clothDestination = FOR_WITHDRAW;
        }
        MyClothStatusHistory actualStatus = MyClothStatusHistory.create(
                clothStatus, clothDestination, cloth, user);
        cloth.updateStatusHistory(actualStatus);
    }
}
