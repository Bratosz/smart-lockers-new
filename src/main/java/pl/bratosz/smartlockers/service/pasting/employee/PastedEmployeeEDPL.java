package pl.bratosz.smartlockers.service.pasting.employee;

import pl.bratosz.smartlockers.strings.MyString;

public class PastedEmployeeEDPL extends PastedEmployee {
    private String personalNumber;
    private String employeeName;
    private String department;
    private String position;
    private String location;

    public PastedEmployeeEDPL() {
    }


    @Override
    String getPersonalNumber() {
        String s = MyString.create(personalNumber).get();
        return s;
    }

    @Override
    String getFirstName() {
        String s = MyString.create(employeeName).get();
        if(s.isEmpty()) throw new IllegalArgumentException("Name can not be empty");
        return null;
    }

    @Override
    String getLastName() {
        return null;
    }

    @Override
    int getLockerNumber() {
        return 0;
    }

    @Override
    int getBoxNumber() {
        return 0;
    }

    @Override
    String getDepartment() {
        return null;
    }

    @Override
    String getPosition() {
        return null;
    }

    @Override
    String getLocation() {
        return null;
    }
}
