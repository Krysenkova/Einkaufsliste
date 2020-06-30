package shoppinglist;

import data.ShoppingListItem;

import java.io.*;
import java.util.ArrayList;

public class ShoppingList implements ShoppingListI {

    private ArrayList<ShoppingListItem> shoppingList = new ArrayList<>();

    private String filename1 = "shoppinglist.txt";

    //for writing into a file
    private OutputStream os1 = new FileOutputStream(filename1, true);
    private DataOutputStream dos1 = new DataOutputStream(os1);

    //for reading from file
    private InputStream is1 = new FileInputStream(filename1);
    private DataInputStream dis1 = new DataInputStream(is1);

    public ShoppingList() throws FileNotFoundException {
    }


    @Override
    public void addToList(String newProduct) {
        ShoppingListItem newItem = divide(newProduct);
        if (newItem != null) {
            shoppingList.add(newItem);
        }
    }

    private ShoppingListItem divide(String stringToDivide) {
        String workingString = stringToDivide.replaceAll("\\s", "");
        String[] parts = workingString.split("(?<=\\D)(?=\\d)");
        String newGood = parts[0];
        ShoppingListItem newItem = null;
        int newPrice = Integer.parseInt(parts[1]);
        if (isInTheList(newGood)) {
            System.out.println("Exception: Duplicated entry!");
        } else
            newItem = new ShoppingListItem(newGood, newPrice);
        return newItem;
    }

    @Override
    public void removeFromList(String product) {
        ShoppingListItem toRemove = null;
        String productToRemove = product.substring(7);
        for (ShoppingListItem shoppingListItem : shoppingList) {
            if (productToRemove.toLowerCase().equals(shoppingListItem.getProduct().toLowerCase())) {
                toRemove = shoppingListItem;
            }
        }
        shoppingList.remove(toRemove);
    }

    @Override
    public void printList() {
        System.out.println("-------------------");
        System.out.println("Your shopping list:");
        for (ShoppingListItem shoppingListItem : shoppingList) {
            System.out.println(shoppingListItem);
        }
        System.out.println("-------------------");
    }

    @Override
    public int getSize() {
        return shoppingList.size();
    }

    @Override
    public int getTotal() {
        int total = 0;
        for (ShoppingListItem shoppingListItem : shoppingList) {
            total = total + shoppingListItem.getPrice();
        }
        return total;
    }

    public boolean checkIfFileIsEmpty() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename1));
        return br.readLine() == null;
    }

    public void fillShoppingList() throws IOException {
        int numberOfItems = dis1.readInt();
        for (int i = 0; i < numberOfItems; i++) {
            String oldProduct = dis1.readUTF();
            int oldPrice = dis1.readInt();
            var oldItem = new ShoppingListItem(oldProduct, oldPrice);
            shoppingList.add(oldItem);
        }
    }

    public void saveAllItems() throws IOException {
        new FileOutputStream(filename1).close();
        dos1.writeInt(shoppingList.size());
        for (ShoppingListItem shoppingListItem : shoppingList) {
            dos1.writeUTF(shoppingListItem.getProduct());
            dos1.writeInt(shoppingListItem.getPrice());
        }

    }

    private boolean isInTheList(String checkIfInTheList) {
        for (ShoppingListItem shoppingListItem : shoppingList) {
            if (checkIfInTheList.toLowerCase().equals(shoppingListItem.getProduct().toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public ShoppingListItem getItemAtIndex(int index){
        return shoppingList.get(index);
    }
}
