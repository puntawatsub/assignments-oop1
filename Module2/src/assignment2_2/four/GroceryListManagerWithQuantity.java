package assignment2_2.four;

import assignment2_2.two_and_three.GroceryListManager;

import java.util.HashMap;

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

    public void addItem(String item, double cost, String category, int quantity) {
        super.addItem(item, cost, category);
        if (this.groceriesQuantity.containsKey(item)) {
            System.out.printf("%s exists.\n", item);
            return;
        }
        this.groceriesQuantity.put(item, quantity);
    }
}

