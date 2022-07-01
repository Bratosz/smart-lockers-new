package pl.bratosz.smartlockers.service.orders2;

public class NewOrderCreator {

    public static MyMainOrder create(OrderParameters params) {
        MyMainOrder mainOrder;
        if(params.isThereIsOrderToExtend()) {
            mainOrder = extend(params);
        } else {
            mainOrder = createNew(params);
        }
    }

    private static MyMainOrder createNew(OrderParameters params) {
        MyMainOrder o = MyMainOrder.create(params);
    }
}
