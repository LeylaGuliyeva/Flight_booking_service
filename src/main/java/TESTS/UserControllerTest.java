package TESTS;

import BASE_CLASSES.User;
import CONTROLLERS.UserController;
import SERVICE.UserService;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserControllerTest {
    UserController uc=new UserController();
    @Test
    public void getUserByNameTest(){
        User u=new User("Leyla","Guliyeva","leyla1","12345");
        uc.register("Leyla","Guliyeva","leyla1","12345");
        assertTrue(uc.getUserByName("leyla1").get().equals(u));
    }
}
