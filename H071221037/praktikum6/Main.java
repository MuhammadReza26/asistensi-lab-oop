public class Main {
    public static void main(String[] args) {
        System.out.println("=".repeat(40));
        System.out.println("class Dog");
        Pitbull pitbull = new Pitbull(0, 50);
        pitbull.move();
        pitbull.describe();
        System.out.println("=".repeat(40));

        System.out.println("=".repeat(40));
        System.out.println("class smartphone");
        Smartphone smartphone = new Smartphone(5_000_000, "Xiaomi");
        smartphone.move();
        System.out.printf("Harga  : Rp." + smartphone.price);
        System.out.println();
        System.out.println("Brand  : " + smartphone.brand);
        System.out.println("=".repeat(40));

        System.out.println("=".repeat(40));
        System.out.println("class car");
        Car car = new Car(5, "Hijau", 240);
        car.move();
        System.out.println("Gear toal  : " + car.totalForwardGear);
        System.out.println("Warna      : " + car.color);
        System.out.printf("Max Speed  : " + car.maxSpeed + "Km / Jam ");
        System.out.println();
        System.out.println("=".repeat(40));

    }

}
