package seminars.first.hw;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ShopTest {

    /*
     1. Проверить, что магазин хранит верный список продуктов (количество продуктов, состав корзины)
     2. Проверить, что магазин возвращает верный самый дорого продукт getMostExpensiveProduct
     3. Проверить, что магазин возвращает верный отсортированный по цене список продуктов
    */

    public static void main(String[] args) {

        Product apple = new Product();
        apple.setTitle("Apple");
        apple.setCost(10);

        Product juice = new Product();
        juice.setTitle("Juice");
        juice.setCost(5);

        Product meat = new Product();
        meat.setTitle("Meat");
        meat.setCost(8);

        List<Product> productList = new ArrayList<>();
        productList.add(apple);
        productList.add(juice);
        productList.add(meat);

        Shop myShop = new Shop();
        myShop.setProducts(productList);

        assertThat(myShop.getProducts()).isNotEmpty().hasSize(3).contains(apple, juice, meat);
        assertThat(myShop.getMostExpensiveProduct()).isEqualTo(apple);
        assertThat(myShop.getSortedListProducts()).isEqualTo(Arrays.asList(juice, meat, apple));

    }
}




