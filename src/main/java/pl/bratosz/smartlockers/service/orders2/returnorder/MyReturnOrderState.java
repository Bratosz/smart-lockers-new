package pl.bratosz.smartlockers.service.orders2.returnorder;

import pl.bratosz.smartlockers.service.orders.toreturn.ReturnOrderStatus;
import pl.bratosz.smartlockers.service.orders2.MyUser;

public interface MyReturnOrderState {

    ReturnOrderStatus getStatus();

    void updateState();

    void updateCloth(MyUser user);


}
