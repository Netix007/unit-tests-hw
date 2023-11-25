package seminars.first.hw;

public class Product implements Comparable{
    private int cost; // Стоимость продукта
    private String title; // Название

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int compareTo(Object o) {
        Product p = (Product) o;
        return this.cost - p.cost;
    }

    @Override
    public String toString() {
        return "Title: " + this.title + " "
                + "Cost: " + this.cost;
    }

}

