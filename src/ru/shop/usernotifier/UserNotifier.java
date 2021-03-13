package ru.shop.usernotifier;

import ru.shop.user.User;

public interface UserNotifier {

    //этот интерфейс реализует принцип единственной ответственности.
    //Логика отправки уведомлений в консоль или на email при заказе товаров вынесена в отдельный класс,
    //а не находится в каком-либо другом классе
    void notifyUserOrder(User user);

    void notifyUserDelivery(User user);

    void notifyUserError(String msg);

}
