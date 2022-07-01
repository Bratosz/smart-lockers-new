package pl.bratosz.smartlockers.service.orders.toreturn.state;

import pl.bratosz.smartlockers.exception.MyException;
import pl.bratosz.smartlockers.model.users.User;
import pl.bratosz.smartlockers.service.orders.ClothDomain;
import pl.bratosz.smartlockers.service.orders.mainorder.MainClothesOrder;
import pl.bratosz.smartlockers.service.orders.toreturn.ReturnOrderStatusExtended;
import pl.bratosz.smartlockers.service.orders.toreturn.ReturnOrderStatus;

import java.util.LinkedList;
import java.util.List;

public class ClothReturnOrder {

    private ReturnOrderState actualState;
    private MainClothesOrder mainOrder;
    private List<ReturnOrderStatusExtended> statusHistory;
    private ClothDomain clothToReturn;

    public static ClothReturnOrder create(ClothDomain c, MainClothesOrder m, User u) {
        ClothReturnOrder returnOrder = new ClothReturnOrder();
        returnOrder.mainOrder = m;
        returnOrder.createStatus(u);
        returnOrder.setClothToReturn(c);
        return returnOrder;
    }

    public void update(ClothDomain cloth, User user) {
        try {
            updateState(cloth);
            updateStatus(user);
            updateMainOrder(user);
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    private void updateMainOrder(User user) {
        mainOrder.update(this, user);
    }

    private void updateState(ClothDomain cloth) throws MyException {
        actualState.updateStateByCloth(cloth, this);
    }

    public void update(User u) {
        updateState();
        updateStatus(u);
        updateCloth();
    }

    private void updateState() {
        actualState.updateState(mainOrder, this);
    }

    private void updateStatus(User u) {
        ReturnOrderStatus status = actualState.getStatus();
        if(statusHistory == null) statusHistory = new LinkedList<>();
        statusHistory.add(ReturnOrderStatusExtended.create(status, u));

    }

    private void setClothToReturn(ClothDomain c) {
        clothToReturn = c;
        c.setReturnOrder(this);
    }

    private void createStatus(User u) {

    }

    public ReturnOrderStatus getStatus() {
        if(getStatusHistory().isEmpty()) return ReturnOrderStatus.UNKNOWN;
        return getStatusHistory().get(getStatusHistory().size() - 1).getStatus();
    }

    public List<ReturnOrderStatusExtended> getStatusHistory() {
        if(statusHistory == null) return new LinkedList<>();
        return statusHistory;
    }

    private ClothReturnOrder() {
        this.actualState = new PendingForAssignmentOrderState();
    }

    void setState(ReturnOrderState s) {
        actualState = s;
    }
}
