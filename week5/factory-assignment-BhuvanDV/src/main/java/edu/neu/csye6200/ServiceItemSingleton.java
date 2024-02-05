package edu.neu.csye6200;

public class ServiceItemSingleton {
    //Eager Singleton implementation

    //step1: create an instance with static
    private static final ServiceItem inst = new ServiceItem();

    //step 2: create a private constructor
    private ServiceItemSingleton() {

    }

    //step3: create a public method to return the instance
    public static ServiceItem getInstance() {
        return inst;
    }
}
