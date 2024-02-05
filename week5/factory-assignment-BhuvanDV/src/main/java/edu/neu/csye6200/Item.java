package edu.neu.csye6200;

public class Item {
    int ID;
    String Name;
    double Price;

    public double getPrice() {
        return Price;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPrice(double price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "ID: " +this.getID() + ";    Name: "+this.getName() + ";    Price: " + this.getPrice();
    }
}