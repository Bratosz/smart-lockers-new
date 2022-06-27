package pl.bratosz.smartlockers.service.orders;

import pl.bratosz.smartlockers.model.clothes.Cloth;
import pl.bratosz.smartlockers.model.clothes.ClothSize;
import pl.bratosz.smartlockers.model.users.User;

import java.util.Set;

public interface MainOrderState {

    MainOrderStatus getStatus();

    void updateReturnOrders();
}
