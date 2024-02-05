public class Stud {
    String name="mugunth";
    int age=23;
    public static void main(String[] args) {
        Stud s=new Stud();
        s.remind();

    }
    void remind(){
        String name="bhuvan";
        int age =25;
        System.out.println(name+" "+age);
        System.out.println(this.name+" "+this.age);

    }
}
