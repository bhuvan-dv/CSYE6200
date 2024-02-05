package edu.neu.csye6200;

public class FoodItemFactory {
    public static enum ItemList {
        FOOD_ITEM
    }

    public static Item getInstance(ItemList itemCatName, String itemValString) {
        Item currentItem = null;

        if (itemCatName == ItemList.FOOD_ITEM) {
            currentItem = new FoodItem(itemValString);
        } else {
            throw new IllegalStateException("Unexpected value: " + itemCatName);
        }

        return currentItem;
    }
}