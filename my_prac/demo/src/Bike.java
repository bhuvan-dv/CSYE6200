public class Bike{
    String color;
    String model;
    public static void main(String[] args){
        Bike b1=new Bike();
        b1.model="r15";
        b1.color="black";
        Bike b2=new Bike();
        b2.color="red";
        b2.model="ns200";
        System.out.println(b1.model+" "+b2.color);
    }
}