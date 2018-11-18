package Model;

public class Order {
    private String ProductID;
    private String ProductName;
    private String Price;

    public Order(String price, Order order) {
    }

    public Order(String productID, String productName, String price) {
        ProductID = productID;
        ProductName = productName;
        Price = price;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String productID) {
        ProductID = productID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
