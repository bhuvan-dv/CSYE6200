package edu.neu.csye6200;

public class ItemFactory {
    public static enum ItemList {
        FOOD_ITEM, ELECTRONIC_ITEM, SERVICE_ITEM
    }

    public static Item getInstance(ItemList itemCatName, String itemValString) {
        Item currentItem = null;

        switch (itemCatName) {
            case FOOD_ITEM:
                currentItem = new FoodItem(itemValString);
                break;
            case ELECTRONIC_ITEM:
                currentItem = new ElectronicItem(itemValString);
                break;
            case SERVICE_ITEM:
                currentItem = new ServiceItem(itemValString);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + itemCatName);
        }

        return currentItem;
    }
}
