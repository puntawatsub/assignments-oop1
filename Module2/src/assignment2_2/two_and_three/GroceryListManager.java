package assignment2_2.two_and_three;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GroceryListManager {
    private HashMap<String, Double> groceryList;
    // list of items and its assigned category
    private HashMap<String, String> groceryCategories;
    // list of categories and its items
    private HashMap<String, ArrayList<String>> categoryList;

    public GroceryListManager() {
        groceryList = new HashMap<>();
        categoryList = new HashMap<>();
        groceryCategories = new HashMap<>();
    }

    // methods


    public HashMap<String, Double> getGroceryList() {
        return groceryList;
    }

    public void addItem(String item, double cost, String category) {
        // check if item exists
        if (this.checkItem(item)) {
            return;
        }

        // put item in grocery list
        groceryList.put(item, cost);

        // add item to category list
        if (this.categoryList.containsKey(category)) {
            // add item to category in hashmap
            ArrayList<String> tempList = this.categoryList.get(category);
            tempList.add(item);
        } else {
            // if the category is new, create a new ArrayList for that category, and put it in the hashmap
            ArrayList<String> tempList = new ArrayList<>();
            tempList.add(item);

            // put into the hashmap
            categoryList.put(category, tempList);
        }

        // assign category to the item
        this.groceryCategories.put(item, category);

    }

    public void removeItem(String item) {
        if (!groceryList.containsKey(item)) {
            System.out.printf("Item \"%s\" not in ArrayList\n", item);
            return;
        }
        // remove item from category list
        ArrayList<String> tempCategoryList = this.categoryList.get(groceryCategories.get(item));
        tempCategoryList.remove(item);
        // remove category if it's empty
        if (tempCategoryList.isEmpty()) {
            this.categoryList.remove(groceryCategories.get(item));
        }

        // unassign category to an item
        groceryCategories.remove(item);

        // remove the grocery item
        groceryList.remove(item);
    }

    public void displayList() {
        if (this.groceryList.isEmpty()) {
            System.out.println("Empty shopping list");
            return;
        }
        System.out.println("Grocery List:");
        int count = 1;
        for (Map.Entry<String, Double> entry: this.groceryList.entrySet()) {
            final String name = entry.getKey();
            final double price = entry.getValue();
            System.out.printf("%d. %s %.2f EUR\n", count, name, price);
            count++;
        }
    }

    public boolean checkItem(String item) {
        return groceryList.containsKey(item);
    }

    public double calculateTotalCost() {
        double cost = 0;
        for (Map.Entry<String, Double> entry: this.groceryList.entrySet()) {
            final double price = entry.getValue();
            cost += price;
        }

        return cost;
    }

    public void displayByCategory(String category) {
        if (!this.categoryList.containsKey(category)) {
            System.out.printf("No item in category %s.\n", category);
            return;
        }
        final ArrayList<String> tempCategory = this.categoryList.get(category);
        System.out.printf("Item(s) in %s: \n", category);
        for (String item: tempCategory) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        GroceryListManager groceryListManager = new GroceryListManager();

        // display
        groceryListManager.displayList();

        // add items to grocery list
        groceryListManager.addItem("Apples", 2.0, "Fruits");
        groceryListManager.addItem("Milk", 1.0, "Dairy");
        groceryListManager.addItem("White Bread", 1.29, "Bread");
        groceryListManager.addItem("Rye Bread", 1.59, "Bread");

        // display
        groceryListManager.displayList();

        // check item
        System.out.printf("Is \"Milk\" 2,00 EUR in the grocery list? %b\n", groceryListManager.checkItem("Milk"));

        // display item by category
        groceryListManager.displayByCategory("Bread");
        groceryListManager.displayByCategory("Dairy");

        // remove item
        System.out.println("Removing \"Milk\" from the list...");
        groceryListManager.removeItem("Milk");

        System.out.println("Removing \"Bananas\" from the list...");
        groceryListManager.removeItem("Bananas");

        // display
        groceryListManager.displayList();

        // calculate cost
        System.out.printf("Total cost: %.2f EUR\n", groceryListManager.calculateTotalCost());

        groceryListManager.removeItem("White Bread");

        // display categories again
        groceryListManager.displayByCategory("Bread");
        groceryListManager.displayByCategory("Dairy");


    }
}

