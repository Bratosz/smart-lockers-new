package pl.bratosz.smartlockers.utils;

import pl.bratosz.smartlockers.service.jgenderize.model.Gender;
import pl.bratosz.smartlockers.service.jgenderize.model.NameGender;

import java.util.List;

public class EmployeeName {
    private final String firstName;
    private final String lastName;
    private final Gender gender;

    private EmployeeName( String lastName, String firstName, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public static EmployeeName createForGenderUnknown(List<NameGender> genders) {
        String lastName = genders.get(0).getName();
        String firstName = genders.get(1).getName();
        return new EmployeeName(lastName, firstName, Gender.NULL);
    }

    public static EmployeeName create(String lastName, String firstName, Gender gender) {
        return new EmployeeName(lastName, firstName, gender);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }
}
