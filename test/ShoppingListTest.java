import org.junit.Assert;
import org.junit.Test;
import shoppinglist.ShoppingList;

import java.io.FileNotFoundException;

public class ShoppingListTest {


    public ShoppingList provideTestShoppingList() throws FileNotFoundException {
        ShoppingList sp = new ShoppingList();
        String product1 = "Cheese 3";
        String product2 = "Strawberry 2";
        String product3 = "Bread 1";
        sp.addToList(product1);
        sp.addToList(product2);
        sp.addToList(product3);
        return sp;
    }

    @Test
    public void addToListTest() throws FileNotFoundException {
        ShoppingList sp = provideTestShoppingList();
        String product = "Honey 3";
        sp.addToList(product);
        //added at index 3
        Assert.assertEquals(sp.getItemAtIndex(3).toString(), product);
    }

    @Test
    public void removeFromListTest() throws FileNotFoundException {
        ShoppingList sp = provideTestShoppingList();
        sp.removeFromList("remove cheese");
        //the size should decrease
        Assert.assertEquals(sp.getSize(), 2);
        //no more cheese, but strawberry at index 0
        Assert.assertEquals(sp.getItemAtIndex(0).toString(), "Strawberry 2");
    }

    @Test
    public void getSizeTest() throws FileNotFoundException {
        ShoppingList sp = provideTestShoppingList();
        Assert.assertEquals(sp.getSize(), 3);
        sp.removeFromList("remove bread");
        //the size should decrease
        Assert.assertEquals(sp.getSize(), 2);
        String product = "Honey 3";
        sp.addToList(product);
        //the size should increase
        Assert.assertEquals(sp.getSize(), 3);
        //add duplicate -> size won't change as duplicate wouldn't be added
        sp.addToList(product);
        Assert.assertEquals(sp.getSize(), 3);
    }

    @Test
    public void getTotalTest() throws FileNotFoundException {
        ShoppingList sp = provideTestShoppingList();
        //3+2+1
        Assert.assertEquals(sp.getTotal(), 6);
        String product = "Honey 3";
        sp.addToList(product);
        //3+2+1+3
        Assert.assertEquals(sp.getTotal(), 9);
        sp.removeFromList("remove strawberry");
        //3+1+3
        Assert.assertEquals(sp.getTotal(), 7);
    }

}
