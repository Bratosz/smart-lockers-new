package pl.bratosz.smartlockers.service.orders2;

import pl.bratosz.smartlockers.service.orders.mainorder.*;
import pl.bratosz.smartlockers.service.orders.torelease.ClothReleaseOrder;
import pl.bratosz.smartlockers.service.orders.toreturn.state.ClothReturnOrder;

import java.util.List;

import static pl.bratosz.smartlockers.service.orders.toreturn.ReturnOrderStatus.RETURNED;

public class
AssignedMainOrderState implements MyMainOrderState {
    private final MyMainOrder order;

    public AssignedMainOrderState(MyMainOrder order) {
        this.order = order;
    }

    @Override
    public MyMainOrderStatus getStatus() {
        return MyMainOrderStatus.ASSIGNED;
    }

    @Override
    public void updateState() {
        order.actualState = new
    }
}
