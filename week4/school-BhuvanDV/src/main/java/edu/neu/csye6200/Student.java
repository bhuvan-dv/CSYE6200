package edu.neu.csye6200;
import java.util.ArrayList;
import java.util.List;
import java.lang.Comparable;
// Person is super class
// Student is derived subclass of Person
public class Student extends Person {
    private int ID;
    private int age;
    private double GPA;
    private String firstName;
    private String lastName;

    //getter methods
    public int getStudentID(){
        return this.ID;
    }
    public String getfirstName(){
        return this.firstName;
    }
    public int getAge(){
        return this.age;
    }
    public double getGPA(){
        return this.GPA;
    }
    public String getLastName(){
        return this.lastName;
    }
    //setter methods
    public void setStudentID(int ID){
         this.ID=ID;
    }
    public void setAge(int age){
        this.age=age;
    }
    public void setGPA(double GPA){
        this.GPA=GPA;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    //constructor
    public Student(String firstName, String LastName, int age, int ID, double GPA){
        super(firstName, LastName, ID, age, GPA);
        this.firstName=firstName;
        this.lastName=LastName;
        this.age=age;
        this.ID=ID;
        this.GPA=GPA;
            }
    //Override toString() to show  Lists
    @Override
    public String toString(){
        return "Student{" +
        "ID=" + ID +
        ", lastName='" + lastName + '\'' +
        ", firstName='" + firstName + '\'' +
        ", age=" + age +
        ", GPA=" + GPA +
        '}';
    }

    //sort By ID
    public static int compareByID(Student student1, Student student2) {
        return Integer.compare(student1.getStudentID(), student2.getStudentID());
    }
    //sort by GPA
    public static int compareByGPA(Student student1, Student student2){
        return Double.compare(student1.getGPA(),student2.getGPA());
    }
    //sort by LASTNAME
    public static int compareByLastName(Student student1, Student student2){
        return student1.getLastName().compareToIgnoreCase(student2.getLastName());
    }
    //Sort By AGE
    public static int compareByAge(Student student1, Student student2){
        return Integer.compare(student1.getAge(),student2.getAge());
    }
}
