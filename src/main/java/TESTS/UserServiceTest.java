package TESTS;

import BASE_CLASSES.User;
import SERVICE.UserService;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserServiceTest {
    UserService us=new UserService();
    @Test
    public void registerTest(){
        User u=new User("Leyla","Guliyeva","leyla1","12345");
        us.register("Leyla","Guliyeva","leyla1","12345");
        assertTrue(us.login("leyla1","12345").isPresent());
    }
    @Test
    public void loginTest(){
        User u=new User("Leyla","Guliyeva","leyla1","12345");
        us.save(u);
        assertTrue(us.login("leyla1","12345").isPresent());
    }
}
