package pl.bratosz.smartlockers.service.orders2.returnorder;

import pl.bratosz.smartlockers.model.clothes.ClothStatus;
import pl.bratosz.smartlockers.model.orders.ExchangeStrategy;
import pl.bratosz.smartlockers.service.orders2.*;

import java.util.LinkedList;
import java.util.List;

import static pl.bratosz.smartlockers.model.orders.ExchangeStrategy.PIECE_FOR_PIECE;
import static pl.bratosz.smartlockers.model.orders.ExchangeStrategy.RELEASE_BEFORE_RETURN;

public class MyReturnOrder {

    private long id;
    private MyMainOrder mainOrder;
    protected MyReturnOrderState actualState;
    private List<MyReturnOrderStatusHistory> statusHistory;
    private MyCloth cloth;


    public static MyReturnOrder create(MyCloth cloth, MyMainOrder mainOrder, MyUser user) {
        MyReturnOrder o = new MyReturnOrder();
        o.mainOrder = mainOrder;
        o.actualState = createInitialState(mainOrder.getStatus(), mainOrder.getExchangeStrategy());
        o.updateStatus(user);
        o.setClothToReturn(cloth, user);
        return o;
    }

    public void update(MyUser user) {
        actualState.updateState();
        updateStatus(user);
        actualState.updateCloth(user);
        mainOrder.update(this, user);
    }

    public ClothStatus getStatus() {
        return cloth.getActualStatusHistory()
    }

    private void updateStatus(MyUser user) {
        if(statusHistory == null) statusHistory = new LinkedList<>();
        MyReturnOrderStatusHistory actualStatus = new MyReturnOrderStatusHistory(actualState.getStatus(), user);
        statusHistory.add(actualStatus);
    }

    private static MyReturnOrderState createInitialState(MyMainOrderStatus actualStatus, ExchangeStrategy exchangeStrategy) {
        switch (actualStatus) {
            case ACCEPTED:
                if(exchangeStrategy.equals(PIECE_FOR_PIECE)) {
                    return new PendingForClothReturnReturnOrderState();
                } else if(exchangeStrategy.equals(RELEASE_BEFORE_RETURN)) {
                    return new PendingForClothReleaseReturnOrderState();
                }
        }
    }

    protected ExchangeStrategy getExchangeStrategy() {
        return mainOrder.getExchangeStrategy();
    }

    private void setClothToReturn(MyCloth cloth, MyUser user) {
        this.cloth = cloth;
        actualState.updateCloth(cloth, user);
    }

    public MyCloth getCloth() {
        return cloth;
    }
}
