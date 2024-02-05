package edu.neu.csye6200;

public class ElectronicItemSingleton {
    //ElectronicItemFactory, this implements a Lazy Singleton and Factory method patterns

    //Lazy singelton implementation

    //step1: create an instance as static and private
    private static ElectronicItem inst = new ElectronicItem();

    //step2: make the constructor private and point the instance to null
    private ElectronicItemSingleton() {
        inst = null;
    }

    //step3: create a public method to return the instance
    public static synchronized ElectronicItem getInstance() {
        //checking if the object is previously created inorder to maintain singleton design pattern approach
        if (inst == null) {
            inst = new ElectronicItem();
        }
        return inst;
    }

    //long method not working
    // @Override
    // public Item getobject() {
    //     // TODO Auto-generated method stub
    //     // throw new UnsupportedOperationException("Unimplemented method 'getobject'");
    //     return new ElectronicItem();
    // }

}
