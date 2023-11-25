package seminars.first;

import seminars.first.model.Hero;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Main {


    public static void main(String[] args) {
        //assertConditionA();


        //assertConditionB();

        //System.out.println(sum(2_147_483_647, 2));

        //happyNY();

        expectedValue();

        checkingShoppingCart();

        String[] colors = {"aqua", "green", "violet", "orange", "yellow", "blue", "gold"};
        testingJavaCollectionsAssertJ(colors);

        List<String> heroBag = Arrays.asList("Bow", "Axe", "Gold");
        Hero emmett = new Hero("Emmett", 50, "sword", heroBag, true);
        checkingHero(emmett);
    }

    /**
     * 1) ����� ����� � ��������� ������ � �������� assert
     */
    public static void assertConditionA() {
        String[] weekends = {"�������", "�����������"};
        assert weekends.length == 2;
        System.out.println("� ������ " + weekends.length + " ��� ��������");
    }

    /**
     * 2) ����� ����� � ��������� ������ � �������� assert
     */
    public static void assertConditionB() {
        int x = -1;
        assert x <= 0;
    }

    /**
     * 3) �����, ��������� ������ �������, ����������� ������� ��� ��������� �����
     * 2_147_483_647 � 1, �������� assert ���� �����
     * (https://habr.com/ru/company/pvs-studio/blog/306748/)
     *
     * @param a ������ �����
     * @param b ������ �����
     * @return ����� ���������� �����
     * @apiNote assert boolean_��������� : ���������_��_������;
     */
    public static int sum(int a, int b) {
        assert Integer.MAX_VALUE - a - b > 0;
        return a + b;
    }

    /**
     * 4) ����� ����� � ��������� ������ � �������� assert
     * windows fail - https://habr.com/ru/company/pvs-studio/blog/698404/
     */
    public static void happyNY() {
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String currentDateTime = dateFormat.format(calendar.getTime());

        // �������� ������ currentDateTime � ������� "09/12/2022 20:20:04"

        assert currentDateTime.equals("01/01/2023 00:00:00") : "��� 2022 ��� :(";
        System.out.println("� ����� �����!");
    }

    /**
     * 5) ����������� ������������� �� ������, ����� ��������� ���, ����� ����������� �� ����������� ������
     */
    public static void checkingShoppingCart() {
        ArrayList<String> productCategories = new ArrayList<>();
        productCategories.add("fruits");
        productCategories.add("vegetables");
        productCategories.add("bakery");
        productCategories.add("liquid");

        ArrayList<String> products = new ArrayList<>();
        products.add("apple");
        products.add("tomato");
        products.add("bread");
        products.add("water");

        for (String product : products) {
            if (product.equals("apple")) {
                System.out.println("category: " + productCategories.get(0));
            } else if (product.equals("tomato")) {
                System.out.println("category: " + productCategories.get(1));
            } else if (product.equals("bread")) {
                System.out.println("category: " + productCategories.get(2));
            } else if (product.equals("water")) {
                System.out.println("category: " + productCategories.get(3));
            } else {
                assert false : "Unknown category for the product " + product;
            }
        }
    }

    /**
     * 6) ������� ������
     */
    public static void expectedValue() {
        assertThat(sum(2, 3)).isEqualTo(5);
    }

    /**
     * ����� �������� � ����� ������, ������� ������������� �������� � �����������
     *
     * @param colors ������ � �������
     */
    public static void testingJavaCollectionsAssertJ(String[] colors) {
        assertThat(colors)
                .isNotEmpty()
                .hasSize(7)
                .doesNotHaveDuplicates()
                .contains("orange", "green", "violet")
                .endsWith("gold")
                .startsWith("aqua")
                .containsSequence("yellow", "blue")
                .doesNotContain("red", "black");
    }

    /**
     * 8) ������������� ���� ��������: <p>
     * 1. ���������, ��� ����� �������� � ������ Emmett<p>
     * 2. ���������, ��� �������� ��������� ����� ����� ����� 50<p>
     * 3. ���������, ��� � ����� ������ ���� sword<p>
     * 4. ��������� ���������� ��������� ����� (������ 3, ���������� "Bow", "Axe", "Gold", ������� �� �����)<p>
     * 5. ���������, ��� ����� ��� ������� (�������� isHuman)<p>
     */
    public static void checkingHero(Hero hero) {
        assertThat(hero.getName()).isEqualTo("Emmett");
        assertThat(hero.getArmorStrength()).isEqualTo(50);
        assertThat(hero.getWeapon()).isEqualTo("sword");
        assertThat(hero.getBag()).isNotEmpty().hasSize(3).contains("Bow", "Axe", "Gold");
        assertThat(hero.isHuman()).isTrue();
    }

}