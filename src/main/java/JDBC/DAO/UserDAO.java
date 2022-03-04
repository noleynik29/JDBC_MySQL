package JDBC.DAO;

import JDBC.EntityJDBC.UserJDBC;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    //create
    void add(UserJDBC userJDBC) throws SQLException;
    //read
    List<UserJDBC> getAll() throws SQLException;

    UserJDBC getById(int idUser) throws SQLException;
    //update
    void update(UserJDBC userJDBC) throws SQLException;
    //delete
    void remove(UserJDBC userJDBC) throws SQLException;
}
