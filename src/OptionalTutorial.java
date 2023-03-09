import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import static java.time.Month.*;
import static java.time.Month.JANUARY;
import static java.time.Month.MARCH;

public class OptionalTutorial {

    List<User> users = List.of(
            new User("John", LocalDate.of(1995, JANUARY, 23)),
            new User("Chris", LocalDate.of(2023, MARCH, 9)),
            new User("Christina"),
            new User("Madlene", LocalDate.of(2000, APRIL, 28)),
            new User("Rob", LocalDate.of(1923, MARCH, 9)),
            new User("Anna")
    );

    public Optional<User> searchUser(String name) {
        Optional<User> foundUser = users.stream().filter((user -> user.name.equals(name))).findFirst();
        if (foundUser.isPresent()) {
            return foundUser;
        } else {
            return Optional.empty();
        }
    }

    public void printOutUserNameIfPresent(String name) {
        System.out.println(name);
    }
    public void printOutUserNameIfNotPresent(String name) {
        System.out.println("User is not present");
    }

}