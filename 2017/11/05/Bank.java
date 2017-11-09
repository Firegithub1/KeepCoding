public class Bank {
    private int account = 100;

    public void deposit(int money) {
        account += money;
    }

    public int getAccount() {
        return account;
    }
}
