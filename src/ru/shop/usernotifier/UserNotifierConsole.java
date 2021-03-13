package ru.shop.usernotifier;

import ru.shop.product.Product;
import ru.shop.user.User;

import java.util.Map;

public class UserNotifierConsole implements UserNotifier {

    @Override
    public void notifyUserOrder(User user) {
        if (user.getShoppingCart().isEmpty()) {
            System.out.println("Ваша корзина пуста!");
        } else {
            System.out.println("Заказ успешно оформлен! Вы заказали:");
            int i = 1;
            for (Map.Entry<Product, Integer> entry : user.getShoppingCart().entrySet()) {
                System.out.println(i++ + ". " + entry.getKey() +
                        ", размер: " + entry.getKey().getSize() +
                        ", количество: " + entry.getValue() + " ед.");
            }
            System.out.println("Общая сумма заказа: " + user.cartPrice() + " руб.");
        }

    }

    public void notifyUserDelivery(User user) {
        if (!user.getShoppingCart().isEmpty()) {
            System.out.println("Ваш заказ отправляется на ваш адрес в г. " + user.getAddress());
        }
    }

    public void notifyUserError(String msg) {
        System.out.println(msg);
    }
}

