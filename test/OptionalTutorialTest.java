import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import static java.time.Month.APRIL;
import static java.time.Month.MARCH;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OptionalTutorialTest {

    private final OptionalTutorial optional = new OptionalTutorial();

    @Test
    void searchUser_Rob() {
        assertEquals(Optional.of(new User("Rob")), optional.searchUser("Rob"));
        optional.printOutUserNameIfPresent("Rob");
    }

    @Test
    void searchUser_Madlene() {
        assertEquals(Optional.of(new User("Madlene")), optional.searchUser("Madlene"));
        optional.printOutUserNameIfPresent("Madlene");
    }

    @Test
    void searchUser_Rain() {
        assertEquals(Optional.empty(), optional.searchUser("Rain"));
        optional.printOutUserNameIfNotPresent("Rain");
    }


    @Test
    void searchUserByPartial_hri() {
        assertEquals(List.of(
                new User("Chris"),
                new User("Christina")
        ), optional.searchUserByPartial("hri"));
    }

    @Test
    void findBirthday_Rob() {
        assertEquals(Optional.of(LocalDate.of(1923, Month.MARCH, 9)),optional.findBirthday("Rob"));
    }

    @Test
    void findBirthday_Christina() {
        assertEquals(Optional.empty(),optional.findBirthday("Christina"));
    }

    @Test
    void findBirthday_Anna() {
        assertEquals(Optional.empty(),optional.findBirthday("Anna"));
    }

    @Test
    void findBirthdaykids() {
        assertEquals(List.of(
                new User("Chris", LocalDate.of(2020, MARCH, 9)),
                new User("Rob", LocalDate.of(1923, MARCH, 9))
        ),optional.findBirthdayKids());
    }

    @Test
    void findBirthdayKid_Chris() {
        assertEquals(Optional.of(new User("Chris")),optional.findBirthdayKid());
    }

}