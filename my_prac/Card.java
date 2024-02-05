public class Card {
    long cardName;
    int cvv;
    String name,expDate;
    double balance;
    void swipe() {
        System.out.println("Swipe the card");
    }
}
class CreditCard extends Card{
    int creditLimit;
    void payBill(){
        System.out.println("pay credit card bill");
    }
}
class DebitCard extends Card{
int balance;
}
class Test{
public static void main(String[] args) {
    CreditCard cc = new CreditCard();
    cc.balance=43000;
    // cc.cardNumber=4567234156782340L;
    cc.cvv=143;
    cc.expDate="12/22";
    cc.name="Ramesh";
    cc.creditLimit=100000;
    cc.swipe();
    cc.payBill();
}}
