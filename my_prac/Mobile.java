public class Mobile{
    String brand;
    String model;
    public Mobile(String b, String m){
        this.brand=b;
        this.model=m;
        System.out.println(b+" from object "+m);
    }
    public static void main(String[] args) {
        Mobile m=new Mobile("samsung","s23");
        System.out.println(m+" "+m.brand+" "+m.model); 
        Mobile m2=new Mobile("Real-Me","GT");
        System.out.println(m.brand);
        System.out.println(m.model);
        System.out.println(m2.brand);
        System.out.println(m2.model);
   }
}