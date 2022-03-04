package JDBC.ServiceJDBC;

import BusinessLogic.Util;
import JDBC.DAO.ShoppingCartDAO;
import JDBC.EntityJDBC.ShoppingCartJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartServiceJDBC extends Util implements ShoppingCartDAO {

    Connection connection = getConnection();

    public void add(ShoppingCartJDBC shoppingCartJDBC) throws SQLException {
        if(connection.isClosed()){
            connection = getConnection();
        }
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO shopping_cart (idOrder, idProduct, order_quantity) VALUES(?, ?, ?)";//insert shopping_cart
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, shoppingCartJDBC.getIdOrder());
            preparedStatement.setInt(2, shoppingCartJDBC.getIdProduct());
            preparedStatement.setInt(3, shoppingCartJDBC.getOrderQuantity());

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

    public List<ShoppingCartJDBC> getAll() throws SQLException {
        if(connection.isClosed()){
            connection = getConnection();
        }
        List<ShoppingCartJDBC> shoppingCartJDBCList = new ArrayList<ShoppingCartJDBC>();

        String sql = "SELECT idOrder, idProduct, order_quantity FROM shopping_cart"; //select * from shopping_cart;

        Statement statement = null;
        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                ShoppingCartJDBC shoppingCartJDBC = new ShoppingCartJDBC();
                shoppingCartJDBC.setIdOrder(resultSet.getInt("idOrder"));
                shoppingCartJDBC.setIdProduct(resultSet.getInt("idProduct"));
                shoppingCartJDBC.setOrderQuantity(resultSet.getInt("order_quantity"));

                shoppingCartJDBCList.add(shoppingCartJDBC);
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

        return shoppingCartJDBCList;
    }

    public ShoppingCartJDBC getById(int idShoppingCart) throws SQLException {
        if(connection.isClosed()){
            connection = getConnection();
        }
        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM shopping_cart WHERE idShoppingCart=?";//select

        ShoppingCartJDBC shoppingCartJDBC = new ShoppingCartJDBC();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idShoppingCart);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            shoppingCartJDBC.setIdShoppingCart(resultSet.getInt("idShoppingCart"));
            shoppingCartJDBC.setIdOrder(resultSet.getInt("idOrder"));
            shoppingCartJDBC.setIdProduct(resultSet.getInt("idProduct"));
            shoppingCartJDBC.setOrderQuantity(resultSet.getInt("order_quantity"));

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
        return shoppingCartJDBC;
    }

    public void update(ShoppingCartJDBC shoppingCartJDBC) throws SQLException {
        if(connection.isClosed()){
            connection = getConnection();
        }
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE shopping_cart SET idProduct=?, order_quantity=? WHERE idOrder=?"; //update

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, shoppingCartJDBC.getIdOrder());
            preparedStatement.setInt(2, shoppingCartJDBC.getIdProduct());
            preparedStatement.setInt(3, shoppingCartJDBC.getOrderQuantity());

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

    public void remove(ShoppingCartJDBC shoppingCartJDBC) throws SQLException {
        if(connection.isClosed()){
            connection = getConnection();
        }
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM shopping_cart WHERE idOrder=?"; //delete

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, shoppingCartJDBC.getIdOrder());

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
