import JDBC.EntityJDBC.OrderJDBC;
import JDBC.EntityJDBC.ProductJDBC;
import JDBC.EntityJDBC.ShoppingCartJDBC;
import JDBC.EntityJDBC.UserJDBC;
import JDBC.ServiceJDBC.OrderServiceJDBC;
import JDBC.ServiceJDBC.ProductServiceJDBC;
import JDBC.ServiceJDBC.ShoppingCartServiceJDBC;
import JDBC.ServiceJDBC.UserServiceJDBC;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        /*logger.info("Log4j2ExampleApp started.");
        logger.warn("Something to warn");
        logger.error("Something failed.");
        try {
            Files.readAllBytes(Paths.get("/file/does/not/exist"));
        } catch (IOException ioex) {
            logger.error("Error message", ioex);
        }*/ //log4j2
        //////////////////////////////////////////////////////JDBC
        OrderServiceJDBC orderServiceJDBC = new OrderServiceJDBC();
        ProductServiceJDBC productServiceJDBC = new ProductServiceJDBC();
        ShoppingCartServiceJDBC shoppingCartServiceJDBC = new ShoppingCartServiceJDBC();
        UserServiceJDBC userServiceJDBC = new UserServiceJDBC();

        UserJDBC userJDBC = new UserJDBC();
        userJDBC.setFirstName("George2");
        userJDBC.setLastName("Miller2");

        ProductJDBC productJDBC = new ProductJDBC();
        //productJDBC.setName("Marvel's Spider-Man");
        //productJDBC.setDescription("Game");
        //productJDBC.setPrice(120);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();

        OrderJDBC orderJDBC = new OrderJDBC();
        //orderJDBC.setIdUser(9);
        //orderJDBC.setDate(dateFormat.format(date));
        //orderJDBC.setTotalPrice(120);

        ShoppingCartJDBC shoppingCartJDBC = new ShoppingCartJDBC();
        //shoppingCartJDBC.setIdOrder(10);
        //shoppingCartJDBC.setIdProduct(18);
        //shoppingCartJDBC.setOrderQuantity(1);

        try{
            System.out.println(userServiceJDBC.getAll());
            //productServiceJDBC.add(productJDBC);
            //orderServiceJDBC.add(orderJDBC);
            //shoppingCartServiceJDBC.add(shoppingCartJDBC);
            //shoppingCartJDBC = shoppingCartServiceJDBC.getById(1);
            //System.out.println(shoppingCartJDBC);
            List<ProductJDBC> products = productServiceJDBC.getAll();
            for (ProductJDBC product: products) {
                logger.info(product);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } //JDBC
    }
}
