public class Student {
    String name="Bhuvan";
    String course="SES";
    int age=25;
    public  void study (){
        System.out.println("I am studying");
    }
    public void sleep(){
        System.out.println("I am sleeping");
    }
    public int age2(){
        return 18;
    }
    public static void main(String[] args) {
        System.out.println("main starts");
        Student s1=new Student();
        s1.study();
        s1.sleep();
        System.out.println(s1.age2());
        System.out.println("main ends");

    }

}
