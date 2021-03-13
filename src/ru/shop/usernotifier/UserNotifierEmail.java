package ru.shop.usernotifier;

import ru.shop.user.User;

public class UserNotifierEmail implements UserNotifier {
    @Override
    public void notifyUserOrder(User user) {
        //отправляет пользователю информацию о приобретенных товарах на e-mail
    }

    @Override
    public void notifyUserDelivery(User user) {
        //отправляет пользователю информацию по доставке на e-mail
    }

    @Override
    public void notifyUserError(String msg) {

    }
}
