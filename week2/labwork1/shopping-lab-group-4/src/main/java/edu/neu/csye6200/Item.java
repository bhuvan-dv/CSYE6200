package edu.neu.csye6200;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Item {
    final private String itemName;      // the name of the item
    final private float itemPrice;      // the price of the item
    final private int quantity;
    public static ArrayList<Item> items = new ArrayList<>();    // the array to keep the items that to purchase

    public Item(String itemName, float itemPrice, int quantity) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.quantity = quantity;
    }

    public String getItemName(){
        return itemName;
    }
    public float getItemPrice(){
        return itemPrice;
    }
    public int getQuantity(){
        return quantity;
    }

    @Override
    public String toString() {
        return ("$" + itemPrice + "\t\t" + quantity + "\t\t" + itemName);
    }

    public static void checkOut(ArrayList<Item> items, float cash){
        float totalPrice = 0;       // the total price of the current items
        StringBuilder receipt = new StringBuilder();

        receipt.append("ItemPrice\tQuantity\tItemName\n\n");

        // itemized all items
        for (Item item : items) {
            receipt.append(item.toString()).append("\n");
            totalPrice += item.getItemPrice() * item.getQuantity();
            if (totalPrice > 20){
                // check if the total prices is beyond the current cash
                System.out.println("Your cash is not enough! Please manage your items.");
                return;
            }
        }

        float change = cash - totalPrice;      // the current change
        // print the total price
        receipt.append("\nTotal Price:\t$").append(totalPrice);
        // print the change
        receipt.append("\nChange:\t\t\t$").append(change);

        // print the date and time the purchase was made
        SimpleDateFormat formatter = new SimpleDateFormat("\nMM-dd-YYYY 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        receipt.append(formatter.format(date));

        // print the receipt
        System.out.println(receipt);
    }

    public static void demo(float currentCash){
        Item item1 = new Item("basketball", 1, 2);
        Item item2 = new Item("football", 2, 1);
        Item item3 = new Item("shoes", 3, 1);

        items.add(item1);
        items.add(item2);
        items.add(item3);

        checkOut(items, currentCash);
    }
}

