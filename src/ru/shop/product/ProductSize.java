package ru.shop.product;

public enum ProductSize {
    XS("XS"), S("S"), M("M"), L("L"), XL("XL"), XXL("XXL");

    private final String size;

    ProductSize(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public static ProductSize getEnumSizeFromString(String size) {
        for (ProductSize pS : ProductSize.values()) {
            if (pS.getSize().equals(size)) {
                return pS;
            }
        }
        return null;
    }
}
