package edu.neu.csye6200;

public class FoodItem extends Item{
    Boolean isVeg;
    public FoodItem(String csvString){
        String[] strValues = csvString.split(",");
        this.ID = Integer.parseInt(strValues[0]);
        this.Name = strValues[1];
        this.Price = Double.parseDouble(strValues[2]);
        this.isVeg = Boolean.parseBoolean(strValues[3]);
    }
    public boolean getsVeg() {
        return this.isVeg;
    }

    @Override
    public String toString() {
        return super.toString() + "; is Veg: " + this.getsVeg();
    }
}