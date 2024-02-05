package edu.neu.csye6200;
import java.util.ArrayList;
import java.util.List;

public class School {
    //basic caller to call methods to execute
    public static void callMethods(){
        //add method to add Students to Student List
		addStudentsToStudentsList();
		// add method to add Students to Person List
		addStudentsToPersonsList();
    }

    public static void addStudentsToStudentsList(){
        // Created a List<Student> studentRoster 
        List<Student> stud=new ArrayList();
        stud.add(new Student("Bhuvan","raj",25,02,4.0));
        stud.add(new Student("Mugunth","Dinesh",23,05,3.0));
        stud.add(new Student("Arjun","R",24,01,3.9));
        stud.add(new Student("Robert","Q",22,03,3.0));
        stud.add(new Student("Lawrence","E",21,04,2.9));
        System.out.println("All the students unsorted data");
         for(Student a:stud){
             System.out.println(a);
         }

         //Sorting methods for students
         sortStudents(stud);
    }

   public static void addStudentsToPersonsList(){
    // Created a List<Person> personRoster
       List<Person> per=new ArrayList();
       per.add(new Person("giri", "kishore", 12, 25, 4.0));
       per.add(new Person("Tejas","va",1,23,3.0));
        per.add(new Person("Donald","Mc",5,24,1.2));
       per.add(new Person("Dom","inos",9,22,3.2));
       per.add(new Person("Tom","Richie",10,21,3.3));
                System.out.println("\n\n"+"All the Persons unsorted data");

       for(Person b:per){
        System.out.println(b);
       } 

       //sorting method for Persons
       sortPersons(per);
   }

   public static void sortStudents(List<Student> stud){
        System.out.println("\n\n"+"========" + stud.size()+ " Students are SORTED BY ID. ========");
        stud.sort(Student::compareByID);
        stud.forEach(System.out::println);

        System.out.println("\n\n"+"========" + stud.size()+ " Students are SORTED BY AGE. ========");
        stud.sort(Student::compareByAge);
        stud.forEach(System.out::println);

        System.out.println("\n\n"+"========" + stud.size()+ " Students are SORTED BY GPA. ========");
        stud.sort(Student::compareByGPA);
        stud.forEach(System.out::println);

        System.out.println("\n\n"+"========" + stud.size()+ " Students are SORTED BY LastName. ========");
        stud.sort(Student::compareByLastName);
        stud.forEach(System.out::println);
   }

   public static void sortPersons(List<Person> per){
        System.out.println("\n\n"+"========" + per.size()+ " Persons are SORTED BY ID. ========");
        per.sort(Person::compareByID);
        per.forEach(System.out::println);

        System.out.println("\n\n"+"========" + per.size()+ " Persons are SORTED BY AGE. ========");
        per.sort(Person::compareByAge);
        per.forEach(System.out::println);

        System.out.println("\n\n"+"========" + per.size()+ " Persons are SORTED BY GPA. ========");
        per.sort(Person::compareByGPA);
        per.forEach(System.out::println);

        System.out.println("\n\n"+"========" + per.size()+ " Persons are SORTED BY LastName. ========");
        per.sort(Person::compareByLastName);
        per.forEach(System.out::println);
   }
}
