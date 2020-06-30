package shoppinglist;

public interface ShoppingListI {
    /**
     * @param newProduct String with new product name and its price
     */
    void addToList(String newProduct);

    /**
     * @param product item to delete from list
     */
    void removeFromList(String product);

    /**
     * prints all items from the shopping list
     */
    void printList();

    /**
     * @return number of items in the shopping list
     */
    int getSize();

    /**
     * @return sum of all prices
     */
    int getTotal();
}
