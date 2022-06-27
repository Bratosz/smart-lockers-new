package pl.bratosz.smartlockers.service.orders.toreturn;

import pl.bratosz.smartlockers.exception.MyException;
import pl.bratosz.smartlockers.model.clothes.LifeCycleStatus;
import pl.bratosz.smartlockers.service.orders.ClothDomain;
import pl.bratosz.smartlockers.service.orders.MainClothesOrder;

public class ClothToReturnPendingForReturnState implements ClothToReturnState {
    @Override
    public ClothToReturnStatus getStatus() {
        return ClothToReturnStatus.PENDING_FOR_RETURN;
    }

    @Override
    public void updateState(MainClothesOrder mainOrder, ClothReturnOrder o) {
        o.setState(new ReturnedState());
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
