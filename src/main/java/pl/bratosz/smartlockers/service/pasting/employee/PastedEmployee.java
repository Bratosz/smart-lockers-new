package pl.bratosz.smartlockers.service.pasting.employee;

public abstract class PastedEmployee {
    public abstract String getPersonalNumber();
    public abstract String getFirstName();
    public abstract String getLastName();
    public abstract int getLockerNumber();
    public abstract int getBoxNumber();
    public abstract String getDepartment();
    public abstract String getPosition();
    public abstract String getLocation();
}
