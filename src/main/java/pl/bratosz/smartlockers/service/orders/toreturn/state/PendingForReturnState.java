package pl.bratosz.smartlockers.service.orders.toreturn.state;

import pl.bratosz.smartlockers.exception.MyException;
import pl.bratosz.smartlockers.model.clothes.LifeCycleStatus;
import pl.bratosz.smartlockers.service.orders.ClothDomain;
import pl.bratosz.smartlockers.service.orders.mainorder.MainClothesOrder;
import pl.bratosz.smartlockers.service.orders.toreturn.ReturnOrderStatus;

public class PendingForReturnState implements ReturnOrderState {
    @Override
    public ReturnOrderStatus getStatus() {
        return ReturnOrderStatus.PENDING_FOR_RETURN;
    }

    @Override
    public void updateState(MainClothesOrder mainOrder, ClothReturnOrder o) throws MyException {
        throw new MyException("Cloth cant be set returned from mainorder order");
    }

    @Override
    public void updateStateByCloth(ClothDomain c, ClothReturnOrder o) throws MyException {
        if(isWithdrawn(c)) {
            o.setState(new ReturnedState());
        } else {
            throw new MyException("Wrong life cycle status");
        }
    }

    private boolean isWithdrawn(ClothDomain cloth) {
        return cloth.getLifeCycleStatus().equals(LifeCycleStatus.WITHDRAWN);
    }
}
