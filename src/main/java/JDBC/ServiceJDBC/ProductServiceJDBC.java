package JDBC.ServiceJDBC;

import BusinessLogic.Util;
import JDBC.DAO.ProductDAO;
import JDBC.EntityJDBC.ProductJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceJDBC extends Util implements ProductDAO {

    Connection connection = getConnection();

    public void add(ProductJDBC productJDBC) throws SQLException {
        if(connection.isClosed()){
            connection = getConnection();
        }
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO product (idProduct, name, description, price) VALUES(?, ?, ?, ?)";//insert product
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, productJDBC.getIdProduct());
            preparedStatement.setString(2, productJDBC.getName());
            preparedStatement.setString(3, productJDBC.getDescription());
            preparedStatement.setDouble(4, productJDBC.getPrice());

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

    public List<ProductJDBC> getAll() throws SQLException {
        if(connection.isClosed()){
            connection = getConnection();
        }
        List<ProductJDBC> productJDBCList = new ArrayList<ProductJDBC>();

        String sql = "SELECT idProduct, name, description, price FROM product"; //select * from product;

        Statement statement = null;
        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                ProductJDBC productJDBC = new ProductJDBC();
                productJDBC.setIdProduct(resultSet.getInt("idProduct"));
                productJDBC.setName(resultSet.getString("name"));
                productJDBC.setDescription(resultSet.getString("description"));
                productJDBC.setPrice(resultSet.getDouble("price"));

                productJDBCList.add(productJDBC);
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

        return productJDBCList;
    }

    public ProductJDBC getById(int idProduct) throws SQLException {
        if(connection.isClosed()){
            connection = getConnection();
        }
        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM product WHERE idProduct=?";//select where id=?

        ProductJDBC productJDBC = new ProductJDBC();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idProduct);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            productJDBC.setIdProduct(resultSet.getInt("idProduct"));
            productJDBC.setName(resultSet.getString("name"));
            productJDBC.setDescription(resultSet.getString("description"));
            productJDBC.setPrice(resultSet.getDouble("price"));

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
        return productJDBC;
    }

    public void update(ProductJDBC productJDBC) throws SQLException {
        if(connection.isClosed()){
            connection = getConnection();
        }
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE product SET name=?, description=?, price=? WHERE idProduct=?"; //update

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, productJDBC.getIdProduct());
            preparedStatement.setString(2, productJDBC.getName());
            preparedStatement.setString(3, productJDBC.getDescription());
            preparedStatement.setDouble(4, productJDBC.getPrice());

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

    public void remove(ProductJDBC productJDBC) throws SQLException {
        if(connection.isClosed()){
            connection = getConnection();
        }
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM product WHERE idProduct=?"; //delete

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, productJDBC.getIdProduct());

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
