public class Bank2 {
    public static ThreadLocal<Integer> account = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 100; // 重写 initialValue() 方法，将 account 的初始值设为 100
        }
    };

    public void deposit(int money) {
        account.set(account.get() + money); // 利用 account 的 get()、set() 方法实现存钱
    }

    public int getAccount() {
        return account.get();
    }
}
