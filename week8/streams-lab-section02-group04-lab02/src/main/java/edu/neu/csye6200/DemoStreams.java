package edu.neu.csye6200;

import java.util.*;

public class DemoStreams {
    static class MyItem {
        private int id;
        private double price;
        private String name;

        public MyItem(String myItem) {
            String [] s=myItem.split(",");
            this.id=Integer.parseInt(s[0]);
            this.price= Double.parseDouble(s[1]);
            this.name=s[2];
        }

        public int getId() {
            return this.id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getPrice() {
            return this.price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "MyItem{" +
                    "id=" + id +
                    ", price=" + price +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void demo() {
        String [] input_csv={"01,2.89,Milk","02,0.56,Banana","03,9.87,Oj"};
        System.out.println("=====Sorted By ID========");
        Arrays.stream(input_csv).map(MyItem::new).sorted(
                Comparator.comparingInt(i->i.getId())
        ).forEach(System.out::println);
        System.out.println("\n=====Sorted By Price========");

        Arrays.stream(input_csv).map(MyItem::new).sorted(
                Comparator.comparingDouble(i->i.getPrice())
        ).forEach(System.out::println);
        System.out.println("\n=====Sorted By Name========");

        Arrays.stream(input_csv).map(MyItem::new).sorted(
                Comparator.comparing(i->i.getName())
        ).forEach(System.out::println);
    }
}
