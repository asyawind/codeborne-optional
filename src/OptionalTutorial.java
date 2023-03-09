import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.time.Month.*;
import static java.time.Month.JANUARY;
import static java.time.Month.MARCH;

public class OptionalTutorial {

    public static final int MULTIPLIER_TWO = 2;
    List<User> users = List.of(
            new User("John", LocalDate.of(1995, JANUARY, 23)),
            new User("Chris", LocalDate.of(2020, MARCH, 9)),
            new User("Christina"),
            new User("Madlene", LocalDate.of(2000, APRIL, 28)),
            new User("Rob", LocalDate.of(1923, MARCH, 9)),
            new User("Anna")
    );

    public Map<String,LocalDate> usersByName() {
        Map<String, LocalDate> userMap = new HashMap<>();
        for (User user : users) {
            userMap.put(user.name, user.birthdate);
        }
        return users.stream().collect(Collectors.toMap(user -> user.name, user -> user.birthdate == null ? LocalDate.parse("0000-01-01") : user.birthdate ));
    }

    public List<Integer> multiplyByTwoAll(List<Integer> numbers) {
        return numbers.stream().map(number -> number * MULTIPLIER_TWO).toList();
    }

    public Optional<User> searchUser(String name) {
        return users.stream().filter((user -> user.name.equals(name))).findFirst();
    }

    public List<User> searchUserByPartial(String name) {
        return users.stream().filter((user -> user.name.contains(name))).toList();
    }

    public Optional<LocalDate> findBirthday(String name) {
        return searchUser(name).map(user -> user.birthdate);
    }

    public Optional<User> findBirthdayKid() {
        return users.stream().filter(this::checkBirthdateMatch).findFirst();
    }

    public List<User> findBirthdayKids() {
        return users.stream()
                .filter((this::checkBirthdateMatch))
                .toList();
    }

    public void printOutUserNameIfPresent(String name) {
        System.out.println(name);
    }

    public void printOutUserNameIfNotPresent(String name) {
        System.out.println("User: " + name + " is not present");
    }

    private boolean checkBirthdateMatch(User user) {
        return user.birthdate != null
                && user.birthdate.getMonthValue() == LocalDate.now().getMonthValue()
                && user.birthdate.getDayOfMonth() == LocalDate.now().getDayOfMonth();
    }
}