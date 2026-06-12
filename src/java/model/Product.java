package model;

import java.sql.Date;

public class Product {

    private String productCode;
    private String name;
    private double price;
    private int stockQuantity;
    private int categoryID;
    private Date startDate;
    private String image;

    public Product() {
    }

    public Product(String productCode, String name, double price, int stockQuantity, int categoryID, Date startDate, String image) {
        this.productCode = productCode;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.categoryID = categoryID;
        this.startDate = startDate;
        this.image = image;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}