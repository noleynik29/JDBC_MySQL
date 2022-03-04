package JDBC.DAO;

import JDBC.EntityJDBC.OrderJDBC;

import java.sql.SQLException;
import java.util.List;

public interface OrderDAO {
    //create
    void add(OrderJDBC orderJDBC) throws SQLException;
    //read
    List<OrderJDBC> getAll() throws SQLException;

    OrderJDBC getById(int idOrder) throws SQLException;
    //update
    void update(OrderJDBC orderJDBC) throws SQLException;
    //delete
    void remove(OrderJDBC orderJDBC) throws SQLException;
}
