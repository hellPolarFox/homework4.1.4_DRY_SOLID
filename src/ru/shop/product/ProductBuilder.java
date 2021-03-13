package ru.shop.product;

public class ProductBuilder {

    protected String productID, productName;
    protected Manufacturer manufacturer;
    protected ProductSize size;
    protected double price;

    public ProductBuilder setProductID(String productID) {
        this.productID = productID;
        return this;
    }

    public ProductBuilder setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public ProductBuilder setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public ProductBuilder setSize(ProductSize size) {
        this.size = size;
        return this;
    }

    public ProductBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public Product build() {
        return new Product(productID, productName, manufacturer, size, price);
    }
}
