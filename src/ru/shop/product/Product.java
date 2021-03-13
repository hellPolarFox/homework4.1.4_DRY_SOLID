package ru.shop.product;

import java.util.Objects;

public class Product {
    private final String productID, productName;
    private final Manufacturer manufacturer;
    private ProductSize size;
    private double price;

    public Product(String productID,
                   String productName,
                   Manufacturer manufacturer,
                   ProductSize size,
                   double price) {
        this.productID = productID;
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.size = size;
        this.price = price;
    }

    public Product(String productID,
                   String productName,
                   Manufacturer manufacturer) {
        this.productID = productID;
        this.productName = productName;
        this.manufacturer = manufacturer;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public ProductSize getSize() {
        return size;
    }

    public void setSize(ProductSize size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return productName +
                ", производитель: " + manufacturer +
                ", цена: " + price + " руб.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                Objects.equals(productID, product.productID) &&
                Objects.equals(productName, product.productName) &&
                manufacturer == product.manufacturer &&
                size == product.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID, productName, manufacturer, size, price);
    }
}
