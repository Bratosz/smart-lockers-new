package pl.bratosz.smartlockers.service.orders2;

import pl.bratosz.smartlockers.exception.MyException;
import pl.bratosz.smartlockers.model.clothes.ClothSize;
import pl.bratosz.smartlockers.model.orders.OrderType;

import java.util.Set;

public class ClothesForOrderValidator {
    public static boolean clothesIsValid(Set<MyCloth> c, OrderType o) throws MyException {
        switch(o) {
            case EXCHANGE_FOR_NEW_ONE:
                return validateForExchange(c);
            default: return false;
        }
    }

    private static boolean validateForExchange(Set<MyCloth> clothes) {
        ClothSize s = null;
        MyClientArticle a = null;
        int i = 0;
        for(MyCloth c : clothes) {
            if(i == 0) {
                s = c.getSize();
                a = c.getClientArticle();
                i = 1;
            } else {
                if(sizeIsDifferent(s, c.getSize()) || articleIsDifferent(a, c.getClientArticle())) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean articleIsDifferent(MyClientArticle a1, MyClientArticle a2) {
        if(a1.equals(a2)) return false;
        return true;
    }

    private static boolean sizeIsDifferent(ClothSize s1, ClothSize s2) {
        if(s1.equals(s2)) return false;
        return true;
    }
}
