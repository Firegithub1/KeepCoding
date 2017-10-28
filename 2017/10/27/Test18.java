/**
 * 118：适配器模式的简单应用
 */

public class Test18 {
    public static void main(String[] args) {
        System.out.println("自定义普通的汽车：");
        Car1 car = new Car1();
        car.setName("Audi");
        car.setSpeed(60);
        System.out.println(car);
        System.out.println("自定义 GPS 汽车：");
        GPSCar gpsCar = new GPSCar();
        gpsCar.setName("Audi");
        gpsCar.setSpeed(60);
        System.out.println(gpsCar);
    }
}
