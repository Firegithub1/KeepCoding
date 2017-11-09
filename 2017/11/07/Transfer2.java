import javax.swing.*;

public class Transfer2 implements Runnable {
    private Bank2 bank;
    private JTextArea textArea;

    public Transfer2(Bank2 bank, JTextArea textArea) {
        this.bank = bank;
        this.textArea = textArea;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            bank.deposit(10);
            String text = textArea.getText();
            textArea.setText(text + "账户中的余额为：" + bank.getAccount() + "\n");
        }
    }
}
