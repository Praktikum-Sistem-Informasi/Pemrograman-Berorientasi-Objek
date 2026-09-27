// ===========================================================
// Topik: Integrasi Database
// Letakkan file ini pada src/config/TestKoneksi.java
// ===========================================================

package config;
import java.sql.Connection;

public class TestKoneksi {

    public static void main(String[] args) {
        System.out.println("Mengecek koneksi ke database...");

        //Memanggil koneksi
        Connection conn = Koneksi.getConnection();

        //Mengecek variabel conn ada isinya atau kosong (null)
        if (conn != null) {
            System.out.println("STATUS: BERHASIL! Database siap digunakan.");
        } else {
            System.out.println("STATUS: GAGAL! Periksa kembali URL, USER, PASS, dan pastikan service MySQL sudah menyala.");
        }
    }
}
