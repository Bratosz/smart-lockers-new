package pl.bratosz.smartlockers.service.orders.toreturn;

public enum ReturnOrderStatus {
    PENDING_FOR_ASSIGNMENT("Oczekuje na przypisanie"),
    PENDING_FOR_CLOTH_RELEASE("Oczekuje na wydanie odzieży"),
    PENDING_FOR_RETURN("Oczekuje na zwrot"),
    RETURNED("Zwrócono"),
    FINALIZED("Zakończono"),
    UNKNOWN("Nieznany");

    private String name;

    ReturnOrderStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
