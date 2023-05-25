import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

class Typer extends Thread {
    private String botName, wordsType;
    private double wpm;
    private TypeRacer typeRacer;
    private int durasi;

    public void setDurasi(int durasi) {
        this.durasi = durasi;
    }

    public int getDurasi() {
        return durasi;
    }

    public Typer(String botName, Double wpm, TypeRacer typeRacer) {
        this.botName = botName;
        this.wpm = wpm;
        this.wordsType = "";
        this.typeRacer = typeRacer;
    }

    public void setBotName(String botName) {
        this.botName = botName;
    }

    public void setWpm(int wpm) {
        this.wpm = wpm;
    }

    private void addWordType(String newWordsTyped) {
        this.wordsType += newWordsTyped + " ";
    }
    // method ini digunakan untuk menambahkan kata yang diketik ke variabel
    // wordsType

    public String getWordstype() {
        return wordsType;
    }

    public String getBotName() {
        return botName;
    }

    public double getWpm() {
        return wpm;
    }

    @Override
    public void run() {
        String[] wordsToType = typeRacer.getWordsToType().split(" ");
        // kata kata yang akan diketik itu akan masuk ke dalam list kemudian dipecah
        // menjadi array kata
        long howLongToType = (long) ((60 / this.getWpm()) * 1000);
        // untuk menghitung berapa lama untuk mengetik satu kata berdasarkan kecepatan
        // mengetik
        long start = System.currentTimeMillis();
        // waktu mulai (start) dicatat menggunakan system currenttimemillis()
        for (String word : wordsToType) {
            // untuk setiap kata dalam array kata, thread akan tidur selama howLongToType
            // dan kata tersebut ditambah ke wordsType
            try {
                TimeUnit.MILLISECONDS.sleep(howLongToType);
                this.addWordType(word);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.addWordType("(selesai)"); // setelah selesai mengetik, maka akan menghasilkan selesai yang ditambahkan ke
                                       // // wordType
        long end = System.currentTimeMillis(); // waktu akhir (end) dicatat menggunakan system.currenttimemillis()
        int waktu = (int) (end - start); // waktu dihitung berdasarkan pengurangan end dan start kemudian diubah dalam
                                         // // bentuk int
        this.setDurasi(waktu); // durasi di set berdasarkan waktu
        // hasilnya (objek typer dengan nama dan durasi waktu mengetik) ditambahkan ke
        // objek TypeRacer menggunakan
        typeRacer.addResult(this);

    }
}

class Result {
    private String name;
    private int finishTime;

    public Result(String name, int finishTime) {
        this.name = name;
        this.finishTime = finishTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }
}

class TypeRacer {
    private String wordsToType;
    private ArrayList<Typer> raceContestant = new ArrayList<>();
    private ArrayList<Result> raceStanding = new ArrayList<>();

    public String getWordsToType() {
        return wordsToType;
    }

    public ArrayList<Typer> getRaceContestant() {
        return raceContestant;
    }

    private String[] wordsToTypeList = {
            "Kesuksesan sejati adalah ketika kita mencapai tujuan kita sambil tetap mempertahankan integritas dan empati terhadap orang lain" };

    public void setNewWordsToType() {
        Random random = new Random();
        int angkaRandom = random.nextInt(wordsToTypeList.length);
        wordsToType = wordsToTypeList[angkaRandom];
    }

    // objek random digunakan untuk menghasilkan angka random dalam pemrograman
    public void addResult(Typer typer) {
        Result result = new Result(typer.getBotName(), typer.getDurasi());
        raceStanding.add(result);
    }

    private void printRaceStanding() {
        System.out.println("\nKlasmen Akhir Type Racer");
        System.out.println("=========================\n");
        for (int i = 0; i < raceStanding.size(); i++) {
            System.out.printf("%d. %s = %d detik%n", raceStanding.indexOf(raceStanding.get(i)) + 1,
                    raceStanding.get(i).getName(), raceStanding.get(i).getFinishTime());
        }
    }

    public void startRace() throws InterruptedException {
        this.setNewWordsToType();
        for (Typer typer : raceContestant) {
            typer.start();
        }
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Typing Progress ...");
            System.out.println("================");
            for (Typer i : raceContestant) {
                System.out.printf("- %s => %s%n", i.getBotName(), i.getWordstype());
            }
            if (raceStanding.size() == raceContestant.size()) {
                break;
            }
        }

        this.printRaceStanding();
    }
}

public class Nomor2 {
    public static void main(String[] args) throws InterruptedException {
        TypeRacer typeRacer = new TypeRacer();
        typeRacer.setNewWordsToType();
        System.out.println("|| Text to Type");
        System.out.println("\"" + typeRacer.getWordsToType() + "\"");

        Typer[] typers = new Typer[3];

        typers[0] = new Typer("Bot Mansur", 80.0, typeRacer);
        typers[1] = new Typer("Bot Toku", 72.0, typeRacer);
        typers[2] = new Typer("Bot Yukiao", 70.0, typeRacer);

        typeRacer.getRaceContestant().addAll(Arrays.asList(typers));

        typeRacer.startRace();
    }
}
