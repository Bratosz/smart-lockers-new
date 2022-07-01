package pl.bratosz.smartlockers.service.orders.toreturn;

import pl.bratosz.smartlockers.model.users.User;

import java.time.LocalDate;

public class ReturnOrderStatusExtended {
    private ReturnOrderStatus status;
    private LocalDate date;
    private User user;

    public static ReturnOrderStatusExtended create(ReturnOrderStatus status, User user) {
        ReturnOrderStatusExtended clothReturnOrderStatus = new ReturnOrderStatusExtended();
        clothReturnOrderStatus.status = status;
        clothReturnOrderStatus.date = LocalDate.now();
        clothReturnOrderStatus.user = user;
        return clothReturnOrderStatus;
    }

    public ReturnOrderStatus getStatus() {
        return status;
    }

    public LocalDate getDate() {
        return date;
    }

    public User getUser() {
        return user;
    }
}
