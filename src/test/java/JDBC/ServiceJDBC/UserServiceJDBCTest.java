package JDBC.ServiceJDBC;

import JDBC.EntityJDBC.UserJDBC;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceJDBCTest {

    private static UserServiceJDBC userServiceJDBC = new UserServiceJDBC();

    @Test
    void add() throws SQLException {
        UserJDBC userJDBC = new UserJDBC();
        userJDBC.setIdUser(13);
        userJDBC.setFirstName("Matt");
        userJDBC.setLastName("Murdock");

        userServiceJDBC.add(userJDBC);

        UserJDBC userFromDB = userServiceJDBC.getById(13);
        assertEquals("Matt", userFromDB.getFirstName());
        assertEquals("Murdock", userFromDB.getLastName());
    }

    @Test
    void getAll() throws SQLException {
        List<UserJDBC> userJDBCList = userServiceJDBC.getAll();
        assertEquals(13, userJDBCList.size());
    }

    @Test
    void getById() throws SQLException {
        UserJDBC userFromDB = userServiceJDBC.getById(13);
        assertEquals("Matt", userFromDB.getFirstName());
        assertEquals("Murdock", userFromDB.getLastName());
    }

    @Test
    void remove() throws SQLException {
        UserJDBC userJDBC = userServiceJDBC.getById(13);
        userServiceJDBC.remove(userJDBC);
        assertNull(userServiceJDBC.getById(13));
    }
}