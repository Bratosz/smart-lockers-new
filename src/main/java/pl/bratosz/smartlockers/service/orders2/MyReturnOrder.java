package pl.bratosz.smartlockers.service.orders2;

import pl.bratosz.smartlockers.model.orders.ExchangeStrategy;
import pl.bratosz.smartlockers.service.orders.toreturn.ReturnOrderStatus;

import java.util.LinkedList;
import java.util.List;

import static pl.bratosz.smartlockers.service.orders.toreturn.ReturnOrderStatus.*;

public class MyReturnOrder {

    private long id;
    private MyMainOrder mainOrder;
    private List<MyReturnOrderStatusHistory> statusHistory;
    protected MyReturnOrderState state;
    private MyCloth cloth;


    public static MyReturnOrder create(MyCloth cloth, MyMainOrder mainOrder, MyUser user) {
        MyReturnOrder o = new MyReturnOrder();
        o.mainOrder = mainOrder;
        o.statusHistory = createInitialStatus(mainOrder.getExchangeStrategy(), user);
        o.createState();
        o.setClothToReturn(cloth);
    }

    private void createState() {
        ReturnOrderStatus status = getStatus();
        switch (status) {
            case PENDING_FOR_RETURN:
            default:
                this.state = new ReturnOrderPendingForReturnState(this);
        }
    }

    private ReturnOrderStatus getStatus() {
        if (statusHistory == null) return UNKNOWN;
        else return statusHistory.get(statusHistory.size() - 1).getOrderStatus();
    }

    private static MyReturnOrderState createInitialState(MyMainOrderStatus initialStatus) {
        switch (initialStatus) {
            case ACCEPTED:
            default:
                return new AcceptedReturnOrderState(this);
        }
    }

    private void setClothToReturn(MyCloth cloth) {
        this.cloth = cloth;
        state.updateCloth(cloth);
    }

    private static List<MyReturnOrderStatusHistory> createInitialStatus(ExchangeStrategy exchangeStrategy, MyUser user) {
        List<MyReturnOrderStatusHistory> statusHistory = new LinkedList<>();
        MyReturnOrderStatusHistory returnStatus;
        if (exchangeStrategy.equals(ExchangeStrategy.PIECE_FOR_PIECE)) {
            returnStatus = new MyReturnOrderStatusHistory(PENDING_FOR_RETURN, user);
        } else {
            returnStatus = new MyReturnOrderStatusHistory(PENDING_FOR_CLOTH_RELEASE, user);
        }
        statusHistory.add(returnStatus);
        return statusHistory;
    }
}
