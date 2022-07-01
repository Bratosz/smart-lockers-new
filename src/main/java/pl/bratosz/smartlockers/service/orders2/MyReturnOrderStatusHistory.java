package pl.bratosz.smartlockers.service.orders2;

import pl.bratosz.smartlockers.service.orders.toreturn.ReturnOrderStatus;

import java.time.LocalDate;

public class MyReturnOrderStatusHistory {

    private long id;
    private ReturnOrderStatus orderStatus;
    private MyUser user;
    private LocalDate date;

    public MyReturnOrderStatusHistory(ReturnOrderStatus orderStatus, MyUser user) {
        this.orderStatus = orderStatus;
        this.user = user;
        this.date = LocalDate.now();
    }

    public long getId() {
        return id;
    }

    public ReturnOrderStatus getOrderStatus() {
        return orderStatus;
    }

    public MyUser getUser() {
        return user;
    }

    public LocalDate getDate() {
        return date;
    }
}
