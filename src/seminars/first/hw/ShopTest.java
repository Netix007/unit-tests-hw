package seminars.first.hw;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ShopTest {

    /*
     1. ���������, ��� ������� ������ ������ ������ ��������� (���������� ���������, ������ �������)
     2. ���������, ��� ������� ���������� ������ ����� ������ ������� getMostExpensiveProduct
     3. ���������, ��� ������� ���������� ������ ��������������� �� ���� ������ ���������
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




