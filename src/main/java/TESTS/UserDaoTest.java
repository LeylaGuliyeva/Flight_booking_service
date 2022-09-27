package TESTS;

import BASE_CLASSES.User;
import DAO.UserDao;
import org.junit.Test;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserDaoTest {
    UserDao d=new UserDao();
    @Test
    public void saveTest(){
        User u=new User("Leyla","Guliyeva","leyla1","12345");
        d.save(u);
        assertTrue(d.getAll().contains(u));
    }
    @Test
    public void deleteTest1(){
        User u=new User("Leyla","Guliyeva","leyla1","12345");
        d.save(u);
        assertTrue(d.getAll().contains(u));
        d.delete(u);
        assertFalse(d.getAll().contains(u));
    }
    @Test
    public void loadTest() {
        User u = new User("Leyla", "Guliyeva", "leyla1", "12345");
        d.save(u);
        assertTrue(d.getAll().contains(u));
        assertTrue(d.load("leyla1").get().equals(u));
    }
    @Test
    public void deleteTest2(){
        User u=new User("Leyla","Guliyeva","leyla1","12345");
        d.save(u);
        assertTrue(d.getAll().contains(u));
        d.delete("leyla1");
        assertFalse(d.getAll().contains(u));
    }
    @Test
    public void checkUsernameTest(){
        User u=new User("Leyla","Guliyeva","leyla1","12345");
        d.save(u);
        assertTrue(d.getAll().contains(u));
        assertTrue(d.checkUsername("leyla1").isPresent());
    }
}
