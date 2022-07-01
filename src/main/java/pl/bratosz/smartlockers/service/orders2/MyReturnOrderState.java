package pl.bratosz.smartlockers.service.orders2;

import pl.bratosz.smartlockers.service.orders.toreturn.ReturnOrderStatus;

public interface MyReturnOrderState {
    ReturnOrderStatus getStatus();

    void updateState(MyReturnOrder order);

    void updateCloth(MyCloth cloth, MyUser user);
}
