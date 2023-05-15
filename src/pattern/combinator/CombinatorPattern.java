package pattern.combinator;

import model.Person;

import static pattern.combinator.PersonValidator.*;

public class CombinatorPattern {

    public static void execute() {
        System.out.println("Start executing validation process with combinator pattern...");

        Person person = new Person(
                "Morsalin",
                "mor@gmail.com",
                "01674333125",
                "1950"
        );

        ValidationResult validationResult = isNameValid()
                .and(isEmailValid(), "emailValidation")
                .and(isMobileValid(), "mobileValidation")
                .and(isDobValid(), "dobValidation")
                .apply(person);

        System.out.println("validation result: " + validationResult);
    }
}
