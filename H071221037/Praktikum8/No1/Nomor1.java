import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Nomor1 {
}

class TaskTimeHelper {
    private static int waktuEksekusi; // attribut static untuk menyimpan waktu eksekusi

    public static int getWaktuEksekusi() {
        Random random = new Random();
        waktuEksekusi = random.nextInt(7) + 1;
        return waktuEksekusi;
    }
    // untuk menghasilkan waktu eksesusi secara acak antara 1 hingga 7
}

class BackgroundThread implements Runnable { // impementasikan dari runnable yang memang dari java
    private int waktuEksekusi;
    private int berhasil;
    private int gagal;
    private int jumlahData;
    // untuk mendefinisikan tugas yang akan dieksekusi pada thread terpisah

    public BackgroundThread(int jumlahData) {
        this.jumlahData = jumlahData;
    }

    @Override
    public void run() {
        for (int i = 0; i < jumlahData; i++) {
            waktuEksekusi = TaskTimeHelper.getWaktuEksekusi();
            if (0 <= waktuEksekusi && waktuEksekusi <= 4) {
                try {
                    TimeUnit.SECONDS.sleep(waktuEksekusi);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("Loading... (%ss)%n", waktuEksekusi);
                this.berhasil++;
            } else {
                System.out.println("Request Time Out!");
                this.gagal++;
            }
        }
    }

    // menjalankan tugas utama dalam thread terpisah
    // 1. melakukan perulangan sebanyak jumlah data
    // 2. setiap iterasi, waktu eksekusi diambil menggunakan task time
    // helper.getwaktueksekusi()
    // 3. jika waktu eksekusi berada dalam rentang 0 - 4, maka thread akan tidur
    // selama waktu eksekusi detik
    // 3.1 kemudian memprint loading.... dan variabel berhasil diinkremen / ditambah
    // 1
    // 3.2 jika tidak berada dalam rentang 0 - 4, maka thread akan print RTO dan
    // variabel gagal diinkremen / ditambah 1
    public int getBerhasil() {
        return this.berhasil;
    }

    public int getGagal() {
        return this.gagal;
    }
}
// kemudian kita getter berhasil dan gagal;

class UIThread {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        int jumlahData = random.nextInt(9) + 1;

        long start = System.currentTimeMillis();

        System.out.printf("Start load %s data%n%n", jumlahData);

        BackgroundThread backgroundThread = new BackgroundThread(jumlahData);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(backgroundThread);
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

        long end = System.currentTimeMillis();

        System.out.println();
        System.out.println("Task Finish");
        System.out.printf("Time Execution %ds%n", (int) ((end - start) / 1000));

        if (backgroundThread.getBerhasil() == jumlahData) {
            System.out.println("All data is succesfully loaded!");
        } else {
            System.out.printf("Data Succesfully Loaded %d & Data Failed to load %d", backgroundThread.getBerhasil(),
                    backgroundThread.getGagal());
        }
    }
}

// 1. terdapat bilangan acak antara 1 - 9 (inklusif) dihasilkan sebagai
// jumlahdata
// 2. waktu mulai (start) dicatat menggunakan system.current time millis
// 3. oesan start load jumlahData data
// 4. objek backgroundThread dibuat dengan jumlah data sebagai parameter /
// argumen konstruktor
// 5. objek executorService dibuat menggunakan excecutor .newfixedthreadpool (4)
// untuk membuat thread pool dengan 4 thread
// 6. backgroundThread disubmit ke executor Service untuk dieksekusi
// 7. executorService dishutdown agar tidak menerima lagi tugas baru
// 8. executorService.awaittermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS)
// digunakan untuk menunggu hingga semua tugas selesai dieksekusi
// 9. waktu akhir (end) dicatat menggunakan system.currenttimemillis()
// 10. pesan task finish diprint
// 11. waktu eksekusi program dicetak dengan type data int
// 12. jika semua data berhasil di load
// 12.1 backgroundThread.getBerhasil() == jumlahData maka pesan all .... dicetak
// 12.2 jika tidak sama, maka pesan data .... dicetak
