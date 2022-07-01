package pl.bratosz.smartlockers.service.orders2;

import java.time.LocalDateTime;

public class MyMainOrderStatusHistory {
    private final MyMainOrderStatus status;
    private final LocalDateTime date;
    private final MyUser user;

    public MyMainOrderStatusHistory(MyMainOrderStatus status, MyUser user) {
        this.status = status;
        this.user = user;
        this.date = LocalDateTime.now();
    }

    public MyMainOrderStatus getStatus() {
        return status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public MyUser getUser() {
        return user;
    }
}
