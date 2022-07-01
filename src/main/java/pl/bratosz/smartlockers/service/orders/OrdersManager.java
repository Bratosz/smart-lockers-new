package pl.bratosz.smartlockers.service.orders;

import pl.bratosz.smartlockers.model.Client;
import pl.bratosz.smartlockers.model.clothes.Cloth;
import pl.bratosz.smartlockers.model.clothes.ClothSize;
import pl.bratosz.smartlockers.model.orders.OrderType;
import pl.bratosz.smartlockers.model.users.User;
import pl.bratosz.smartlockers.service.orders.mainorder.MainClothesOrder;

import java.util.Set;

public class OrdersManager {

    public MainClothesOrder create(
            OrderType orderType, ClothSize clothSize, Set<Cloth> clothes, Client client, User user) {

    }


    public MainClothesOrder clothUpdate(Cloth cloth, User user) {
        ClothDomain c = create(cloth);
        if(returnOrderIsPresent(c)) {
            c.getReturnOrder().update(c, user);
        } else if(releaseOrderIsPresent(c)) {
            c.getReleaseOrder().update(c, user);
        }
    }

    private boolean releaseOrderIsPresent(ClothDomain cloth) {
        return cloth.getReleaseOrder() != null;
    }

    private boolean returnOrderIsPresent(ClothDomain cloth) {
        return cloth.getReturnOrder() != null;
    }
}
