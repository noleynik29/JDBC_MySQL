package JDBC.ServiceJDBC;

import JDBC.EntityJDBC.OrderJDBC;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceJDBCTest {

    private static OrderServiceJDBC orderServiceJDBC = new OrderServiceJDBC();

    @Test
    void add() throws SQLException {
        OrderJDBC orderJDBC = new OrderJDBC();
        orderJDBC.setIdOrder(12);
        orderJDBC.setIdUser(1);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();

        orderJDBC.setDate(dateFormat.format(date));
        orderJDBC.setTotalPrice(120);

        orderServiceJDBC.add(orderJDBC);

        OrderJDBC orderFromDB = orderServiceJDBC.getById(12);
        assertEquals(120, orderFromDB.getTotalPrice());
        assertEquals(1, orderFromDB.getIdUser());
    }

    @Test
    void getAll() throws SQLException {
        List<OrderJDBC> listFromDB = orderServiceJDBC.getAll();
        assertEquals(11, listFromDB.size());
    }

    @Test
    void getById() throws SQLException {
        OrderJDBC orderFromDB = orderServiceJDBC.getById(12);
        assertEquals(120, orderFromDB.getTotalPrice());
        assertEquals(1, orderFromDB.getIdUser());
    }

    @Test
    void remove() throws SQLException {
        OrderJDBC orderFromDB = orderServiceJDBC.getById(12);
        orderServiceJDBC.remove(orderFromDB);
        assertNull(orderServiceJDBC.getById(12));
    }
}