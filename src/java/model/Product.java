package model;

import java.sql.Date;

public class Product extends Categories {

    private String productCode;
    private String name;
    private float price;
    private int stockQuantity;
    private int categoriesId;
    private java.util.Date startDate;
    private String image;

    public Product() {
    }

    public Product(String productCode, String name, float price, int stockQuantity, int categoriesId, java.util.Date startDate, String image) {
        this.productCode = productCode;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.categoriesId = categoriesId;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public int getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(int categoriesId) {
        this.categoriesId = categoriesId;
    }

    public java.util.Date getStartDate() {
        return startDate;
    }

    public void setStartDate(java.util.Date startDate) {
        this.startDate = startDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
