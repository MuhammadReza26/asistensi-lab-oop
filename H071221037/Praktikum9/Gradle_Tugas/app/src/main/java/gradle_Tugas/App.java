package gradle_Tugas;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {
    private Stage primaryStage;
    private Scene scene1, scene2, scene3;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        createScene1();
        createScene2();
        primaryStage.setTitle("Aplikasi Kalkulator");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    private void createScene1() {
        ImageView logoImage = new ImageView("/Image/logo.png"); // Ubah "logo.png" dengan path logo Anda
        logoImage.setFitHeight(200); // untuk mengatur tinggi logo
        logoImage.setFitWidth(200); // untuk mengatur lebar logo

        Text titleText = new Text("Kalkulator Sederhana");
        titleText.setId("Kalkulator_Sederhana");

        Button startButton = new Button("Mulai");
        startButton.setId("Mulai");
        startButton.setOnAction(event -> primaryStage.setScene(scene2));

        VBox root = new VBox(50);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(logoImage, titleText, startButton);
        StackPane pane = new StackPane(root);
        // Membuat scene
        scene1 = new Scene(pane, 500, 500);
        scene1.getStylesheets().add(getClass().getResource("/Style/Style.css").toExternalForm());
    }

    private void createScene2() {
        // Membuat judul menu
        Text menuTitleText = new Text("Menu Utama");
        menuTitleText.setId("Menu_Utama");

        // Membuat tombol menu
        Button trigonometryButton = new Button("Kalkulator Trigonometri");
        trigonometryButton.setId("trigonometry");
        trigonometryButton.setOnAction(event -> primaryStage.setScene(scene3("Trigonometri")));

        Button conversionButton = new Button("Konversi Celcius ke Fahrenheit");
        conversionButton.setId("conversion");
        conversionButton.setOnAction(event -> primaryStage.setScene(scene3("Konversi")));

        // Membuat layout dan menambahkan komponen
        VBox root = new VBox(50);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(menuTitleText, trigonometryButton, conversionButton);
        StackPane pane = new StackPane(root);

        // Membuat scene
        scene2 = new Scene(pane, 500, 500);
        scene2.getStylesheets().add(getClass().getResource("/Style/Style.css").toExternalForm());
    }

    private Scene scene3(String calculatorType) {
        // Membuat judul halaman
        Text pageTitleText = new Text(calculatorType);
        pageTitleText.setId("calculator");

        // Membuat inputan
        TextField inputField = new TextField();
        inputField.setId("calculatorInput");
        Label teksHasil = new Label("Hasil : ");
        Label hasilkalkulasi = new Label("");
        Label hasilkalkulasi2 = new Label("");
        Label hasilkalkulasi3 = new Label("");
        Label hasilkalkulasi4 = new Label("");

        // Membuat tombol-tombol
        Button clearButton = new Button("Clear");
        clearButton.setId("Clear");
        clearButton.setOnAction(event -> inputField.clear());

        Button calculateButton = new Button("Calculate");
        calculateButton.setId("calculate");
        calculateButton.setOnAction(event -> {
            // Logika perhitungan sesuai dengan tipe kalkulator
            String input = inputField.getText();
            if (calculatorType.equalsIgnoreCase("Trigonometri")) {
                // Logika perhitungan kalkulator trigonometri
                hasilkalkulasi.setText(String.format("Sin : %.2f Cm ", calculateTrigonometrySin(input)));
                hasilkalkulasi2.setText(String.format("Cos : %.2f Cm ", calculateTrigonometryCos(input)));
                hasilkalkulasi3.setText(String.format("Tan : %.2f Cm ", calculateTrigonometryTan(input)));
            } else if (calculatorType.equalsIgnoreCase("Konversi")) {
                // Logika perhitungan kalkulator konversi Celcius ke Fahrenheit
                hasilkalkulasi4.setText(String.format("%.2f F", convertCelciusToFahrenheit(input)));
            }
        });

        Button backButton = new Button("Kembali ke Menu");
        backButton.setId("menu");
        backButton.setOnAction(event -> primaryStage.setScene(scene2));

        // Membuat layout dan menambahkan komponen
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(pageTitleText, inputField, teksHasil);
        if (calculatorType.equalsIgnoreCase("Trigonometri")) {
            root.getChildren().addAll(hasilkalkulasi, hasilkalkulasi2, hasilkalkulasi3);
        } else {
            root.getChildren().add(hasilkalkulasi4);
        }
        root.getChildren().addAll(clearButton, calculateButton, backButton);
        StackPane pane = new StackPane(root);

        // Membuat scene
        scene3 = new Scene(pane, 500, 500);
        scene3.getStylesheets().add(getClass().getResource("/Style/Style.css").toExternalForm());
        return scene3;
    }

    private double calculateTrigonometrySin(String input) {
        // Logika perhitungan kalkulator trigonometri
        // Misalnya, menghitung sinus dari input
        double value = Double.parseDouble(input);
        double sin = Math.sin(Math.toRadians(value));
        return sin;
    }

    private double calculateTrigonometryCos(String input) {
        double value = Double.parseDouble(input);
        double cos = Math.cos(Math.toRadians(value));
        return cos;
    }

    private double calculateTrigonometryTan(String input) {
        double value = Double.parseDouble(input);
        double tan = Math.tan(Math.toRadians(value));
        return tan;
    }

    private double convertCelciusToFahrenheit(String input) {
        // Logika perhitungan konversi Celcius ke Fahrenheit
        double celcius = Double.parseDouble(input);
        // return celcius * 9 / 5 + 32;
        double hasil = celcius * 9 / 5 + 32;
        return hasil;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
