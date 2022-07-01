package pl.bratosz.smartlockers.service.orders.toreturn.state;

import pl.bratosz.smartlockers.exception.MyException;
import pl.bratosz.smartlockers.service.orders.ClothDomain;
import pl.bratosz.smartlockers.service.orders.mainorder.MainClothesOrder;
import pl.bratosz.smartlockers.service.orders.toreturn.ReturnOrderStatus;

public class ReturnedState implements ReturnOrderState {
    @Override
    public ReturnOrderStatus getStatus() {
        return ReturnOrderStatus.RETURNED;
    }

    @Override
    public void updateState(MainClothesOrder mainOrder, ClothReturnOrder o) {
        o.setState(this);
    }

    @Override
    public void updateStateByCloth(ClothDomain cloth, ClothReturnOrder clothReturnOrder) throws MyException {
        clothReturnOrder.setState(this);
    }
}
