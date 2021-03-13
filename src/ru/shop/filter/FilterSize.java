package ru.shop.filter;

import ru.shop.product.Product;
import ru.shop.product.ProductSize;

import java.util.HashMap;
import java.util.Map;

public class FilterSize implements Filter{
    private ProductSize size;

    public FilterSize(ProductSize size) {
        this.size = size;
    }

    @Override
    public Map<String, Map<Product, Integer>> filterOut(Map<String, Map<Product, Integer>> store) {
        Map<String, Map<Product, Integer>> filteredStore = new HashMap<>();

        for (Map.Entry<String, Map<Product, Integer>> entryStore : store.entrySet()) {
            Map<Product, Integer> filteredProducts = new HashMap<>();
            for (Map.Entry<Product, Integer> entryProducts : entryStore.getValue().entrySet()) {
                if (entryProducts.getKey().getSize().equals(size)) {
                    filteredProducts.put(entryProducts.getKey(), entryProducts.getValue());
                    filteredStore.put(entryStore.getKey(), filteredProducts);
                }
            }
        }
        return filteredStore;
    }
}
