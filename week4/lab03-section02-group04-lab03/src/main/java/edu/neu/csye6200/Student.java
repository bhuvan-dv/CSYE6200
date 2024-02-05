package edu.neu.csye6200;

public class Student implements Comparable<Student>{
    private int ID;
    private String firstName;
    private String lastName;
    private int age;
    private double GPA;


    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return lastName;
    }

    public int getID() {
        return ID;
    }

    public int getAge() {
        return age;
    }

    public double getGPA() {
        return GPA;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setFirstName(String firstName) {
        this.lastName = firstName;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }


    public Student(String lastName, int ID, int age, double GPA) {
        this.lastName = lastName;
        this.ID = ID;
        this.age = age;
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", GPA=" + GPA +
                '}';
    }

    @Override
    public int compareTo(Student student) {
        // Student natural order: sort by GPA
        return Double.compare(this.getID(), student.getID());

    }
    public static int compareByAge(Student student1, Student student2) {
        return Integer.compare(student1.getAge(), student2.getAge());
    }

    public static int compareByLastName(Student student1, Student student2) {
        return student1.getLastName().compareToIgnoreCase(student2.getLastName());
    }

    public static int compareByGPA(Student student1, Student student2) {
        return Double.compare(student1.getGPA(), student2.getGPA());
    }

    // compare by id is implemented default in compareTo(), put it here just in case
    public static int compareByID(Student student1, Student student2) {
        return Integer.compare(student1.getID(), student2.getID());
    }
}
