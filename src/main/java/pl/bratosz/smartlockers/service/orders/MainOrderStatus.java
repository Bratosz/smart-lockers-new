package pl.bratosz.smartlockers.service.orders;

public enum MainOrderStatus {
    ACCEPTED("Zaakceptowano"),
    ASSIGNED("Przypisano");

    private String name;

    MainOrderStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
