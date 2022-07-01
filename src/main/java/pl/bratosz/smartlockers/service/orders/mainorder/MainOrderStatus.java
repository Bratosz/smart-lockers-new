package pl.bratosz.smartlockers.service.orders.mainorder;

public enum MainOrderStatus {
    ACCEPTED("Zaakceptowano"),
    ASSIGNED("Przypisano"),
    IN_REALIZATION("W realizacji"),
    REALIZED_BUT_PENDING_FOR_CLOTH_RETURN("Zrobiono - odzież nie została zwrócona"),
    FINALIZED("Zakończono");

    private String name;

    MainOrderStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
