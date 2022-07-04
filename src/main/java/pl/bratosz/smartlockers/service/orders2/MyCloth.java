package pl.bratosz.smartlockers.service.orders2;

import pl.bratosz.smartlockers.model.clothes.ClothSize;
import pl.bratosz.smartlockers.model.clothes.ClothStatus;
import pl.bratosz.smartlockers.service.orders2.returnorder.MyReturnOrder;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import static pl.bratosz.smartlockers.model.clothes.ClothStatus.UNKNOWN;

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
    private MyReturnOrder returnOrder;

    public ClothSize getSize() {
        return size;
    }

    public MyClientArticle getClientArticle() {
        return clientArticle;
    }


    public ClothStatus getActualStatus() {
        if(statusHistory == null || statusHistory.isEmpty()) return UNKNOWN;
        return getActualStatusHistory().getStatus();
    }

    private MyClothStatusHistory getActualStatusHistory() {
        if(statusHistory == null || statusHistory.isEmpty()) return MyClothStatusHistory.empty();
        return statusHistory.get(statusHistory.size() - 1);
    }

    public void updateStatusHistory(MyClothStatusHistory actualStatus) {
        if(statusHistory == null) statusHistory = new LinkedList<>();
        statusHistory.add(actualStatus);
    }

    public MyReturnOrder getReturnOrder() {
        return returnOrder;
    }
}
