package pl.bratosz.smartlockers.service.orders2;

import pl.bratosz.smartlockers.model.clothes.ClothSize;
import pl.bratosz.smartlockers.model.clothes.ClothStatus;
import pl.bratosz.smartlockers.model.orders.ExchangeStrategy;
import pl.bratosz.smartlockers.model.orders.OrderType;
import pl.bratosz.smartlockers.service.orders2.returnorder.MyReturnOrder;

import javax.print.DocFlavor;
import java.util.LinkedList;
import java.util.List;

public class MyMainOrder {
    private OrderType orderType;
    private ClothSize size;
    private MyClientArticle clientArticle;
    protected MyMainOrderState actualState;
    private List<MyMainOrderStatusHistory> statusHistory;
    private MyEmployee employee;
    private ExchangeStrategy exchangeStrategy;
    private List<MyClothReleaseOrder> clothReleaseOrders;
    private List<MyReturnOrder> clothReturnOrders;

    public static MyMainOrder create(OrderParameters p) {
        MyMainOrder o = new MyMainOrder();
        o.orderType = p.getOrderType();
        o.size = p.getSize();
        o.clientArticle = p.getClientArticle();
        o.employee = p.getEmployee();
        o.exchangeStrategy = p.getExchangeStrategy();
        o.actualState = createInitialState(p);
        o.updateStatus(p.getUser());
        o.createOrders(p);
        return o;
    }

    public void updateForClothReturn(MyReturnOrder returnOrder, MyUser user) {
        if(exchangeStrategy.equals(ExchangeStrategy.PIECE_FOR_PIECE)) {
            setOneToRelease(user);
        }
    }

    private void setOneToRelease(MyUser user) {
        clothReleaseOrders.stream().findFirst().get().update();
    }

    private void updateStatus(MyUser user) {
        if(statusHistory == null) statusHistory = new LinkedList<>();
        MyMainOrderStatusHistory actualOrderStatus = new MyMainOrderStatusHistory(actualState.getStatus(), user);
        statusHistory.add(actualOrderStatus);
    }

    private static MyMainOrderState createInitialState(OrderParameters p) {
        MyMainOrderStatus initialStatus = p.getUser().getInitialStatusForOrders();
        switch (initialStatus) {
            case ACCEPTED:
            default:
                return new AcceptedMainOrderState();
        }
    }

    private void createOrders(OrderParameters p) {
        switch (orderType) {
            case CHANGE_ARTICLE:
            case CHANGE_SIZE:
            case EXCHANGE_FOR_NEW_ONE:
                createReturnOrders(p);
                createReleaseOrders(p);
                break;
            case NEW_ARTICLE:
                createReleaseOrders(p);
        }
    }

    private void createReleaseOrders(OrderParameters p) {
    }

    private void createReturnOrders(OrderParameters p) {
        List<MyReturnOrder> clothReturnOrders = new LinkedList<>();
        for (MyCloth cloth : p.getClothesToChange()) {
            MyReturnOrder order = MyReturnOrder.create(cloth, this, p.getUser());
            clothReturnOrders.add(order);
        }
        this.clothReturnOrders = clothReturnOrders;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public ClothSize getSize() {
        return size;
    }

    public MyClientArticle getClientArticle() {
        return clientArticle;
    }

    public MyMainOrderStatus getStatus() {
        if (statusHistory == null) return MyMainOrderStatus.UNKNOWN;
        return statusHistory.get(statusHistory.size() - 1).getStatus();
    }

    public MyMainOrderStatusHistory getActualStatus() {
        if(statusHistory == null) return new MyMainOrderStatusHistory(MyMainOrderStatus.UNKNOWN, new MyUser());
        return statusHistory.get(statusHistory.size() - 1);
    }

    public ExchangeStrategy getExchangeStrategy() {
        return exchangeStrategy;
    }
}
