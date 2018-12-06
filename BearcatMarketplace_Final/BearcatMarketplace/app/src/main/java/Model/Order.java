package Model;

import java.io.Serializable;

public class Order implements Serializable{
    private String ProductID;
    private String ProductName;
    private String Price;
    private int image;
    private String type;
    String description;

    public Order() {
    }

    public Order(String productID, String productName, String price,int image,String type,String description) {
        this.ProductID = productID;
        this.ProductName = productName;
        this.Price = price;
        this.image=image;
        this.type=type;
        this.description=description;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
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
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
