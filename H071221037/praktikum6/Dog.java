abstract class Dog implements Move {

    int position;
    int averageLength;

    public Dog(int position, int averageLength) {
        this.position = position;
        this.averageLength = averageLength;
    }

    public abstract void describe();
}

class Pitbull extends Dog {
    public Pitbull(int position, int averageLength) {
        super(position, averageLength);
    }

    @Override
    public void move() {
        position += 3;
        System.out.println("Posisi pitbull bergerak sejauh : " + position);
    }

    @Override
    public void describe() {
        System.out.println("Anjing pitbull berasal dari Inggris ");
        System.out.println("Anjing pitbull Memiliki tubuh yang atletis dan kokoh ");
        System.out.println("Anjing pitbull memiliki bulu yang pendek, rapat, dan berkilau ");
        System.out.println("Anjing pitbull merupakan anjing yang sangat cerdas, penuh energi, dan suka bermain ");
        System.out.println("Anjing pitbull memiliki rata-rata panjang :" + this.averageLength + "cm");
        System.out.println();
    }
}

class SiberianHusky extends Dog {
    public SiberianHusky(int position, int averageLength) {
        super(position, averageLength);
    }

    @Override
    public void move() {
        position += 2;
        System.out.println("Posisi Siberian Husky bergerak sejauh : " + position);
    }

    @Override
    public void describe() {
        System.out.println("Anjing Siberian Husky berasal dari Rusia ");
        System.out.println("Anjing Siberian Husky Memiliki tubuh yang tegap dan atletis ");
        System.out.println("Anjing Siberian Husky memiliki bulu tebal dan lebat ");
        System.out.println("Anjing Siberian Husky merupakan anjing yang ramah dan suka bersosialisasi dengan manusia ");
        System.out.println("Anjing Siberian Husky memiliki rata-rata panjang :" + this.averageLength + "cm");
        System.out.println();
    }
}

class Bulldog extends Dog {
    public Bulldog(int position, int averageLength) {
        super(position, averageLength);
    }

    @Override
    public void describe() {
        System.out.println("Anjing Bulldog berasal dari Inggris  ");
        System.out.println("Anjing Bulldog Memiliki tubuh yang pendek dan kompak ");
        System.out.println("Anjing Bulldog memiliki bulu yang pendek dan padat ");
        System.out.println("Anjing Bulldog merupakan anjing yang lembut dan ramah  ");
        System.out.println("Anjing Bulldog memiliki rata-rata panjang :" + this.averageLength + "cm");
        System.out.println();
    }

    @Override
    public void move() {
        position += 1;
        System.out.println("posisi Bulldog bergerak sejauh : " + position);
    }
}

class GermanShepherd extends Dog {
    public GermanShepherd(int position, int averageLength) {
        super(position, averageLength);
    }

    @Override
    public void move() {
        position += 3;
        System.out.println("posisi GermanShepherd bergerak sejauh : " + position);
    }

    @Override
    public void describe() {
        System.out.println("Anjing GermanShepherd berasal dari Inggris  ");
        System.out.println("Anjing GermanShepherd Memiliki tubuh yang kuat dan berotot ");
        System.out.println("Anjing GermanShepherd memiliki bulu yang panjang dan tebal ");
        System.out.println("Anjing GermanShepherd merupakan anjing yang cerdas dan penuh semangat   ");
        System.out.println("Anjing GermanShepherd memiliki rata-rata panjang :" + this.averageLength + "cm");
        System.out.println();
    }
}
