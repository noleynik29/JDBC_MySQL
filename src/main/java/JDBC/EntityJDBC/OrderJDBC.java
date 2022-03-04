package JDBC.EntityJDBC;

public class OrderJDBC {
    private int idOrder;
    private int idUser;
    private int totalPrice;
    private String date;

    public OrderJDBC(){

    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {this.date = date;}

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderJDBC orderJDBC = (OrderJDBC) o;

        if (idOrder != orderJDBC.idOrder) return false;
        if (idUser != orderJDBC.idUser) return false;
        if (totalPrice != orderJDBC.totalPrice) return false;
        return date.equals(orderJDBC.date);
    }

    @Override
    public int hashCode() {
        int result = idOrder;
        result = 31 * result + idUser;
        result = 31 * result + totalPrice;
        result = 31 * result + date.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "OrderJDBC{" +
                "idOrder=" + idOrder +
                ", idUser=" + idUser +
                ", totalPrice=" + totalPrice +
                ", date=" + date +
                '}';
    }
}
