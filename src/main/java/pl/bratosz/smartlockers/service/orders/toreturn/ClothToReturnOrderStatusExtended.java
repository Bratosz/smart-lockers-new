package pl.bratosz.smartlockers.service.orders.toreturn;

import pl.bratosz.smartlockers.model.users.User;

import java.time.LocalDate;

public class ClothToReturnOrderStatusExtended {
    private ClothToReturnStatus status;
    private LocalDate date;
    private User user;

    public static ClothToReturnOrderStatusExtended create(ClothToReturnStatus status, User user) {
        ClothToReturnOrderStatusExtended clothReturnOrderStatus = new ClothToReturnOrderStatusExtended();
        clothReturnOrderStatus.status = status;
        clothReturnOrderStatus.date = LocalDate.now();
        clothReturnOrderStatus.user = user;
        return clothReturnOrderStatus;
    }

    public ClothToReturnStatus getStatus() {
        return status;
    }

    public LocalDate getDate() {
        return date;
    }

    public User getUser() {
        return user;
    }
}
