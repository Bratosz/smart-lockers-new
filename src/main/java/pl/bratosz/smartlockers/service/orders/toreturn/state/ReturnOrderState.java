package pl.bratosz.smartlockers.service.orders.toreturn.state;

import pl.bratosz.smartlockers.exception.MyException;
import pl.bratosz.smartlockers.service.orders.ClothDomain;
import pl.bratosz.smartlockers.service.orders.mainorder.MainClothesOrder;
import pl.bratosz.smartlockers.service.orders.toreturn.ReturnOrderStatus;

public interface ReturnOrderState {

    ReturnOrderStatus getStatus();

    void updateState(MainClothesOrder mainOrder, ClothReturnOrder u) throws MyException;

    void updateStateByCloth(ClothDomain cloth, ClothReturnOrder clothReturnOrder) throws MyException;
}
