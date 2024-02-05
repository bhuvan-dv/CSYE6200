public class AccountDetail {
    long accNumber;
    double balance;
    String name;
    public AccountDetail(long accNumber, double balance, String name) {
        this.accNumber = accNumber;
        this.balance = balance;
        this.name = name;
    }
    public AccountDetail(long accNumber) {
        this.accNumber = accNumber;
    }
    public AccountDetail() {
    }
    public static void main(String[] args) {
        AccountDetail ac1=new AccountDetail();
        System.out.println(ac1.accNumber+" "+ac1.name+" "+ac1.balance);
        AccountDetail ac2=new AccountDetail(9886723610L);
        System.out.println(ac2.accNumber+" "+ac2.name+" "+ac2.balance);
        AccountDetail ac3=new
        AccountDetail(9886723610L,43000,"spiders");
        System.out.println(ac3.accNumber+" "+ac3.name+" "+ac3.balance);
    }
}