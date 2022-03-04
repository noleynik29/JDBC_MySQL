package JDBC.EntityJDBC;

public class ProductJDBC {
    private int idProduct;
    private String name;
    private String description;
    private double price;

    public ProductJDBC(){

    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductJDBC that = (ProductJDBC) o;

        if (idProduct != that.idProduct) return false;
        if (price != that.price) return false;
        if (!name.equals(that.name)) return false;
        return description.equals(that.description);
    }

    @Override
    public int hashCode() {
        double result = idProduct;
        result = 31 * result + name.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + price;
        return (int) result;
    }

    @Override
    public String toString() {
        return "ProductJDBC{" +
                "idProduct=" + idProduct +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
