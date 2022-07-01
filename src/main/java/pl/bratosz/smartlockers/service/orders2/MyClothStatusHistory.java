package pl.bratosz.smartlockers.service.orders2;

import pl.bratosz.smartlockers.model.clothes.ClothDestination;
import pl.bratosz.smartlockers.model.clothes.ClothStatus;
import pl.bratosz.smartlockers.model.clothes.ClothStatusHistory;

import java.time.LocalDateTime;

import static pl.bratosz.smartlockers.model.clothes.ClothDestination.UNKNOWN;

public class MyClothStatusHistory {
    private long id;
    private ClothStatus clothStatus;
    private ClothDestination clothDestination;
    private MyCloth cloth;
    private LocalDateTime date;
    private MyUser user;

    public static MyClothStatusHistory create(
            ClothDestination clothDestination,
            MyCloth cloth,
            MyUser user) {
        MyClothStatusHistory s = new MyClothStatusHistory();
        s.clothStatus = cloth.getActualStatus();
        s.clothDestination = clothDestination;
        s.cloth = cloth;
        s.user = user;
        s.date = setDate();
        return s;
    }

    public static MyClothStatusHistory create(
            ClothStatus clothStatus,
            ClothDestination clothDestination,
            MyCloth cloth,
            MyUser user) {
        MyClothStatusHistory s = new MyClothStatusHistory();
        s.clothStatus = clothStatus;
        s.clothDestination = clothDestination;
        s.cloth = cloth;
        s.user = user;
        s.date = setDate();
        return s;
    }

    private static LocalDateTime setDate() {
        return LocalDateTime.now();
    }

    public static MyClothStatusHistory empty() {
        MyClothStatusHistory s = new MyClothStatusHistory();
        s.clothStatus = ClothStatus.UNKNOWN;
        s.clothDestination = UNKNOWN;
        return s;
    }

    public ClothStatus getStatus() {
        return clothStatus;
    }
}
