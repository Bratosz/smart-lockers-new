package pl.bratosz.smartlockers.service.orders2;

import pl.bratosz.smartlockers.exception.MyException;
import pl.bratosz.smartlockers.model.clothes.ClothDestination;
import pl.bratosz.smartlockers.service.orders2.returnorder.MyReturnOrder;


import java.util.Set;

public class Foo {

    public MyMainOrder addOrder(MyEmployee employee, Set<MyCloth> clothes, MyClient client, MyUser user) throws MyException {
        OrderParameters params = OrderParameters.createForExchange(employee, clothes, client, user);
        MyMainOrder order = NewOrderCreator.create(params);
        return order;
    }

    public void updateCloth(MyCloth cloth, MyUser user) {
        ClothDestination destination = cloth.getClothDestination();
        switch (destination) {
            case FOR_WITHDRAW:
                acceptCloth(cloth, user);
        }
    }

    public MyMainOrder acceptCloth(MyCloth cloth, MyUser user) throws MyException {
        MyReturnOrder returnOrder = cloth.getReturnOrder();
        returnOrder.update(user);

    }
}
