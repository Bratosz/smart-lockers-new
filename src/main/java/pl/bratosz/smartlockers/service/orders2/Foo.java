package pl.bratosz.smartlockers.service.orders2;

import pl.bratosz.smartlockers.exception.MyException;
import pl.bratosz.smartlockers.model.clothes.Cloth;


import java.util.Set;

public class Foo {

    public MyMainOrder addOrder(MyEmployee employee, Set<MyCloth> clothes, MyClient client, MyUser user) throws MyException {
        OrderParameters params = OrderParameters.createForExchange(employee, clothes, client, user);
        MyMainOrder order = NewOrderCreator.create(params);
    }


    public MyMainOrder updateOrder(Cloth c) {

    }
}
