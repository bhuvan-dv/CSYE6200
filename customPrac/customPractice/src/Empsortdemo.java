import java.util.ArrayList;
import java.util.List;

public class Empsortdemo{
    public static void Demo() {
        Employee e1=new Employee("bhuvan","10",150000);
        Employee e2=new Employee("basavraj","12",75000);
        Employee e3=new Employee("nitin","ECE",95000);
        Employee e4=new Employee("Deepthi","EEE",35000);
        Employee e5=new Employee("Amulya","HR",15000);

        List <Employee> al=new ArrayList();
        al.add(e1);
        al.add(e2);
        al.add(e3);
        al.add(e4);
        al.add(e5);

        al.sort(Employee::compareByName);
        System.out.println(al);

        al.sort(Employee::compareBySalary);
        System.out.println(al);
//        e1.compareTo(e2);

    }

//    @Override
//    public int compareTo(Employee o) {
//        return Integer.compare(this.salary,o.salary);
//    }
}
