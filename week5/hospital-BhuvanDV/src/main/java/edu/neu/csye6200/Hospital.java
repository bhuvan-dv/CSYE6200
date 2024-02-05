package neu.edu.csye6200;

/**
 * class to model a zoo with animals
 *
 * @author dgpeters
 */

import java.util.*;

/**
 * class Hospital 
 *
 * REQUIREMENTS:
 *
 * Implement class Hospital Generically with the following data and method members:
 *  - Hospital Item list: List of ItemAPI objects (e.g. Drug, etc.)
 *  - Inner ItemAPI class (attributes: id=21, name=item);
 *  - Inner CTSCAN class derived from ItemAPI class (attributes: id=32, name=CTSCAN) is a hospital item;
 *  - Inner Drug class derived from ItemAPI class (attributes: id=13, name=Drug) is a hospital item;
 *
 *  - add method to add one item to hospital Item list
 *  - addItems method to create hospital items (ItemAPI objects) and call add method
 *
 *  - sort method to sort Hospital Item List as specified by supplied Comparator
 *  - sortItems method to call sort method and then hospital toString method to show results of sorted item List
 *
 *  - sortGenericList method written GENERICALLY to sort a supplied List using a supplied Comparator
 *  - demoSort method to create Lists and call sortGenericList
 * Complete coding of the supplied static Hospital.demo() and other methods.
 *
 * @author dgpeters
 *
 *

// STUDENT TODO: COMPLETE THIS CODE to demonstrate the use of this Hospital class
 *
 */
public class Hospital {
    public static final int MAJOR = 1;
    public static final int MINOR = 0;
    public static final String VERSION = MAJOR + "." + MINOR;
    /**
     * STUDENT TODO: use List API abstract usage of re-sizable sequential container
     * to contain Animal reference type objects
     */
    // STUDENT TODO:

    /**
     * STUDENT TODO: class ItemAPI is a concrete class
     * (inner class, data member of Hospital outer class)
     * which we use as a super class API for derived classes to inherit
     * with the option of using or overriding its default implementation.
     *
     * @author dgpeters
     *
     */
    private static List<ItemAPI> items = new ArrayList<>();

    private static class ItemAPI implements Comparable<ItemAPI> {

        // STUDENT TODO:
        private String name;

        public ItemAPI(int id, String name) {
            this.id = id;
            this.name = name;
        }

        private int id;

        /**
         * ItemAPI
         *
         * @return String representation of this item's description
         */
        public String description() {
            return "I am an item!";
        }

        /**
         * output to console (stdout) this item's description
         */
        public void describe() {
            System.out.println(this.description());
        }

        /**
         * return a String representation of this object's state
         */
        @Override
        public String toString() {
            return this.description() + " My item name is " + this.name + ", ID # " + this.id;
        }

        @Override
        public int compareTo(ItemAPI o) {
            if (this.id > o.id) {
                return 1;
            } else if (this.id < o.id) {
                return -1;
            } else {
                return 0;
            }
        }
        // STUDENT TODO:

    }

    /**
     * STUDENT TODO: class CTSCAN implements (inherits from the) ItemAPI to derive a CTSCAN class
     * @author dgpeters
     *
     */
    // STUDENT TODO:
    static class CTSCAN extends ItemAPI {
        public CTSCAN(int id, String name) {
            super(id, name);
        }

        @Override
        public String description() {
            return "I am a CTSCAN!";
        }
    }

    /**
     * STUDENT TODO: class Drug implements (inherits from the) ItemAPI to derive a Drug class
     * @author dgpeters
     *
     */
    // STUDENT TODO:
    static class Drug extends ItemAPI {
        public Drug(int id, String name) {
            super(id, name);
        }

        @Override
        public String description() {
            return "I am a Drug!";
        }
    }

    /**
     * STUDENT TODO: object instance method to add one ItemAPI object to hospital List
     *
     * @param an ItemAPI object to add to hospital List
     */
    public void add(ItemAPI an) {
        // STUDENT TODO:
        items.add(an);
    }

    /**
     * STUDENT TODO: sort all items in hospital list of items (ItemAPI objects)
     *
     * @param c        Comparator to specify an EXPLICIT SORT ORDER for ItemAPI objects
     */
    public void sort(Comparator<ItemAPI> c) {
        // STUDENT TODO:
        items.sort(c);
    }

