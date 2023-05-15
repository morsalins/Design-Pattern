package pattern.combinator;

import model.Person;

import java.time.LocalDate;
import java.util.function.Function;

import static pattern.combinator.ValidationResult.*;

public interface PersonValidator extends Function<Person, ValidationResult> {
    static PersonValidator isNameValid() {
        return person -> {
            System.out.println("Validating Name.....");
            return person.getName().matches("[A-Za-z]+")
                    ? SUCCESS : INVALID_NAME;
        };
    }

    static PersonValidator isMobileValid() {
        return person -> {
            System.out.println("Validating Mobile.....");
            return person.getMobile().matches("\\d+")
                    ? SUCCESS : INVALID_MOBILE;
        };
    }

    static PersonValidator isEmailValid() {
        return person -> {
            System.out.println("Validating Email.....");
            return person.getEmail().contains("@")
                    ? SUCCESS : INVALID_EMAIL;
        };
    }

    static PersonValidator isDobValid() {
        return person -> {
            System.out.println("Validating DOB.....");
            return (LocalDate.now().getYear() - Integer.parseInt(person.getDobYear())) >= 18
                    ? SUCCESS : INVALID_DOB;
        };
    }

    default PersonValidator and(PersonValidator other, String validationName) {
        return person -> {
            System.out.println("validation passed: " + validationName);
            ValidationResult result = this.apply(person);
            return result.equals(SUCCESS) ? other.apply(person) : result;
        };
    }
}
