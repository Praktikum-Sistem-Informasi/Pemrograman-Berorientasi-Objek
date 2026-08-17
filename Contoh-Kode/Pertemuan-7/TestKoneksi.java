// ===========================================================
// Topik: Integrasi Database
// Letakkan file ini pada src/main/TestKoneksi.java
// ===========================================================

package main;

import java.sql.Connection;
import koneksi.Koneksi;

public class TestKoneksi {
    public static void main(String[] args) {
        Connection conn = Koneksi.getConnection();

        if (conn != null) {
            System.out.println("Koneksi ke database BERHASIL!");
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println("Gagal menutup koneksi: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi database GAGAL. Periksa kembali URL, USER, PASS, dan pastikan service MySQL sudah menyala.");
        }
    }
}