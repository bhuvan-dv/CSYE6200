package edu.neu.csye6200;
import java.lang.Comparable;
public class Person  implements Comparable <Person>{
    private String fName;
    private String lName;
    private int ID;
    private int age;
    private double GPA;
    
    public Person(String fName, String lName, int ID, int age, double GPA){
        this.age=age;
        this.GPA=GPA;
        this.ID=ID;
        this.fName=fName;
        this.lName=lName;
    }
    public int getPersonID(){
        return this.ID;
    }
    public String getfName(){
        return this.fName;
    }
    public int getAge(){
        return this.age;
    }
    public double getGPA(){
        return this.GPA;
    }
    public String getlName(){
        return this.lName;
    }
    //setter methods
    public void setPersonID(int ID){
         this.ID=ID;
    }
    public void setAge(int age){
        this.age=age;
    }
    public void setGPA(double GPA){
        this.GPA=GPA;
    }
    public void setfName(String fName){
        this.fName=fName;
    }
    public void setlName(String lName){
        this.lName=lName;
    }
    //Override toString() to show  Lists
    @Override
    public String toString(){
        return "Person{" +
        "ID=" + ID +
        ", lName='" + lName + '\'' +
        ", fName='" + fName + '\'' +
        ", age=" + age +
        ", GPA=" + GPA +
        '}';
    }
    @Override
    public int compareTo(Person per) {
        // Person natural order: sort by GPA
        return Double.compare(this.getGPA(), per.getGPA());
    }
    //sort By ID
    public static int compareByID(Person Person1, Person Person2) {
        return Integer.compare(Person1.getPersonID(), Person2.getPersonID());
    }
    //sort by GPA
    public static int compareByGPA(Person person1, Person person2){
        return Double.compare(person1.getGPA(),person2.getGPA());
    }
    //sort by LASTNAME
    public static int compareByLastName(Person person1, Person person2){
        return person1.getlName().compareToIgnoreCase(person2.getlName());
    }
    //Sort By AGE
    public static int compareByAge(Person person1, Person person2){
        return Integer.compare(person1.getAge(),person2.getAge());
    }
}
