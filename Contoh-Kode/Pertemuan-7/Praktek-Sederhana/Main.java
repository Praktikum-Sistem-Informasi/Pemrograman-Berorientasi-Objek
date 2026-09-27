import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    static Connection conn = Koneksi.getConnection();

    public static void main(String[] args) {

        if (conn == null) {
            System.out.println("Gagal terhubung ke database. Program dihentikan.");
            return;
        }

        System.out.println(">>> CREATE: tambah buku baru");
        tambahBuku(new Buku("B004", "Belajar Basis Data", 8));
        tampilkanBuku();

        System.out.println("\n>>> UPDATE: ubah stok buku B004");
        updateBuku(new Buku("B004", "Belajar Basis Data Lanjutan", 20));
        tampilkanBuku();

        System.out.println("\n>>> DELETE: hapus buku B004");
        hapusBuku("B004");
        tampilkanBuku();
    }

    // CREATE
    static void tambahBuku(Buku buku) {
        String sql = "INSERT INTO buku (id_buku, judul, stok) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, buku.getIdBuku());
            pstmt.setString(2, buku.getJudul());
            pstmt.setInt(3, buku.getStok());

            pstmt.executeUpdate();
            System.out.println("Buku berhasil ditambahkan!");
        } catch (SQLException e) {
            System.out.println("Gagal menambah buku - " + e.getMessage());
        }
    }

    // READ
    static void tampilkanBuku() {
        String sql = "SELECT * FROM buku";

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("--- DATA BUKU ---");
            while (rs.next()) {
                String id = rs.getString("id_buku");
                String judul = rs.getString("judul");
                int stok = rs.getInt("stok");
                System.out.println(id + " | " + judul + " | Stok: " + stok);
            }
        } catch (SQLException e) {
            System.out.println("Gagal mengambil data buku - " + e.getMessage());
        }
    }

    // UPDATE
    static void updateBuku(Buku buku) {
        String sql = "UPDATE buku SET judul=?, stok=? WHERE id_buku=?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, buku.getJudul());
            pstmt.setInt(2, buku.getStok());
            pstmt.setString(3, buku.getIdBuku());

            int baris = pstmt.executeUpdate();
            if (baris > 0) {
                System.out.println("Data buku berhasil diubah!");
            } else {
                System.out.println("ID buku tidak ditemukan.");
            }
        } catch (SQLException e) {
            System.out.println("Gagal mengubah data buku - " + e.getMessage());
        }
    }

    // DELETE
    static void hapusBuku(String idBuku) {
        String sql = "DELETE FROM buku WHERE id_buku=?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idBuku);

            int baris = pstmt.executeUpdate();
            if (baris > 0) {
                System.out.println("Buku berhasil dihapus!");
            } else {
                System.out.println("ID buku tidak ditemukan.");
            }
        } catch (SQLException e) {
            System.out.println("Gagal menghapus buku - " + e.getMessage());
        }
    }
}
