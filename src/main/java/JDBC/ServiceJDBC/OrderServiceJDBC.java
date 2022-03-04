package JDBC.ServiceJDBC;

import BusinessLogic.Util;
import JDBC.DAO.OrderDAO;
import JDBC.EntityJDBC.OrderJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class OrderServiceJDBC extends Util implements OrderDAO {

    Connection connection = getConnection();

    public void add(OrderJDBC orderJDBC) throws SQLException {
        if(connection.isClosed()){
            connection = getConnection();
        }
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO `order` (idOrder, idUser, total_price, datetime) VALUES(?, ?, ?, ?)";//insert order
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, orderJDBC.getIdOrder());
            preparedStatement.setInt(2, orderJDBC.getIdUser());
            preparedStatement.setInt(3, orderJDBC.getTotalPrice());
            preparedStatement.setString(4, orderJDBC.getDate());

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

    public List<OrderJDBC> getAll() throws SQLException {
        if(connection.isClosed()){
            connection = getConnection();
        }
        List<OrderJDBC> orderJDBCList = new ArrayList<OrderJDBC>();

        String sql = "SELECT idOrder, idUser, total_price, datetime FROM `order`"; //select * from order;

        Statement statement = null;
        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                OrderJDBC orderJDBC = new OrderJDBC();
                orderJDBC.setIdOrder(resultSet.getInt("idOrder"));
                orderJDBC.setIdUser(resultSet.getInt("idUser"));
                orderJDBC.setDate(resultSet.getString("datetime"));
                orderJDBC.setTotalPrice(resultSet.getInt("total_price"));

                orderJDBCList.add(orderJDBC);
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

        return orderJDBCList;
    }

    public OrderJDBC getById(int idOrder) throws SQLException {
        if(connection.isClosed()){
            connection = getConnection();
        }
        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM `order` WHERE idOrder=?";//select where id=?

        OrderJDBC orderJDBC = new OrderJDBC();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idOrder);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            orderJDBC.setIdOrder(resultSet.getInt("idOrder"));
            orderJDBC.setIdUser(resultSet.getInt("idUser"));
            orderJDBC.setDate(resultSet.getString("datetime"));
            orderJDBC.setTotalPrice(resultSet.getInt("total_price"));

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
        return orderJDBC;
    }

    public void update(OrderJDBC orderJDBC) throws SQLException {
        if(connection.isClosed()){
            connection = getConnection();
        }
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE `order` SET idUser=?, datetime=?, total_price=? WHERE idOrder=?"; //update

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, orderJDBC.getIdOrder());
            preparedStatement.setInt(2, orderJDBC.getIdUser());
            preparedStatement.setString(3, orderJDBC.getDate());
            preparedStatement.setInt(4, orderJDBC.getTotalPrice());

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

    public void remove(OrderJDBC orderJDBC) throws SQLException {
        if(connection.isClosed()){
            connection = getConnection();
        }
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM `order` WHERE idOrder=?"; //delete

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, orderJDBC.getIdOrder());

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
