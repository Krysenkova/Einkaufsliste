package main;

import shoppinglist.ShoppingList;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("--------------------Welcome to your shopping list!-------------------------");
        System.out.println("       To add a product write a name of the product and its price.");
        System.out.println("To remove a product from the list write remove and the name of the product.");
        System.out.println("             To show your full shopping list write print");
        System.out.println("    Write close to stop working with the shopping list and save it");

        ShoppingList shoppingList = new ShoppingList();
        boolean listIsEmpty = shoppingList.checkIfFileIsEmpty();
        if(!listIsEmpty){
            shoppingList.fillShoppingList();
        }
        String input;
        while(shoppingList.getSize() < 1000){
        input = Console.readStringFromStdin("Enter: ");
        if (input.startsWith("print")){
            shoppingList.printList();
        }
        else if(input.startsWith("remove")){
            shoppingList.removeFromList(input);
        }
        else if(input.startsWith("close")){
            shoppingList.saveAllItems();
            break;
        }
        else
            shoppingList.addToList(input);
            System.out.println("Total: " + shoppingList.getTotal());
    }}
}
