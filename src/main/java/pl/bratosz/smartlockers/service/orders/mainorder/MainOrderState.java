package pl.bratosz.smartlockers.service.orders.mainorder;

import pl.bratosz.smartlockers.model.users.User;

public interface MainOrderState {

    MainOrderStatus getStatus();

    void updateState(MainClothesOrder mainOrder);

}
