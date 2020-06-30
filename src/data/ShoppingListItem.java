package data;

public class ShoppingListItem {
    private String product;
    private int price;

    public ShoppingListItem(String product, int price) {
        this.product = product;
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return product + " " + price;
    }
}
