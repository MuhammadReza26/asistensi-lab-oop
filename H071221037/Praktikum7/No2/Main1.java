import java.time.LocalDate;

public class Main1 {

        public static void main(String[] args) {
                // objek produk dengan price bertipe Integer,double dan String
                Product<Integer> Product1 = new Product<>("Kinder Joy", 10000, LocalDate.of(2023, 05, 01));
                Product<Double> Product2 = new Product<>("Sari Roti", 15000.0, LocalDate.of(2023, 05, 20));
                Product<String> Product3 = new Product<>("Susu Kurma", "7.5", LocalDate.of(2023, 06, 01));
                // Informasi dari setiap produk
                System.out.println(
                                " Product 1 : " + Product1.getName() + " - " + Product1.getPrice() + " - "
                                                + Product1.getExpiryDate());
                System.out.println(
                                " Product 2 : " + Product2.getName() + " - " + Product2.getPrice() + " - "
                                                + Product2.getExpiryDate());
                System.out.println(
                                " Product 3 : " + Product3.getName() + " - " + Product3.getPrice() + " - "
                                                + Product3.getExpiryDate());
        }
}

// untuk produk 1 itu price nya bertipe integer
// untuk produk 2 itu price nya bertipe double
// untuk produk 3 itu price nya bertipe string
