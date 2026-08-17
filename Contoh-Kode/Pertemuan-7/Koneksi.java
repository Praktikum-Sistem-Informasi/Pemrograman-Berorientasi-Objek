// ===========================================================
// Topik: Integrasi Database
// Letakkan file ini pada src/koneksi/Koneksi.java
// ===========================================================

package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {

    private static final String URL = "jdbc:mysql://localhost:3306/db_perpustakaan";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // sesuaikan dengan password MySQL Anda

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Koneksi database GAGAL: " + e.getMessage());
        }
        return conn;
    }
}