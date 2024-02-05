package edu.neu.csye6200;

public class ElectronicItemFactory {
    static volatile ElectronicItemFactory ei;

    private ElectronicItemFactory(){}
    public static ElectronicItemFactory getInstance() {
        ElectronicItemFactory localInstance = ei;
        if (localInstance == null){
            synchronized (ElectronicItem.class)
            {
                localInstance = ei;
                if (localInstance == null)
                {
                    ei = localInstance = new ElectronicItemFactory();
                }
            }
        }
        return localInstance;
    }

    public ElectronicItem getElectronicItem(String electronicItemString) {
        return new ElectronicItem(electronicItemString);
    }
}
