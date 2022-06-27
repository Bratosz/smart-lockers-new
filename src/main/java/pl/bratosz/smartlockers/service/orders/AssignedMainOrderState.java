package pl.bratosz.smartlockers.service.orders;

import org.hibernate.id.Assigned;
import pl.bratosz.smartlockers.model.users.User;

public class AssignedMainOrderState implements MainOrderState {
    private final MainClothesOrder mainClothesOrder;
    private final User user;

    public AssignedMainOrderState(MainClothesOrder mainClothesOrder, User u) {
        this.mainClothesOrder = mainClothesOrder;
        this.user = u;
    }

    @Override
    public MainOrderStatus getStatus() {
        return MainOrderStatus.ASSIGNED;
    }

    @Override
    public void updateReturnOrders() {

    }
}
