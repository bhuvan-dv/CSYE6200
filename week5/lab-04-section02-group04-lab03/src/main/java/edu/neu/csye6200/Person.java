package edu.neu.csye6200;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person {
    public int ID;
    public int age;
    public String firstName;
    public String lastName;
    public String parent_first_name;
    public String parent_last_name;

    public Person(int ID, int age, String firstName, String lastName, String parent_first_name, String parent_last_name){
        this.ID=ID;
        this.age=age;
        this.firstName=firstName;
        this.lastName=lastName;
        this.parent_first_name=parent_first_name;
        this.parent_last_name=parent_last_name;
    }
    public static class Student extends Person{
        public int StudentID;
        public double GPA;

        public Student(int ID, int age, String firstName, String lastName,String parent_first_name,String parent_last_name, double GPA) {
            super(ID, age, firstName, lastName, parent_first_name,parent_last_name);
            this.ID=StudentID;
            this.age=age;
            this.firstName=firstName;
            this.lastName=lastName;
            this.parent_first_name=parent_last_name;
            this.parent_last_name=parent_first_name;
            this.GPA=GPA;
        }
        @Override
        public String toString(){
            return "Student{" +
                    "ID=" + ID +
                    ", lName='" + lastName + '\'' +
                    ", fName='" + firstName + '\'' +
                    ", age=" + age +
                    ", GPA=" + GPA  +
                    '}';
        }
    }

    public static class Teacher extends Person{

        public double hourlyWage;

        public Teacher(int ID, int age, String firstName, String lastName, String parent_first_name, String parent_last_name, double hourlyWage) {
            super(ID, age, firstName, lastName, parent_first_name, parent_last_name);
            this.ID=ID;
            this.age=age;
            this.firstName=firstName;
            this.lastName=lastName;
            this.parent_first_name=parent_last_name;
            this.parent_last_name=parent_first_name;
            this.hourlyWage=hourlyWage;
        }

        @Override
        public String toString() {
            return "teacher{" +
                    "ID=" + ID +
                    ", lName='" + lastName + '\'' +
                    ", fName='" + firstName + '\'' +
                    ", age=" + age +
                    ", HourlyWage=" + hourlyWage  +
                    '}';
        }
    }
    public static void demo(){
        List <String> readFileStringObj=FileUtils.readFile("src/main/java/edu/neu/csye6200/students.txt");
        System.out.println("11111"+readFileStringObj);
        List <Student> students=new ArrayList();
        for (String s:readFileStringObj) {
            String[] substr= s.split(", ");
//            System.out.println(Arrays.toString(substr));
            int ID= Integer.parseInt(substr[0]);
            int age=Integer.parseInt(substr[1]);
            String fName=substr[2];
            String lName=substr[3];
            String pFname=substr[4];
            String pLname=substr[5];
            double GPA=Double.parseDouble(substr[6]);
            students.add(new Student(ID,age,fName,lName,pFname,pLname, GPA));
        }
        System.out.println(students);
        List <String> s1= new ArrayList<>();
        for(Student s:students){
//            s1.add();
        }
//        FileUtils.writeFile("src/main/java/edu/neu/csye6200/stud.txt",);
    }
    @Override
    public String toString(){
        return "Person{" +
                "ID=" + ID +
                ", lName='" + lastName + '\'' +
                ", fName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }

}
