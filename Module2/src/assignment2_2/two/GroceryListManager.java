package assignment2_2.two;

import java.util.ArrayList;

public class GroceryListManager {
    private ArrayList<String> groceryList;

    public GroceryListManager() {
        groceryList = new ArrayList<>();
    }

    // methods
    public void addItem(String item) {
        if (this.checkItem(item)) {
            return;
        }
        groceryList.add(item);
    }

    public void removeItem(String item) {
        if (!groceryList.contains(item)) {
            System.out.printf("Item \"%s\" not in ArrayList\n", item);
            return;
        }
        groceryList.remove(item);
    }

    public void displayList() {
        if (this.groceryList.isEmpty()) {
            System.out.println("Empty shopping list");
            return;
        }
        System.out.println("Grocery List:");
        int count = 1;
        for (String item : this.groceryList) {
            System.out.printf("%d. %s\n", count, item);
            count++;
        }
    }

    public boolean checkItem(String item) {
        return groceryList.contains(item);
    }

    public static void main(String[] args) {
        assignment2_2.one.GroceryListManager groceryListManager = new assignment2_2.one.GroceryListManager();

        // display
        groceryListManager.displayList();

        // add items to grocery list
        groceryListManager.addItem("Apples");
        groceryListManager.addItem("Milk");
        groceryListManager.addItem("Bread");
        groceryListManager.addItem("Bread");

        // display
        groceryListManager.displayList();

        // check item
        System.out.printf("Is \"Milk\" in the grocery list? %b\n", groceryListManager.checkItem("Milk"));

        // remove item
        System.out.println("Removing \"Milk\" from the list...");
        groceryListManager.removeItem("Milk");

        System.out.println("Removing \"Bananas\" from the list...");
        groceryListManager.removeItem("Bananas");

        // display
        groceryListManager.displayList();
    }
}

