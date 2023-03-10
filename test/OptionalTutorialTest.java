import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.time.Month.*;
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
        assertEquals(Optional.of(LocalDate.of(1923, Month.MARCH, 10)),optional.findBirthday("Rob"));
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
                new User("Chris", LocalDate.of(2020, MARCH, 10)),
                new User("Rob", LocalDate.of(1923, MARCH, 10))
        ),optional.findBirthdayKids());
    }

    @Test
    void findBirthdayKid_Chris() {
        assertEquals(Optional.of(new User("Chris")),optional.findBirthdayKid());
    }

    @Test
    void multiplyByTwoAll() {
        assertEquals(List.of(2,4,6,8,10),optional.multiplyByTwoAll(List.of(1,2,3,4,5)));
    }

    @Test
    void groupsUserByName() {
        Map<String,LocalDate> userMap = new HashMap<>();
        userMap.put("John", LocalDate.of(1995, JANUARY, 23));
        userMap.put("Chris", LocalDate.of(2020, MARCH, 10));
        userMap.put("Christina",null);
        userMap.put("Madlene", LocalDate.of(2000, APRIL, 28));
        userMap.put("Rob", LocalDate.of(1923, MARCH, 10));
        userMap.put("Anna",null);

        assertEquals(userMap,optional.usersByName());

    }

}