package pl.bratosz.smartlockers.service.orders.mainorder;

import pl.bratosz.smartlockers.model.users.User;

import java.time.LocalDate;

public class MainOrderStatusExtended {
    private MainOrderStatus orderStatus;
    private LocalDate date;
    private User user;

    public static MainOrderStatusExtended create(MainOrderStatus status, User user) {
        MainOrderStatusExtended mainOrderStatusExtended = new MainOrderStatusExtended();
        mainOrderStatusExtended.orderStatus = status;
        mainOrderStatusExtended.date = LocalDate.now();
        mainOrderStatusExtended.user = user;
        return mainOrderStatusExtended;
    }

    public MainOrderStatus getOrderStatus() {
        return orderStatus;
    }

    public LocalDate getDate() {
        return date;
    }

    public User getUser() {
        return user;
    }
}
