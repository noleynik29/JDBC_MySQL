package JDBC.DAO;

import JDBC.EntityJDBC.ProductJDBC;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
    //create
    void add(ProductJDBC productJDBC) throws SQLException;
    //read
    List<ProductJDBC> getAll() throws SQLException;

    ProductJDBC getById(int idProduct) throws SQLException;
    //update
    void update(ProductJDBC productJDBC) throws SQLException;
    //delete
    void remove(ProductJDBC productJDBC) throws SQLException;
}
