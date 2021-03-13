package ru.shop.filter;

import ru.shop.product.Product;

import java.util.Map;

public interface Filter {

    //интерфейс реализует приницп сегрегации (разделения) интерфейса
    //он предназначен только для фильтрации списка товаров по предпочтению пользователя

    Map<String, Map<Product, Integer>> filterOut(Map<String, Map<Product, Integer>> store);
}
