import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Passport {
    private String number;
    private String name;
    private String surname;
    private String patronymic;
    private String dateOfBirth;

    public Passport(String number, String name, String surname, String patronymic, String dateOfBirth) {
        if (number == null || number.isBlank() || number.isEmpty()) {
            throw new IllegalArgumentException("Необходимо указать номер паспорта!");
        } else {
            this.number = number;
        }
        if (name == null || name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException("Необходимо указать имя!");
        } else {
            this.name = name;
        }
        if (surname == null || surname.isBlank() || surname.isEmpty()) {
            throw new IllegalArgumentException("Необходимо указать отчество!");
        } else {
            this.surname = surname;
        }
        this.patronymic = patronymic;
        if (dateOfBirth == null || dateOfBirth.isBlank() || dateOfBirth.isEmpty()) {
            throw new IllegalArgumentException("Необходимо указать дату рождения!");
        } else {
            this.dateOfBirth = dateOfBirth;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return Objects.equals(number, passport.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return name + " " + patronymic + " " + surname + ", дата рождения: " + dateOfBirth + ", номер паспорта: " + number + "\n";
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
}
