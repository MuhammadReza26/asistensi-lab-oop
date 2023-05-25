public class FoodFactory { // untuk method getfood dengan type class Food dengan parameter string type
    public static Food getFood(String type) {
        if (type.equalsIgnoreCase("burger")) {
            return new Burger();
        } else if (type.equalsIgnoreCase("pizza")) {
            return new Pizza();
        } else if (type.equalsIgnoreCase("steak")) {
            return new Steak();
        } else {
            throw new IllegalArgumentException("Invalid food type: " + type);
        }
    }
}

// illegal argument exception itu pengecualian yang terjadi ketika method
// menerima argumen yang tidak valid atau tidak sesuai dengan yang diinginkan
// jika method menerima argumen yang tidak valid , maka melemparkan illegal
// argument exception yang menunjukkan bahwa argumen yang diberikan tidak dapat
// diterima atau digunakan dalam method tersebut