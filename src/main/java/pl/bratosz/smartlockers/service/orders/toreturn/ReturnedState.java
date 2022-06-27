package pl.bratosz.smartlockers.service.orders.toreturn;

import pl.bratosz.smartlockers.exception.MyException;
import pl.bratosz.smartlockers.service.orders.MainClothesOrder;

public class ReturnedState implements ClothToReturnState {
    @Override
    public ClothToReturnStatus getStatus() {
        return ClothToReturnStatus.RETURNED;
    }

    @Override
    public void updateState(MainClothesOrder mainOrder, ClothReturnOrder o) {
        o.setState(this);
    }
}
