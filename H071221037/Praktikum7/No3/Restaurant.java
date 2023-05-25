import java.util.List;

public class Restaurant {
    public static int calculateTotal(List<Food> foods) {
        int total = 0;
        for (Food food : foods) {
            total += food.getprice();
        }
        return total;
    }
}

// mempunyai method calculatetotal dengan parameter list dari kelas Food yang
// diberinama foods
// jika food itu benar terdapat di list foods maka semua getprice nya //
// dijumlahkan kemudian dimasukkan ke variabel total