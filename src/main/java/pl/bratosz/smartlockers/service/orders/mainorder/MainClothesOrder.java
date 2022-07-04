package pl.bratosz.smartlockers.service.orders.mainorder;

import pl.bratosz.smartlockers.model.Client;
import pl.bratosz.smartlockers.model.ClientArticle;
import pl.bratosz.smartlockers.model.Employee;
import pl.bratosz.smartlockers.model.clothes.Cloth;
import pl.bratosz.smartlockers.model.clothes.ClothSize;
import pl.bratosz.smartlockers.model.clothes.LengthModification;
import pl.bratosz.smartlockers.model.orders.ExchangeStrategy;
import pl.bratosz.smartlockers.model.orders.OrderType;
import pl.bratosz.smartlockers.model.users.User;
import pl.bratosz.smartlockers.service.orders.ChangeSizeOrdersCreator;
import pl.bratosz.smartlockers.service.orders.torelease.ClothReleaseOrder;
import pl.bratosz.smartlockers.service.orders.toreturn.state.ClothReturnOrder;
import pl.bratosz.smartlockers.service.orders2.AssignedMainOrderState;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class MainClothesOrder {

    private MainOrderState actualState;
    private OrderType orderType;
    private ClothSize desiredSize;
    private ClientArticle desiredArticle;
    private LengthModification lengthModification;
    private Employee employee;
    private ExchangeStrategy exchangeStrategy;
    private String description;
    private List<MainOrderStatusExtended> orderStatusHistory;
    private List<ClothReleaseOrder> clothReleaseOrders;
    private List<ClothReturnOrder> clothReturnOrders;

    public static MainClothesOrder createForChangeSize(
            ClothSize desiredSize,
            LengthModification lengthModification,
            Set<Cloth> clothes,
            Client client,
            User user) {
        MainClothesOrder mainOrder = new MainClothesOrder(user);
        mainOrder.orderType = OrderType.CHANGE_SIZE;
        mainOrder.desiredSize = desiredSize;
        mainOrder.lengthModification = lengthModification;
        mainOrder.setEmployee(clothes);
        mainOrder.exchangeStrategy = client.getExchangeStrategies().get(mainOrder.orderType);
        mainOrder.updateStatus(user);
        mainOrder.setChangeSizeClothOrders(clothes, user);
        return mainOrder;
    }

    public void update(ClothReturnOrder clothReturnOrder, User user) {
        updateState();
        updateStatus(user);
        updateClothReleaseOrders(user);
    }

    private void updateClothReleaseOrders(User user) {
        if(exchangeStrategy.equals(ExchangeStrategy.PIECE_FOR_PIECE)) {

        }
    }

    private void updateState() {
        actualState.updateState(this);
    }

    public void setAssigned(User u) {
        this.actualState = new AssignedMainOrderState(this, u);
        updateStatus(u);
        updateClothOrders(u);
    }

    public ExchangeStrategy getExchangeStrategy() {
        return exchangeStrategy;
    }

    private void updateClothOrders(User u) {
        clothReturnOrders.forEach(o -> o.update(u));
    }

    private void updateStatus(User user) {
        MainOrderStatus status = actualState.getStatus();
        if(orderStatusHistory == null) orderStatusHistory = new LinkedList<>();
        orderStatusHistory.add(MainOrderStatusExtended.create(status, user));
    }

    private void setChangeSizeClothOrders(Set<Cloth> clothes, User user) {
        ChangeSizeOrdersCreator oc = new ChangeSizeOrdersCreator(this);
        clothReturnOrders = oc.getReturnOrders(clothes, user);
        clothReleaseOrders = oc.getReleaseOrders(clothes);
    }

    private void setEmployee(Set<Cloth> clothes) {
        employee = clothes.stream().findFirst().get().getEmployee();
    }



    private MainClothesOrder(User user) {
        switch (user.getInitialStageForOrders()) {
            case POSTED:
            case REQUESTED:
            case ACCEPTED:
                this.actualState = new AcceptedMainOrderState();
        }
    }

    public List<ClothReleaseOrder> getReleaseOrders() {
        if(clothReleaseOrders == null) return new LinkedList<>();
        return clothReleaseOrders;
    }

    public List<ClothReturnOrder> getReturnOrders() {
        if(clothReleaseOrders == null) return new LinkedList<>();
        return clothReturnOrders;
    }

    public void setActualState(MainOrderState s) {
        actualState = s;
    }
}
