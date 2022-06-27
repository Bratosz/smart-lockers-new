package pl.bratosz.smartlockers.service.orders.toreturn;

import pl.bratosz.smartlockers.exception.MyException;
import pl.bratosz.smartlockers.service.orders.ClothDomain;
import pl.bratosz.smartlockers.service.orders.MainClothesOrder;

public interface ClothToReturnState {

    ClothToReturnStatus getStatus();

    void updateState(MainClothesOrder mainOrder, ClothReturnOrder u);

    void updateStateByCloth(ClothDomain cloth, ClothReturnOrder clothReturnOrder) throws MyException;
}
