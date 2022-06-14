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
//        resolveEmployeeNames();
    }

    public String getEmployeeName() {
        return lastName + " " + firstName;
    }

    @Override
    public String getPersonalNumber() {
        String s = MyString.create(personalNumber).get();
        return s;
    }

    @Override
    public String getFirstName() {
        if(MyString.isEmpty(firstName)) {
            resolveEmployeeNames();
            return firstName;
        } else {
            return firstName;
        }

    }

    private void resolveEmployeeNames() {
        String s = MyString.create(employeeName).get();
        if(s.isEmpty()) throw new IllegalArgumentException("Name can not be empty");
        EmployeeNameAndGender e = NameExtractor.getInstance().get(s);
        firstName = e.getFirstName();
        lastName = e.getLastName();
    }

    @Override
    public String getLastName() {
        if(MyString.isEmpty(lastName)) {
            resolveEmployeeNames();
            return lastName;
        } else {
            return lastName;
        }
    }

    @Override
    public int getLockerNumber() {
        return 0;
    }

    @Override
    public int getBoxNumber() {
        return 0;
    }

    @Override
    public String getDepartment() {
        return null;
    }

    @Override
    public String getPosition() {
        return null;
    }

    @Override
    public String getLocation() {
        return null;
    }
}
