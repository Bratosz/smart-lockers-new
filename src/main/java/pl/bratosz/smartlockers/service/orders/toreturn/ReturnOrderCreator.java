package pl.bratosz.smartlockers.service.orders.toreturn;

import pl.bratosz.smartlockers.model.users.User;
import pl.bratosz.smartlockers.service.orders.ClothDomain;
import pl.bratosz.smartlockers.service.orders.MainClothesOrder;

public class ReturnOrderCreator {
    MainClothesOrder mainOrder;

    public ReturnOrderCreator(MainClothesOrder mainOrder) {
        this.mainOrder = mainOrder;
    }

    public ClothReturnOrder create(ClothDomain c, User u) {
        return ClothReturnOrder.create(c, mainOrder, u);
    }
}
