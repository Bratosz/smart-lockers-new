package pl.bratosz.smartlockers.service.orders;

import pl.bratosz.smartlockers.model.Client;
import pl.bratosz.smartlockers.model.clothes.Cloth;
import pl.bratosz.smartlockers.model.clothes.ClothSize;
import pl.bratosz.smartlockers.model.orders.OrderType;
import pl.bratosz.smartlockers.model.users.User;
import pl.bratosz.smartlockers.service.orders.toreturn.ClothReturnOrder;

import java.util.Set;

public class OrdersManager {

    public MainClothesOrder create(
            OrderType orderType, ClothSize clothSize, Set<Cloth> clothes, Client client, User user) {

    }


    public void clothReturn(Cloth returnedCloth, User user) {
        ClothDomain cloth = create(returnedCloth);
        ClothReturnOrder returnOrder = cloth.getReturnOrder();
        returnOrder.update(cloth, user);
    }
}
