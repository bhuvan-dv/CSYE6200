public class Sky{
    public static void main(String[] args){
        System.out.println("here");
        Sky s= new Sky();//object creation
        System.out.println("object created "+s);
    }

    //if you want the variable to hold a constant value use final keyword
    final int c=5; // this is a constant
    //if you want the variable to hold a changing value do not use final
    int a=1; // this is a variable
}