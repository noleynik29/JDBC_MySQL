package JDBC.ServiceJDBC;

import JDBC.EntityJDBC.ShoppingCartJDBC;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartServiceJDBCTest {

    private static ShoppingCartServiceJDBC shoppingCartServiceJDBC = new ShoppingCartServiceJDBC();

    @Test
    void add() throws SQLException {
        ShoppingCartJDBC shoppingCartJDBC = new ShoppingCartJDBC();
        shoppingCartJDBC.setIdShoppingCart(15);
        shoppingCartJDBC.setIdOrder(12);
        shoppingCartJDBC.setIdProduct(20);
        shoppingCartJDBC.setOrderQuantity(2);

        shoppingCartServiceJDBC.add(shoppingCartJDBC);

        ShoppingCartJDBC shoppingCartFromDB = shoppingCartServiceJDBC.getById(15);
        assertEquals(12, shoppingCartFromDB.getIdOrder());
        assertEquals(20, shoppingCartFromDB.getIdProduct());
        assertEquals(2, shoppingCartFromDB.getOrderQuantity());
    }

    @Test
    void getAll() throws SQLException {
        List<ShoppingCartJDBC> shoppingCartJDBCList = shoppingCartServiceJDBC.getAll();
        assertEquals(15, shoppingCartJDBCList.size());
    }

    @Test
    void getById() throws SQLException {
        ShoppingCartJDBC shoppingCartJDBC = shoppingCartServiceJDBC.getById(15);
        assertEquals(12, shoppingCartJDBC.getIdOrder());
        assertEquals(20, shoppingCartJDBC.getIdProduct());
        assertEquals(2, shoppingCartJDBC.getOrderQuantity());
    }

    @Test
    void remove() throws SQLException {
        ShoppingCartJDBC shoppingCartJDBC = shoppingCartServiceJDBC.getById(15);
        shoppingCartServiceJDBC.remove(shoppingCartJDBC);
        assertNull(shoppingCartServiceJDBC.getById(15));
    }
}