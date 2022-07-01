package pl.bratosz.smartlockers.service.orders.torelease;

import pl.bratosz.smartlockers.model.users.User;

import java.time.LocalDate;

public class ReleaseOrderStatusExtended {
    private ReleaseOrderStatus status;
    private LocalDate localDate;
    private User user;

    public ReleaseOrderStatusExtended(ReleaseOrderStatus status, User user) {
        this.status = status;
        this.localDate = LocalDate.now();
        this.user = user;
    }

    public ReleaseOrderStatus getStatus() {
        return status;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public User getUser() {
        return user;
    }
}
