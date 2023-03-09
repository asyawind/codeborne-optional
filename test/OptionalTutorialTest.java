import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

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


}