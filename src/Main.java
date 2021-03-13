import ru.shop.filter.Filter;
import ru.shop.filter.FilterManufacturer;
import ru.shop.filter.FilterPrice;
import ru.shop.filter.FilterSize;
import ru.shop.product.*;
import ru.shop.user.User;
import ru.shop.usernotifier.UserNotifier;
import ru.shop.usernotifier.UserNotifierConsole;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Store store = Store.getInstance();

    public static void main(String[] args) {
        UserNotifier consoleNotifier = new UserNotifierConsole();
        ProductBuilder builder = new ProductBuilder();
        User user = new User("Ufa", new HashMap<>());

        store.addProduct(builder.setProductID("987").setProductName("Парка мужская")
                .setManufacturer(Manufacturer.THE_NORTH_FACE).setSize(ProductSize.L)
                .setPrice(27999.00).build(), 3);

        store.addProduct(builder.setProductID("987").setProductName("Парка мужская")
                .setManufacturer(Manufacturer.THE_NORTH_FACE).setSize(ProductSize.M)
                .setPrice(27999.00).build(), 5);

        store.addProduct(builder.setProductID("981").setProductName("Ветровка женская")
                .setManufacturer(Manufacturer.NIKE).setSize(ProductSize.XS)
                .setPrice(6780.00).build(), 2);

        store.addProduct(builder.setProductID("121").setProductName("Пуховик мужской")
                .setManufacturer(Manufacturer.JACK_WOLFSKIN).setSize(ProductSize.XXL)
                .setPrice(17999.00).build(), 2);

        store.addProduct(builder.setProductID("121").setProductName("Пуховик мужской")
                .setManufacturer(Manufacturer.JACK_WOLFSKIN).setSize(ProductSize.L)
                .setPrice(17999.00).build(), 4);

        store.addProduct(builder.setProductID("121").setProductName("Пуховик мужской")
                .setManufacturer(Manufacturer.JACK_WOLFSKIN).setSize(ProductSize.M)
                .setPrice(17999.00).build(), 5);

        store.addProduct(builder.setProductID("234").setProductName("Пуховик женский")
                .setManufacturer(Manufacturer.CANADA_GOOSE).setSize(ProductSize.XS)
                .setPrice(34999.00).build(), 6);

        store.addProduct(builder.setProductID("234").setProductName("Пуховик женский")
                .setManufacturer(Manufacturer.CANADA_GOOSE).setSize(ProductSize.S)
                .setPrice(34999.00).build(), 1);

        store.addProduct(builder.setProductID("234").setProductName("Пуховик женский")
                .setManufacturer(Manufacturer.CANADA_GOOSE).setSize(ProductSize.M)
                .setPrice(34999.00).build(), 8);

        store.addProduct(builder.setProductID("356").setProductName("Ветровка мужская")
                .setManufacturer(Manufacturer.ADIDAS).setSize(ProductSize.L)
                .setPrice(9999.00).build(), 8);

        store.addProduct(builder.setProductID("356").setProductName("Ветровка мужская")
                .setManufacturer(Manufacturer.ADIDAS).setSize(ProductSize.XL)
                .setPrice(9999.00).build(), 7);

        store.addProduct(builder.setProductID("356").setProductName("Ветровка мужская")
                .setManufacturer(Manufacturer.ADIDAS).setSize(ProductSize.S)
                .setPrice(9999.00).build(), 5);

        store.addProduct(builder.setProductID("445").setProductName("Парка женская")
                .setManufacturer(Manufacturer.NIKE).setSize(ProductSize.M)
                .setPrice(8760.00).build(), 0);

        store.addProduct(builder.setProductID("445").setProductName("Парка женская")
                .setManufacturer(Manufacturer.NIKE).setSize(ProductSize.S)
                .setPrice(8760.00).build(), 6);

        store.addProduct(builder.setProductID("445").setProductName("Парка женская")
                .setManufacturer(Manufacturer.NIKE).setSize(ProductSize.L)
                .setPrice(8760.00).build(), 2);

        System.out.println("Интернет-магазин курток и пуховиков");
        System.out.println("\n\t* * * * * * * * * * * * * * * *");
        boolean userIsShopping = true;

        while (userIsShopping) {
            System.out.println("\nСписок опций:");
            System.out.println("1. Отобразить список товаров" +
                    "\n2. Фильтрация списка товаров" +
                    "\n3. Отобразить корзину покупателя" +
                    "\n4. Удалить товар из корзины" +
                    "\n5. Завершить покупки");
            String inputOptions = scanner.nextLine();

            switch (inputOptions) {
                case "5":
                    consoleNotifier.notifyUserOrder(user);
                    consoleNotifier.notifyUserDelivery(user);
                    userIsShopping = false;
                    break;
                case "1":
                    while (true) {
                        showProducts(store.getProducts());
                        System.out.println("\nВведите ID и размер товара через пробел для добавления в корзину");
                        System.out.println("для возврата в меню введите любой символ");
                        try {
                            String[] parts = scanner.nextLine().split(" ");
                            ProductSize pS = ProductSize.getEnumSizeFromString(parts[1]);
                            if (pS != null) {
                                user.addProduct(parts[0], pS);
                                break;
                            } else System.out.println("Неверный ввод данных!");
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }
                    break;

                case "2":
                    System.out.println("Вы можете отфильтровать список по:" +
                            "\n1. Производитель" +
                            "\n2. Размер" +
                            "\n3. Цена");
                    String inputFiltration = scanner.nextLine();
                    switch (inputFiltration) {
                        case "1":
                            int i = 1;
                            for (Manufacturer m : Manufacturer.values()) {
                                System.out.println(i++ + ". " + m);
                            }
                            String inputManufacturer = scanner.nextLine();

                            switch (inputManufacturer) {
                                case "1" -> {
                                    Filter filterNF = new FilterManufacturer(Manufacturer.THE_NORTH_FACE);
                                    showProducts(filterNF.filterOut(store.getProducts()));
                                }
                                case "2" -> {
                                    Filter filterCG = new FilterManufacturer(Manufacturer.CANADA_GOOSE);
                                    showProducts(filterCG.filterOut(store.getProducts()));
                                }
                                case "3" -> {
                                    Filter filterJW = new FilterManufacturer(Manufacturer.JACK_WOLFSKIN);
                                    showProducts(filterJW.filterOut(store.getProducts()));
                                }
                                case "4" -> {
                                    Filter filterNk = new FilterManufacturer(Manufacturer.NIKE);
                                    showProducts(filterNk.filterOut(store.getProducts()));
                                }
                                case "5" -> {
                                    Filter filterAdds = new FilterManufacturer(Manufacturer.ADIDAS);
                                    showProducts(filterAdds.filterOut(store.getProducts()));
                                }
                            }
                        case "2":
                            System.out.println("Введите размер (например, XL)");
                            String inputSize = scanner.nextLine();
                            Filter filter = new FilterSize(ProductSize.getEnumSizeFromString(inputSize));
                            showProducts(filter.filterOut(store.getProducts()));
                            break;
                        case "3":
                            System.out.println("Введите нужный диапазон цен через пробел");
                            String[] parts = scanner.nextLine().split(" ");
                            Filter filterPrice = new FilterPrice(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
                            showProducts(filterPrice.filterOut(store.getProducts()));
                            break;
                    }
                    break;

                case "3":
                    user.displayCart();
                    break;
                case "4":
                    if (user.getShoppingCart().isEmpty()) {
                        System.out.println("В корзине нет товаров");
                    } else {
                        user.displayCart();
                        System.out.println("Введите номер товара в корзине, который хотите удалить");
                        int inputReturn = Integer.parseInt(scanner.nextLine());
                        user.deleteFromCart(inputReturn);
                    }
                    break;
            }

        }

    }

    public static void showProducts(Map<String, Map<Product, Integer>> storeMap) {
        for (Map.Entry<String, Map<Product, Integer>> entryStore : storeMap.entrySet()) {
            System.out.println("№" + entryStore.getKey() + " " + store.getProductFromStore(entryStore.getKey()));
            for (Map.Entry<Product, Integer> entryProduct : entryStore.getValue().entrySet()) {
                System.out.println("\t- размер " + entryProduct.getKey().getSize() +
                        ": на складе " + entryProduct.getValue() + " ед.");
            }
        }
    }

}
