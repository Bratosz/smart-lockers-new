package pl.bratosz.smartlockers.service.orders2;

public enum MyMainOrderStatus {
    REQUESTED("Zgłoszono"),
    ACCEPTED("Zaakceptowano"),
    ASSIGNED("Przypisano"),
    IN_REALIZATION("W realizacji"),
    REALIZED_BUT_PENDING_FOR_CLOTH_RETURN("Zrobiono - odzież nie została zwrócona"),
    FINALIZED("Zakończono"),
    UNKNOWN("Nieznany");

    private String name;

    MyMainOrderStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
