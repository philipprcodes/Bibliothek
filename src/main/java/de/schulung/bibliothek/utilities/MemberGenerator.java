package de.schulung.bibliothek.utilities;

import de.schulung.bibliothek.administration.Member;
import net.datafaker.Faker;

import java.time.LocalDate;

public class MemberGenerator {

    private static final Faker faker = new Faker();

    public static Member generateMember(int id) {

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        LocalDate birthDate = faker.timeAndDate().birthday(12,100);
        String email = faker.internet().emailAddress();
        String newId = "" + firstName.charAt(0) + lastName.charAt(0) + Integer.toString(id);

        return new Member(newId, firstName, lastName, birthDate, email);
    }
}


