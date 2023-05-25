import java.time.LocalDate; // import supaya format nanti bisa dalam bentuk tahun,bulan, dan hari 

public class Product<T> { // kelas yang bertipe generik T
    String name;
    T price; // type data generik agar bisa diganti ganti type attribut nya
    LocalDate expiryDate;

    public Product(String name, T price, LocalDate expiryDate) {
        this.name = name;
        this.price = price;
        this.expiryDate = expiryDate;
    }

    public String getName() {
        return name;
    }

    public T getPrice() {
        return price;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}
