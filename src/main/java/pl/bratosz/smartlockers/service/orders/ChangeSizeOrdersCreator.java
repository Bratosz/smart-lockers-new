package pl.bratosz.smartlockers.service.orders;

import pl.bratosz.smartlockers.model.clothes.Cloth;
import pl.bratosz.smartlockers.model.users.User;
import pl.bratosz.smartlockers.service.orders.toreturn.ClothReturnOrder;
import pl.bratosz.smartlockers.service.orders.toreturn.ReturnOrderCreator;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ChangeSizeOrdersCreator {
    private MainClothesOrder mainOrder;

    public ChangeSizeOrdersCreator(MainClothesOrder mainClothesOrder) {
        this.mainOrder = mainClothesOrder;
    }

    public List<ClothReturnOrder> getReturnOrders(Set<Cloth> clothes, User u) {
        List<ClothReturnOrder> returnOrders = new LinkedList<>();
        ReturnOrderCreator roc = new ReturnOrderCreator(mainOrder);
        clothes.stream().forEach(c -> returnOrders.add(roc.create(c, u)));
        return returnOrders;
    }

    public List<ClothReleaseOrder> getReleaseOrders(Set<Cloth> clothes) {
        return null;
    }
}
