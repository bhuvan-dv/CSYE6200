package edu.neu.csye6200;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.RunnableFuture;

public class Store extends AbstractStore{
    @Override
    void demo()
    {

        String localFilepath = "src/main/resources/";
        try{

            List<String> ItemDataListString = new ArrayList<>();
            // creating required list to store data
            List<Item> foodItemDataList = foodItemRead("src/main/resources/FoodItemCSV.txt");
            List<Item> electronicItemList = electronicItemRead("src/main/resources/ElectronicItemCSV.txt");
            List<Item> serviceItemList = serviceItemRead("src/main/resources/serviceItemCSV.txt");
            List<Item> electronicItemListLazySingleton =
                    createElectronicItemsLazySingleton("src/main/resources/ElectronicItemCSV.txt");
            List<Item> serviceItemListEagerSingleton =
                    createServiceItemsEagerSingleton("src/main/resources/serviceItemCSV.txt");

            List<Item> itemList = new ArrayList<>();

            itemList.addAll(foodItemDataList);
            itemList.addAll(electronicItemList);
            itemList.addAll(serviceItemList);

            itemList.sort(Comparator.comparingInt(Item::getID));
            System.out.println("Sorting Items by ID: ");
            itemList.forEach((food)-> {
                System.out.println(food);
                ItemDataListString.add(food.toString());
            });
            FileUtil.writeFile(localFilepath + "ItemsCSVOutput.txt",ItemDataListString,
                    "Sorting Items By ID: ", false);

            itemList.sort(Comparator.comparing(Item::getName));
            System.out.println("Sorting Items by Name: ");
            itemList.forEach(System.out::println);
            itemList.forEach((food)-> {
                ItemDataListString.add(food.toString());
            });
            FileUtil.writeFile(localFilepath + "ItemsCSVOutput.txt",ItemDataListString,
                    "Sorting Items By Name: ", true);

            itemList.sort(Comparator.comparingDouble(Item::getPrice));
            System.out.println("Sorting Items by Price: ");
            itemList.forEach(System.out::println);
            itemList.forEach((food)-> {
                System.out.println(food);
                ItemDataListString.add(food.toString());
            });
            FileUtil.writeFile(localFilepath + "ItemsCSVOutput.txt",ItemDataListString,
                    "Sorting Items By Price: ", true);

            System.out.println("\nFood Items List: ");
            System.out.println(foodItemDataList.toString());

            System.out.println("\nElectronic Items List: ");
            System.out.println(electronicItemList.toString());

            System.out.println("\nService Items List: ");
            System.out.println(serviceItemList.toString());

            // sorting food item list by ID
            System.out.println("\nSort Food Items By ID: ");

            foodItemDataList.sort(Comparator.comparingInt(Item::getID));
            foodItemDataList.forEach(System.out::println);


            foodItemDataList.forEach(foodItem ->{
                ItemDataListString.add(foodItem.toString());
            });
            // writing sorted data into file
            FileUtil.writeFile(localFilepath + "FoodItemCSVOutput.txt",ItemDataListString,
                    "Sorting Foods Items By ID: ", false);

            // sorting food item list by Name
            foodItemDataList.sort(Comparator.comparing(Item::getName));

            System.out.println("\nSort Food Items By Name: ");
            foodItemDataList.forEach(System.out::println);

            ItemDataListString.clear(); // clearing list to be able to add new data

            foodItemDataList.forEach(foodItem ->{
                ItemDataListString.add(foodItem.toString());
            });

            // writing sorted data into file
            FileUtil.writeFile(localFilepath + "FoodItemCSVOutput.txt",ItemDataListString,
                    "Sorting Food Items By Name: ", true);

            // sorting food item list by Price
            foodItemDataList.sort(Comparator.comparingDouble(Item::getPrice));

            System.out.println("\nSort Food Items By Price: ");
            foodItemDataList.forEach(System.out::println);

            ItemDataListString.clear(); // clearing list to be able to add new data

            foodItemDataList.forEach(foodItem ->{
                ItemDataListString.add(foodItem.toString());
            });

            // writing sorted data into file
            FileUtil.writeFile(localFilepath + "FoodItemCSVOutput.txt",ItemDataListString,
                    "Sorting Food Items By Price: ", true);

            // sorting electronic items by ID
            electronicItemList.sort(Comparator.comparingInt(Item::getID));

            System.out.println("\nSort Electronic Items By ID: ");
            electronicItemList.forEach(System.out::println);

            ItemDataListString.clear(); // clearing list to be able to add new data

            electronicItemList.forEach(electronicItem ->{
                ItemDataListString.add(electronicItem.toString());
            });
            // writing sorted data into file
            FileUtil.writeFile(localFilepath + "ElectronicItemsCSVOutput.txt",ItemDataListString,
                    "Sorting Electronics Items By ID: ", false);

            //sorting electronic items by Name
            electronicItemList.sort(Comparator.comparing(Item::getName));

            System.out.println("\nSort Electronic Items By Name: ");
            electronicItemList.forEach(System.out::println);

            ItemDataListString.clear(); // clearing list to be able to add new data

            electronicItemList.forEach(electronicItem ->{
                ItemDataListString.add(electronicItem.toString());
            });

            // writing sorted data into file
            FileUtil.writeFile(localFilepath + "ElectronicItemsCSVOutput.txt",ItemDataListString,
                    "Sorting Electronics Items By Name: ", true);

            //sorting electronic items by Price
            electronicItemList.sort(Comparator.comparingDouble(Item::getPrice));

            System.out.println("\nSort Electronic Items By Price: ");
            foodItemDataList.forEach(System.out::println);

            ItemDataListString.clear(); // clearing list to be able to add new data

            electronicItemList.forEach(electronicItem ->{
                ItemDataListString.add(electronicItem.toString());
            });

            // writing sorted data into file
            FileUtil.writeFile(localFilepath + "ElectronicItemsCSVOutput.txt",ItemDataListString,
                    "Sorting Electronics Items By Price: ", true);

            // Sorting Electronic Item data collected using Singleton Method by ID
            electronicItemListLazySingleton.sort(Comparator.comparingInt(Item::getID));

            System.out.println("\nSorting Electronic Items data collected using Singleton Method by ID: ");
            electronicItemListLazySingleton.forEach(System.out::println);

            ItemDataListString.clear(); // clearing list to be able to add new data

            electronicItemListLazySingleton.forEach(electronicItem ->{
                ItemDataListString.add(electronicItem.toString());
            });

            // writing sorted data into file
            FileUtil.writeFile(localFilepath + "ElectronicItemsCSVOutput.txt",ItemDataListString,
                    "Lazy Singleton Design Method: Sorting Electronics Items By ID: ", true);

            // Sorting Electronic Item data collected using Singleton Method by Name
            electronicItemListLazySingleton.sort(Comparator.comparing(Item::getName));

            System.out.println("\nSorting Electronic Items data collected using Singleton Method by Name: ");
            electronicItemListLazySingleton.forEach(System.out::println);

            ItemDataListString.clear(); // clearing list to be able to add new data

            electronicItemListLazySingleton.forEach(electronicItem ->{
                ItemDataListString.add(electronicItem.toString());
            });

            // writing sorted data into file
            FileUtil.writeFile(localFilepath + "ElectronicItemsCSVOutput.txt",ItemDataListString,
                    "Lazy Singleton Design Method: Sorting Electronics Items By Name: ", true);

            // Sorting Electronic Item data collected using Singleton Method by Price
            electronicItemListLazySingleton.sort(Comparator.comparingDouble(Item::getPrice));

            System.out.println("\nSorting Electronic Items data collected using Singleton Method by Price: ");
            electronicItemListLazySingleton.forEach(System.out::println);

            ItemDataListString.clear(); // clearing list to be able to add new data

            electronicItemListLazySingleton.forEach(electronicItem ->{
                ItemDataListString.add(electronicItem.toString());
            });

            // writing sorted data into file
            FileUtil.writeFile(localFilepath + "ElectronicItemsCSVOutput.txt",ItemDataListString,
                    "Lazy Singleton Design Method: Sorting Electronics Items By Price: ", true);

            // Sorting Service Items collected using Factory Method by ID
            serviceItemList.sort(Comparator.comparingInt(Item::getID));
            System.out.println("\nSorting Service Items collected using Factory Method by ID: ");
            serviceItemList.forEach(System.out::println);

            ItemDataListString.clear(); // clearing list to be able to add new data

            serviceItemList.forEach(serviceItem ->{
                ItemDataListString.add(serviceItem.toString());
            });

            // writing sorted data into file
            FileUtil.writeFile(localFilepath + "ServiceItemsCSVOutput.txt",ItemDataListString,
                    "Sorting Service Items By ID: ", false);

            // Sorting Service Items collected using Factory Method by Name
            serviceItemList.sort(Comparator.comparing(Item::getName));

            System.out.println("\nSorting Service Items collected using Factory Method by Name: ");
            serviceItemList.forEach(System.out::println);

            ItemDataListString.clear(); // clearing list to be able to add new data

            serviceItemList.forEach(serviceItem ->{
                ItemDataListString.add(serviceItem.toString());
            });

            // writing sorted data into file
            FileUtil.writeFile(localFilepath + "ServiceItemsCSVOutput.txt",ItemDataListString,
                    "Sorting Service Items By Name: ", true);

            // Sorting Service Items collected using Factory Method by Price
            serviceItemList.sort(Comparator.comparingDouble(Item::getPrice));

            System.out.println("\nSorting Service Items collected using Factory Method by Price: ");
            serviceItemList.forEach(System.out::println);

            ItemDataListString.clear(); // clearing list to be able to add new data

            serviceItemList.forEach(serviceItem ->{
                ItemDataListString.add(serviceItem.toString());
            });

            // writing sorted data into file
            FileUtil.writeFile(localFilepath + "ServiceItemsCSVOutput.txt",ItemDataListString,"Sorting Service Items By Price: ", true);

            // Sorting Service Items collected using Eager Singleton design pattern By ID
            serviceItemListEagerSingleton.sort(Comparator.comparingInt(Item::getID));

            System.out.println("\nSorting Service Items collected using Eager Singleton design pattern By ID: ");
            serviceItemListEagerSingleton.forEach(System.out::println);

            ItemDataListString.clear(); // clearing list to be able to add new data

            serviceItemListEagerSingleton.forEach(serviceItem ->{
                ItemDataListString.add(serviceItem.toString());
            });

            // writing sorted data into file
            FileUtil.writeFile(localFilepath + "ServiceItemsCSVOutput.txt",ItemDataListString,
                    "Eager Singleton Design Method: Sorting Service Items By ID: ", true);

            // Sorting Service Items collected using Eager Singleton design pattern By Name
            serviceItemListEagerSingleton.sort(Comparator.comparing(Item::getName));
            System.out.println("\nSorting Service Items collected using Eager Singleton design pattern By Name: ");
            serviceItemListEagerSingleton.forEach(System.out::println);

            ItemDataListString.clear(); // clearing list to be able to add new data

            serviceItemListEagerSingleton.forEach(serviceItem ->{
                ItemDataListString.add(serviceItem.toString());
            });

            // writing sorted data into file
            FileUtil.writeFile(localFilepath + "ServiceItemsCSVOutput.txt",ItemDataListString,
                    "Eager Singleton Design Method: Sorting Service Items By Name: ", true);

            // Sorting Service Items collected using Eager Singleton design pattern By Price
            serviceItemListEagerSingleton.sort(Comparator.comparingDouble(Item::getPrice));
            System.out.println("\nSorting Service Items collected using Eager Singleton design pattern By Price: ");
            serviceItemListEagerSingleton.forEach(System.out::println);

            ItemDataListString.clear(); // clearing list to be able to add new data

            serviceItemListEagerSingleton.forEach(serviceItem ->{
                ItemDataListString.add(serviceItem.toString());
            });

            // writing sorted data into file
            FileUtil.writeFile(localFilepath + "ServiceItemsCSVOutput.txt",ItemDataListString,
                    "Eager Singleton Design Method: Sorting Service Items By Price: ", true);

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    List<Item> foodItemRead(String filePath) throws IOException {
        List<String> foodItemStringRecords = FileUtil.readFile(filePath);
        List<Item> foodItemDataList = new ArrayList<>();
        foodItemStringRecords.forEach(foodItem ->{
            Item fi = FoodItemFactory.getInstance(FoodItemFactory.ItemList.FOOD_ITEM, foodItem);
            foodItemDataList.add(fi);
        });

        return foodItemDataList;
    }

    List<Item> electronicItemRead(String filePath) throws IOException {
        List<String> electronicItemStringRecords = FileUtil.readFile(filePath);
        List<Item> electronicItemDataList = new ArrayList<>();
        electronicItemStringRecords.forEach(electronicItem ->{
            Item ei = ItemFactory.getInstance(ItemFactory.ItemList.ELECTRONIC_ITEM,electronicItem);
            electronicItemDataList.add(ei);
        });

        return electronicItemDataList;
    }

    List<Item> serviceItemRead(String filePath) throws IOException {
        List<String> serviceItemStringRecords = FileUtil.readFile(filePath);
        List<Item> serviceItemDataList = new ArrayList<>();
        serviceItemStringRecords.forEach(serviceItem ->{
            ServiceItem fi = (ServiceItem) ItemFactory.getInstance(ItemFactory.ItemList.SERVICE_ITEM, serviceItem);
            serviceItemDataList.add(fi);
        });

        return serviceItemDataList;
    }

    List<Item> createElectronicItemsLazySingleton(String filePath) throws IOException {
        List<String> electronicItemStringRecords = FileUtil.readFile(filePath);
        List<Item> electronicItemsSingleton = new ArrayList<>();
        ElectronicItemFactory eif = ElectronicItemFactory.getInstance();
        electronicItemStringRecords.forEach(electronicItem ->{
            ElectronicItem ei = eif.getElectronicItem(electronicItem);
            electronicItemsSingleton.add(ei);
        });

        return electronicItemsSingleton;
    }

    List<Item> createServiceItemsEagerSingleton(String filePath) throws IOException {
        List<String> serviceItemStringRecords = FileUtil.readFile(filePath);
        List<Item> serviceItemsSingleton = new ArrayList<>();
        ServiceItemFactory sif = ServiceItemFactory.getInstance();
        serviceItemStringRecords.forEach(serviceItem ->{
            ServiceItem si = sif.getServiceItem(serviceItem);
            serviceItemsSingleton.add(si);
        });

        return serviceItemsSingleton;
    }

}
