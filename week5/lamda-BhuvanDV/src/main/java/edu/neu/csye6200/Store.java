package edu.neu.csye6200;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Comparator;

public class Store {
    static List<ItemAPI> items= new ArrayList();
    static double total;
    private static class Item implements ItemAPI{
        int ID;
        double price;
        String name;

        public Item(int ID, double price, String name) {
            this.ID = ID;
            this.price = price;
            this.name = name;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return "Item{" +
                    "ID=" + ID +
                    ", price=" + price +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
    public interface ItemAPI{
        public int getID();
        public String getName();
        public double getPrice();
    }

    @Override
    public String toString() {
        return "Store{" +
                "items=" + items +
                '}';
    }
    public static void sort(Comparator<ItemAPI> i){
        items.sort(i);
    }
    public static void add(Item i1){
        items.add(i1);
    }
    public static void checkOut(){
        if(total>20){
            System.out.println("too many items bill more than 20$");
        }else{
            for( ItemAPI i :items){
                total=total+i.getPrice();
                System.out.println(i);
            }
            SimpleDateFormat formatter = new SimpleDateFormat("\nMM-dd-YYYY 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            System.out.println(formatter.format(date));
            System.out.println("change= "+(20.0-total));
        }
    }

    public static void demo(){
        add(new Item(2, 2.49, "Milk"));
        add(new Item(4, 1.49, "Bread"));
        add(new Item(3, 3.49, "OJ"));
        add(new Item(1, 0.99, "Candy"));

        checkOut();

        System.out.println("sorted by ID");
        sort(Comparator.comparingInt(i->i.getID()));
        System.out.println(items);

        System.out.println("sorted by Price");
        sort(Comparator.comparingDouble(i->i.getPrice()));
        System.out.println(items);

        System.out.println("sorted by Name");
        sort(Comparator.comparing(i->i.getName()));
        System.out.println(items);

        System.out.println("sorted by ID");
        uSort(items,Comparator.comparing(ItemAPI::getName));
        items.forEach(System.out::println);
    }
    static <T> void uSort(List <T> lt, Comparator <? super T> V){
        lt.sort(V);
    }
}
