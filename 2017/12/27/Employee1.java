import java.util.HashMap;
import java.util.Map;

public class Employee1 {
    private String name;
    private String[] phoneNumber = new String[10];
    private Map<String, String> address = new HashMap<>();

    public Map<String, String> getAddress() {
        return address;
    }

    public void setAddress(Map<String, String> address) {
        this.address = address;
    }

    public String[] getPhoneNumber() {

        return phoneNumber;
    }

    public void setPhoneNumber(String[] phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
