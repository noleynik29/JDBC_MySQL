package JDBC.ServiceJDBC;

import JDBC.EntityJDBC.ProductJDBC;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceJDBCTest {

    private static ProductServiceJDBC productServiceJDBC = new ProductServiceJDBC();

    @Test
    void add() throws SQLException {
        ProductJDBC productJDBC = new ProductJDBC();
        productJDBC.setIdProduct(20);
        productJDBC.setName("Sifu");
        productJDBC.setPrice(120);
        productJDBC.setDescription("Game");

        productServiceJDBC.add(productJDBC);

        ProductJDBC productFromDB = productServiceJDBC.getById(20);
        assertEquals("Sifu", productFromDB.getName());
        assertEquals(120, productFromDB.getPrice());
        assertEquals("Game", productFromDB.getDescription());
    }

    @Test
    void getAll() throws SQLException {
        List<ProductJDBC> productJDBCList = productServiceJDBC.getAll();
        assertEquals(20, productJDBCList.size());
    }

    @Test
    void getById() throws SQLException {
        ProductJDBC productFromDB = productServiceJDBC.getById(20);
        assertEquals("Sifu", productFromDB.getName());
        assertEquals(120, productFromDB.getPrice());
        assertEquals("Game", productFromDB.getDescription());
    }

    @Test
    void remove() throws SQLException {
        ProductJDBC productJDBC = productServiceJDBC.getById(20);
        productServiceJDBC.remove(productJDBC);
        assertNull(productServiceJDBC.getById(20));
    }
}