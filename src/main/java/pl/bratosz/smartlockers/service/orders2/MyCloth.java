package pl.bratosz.smartlockers.service.orders2;

import pl.bratosz.smartlockers.model.ClientArticle;
import pl.bratosz.smartlockers.model.clothes.ClothSize;
import pl.bratosz.smartlockers.model.orders.ExchangeStrategy;

import java.time.LocalDate;
import java.util.List;

public class MyCloth {

    private long id;
    private ClothSize size;
    private LocalDate assignment;
    private LocalDate released;
    private LocalDate lastWashing;
    private int ordinalNumber;
    private boolean active;
    private List<MyClothStatusHistory> statusHistory;
    private MyClientArticle clientArticle;
    private MyEmployee employee;

    public ClothSize getSize() {
        return size;
    }

    public MyClientArticle getClientArticle() {
        return clientArticle;
    }


}
