import java.io.*;

public class Login implements Serializable {
    private String username;
    private transient String password;

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("用户名：" + username + "，");
        sb.append("密码：" + password);
        return sb.toString();
    }

    public Login clone() { // 使用序列化实现深克隆
        Login login = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this); // 将对象写入到字节数组中
            oos.close(); // 关闭输出流
        } catch (IOException e) {
            e.printStackTrace();
        }
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        try {
            ObjectInputStream ois = new ObjectInputStream(bais);
            login = (Login) ois.readObject(); // 从字节数组中读取对象
            ois.close(); // 关闭输入流
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return login;
    }
}
