package edu.neu.csye6200;

public class Mythread implements Runnable {
    private int threadNum;
    public Mythread(int i){
        this.threadNum=i;
    }
    public static void main(String[] args) {
        for(int i=0;i<=5;i++){
            Thread t=new Thread(new Mythread(i));
//            Mythread t=;
            t.start();
        }
    }
    @Override
    public void run(){
        for(int i=0;i<=5;i++){
            System.out.println(i + " thread number is "+ this.threadNum);
        }
    }
}
