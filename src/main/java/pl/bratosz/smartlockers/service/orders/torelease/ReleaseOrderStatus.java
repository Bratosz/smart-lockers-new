package pl.bratosz.smartlockers.service.orders.torelease;

public enum ReleaseOrderStatus {
    PENDING_FOR_ASSIGNMENT("Oczekuje na przypisanie"),
    PENDING_FOR_RETURN("Oczekuje na zwrot"),
    PENDING_FOR_RELEASE("Oczekuje na wydanie"),
    RELEASED("Wydano"),
    UNKNOWN("Nieznany");

    private String name;

    ReleaseOrderStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
