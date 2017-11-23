public class Chopstick {
    private int id;
    private volatile boolean available = true;

    public Chopstick(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "筷子" + id;
    }
}
