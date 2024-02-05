import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Car{
    private String model;
    private int price;

    public Car(String model,int price){
        this.model=model;
        this.price=price;
    }
    public int getPrice(){
        return price;
    }
    public String getModel(){
        return model;
    }
    public void setPrice(int price){
        this.price=price;
    }

}