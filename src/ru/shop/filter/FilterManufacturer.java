package ru.shop.filter;

import ru.shop.product.Manufacturer;
import ru.shop.product.Product;

import java.util.HashMap;
import java.util.Map;

public class FilterManufacturer implements Filter{

    private Manufacturer manufacturer;

    public FilterManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public Map<String, Map<Product, Integer>> filterOut(Map<String, Map<Product, Integer>> store) {
        Map<String, Map<Product, Integer>> filteredStore = new HashMap<>();

        for (Map.Entry<String, Map<Product, Integer>> entryStore : store.entrySet()) {
            Map<Product, Integer> filteredProducts = new HashMap<>();
            for (Map.Entry<Product, Integer> entryProducts : entryStore.getValue().entrySet()) {
                if (entryProducts.getKey().getManufacturer().equals(manufacturer)) {
                    filteredProducts.put(entryProducts.getKey(), entryProducts.getValue());
                    filteredStore.put(entryStore.getKey(), filteredProducts);
                }
            }
        }
        return filteredStore;
    }
}
