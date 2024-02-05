import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
public class Store {
    static List <ItemAPI> items=new ArrayList<>();
    public interface ItemAPI{
        public double getPrice();
        public int getID();
        public String getName();
    }
     static class Item implements ItemAPI{
        int ID;
        String Name;
        double price;

         public Item(int ID, String name, double price) {
             this.ID = ID;
             this.Name = name;
             this.price = price;
         }

         public int getID() {
             return ID;
         }

         public void setID(int ID) {
             this.ID = ID;
         }

         public String getName() {
             return Name;
         }

         public void setName(String name) {
             Name = name;
         }

         public double getPrice() {
             return price;
         }

         public void setPrice(double price) {
             this.price = price;
         }

         @Override
         public String toString() {
             return "Item{" +
                     "ID=" + ID +
                     ", Name='" + Name + '\'' +
                     ", price=" + price +
                     '}';
         }

    }
     static void add(Item i){ items.add(i);}
    static void  demo(){

        add(new Item(2, "Milk",2.49 ));
        add(new Item(4, "Bread",1.49  ));
        add(new Item(3, "OJ",3.49 ));
        add(new Item(1, "Candy",0.99 ));
        checkOut();
        System.out.println("sort by name");

        //lambda way to implement
        sort(Comparator.comparing(i->i.getPrice()));
        sort(Comparator.comparingInt(i->i.getID()));
        sort(Comparator.comparingDouble(i->i.getPrice()));

        //using anonymous class
        meSort(items, new Comparator<ItemAPI>() {
            @Override
            public int compare(ItemAPI o1, ItemAPI o2) {

                return o1.getPrice() > o2.getPrice()?1:-1;
            }
        });

        //method reference
        items.sort(Comparator.comparingInt(ItemAPI::getID));

        items.forEach(System.out::println);


    }



    static void sort(Comparator<ItemAPI> I){
        items.sort(I);
    }

    static  <T> void meSort(List <T> ltt, Comparator <? super T> C){
        ltt.sort(C);
    }
    static void checkOut(){
        double total=0;
        if(total>20){
            System.out.println("too many items");
        }else{
            for(ItemAPI i:items){
               total=total+ i.getPrice();
                System.out.println(i);
                SimpleDateFormat st=new SimpleDateFormat("\nMM-dd-YYYY 'at' HH:mm:ss z");
                Date dt=new Date(System.currentTimeMillis());
                System.out.println(st.format(dt));
                System.out.println("total bill: "+(20-total));

            }
        }
    }

    @Override
    public String toString() {
        return "Store{" +
                "items=" + items +
                '}';
    }
}
