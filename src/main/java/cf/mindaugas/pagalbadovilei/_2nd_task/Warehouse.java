package cf.mindaugas.pagalbadovilei._2nd_task;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    List<Item> items = new ArrayList<>();

    public static void main(String[] args) {
        // Init warehouse
        Warehouse warehouse = new Warehouse();

        System.out.println("... add item");
        warehouse.add(new Item("Scissors", 15.5));
        warehouse.add(new Item("Scissors", 15.5));
        warehouse.add(new Item("Scissors", 13.75));
        warehouse.add(new Item("Carpet", 10.0));

        System.out.println("... display item");
        warehouse.displayDetails(new Item("Scissors", 15.5));
        warehouse.displayDetails(new Item("Scissors", 13.75));

        System.out.println("... update item");
        warehouse.updateDetails(
                new Item("Scissors", 15.5),
                new Item("Scissors", 17.5));
        warehouse.displayDetails(new Item("Scissors", 17.5));
        warehouse.displayDetails(new Item("Scissors", 13.75));

        System.out.println("... delete item");
        warehouse.deleteItem(new Item("Scissors", 17.5));
        warehouse.displayDetails(new Item("Scissors", 17.5));
        warehouse.displayDetails(new Item("Scissors", 13.75));

        System.out.print("\n... display how many products: ");
        warehouse.displayItemCount();

        System.out.print("\n... display total price of all products: ");
        warehouse.displayTotalPrice();

        System.out.println("\n... custom update warehouse items");
        warehouse.updateWarehouseItems("pliers:3:6.99");
        warehouse.displayDetails(new Item("Pliers", 6.99));

        warehouse.updateWarehouseItems("scissors:+5:7.29");
        warehouse.displayDetails(new Item("Scissors", 7.29));

        warehouse.updateWarehouseItems("scissors:-5:7.29");
        warehouse.displayDetails(new Item("Scissors", 7.29));

        warehouse.displayDetails(new Item("Scissors", 13.75));
        warehouse.updateWarehouseItems("scissors:-100:13.75");
        warehouse.displayDetails(new Item("Scissors", 13.75));
    }

    private void updateWarehouseItems(String s) {
        String[] itemInfo = s.split(":");
        String itemType = itemInfo[0];
        String quantifier = itemInfo[1];
        String price = itemInfo[2];

        if(quantifier.startsWith("+")){ // add items to existing count of items
            for(int i = 0; i < Integer.parseInt(quantifier.substring(1)); i++)
                items.add(new Item(itemType, Double.parseDouble(price)));
        } else if(quantifier.startsWith("-")){ // remove some items
            for(int i = 0; i < Integer.parseInt(quantifier.substring(1)); i++)
                items.remove(new Item(itemType, Double.parseDouble(price)));
        } else { // assure a particular amount of items
            deleteItem(new Item(itemType, Double.parseDouble(price)));
            for(int i = 0; i < Integer.parseInt(quantifier); i++)
                items.add(new Item(itemType, Double.parseDouble(price)));
        }
    }

    private void displayTotalPrice() {
        // 1.
        // double sum = 0.0;
        // for (Item item : items)
        //     sum += item.getPrice();
        // System.out.println(sum);

        // 2.
        double sum = items.stream().mapToDouble(Item::getPrice).sum();
        System.out.println(sum);
    }

    private void displayItemCount() {
        System.out.println(items.size());
    }

    private void deleteItem(Item itemToDelete) {
        items.removeIf(item -> item.equals(itemToDelete));
    }

    private void updateDetails(Item itemToUpdate, Item newItem) {
        for (Item item: items) {
            if(item.equals(itemToUpdate)){
                item.setName(newItem.getName());
                item.setPrice(newItem.getPrice());
            }
        }
    }

    private void displayDetails(Item item){
        List<Item> itemsToReturnFromMethod = new ArrayList<>();
        for (Item tmpItem: this.items)
            if(tmpItem.equals(item))
                itemsToReturnFromMethod.add(tmpItem);
        System.out.println(itemsToReturnFromMethod);
    }

    private void add(Item item){
        this.items.add(item);
    }
}
