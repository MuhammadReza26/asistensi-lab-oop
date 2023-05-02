class Car implements Move {
    int totalForwardGear;
    String color;
    int maxSpeed;

    Car(int totalForwardGear, String color, int maxSpeed) {
        this.totalForwardGear = totalForwardGear;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void move() {
        System.out.println("Mobil Berakselerasi");
    }
}