    /**
     * return a String representation of this Hospital object's state
     * (i.e., all items in hospital List)
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(Hospital.class.getSimpleName() + " [ version " + VERSION + " ]\n");

        sb.append(this.items.size()).append(" items in hospital (described as)...").append("\n");
        for (ItemAPI item : items) {
            sb.append(item).append("\n");
        }

        return sb.toString();
    }

    /**
     * STUDENT TODO: create and add items to hospital and showing incremental changes on console
     *
     * @param hospital        hospital with list to add items
     */
    public static void addItems(Hospital hospital) {
        System.out.println("add items (ItemAPI objects) to Hospital...");
        hospital.add(new ItemAPI(10, "Item"));    // add ItemAPI object to hospital
        // STUDENT TODO: implicitly call hospital toString()
        System.out.println(hospital);
        hospital.add(new CTSCAN(151, "CTSCAN"));        // add Drug object to hospital
        // STUDENT TODO: implicitly call hospital toString()
        System.out.println(hospital);
        hospital.add(new Drug(190, "Drug"));    // add CTSCAN object to hospital
        // STUDENT TODO: implicitly call hospital toString()
        System.out.println(hospital);
    }

    /**
     * STUDENT TODO: sort all hospital items and showing results of each sort on console
     * @param hospital
     */
    public static void sortItems(Hospital hospital) {
        System.out.println("Sort all items BY NAME...");
        hospital.sort(Comparator.comparing(item -> item.name));// STUDENT TODO
        // STUDENT TODO: implicitly call hospital toString()
        System.out.println(hospital);

        System.out.println("Sort all items BY ID...");
        hospital.sort(Comparator.comparingInt(item -> item.id));// STUDENT TODO
        // STUDENT TODO: implicitly call hospital toString()
        System.out.println(hospital);

        System.out.println("Sort all items BY NATURAL DEFAULT ORDER (HIGHEST ID)...");
        Collections.sort(items);// STUDENT TODO:
        // STUDENT TODO: implicitly call hospital toString()
        System.out.println(hospital);
    }

    /**
     * STUDENT TODO:
     *
     * demonstrate sort with generic code
     * sort supplied List, with Comparator specified order and output sorted List to console
     *
     * @param objectList    supplied List to sort
//     * @param c                supplied Comparator to explicitly specify sort order
     */
    public <T> void sortGenericList( List<? extends Comparable<? super T>> objectList) {
        // STUDENT TODO: sort List using Comparator
        // STUDENT TODO:
        objectList.sort(null);
        System.out.println(objectList.size() + " objects in list...");
        for (Comparable<? super T> obj : objectList) {
            System.out.println(obj);
        }
        // STUDENT TODO: output sorted list to console (stdout)
        System.out.println(objectList.size() + " objects in list...");
        // STUDENT TODO:
        System.out.println();
    }

    public void demoSort() {
        {
            // create list of String Objects (ADD IN THIS ORDER): "Pam", "Dan", "Ann", "Sam"
            System.out.print("GIVEN: ");
            String[] a = {"Pam", "Dan", "Ann", "Sam"};
            for (String s : a) System.out.print(s + ", ");
            System.out.println("Use Generic Sort on a list of String objects...");
            List<String> Oblist = Arrays.asList(a);
            sortGenericList(Oblist);
            // STUDENT TODO: create List objects
            // STUDENT TODO:
            // STUDENT TODO: sort List objects in natural order USING GENERIC SORT METHOD
            // STUDENT TODO:
        }
        {
            // create list of Integer Objects (ADD IN THIS ORDER): 3, 2, 1, 4
            System.out.print("GIVEN: ");
            Integer[] a = {3, 2, 1, 4};
            for (int n : a) System.out.print(n + ", ");
            System.out.println("Use Generic Sort on a list of Integer objects...");
            List <Integer> Oblist= Arrays.asList(a);
            sortGenericList(Oblist);
            // STUDENT TODO: create List objects
            // STUDENT TODO:
            // STUDENT TODO: sort List objects in natural order USING GENERIC SORT METHOD
            // STUDENT TODO:
        }
    }

    /**
     *  STUDENT TODO: COMPLETE CODE to demonstrate the use of this Hospital class
     */
    public static void demo() {
        System.out.println("\n\t" + Hospital.class.getName() + ".demo() [ version " + VERSION + " ]...");

        // create object from Hospital using implicit compiler provided default constructor
        Hospital hospital = new Hospital();
        System.out.println(hospital);
        // STUDENT TODO: implicitly call hospital toString()
        // STUDENT TODO: explicitly call hospital toString()
        System.out.println(hospital.toString());

        // create and add items to hospital
        Hospital.addItems(hospital);

        // sort items in hospital
        Hospital.sortItems(hospital);

        // demonstrate Generic Sort
        hospital.demoSort();

        System.out.println("\n\t" + Hospital.class.getName() + ".demo() [ version " + VERSION + " ]... done!");
    }
}
