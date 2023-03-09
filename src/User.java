import java.time.LocalDate;
import java.util.Objects;

public class User {
    String name;
    LocalDate birthdate;

    public User(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    public User(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }
}
