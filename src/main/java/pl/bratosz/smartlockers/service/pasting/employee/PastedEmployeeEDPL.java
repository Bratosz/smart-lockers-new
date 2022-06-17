package pl.bratosz.smartlockers.service.pasting.employee;

import pl.bratosz.smartlockers.utils.string.EmployeeNameAndGender;
import pl.bratosz.smartlockers.utils.string.MyString;
import pl.bratosz.smartlockers.utils.string.NameExtractor;

public class PastedEmployeeEDPL extends PastedEmployee {
    private String personalNumber;
    private String employeeName;
    private String firstName;
    private String lastName;
    private String department;
    private String position;
    private String location;

    public PastedEmployeeEDPL() {
    }

    public String getEmployeeName() {
        return getLastName() + " " + getFirstName();
    }

    @Override
    public String getPersonalNumber() {
        String s = MyString.create(personalNumber).get();
        return s;
    }

    @Override
    public String getFirstName() {
        if (MyString.isEmpty(firstName)) resolveEmployeeNames();
        return firstName;
    }

    private void resolveEmployeeNames() {
        String s = MyString.create(employeeName).get();
        if (s.isEmpty()) throw new IllegalArgumentException("Name can not be empty");
        EmployeeNameAndGender e = NameExtractor.getInstance().get(s);
        firstName = e.getFirstName();
        lastName = e.getLastName();
    }

    @Override
    public String getLastName() {
        if (MyString.isEmpty(lastName)) resolveEmployeeNames();
        return lastName;
    }

    @Override
    public int getLockerNumber() {
        return -1;
    }

    @Override
    public int getBoxNumber() {
        return -1;
    }

    @Override
    public String getDepartment() {
        return MyString.create(department).get();
    }

    @Override
    public String getPosition() {
        return MyString.create(position).get();
    }

    @Override
    public String getLocation() {
        return MyString.create(location).get();
    }
}
