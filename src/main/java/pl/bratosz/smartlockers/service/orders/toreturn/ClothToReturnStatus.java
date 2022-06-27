package pl.bratosz.smartlockers.service.orders.toreturn;

public enum  ClothToReturnStatus {
    PENDING_FOR_ASSIGNMENT("Oczekuje na przypisanie"),
    PENDING_FOR_CLOTH_RELEASE("Oczekuje na wydanie odzieży"),
    PENDING_FOR_RETURN("Oczekuje na zwrot"),
    RETURNED("Zwrócono");

    private String name;

    ClothToReturnStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
