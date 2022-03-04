package JDBC.ServiceJDBC;

import BusinessLogic.Util;
import JDBC.DAO.UserDAO;
import JDBC.EntityJDBC.UserJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceJDBC extends Util implements UserDAO {

    Connection connection = getConnection();

    public void add(UserJDBC userJDBC) throws SQLException {
        if(connection.isClosed()){
            connection = getConnection();
        }
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO `user` (idUser, first_name, last_name) VALUES(?, ?, ?)";//insert user
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userJDBC.getIdUser());
            preparedStatement.setString(2, userJDBC.getFirstName());
            preparedStatement.setString(3, userJDBC.getLastName());

            preparedStatement.executeUpdate();
        } catch (SQLException exception){
            exception.printStackTrace();
        } finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
    }

    public List<UserJDBC> getAll() throws SQLException {
        if(connection.isClosed()){
            connection = getConnection();
        }
        List<UserJDBC> userJDBCList = new ArrayList<UserJDBC>();

        String sql = "SELECT idUser, first_name, last_name FROM `user`"; //select * from user;

        Statement statement = null;
        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                UserJDBC userJDBC = new UserJDBC();
                userJDBC.setIdUser(resultSet.getInt("idUser"));
                userJDBC.setFirstName(resultSet.getString("first_name"));
                userJDBC.setLastName(resultSet.getString("last_name"));

                userJDBCList.add(userJDBC);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        }

        return userJDBCList;
    }

    public UserJDBC getById(int idUser) throws SQLException {
        if(connection.isClosed()){
            connection = getConnection();
        }
        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM `user` WHERE idUser=?";//select

        UserJDBC userJDBC = new UserJDBC();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idUser);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            userJDBC.setIdUser(resultSet.getInt("idUser"));
            userJDBC.setFirstName(resultSet.getString("first_name"));
            userJDBC.setLastName(resultSet.getString("last_name"));

            preparedStatement.executeQuery();
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
        return userJDBC;
    }

    public void update(UserJDBC userJDBC) throws SQLException {
        if(connection.isClosed()){
            connection = getConnection();
        }
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE `user` SET first_name=?, last_name=? WHERE idUser=?"; //update

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userJDBC.getIdUser());
            preparedStatement.setString(2, userJDBC.getFirstName());
            preparedStatement.setString(3, userJDBC.getLastName());

            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
    }

    public void remove(UserJDBC userJDBC) throws SQLException {
        if(connection.isClosed()){
            connection = getConnection();
        }
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM `user` WHERE idUser=?"; //delete

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, userJDBC.getIdUser());

            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
    }
}
