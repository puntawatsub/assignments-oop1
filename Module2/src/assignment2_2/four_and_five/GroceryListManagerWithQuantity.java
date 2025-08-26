package assignment2_2.four_and_five;

import assignment2_2.two_and_three.GroceryListManager;

import java.util.HashMap;
import java.util.Map;

public class GroceryListManagerWithQuantity extends GroceryListManager {
    private HashMap<String, Integer> groceriesQuantity;

    public GroceryListManagerWithQuantity() {
        super();
        this.groceriesQuantity = new HashMap<>();
    }

    @Override
    public void addItem(String item, double cost, String category) {
        this.addItem(item, cost, category, 1);
    }


    @Override
    public void removeItem(String item) {
        super.removeItem(item);
        // remove the quantity assigned to the item
        this.groceriesQuantity.remove(item);
    }

    @Override
    public double calculateTotalCost() {
        final HashMap<String, Double> groceryList = this.getGroceryList();
        double totalCost = 0;
        for (Map.Entry<String, Double> entry: groceryList.entrySet()) {
            final String key = entry.getKey();
            final Double value = entry.getValue();

            totalCost += value * this.groceriesQuantity.get(key);
        }

        return totalCost;
    }

    public void addItem(String item, double cost, String category, int quantity) {
        super.addItem(item, cost, category);
        if (this.groceriesQuantity.containsKey(item)) {
            return;
        }
        this.groceriesQuantity.put(item, quantity);
    }

    public void updateQuantity(String item, int newQuantity) {
        if (!this.groceriesQuantity.containsKey(item)) {
            System.out.printf("No item of name %s to update quantity. \n", item);
            return;
        } else if (newQuantity < 0) {
            System.out.println("New quantity must be positive.");
            return;
        } else if (newQuantity == 0) {
            this.removeItem(item);
            return;
        }
        this.groceriesQuantity.put(item, newQuantity);
    }

    public void displayAvailableItems() {
        System.out.println("All available items:");
        for (Map.Entry<String, Integer> entry: groceriesQuantity.entrySet()) {
            final String item = entry.getKey();
            final int quantity = entry.getValue();
            // only positive items will be displayed due to the update function automatically removing an item without positive quantity
            System.out.printf("%s, quantity: %d\n", item, quantity);
        }
    }

    public static void main(String[] args) {
        GroceryListManagerWithQuantity groceryListManager = new GroceryListManagerWithQuantity();

        // display
        groceryListManager.displayList();

        // add items to grocery list
        groceryListManager.addItem("Apples", 2.0, "Fruits", 2);
        groceryListManager.addItem("Milk", 1.0, "Dairy", 1);
        groceryListManager.addItem("White Bread", 1.29, "Bread", 3);
        groceryListManager.addItem("Rye Bread", 1.59, "Bread", 1);

        // display available items
        groceryListManager.displayAvailableItems();


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
        groceryListManager.displayAvailableItems();

        // calculate cost
        System.out.printf("Total cost: %.2f EUR\n", groceryListManager.calculateTotalCost());

        groceryListManager.removeItem("White Bread");

        // display categories again
        groceryListManager.displayByCategory("Bread");
        groceryListManager.displayByCategory("Dairy");

        // update quantity
        groceryListManager.updateQuantity("Apples", 1);
        groceryListManager.updateQuantity("Rye Bread", 0);

        // display available items
        groceryListManager.displayAvailableItems();

    }

}

