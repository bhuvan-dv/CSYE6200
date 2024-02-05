package edu.neu.csye6200;

public class ServiceItemFactory {
    //    Eager Singleton Design Pattern
    static ServiceItemFactory sc = new ServiceItemFactory();
    private ServiceItemFactory(){}

    public static ServiceItemFactory getInstance() {
        return sc;
    }

    public ServiceItem getServiceItem(String serviceItemString){
        return new ServiceItem(serviceItemString);
    }
}