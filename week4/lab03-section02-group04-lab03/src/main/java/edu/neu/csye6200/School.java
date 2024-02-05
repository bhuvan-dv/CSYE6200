package edu.neu.csye6200;
import java.util.ArrayList;
import java.util.List;

public class School {
    public static void printStudents(List<Student> students) {
        System.out.println("ID\t\tFirst Name\t\tLast Name\t\tAge\t\tGPA");
        for (Student student : students) {
            System.out.println(student.getID() + "\t\t" + student.getFirstName() + "\t\t" + student.getLastName() + "\t\t" + student.getAge() + "\t\t" + student.getGPA());
        }
    }

    public static List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("obama", 1, 19, 4.0));
        students.add(new Student( "trump", 2, 18, 3.8));
        students.add(new Student( "taylor", 4, 19, 3.4));
        students.add(new Student("adams", 5, 20, 4.0));
        students.add(new Student("washington", 3, 99, 3.1));
        return students;
    }

    public static void printStudents(){

        List<Student> students = getStudents();


        System.out.println("\n\n" + students.size()
                + " students in the following collection: 1. SORTED BY ID.");
        students.sort(Student::compareByID);
        students.forEach(System.out::println);


        System.out.println("\n\n" + students.size()
                + " students in the following collection: 2. SORTED BY AGE.");
        students.sort(Student::compareByAge);
        students.forEach(System.out::println);


        System.out.println("\n\n" + students.size()
                + " students in the following collection: 3. SORTED BY LAST NAME.");
        students.sort(Student::compareByLastName);
        students.forEach(System.out::println);


        System.out.println("\n\n" + students.size()
                + " students in the following collection: 4. SORTED BY GPA.");
        students.sort(Student::compareByGPA);
        students.forEach(System.out::println);
    }

}
