import javax.swing.*;

public class Transfer implements Runnable {
    private Bank bank;
    private JTextArea textArea;

    public Transfer(Bank bank, JTextArea textArea) {
        this.bank = bank;
        this.textArea = textArea;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            bank.deposit(10);
            String text = textArea.getText();
            textArea.setText(text + "账户的余额是：" + bank.getAccount() + "\n");
        }
    }
}
