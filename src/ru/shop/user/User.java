package ru.shop.user;

import ru.shop.product.Product;
import ru.shop.product.ProductSize;
import ru.shop.product.Store;

import java.util.Map;
import java.util.Set;

public class User {
    private String address;
    private final Map<Product, Integer> shoppingCart;

    public User(String address, Map<Product, Integer> shoppingCart) {
        this.address = address;
        this.shoppingCart = shoppingCart;
    }

    public String getAddress() {
        return address;
    }

    public Map<Product, Integer> getShoppingCart() {
        return shoppingCart;
    }

    public void addProduct(String iD, ProductSize size) {
        boolean added = false;
        Store store = Store.getInstance();
        for (Map.Entry<String, Map<Product, Integer>> entryStore : store.getProducts().entrySet()) {
            for (Map.Entry<Product, Integer> entryProducts : entryStore.getValue().entrySet()) {
                if (entryProducts.getKey().getSize().equals(size) &&
                        entryProducts.getKey().getProductID().equals(iD) &&
                        entryProducts.getValue() > 0 &&
                        shoppingCart.containsKey(entryProducts.getKey())) {
                    int amount = shoppingCart.get(entryProducts.getKey());
                    shoppingCart.put(entryProducts.getKey(), amount + 1);
                    System.out.println("В вашу корзину добавлен новый товар");
                    added = true;
                } else if (entryProducts.getKey().getSize().equals(size) &&
                        entryProducts.getKey().getProductID().equals(iD) &&
                        entryProducts.getValue() > 0) {
                    shoppingCart.put(entryProducts.getKey(), 1);
                    System.out.println("В вашу корзину добавлен новый товар");
                    added = true;
                }
            }
        }
        if (!added) System.out.println("Этого товара нет в наличии!");
    }

    public void deleteFromCart(int number) {
        Set<Product> list = shoppingCart.keySet();
        Product[] prodArray = list.toArray(Product[]::new);
        System.out.println(prodArray.length);
        int amount = shoppingCart.get(prodArray[number - 1]);
        if (amount > 1) {
            shoppingCart.put(prodArray[number - 1], amount - 1);
            System.out.println("Товар удален из корзины");
        } else {
            shoppingCart.remove(prodArray[number - 1]);
        }

    }

    public double cartPrice() {
        double sum = 0;
        for (Map.Entry<Product, Integer> entry : shoppingCart.entrySet()) {
            sum += entry.getKey().getPrice() * entry.getValue();
        }
        return sum;
    }

    public void displayCart() {
        int i = 1;
        System.out.println("Ваша корзина " + ((shoppingCart.isEmpty()) ? "пуста" : ":"));
        for (Map.Entry<Product, Integer> entry : shoppingCart.entrySet()) {
            System.out.println(i++ + ") " +
                    "№" + entry.getKey().getProductID() + " " + entry.getKey() +
                    ", размер: " + entry.getKey().getSize() +
                    ", количество: " + entry.getValue() + " ед.");
        }
        if (!shoppingCart.isEmpty())
            System.out.println("Общая сумма товаров в корзине: " + this.cartPrice() + " руб.");
    }
}
