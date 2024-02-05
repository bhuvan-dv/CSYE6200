package edu.neu.csye6200;
import java.util.Scanner;;
class Drink{
}
class Tea extends Drink{
}
class Coffee extends Drink{
}
class VendingMachine{
    Drink pressBotton() {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    System.out.println("Enter 1 for Coffee");
    System.out.println("Enter any integer value for Tea");
    sc.close();
    if(n==1) {
    Coffee coffee=new Coffee();
    return coffee;
    }
    else {
    Tea tea=new Tea();
    return tea;
    }
}
public static void main(String[] args) {
    VendingMachine v=new VendingMachine();
    Drink d=v.pressBotton();
    System.out.println(d);
}
}