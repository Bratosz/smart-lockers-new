package pl.bratosz.smartlockers.service.orders2;

import java.time.LocalDate;

public class MyMainOrderStatusHistory {
    private final MyMainOrderStatus status;
    private final LocalDate date;
    private final MyUser user;

    public MyMainOrderStatusHistory(MyUser user) {
        this.user = user;
        this.status = user.getInitialStatusForOrders();
        this.date = LocalDate.now();
    }

    public MyMainOrderStatusHistory(MyMainOrderStatus status, MyUser user) {
        this.status = status;
        this.user = user;
        this.date = LocalDate.now();
    }

    public MyMainOrderStatus getStatus() {
        return status;
    }

    public LocalDate getDate() {
        return date;
    }

    public MyUser getUser() {
        return user;
    }
}
