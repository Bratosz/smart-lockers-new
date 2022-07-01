package pl.bratosz.smartlockers.service.orders2;

import pl.bratosz.smartlockers.exception.MyException;
import pl.bratosz.smartlockers.model.clothes.ClothSize;
import pl.bratosz.smartlockers.model.orders.ExchangeStrategy;
import pl.bratosz.smartlockers.model.orders.OrderType;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderParameters {
    private Set<MyCloth> clothes;
    private MyEmployee employee;
    private OrderType orderType;
    private ExchangeStrategy exchangeStrategy;
    private MyUser user;
    private ClothSize size;
    private MyClientArticle clientArticle;
    private boolean thereIsOrderToExtend;
    private MyMainOrder orderToExtend;

    public static OrderParameters createForExchange(MyEmployee employee, Set<MyCloth> clothes, MyClient client, MyUser user) throws MyException {
        OrderType orderType = OrderType.EXCHANGE_FOR_NEW_ONE;
        if(ClothesForOrderValidator.clothesIsValid(clothes, orderType)) {
            OrderParameters p = new OrderParameters();
            MyCloth cloth = clothes.stream().findFirst().get();
            p.size = cloth.getSize();
            p.clientArticle = cloth.getClientArticle();
            p.clothes = clothes;
            p.employee = employee;
            p.orderType = orderType;
            p.exchangeStrategy = client.getExchangeStrategy(orderType);
            p.user = user;
            if(p.getOrdersToExtend().size() == 1) {
                p.thereIsOrderToExtend = true;
                p.orderToExtend = p.getOrdersToExtend().get(0);
            }
            return p;
        } else {
            throw new MyException("Clothes in order for employee: " + employee.getId() + " are invalid");
        }
    }

    private List<MyMainOrder> getOrdersToExtend() {
        return employee.getMainOrders().stream()
                .filter(o -> o.getStatus().equals(user.getInitialStatusForOrders()))
                .filter(o -> o.getOrderType().equals(orderType))
                .filter(o -> o.getClientArticle().equals(clientArticle))
                .filter(o -> o.getSize().equals(size))
                .collect(Collectors.toList());
    }

    public Set<MyCloth> getClothesToChange() {
        return clothes;
    }

    public void setClothes(Set<MyCloth> clothes) {
        this.clothes = clothes;
    }

    public MyEmployee getEmployee() {
        return employee;
    }

    public void setEmployee(MyEmployee employee) {
        this.employee = employee;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public ExchangeStrategy getExchangeStrategy() {
        return exchangeStrategy;
    }

    public void setExchangeStrategy(ExchangeStrategy exchangeStrategy) {
        this.exchangeStrategy = exchangeStrategy;
    }

    public MyUser getUser() {
        return user;
    }

    public void setUser(MyUser user) {
        this.user = user;
    }

    public ClothSize getSize() {
        return size;
    }

    public void setSize(ClothSize size) {
        this.size = size;
    }

    public MyClientArticle getClientArticle() {
        return clientArticle;
    }

    public void setClientArticle(MyClientArticle clientArticle) {
        this.clientArticle = clientArticle;
    }

    public boolean isThereIsOrderToExtend() {
        return thereIsOrderToExtend;
    }

    public void setThereIsOrderToExtend(boolean thereIsOrderToExtend) {
        this.thereIsOrderToExtend = thereIsOrderToExtend;
    }

    public MyMainOrder getOrderToExtend() {
        return orderToExtend;
    }

    public void setOrderToExtend(MyMainOrder orderToExtend) {
        this.orderToExtend = orderToExtend;
    }
}
