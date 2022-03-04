package JDBC.EntityJDBC;

public class ShoppingCartJDBC {
    private int idShoppingCart;
    private int idOrder;
    private int idProduct;
    private int orderQuantity;

    public ShoppingCartJDBC(){

    }

    public int getIdShoppingCart() {
        return idShoppingCart;
    }

    public void setIdShoppingCart(int idShoppingCart) {
        this.idShoppingCart = idShoppingCart;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoppingCartJDBC that = (ShoppingCartJDBC) o;

        if (idShoppingCart != that.idShoppingCart) return false;
        if (idOrder != that.idOrder) return false;
        if (idProduct != that.idProduct) return false;
        return orderQuantity == that.orderQuantity;
    }

    @Override
    public int hashCode() {
        int result = idShoppingCart;
        result = 31 * result + idOrder;
        result = 31 * result + idProduct;
        result = 31 * result + orderQuantity;
        return result;
    }

    @Override
    public String toString() {
        return "ShoppingCartJDBC{" +
                "idShoppingCart=" + idShoppingCart +
                ", idOrder=" + idOrder +
                ", idProduct=" + idProduct +
                ", orderQuantity=" + orderQuantity +
                '}';
    }
}
