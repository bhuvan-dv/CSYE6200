package edu.neu.csye6200;

public class ServiceItem extends Item{

    double ratePerHour;
    public ServiceItem(){}
    public ServiceItem(String csvString){
        String[] strValues = csvString.split(",");
        this.ID = Integer.parseInt(strValues[0]);
        this.Name = strValues[1];
        this.Price = Double.parseDouble(strValues[2]);
        this.ratePerHour = Double.parseDouble(strValues[3]);
    }
    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    @Override
    public String toString() {
        return super.toString() + ";    Service Rate per Hour: " + this.getRatePerHour();
    }
}