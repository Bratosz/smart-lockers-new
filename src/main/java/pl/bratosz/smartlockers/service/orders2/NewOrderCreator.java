package pl.bratosz.smartlockers.service.orders2;

public class NewOrderCreator {

    public static MyMainOrder create(OrderParameters params) {
        MyMainOrder mainOrder = null;
        if(params.isThereIsOrderToExtend()) {
//            mainOrder = extend(params);
            return mainOrder;
        } else {
           return createNew(params);
        }
    }

    private static MyMainOrder createNew(OrderParameters params) {
        MyMainOrder order = MyMainOrder.create(params);
        return order;
    }

}
