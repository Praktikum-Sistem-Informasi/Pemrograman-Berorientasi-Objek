// ===========================================================
// Topik: Integrasi Database
// Letakkan file ini pada src/main/Main.java
// ===========================================================

package main;
import config.Koneksi;
import controller.BukuController;

public class Main {
    public static void main(String[] args) {

        if (Koneksi.getConnection() != null) {
            BukuController aplikasi = new BukuController();
            aplikasi.mulai();

        } else {
            System.out.println("Gagal terhubung ke Database. Program dihentikan.");
        }
    }
}
