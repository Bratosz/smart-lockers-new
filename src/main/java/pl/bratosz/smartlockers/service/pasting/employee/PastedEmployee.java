package pl.bratosz.smartlockers.service.pasting.employee;

import pl.bratosz.smartlockers.model.Department;
import pl.bratosz.smartlockers.model.Location;
import pl.bratosz.smartlockers.model.Position;

public abstract class PastedEmployee {
    abstract String getPersonalNumber();
    abstract String getFirstName();
    abstract String getLastName();
    abstract int getLockerNumber();
    abstract int getBoxNumber();
    abstract String getDepartment();
    abstract String getPosition();
    abstract String getLocation();
}
