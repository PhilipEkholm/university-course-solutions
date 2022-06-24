package laboration6;

public class BankAccountTest {
    public void action() {
        BankAccount konto = new BankAccount();
        konto.init("399.847.500", 0, 0.005);

        konto.deposit( 1000 );
        konto.info();
        konto.withdrawal( 300 );
        konto.info();
    }

    public static void main(String[] args) {
        BankAccountTest bat = new BankAccountTest();
        bat.action();
    }
}
