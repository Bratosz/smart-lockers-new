package pl.bratosz.smartlockers.service.pasting.employee;

import pl.bratosz.smartlockers.strings.MyString;

public class PastedEmployeeEDPL {
    private String employeeName;
    private String department;
    private String position;
    private String location;

    public PastedEmployeeEDPL() {
    }

    public String getEmployeeName() {
        return MyString.create(employeeName).get();
    }

    public String getDepartment() {
        return MyString.create(department).get();

    }

    public String getPosition() {
        return MyString.create(position).get();

    }

    public String getLocation() {
        return MyString.create(location).get();
    }
}
