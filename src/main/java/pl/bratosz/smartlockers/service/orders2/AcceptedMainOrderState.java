package pl.bratosz.smartlockers.service.orders2;

import pl.bratosz.smartlockers.service.orders.mainorder.MainClothesOrder;
import pl.bratosz.smartlockers.service.orders.mainorder.MainOrderState;
import pl.bratosz.smartlockers.service.orders.mainorder.MainOrderStatus;

public class AcceptedMainOrderState implements MyMainOrderState {

    @Override
    public MyMainOrderStatus getStatus() {
       return MyMainOrderStatus.ACCEPTED;
    }


    @Override
    public void updateState(MyMainOrder mainOrder) {

    }
}
