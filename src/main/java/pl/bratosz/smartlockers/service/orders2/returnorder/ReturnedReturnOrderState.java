package pl.bratosz.smartlockers.service.orders2.returnorder;

import pl.bratosz.smartlockers.model.clothes.ClothDestination;
import pl.bratosz.smartlockers.model.clothes.ClothStatus;
import pl.bratosz.smartlockers.model.orders.ExchangeStrategy;
import pl.bratosz.smartlockers.service.orders.toreturn.ReturnOrderStatus;
import pl.bratosz.smartlockers.service.orders2.MyCloth;
import pl.bratosz.smartlockers.service.orders2.MyClothStatusHistory;
import pl.bratosz.smartlockers.service.orders2.MyUser;


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
    public void updateState() {
        order.actualState = new FinalizedReturnOrderState(order);
    }

    @Override
    public void updateCloth(MyUser user) {
        MyCloth cloth = order.getCloth();
        ExchangeStrategy exchangeStrategy = order.getExchangeStrategy();
        ClothStatus clothStatus = ACCEPTED;
        ClothDestination clothDestination = ClothDestination.UNKNOWN;
        switch (exchangeStrategy) {
            case PIECE_FOR_PIECE:
                clothDestination = FOR_EXCHANGE;
                break;
            case RELEASE_BEFORE_RETURN:
                clothDestination = FOR_WITHDRAW;
                break;
        }
        MyClothStatusHistory actualStatus = MyClothStatusHistory.create(
                clothStatus, clothDestination, cloth, user);
        cloth.updateStatusHistory(actualStatus);
    }
}
