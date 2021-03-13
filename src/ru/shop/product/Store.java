package ru.shop.product;

import java.util.HashMap;
import java.util.Map;

public class Store {

    private Map<String, Map<Product, Integer>> storeMap = new HashMap<>();
    private static Store instance = null;

    private Store() {
    }

    public static Store getInstance() {
        if (instance == null) instance = new Store();
        return instance;
    }

    public Map<String, Map<Product, Integer>> getProducts() {
        return storeMap;
    }

    public void addProduct(Product p, int quantity) {
        //принцип замены Барбары Лисков. Классы User и Store не связаны логически
        //User не является расширением Store и наоборот и они не связаны отношением наследования
        if (storeMap.containsKey(p.getProductID())) {
            Map<Product, Integer> products = storeMap.get(p.getProductID());
            products.put(p, quantity);
        } else {
            Map<Product, Integer> products = new HashMap<>();
            products.put(p, quantity);
            storeMap.put(p.getProductID(), products);
        }
    }

    public Product getProductFromStore(String iD) {
        Map<Product, Integer> products = storeMap.get(iD);
        for (Product p : products.keySet()) {
            if (p.getProductID().equals(iD)) {
                return p;
            }
        }
        return null;
    }

}
