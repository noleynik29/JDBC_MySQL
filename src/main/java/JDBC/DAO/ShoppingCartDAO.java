package JDBC.DAO;

import JDBC.EntityJDBC.ShoppingCartJDBC;

import java.sql.SQLException;
import java.util.List;

public interface ShoppingCartDAO {
    //create
    void add(ShoppingCartJDBC shoppingCartJDBC) throws SQLException;
    //read
    List<ShoppingCartJDBC> getAll() throws SQLException;

    //ShoppingCartJDBC getById(int idShoppingCart) throws SQLException;
    //update
    void update(ShoppingCartJDBC shoppingCartJDBC) throws SQLException;
    //delete
    void remove(ShoppingCartJDBC shoppingCartJDBC) throws SQLException;
}
