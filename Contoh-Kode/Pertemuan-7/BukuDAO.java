// ===========================================================
// Topik: Integrasi Database
// Letakkan file ini pada src/dao/BukuDAO.java
// ===========================================================

package dao;

import koneksi.Koneksi;
import model.Buku;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BukuDAO {

    // CREATE
    public boolean tambahBuku(Buku buku) {
        String sql = "INSERT INTO buku (id_koleksi, judul, penulis, tahun_terbit, stok) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, buku.getIdKoleksi());
            ps.setString(2, buku.getJudul());
            ps.setString(3, buku.getPenulis());
            ps.setInt(4, buku.getTahunTerbit());
            ps.setInt(5, buku.getStok());

            return ps.executeUpdate() > 0; // true jika ada baris yang berhasil ditambahkan

        } catch (SQLException e) {
            System.out.println("Gagal menambah buku: " + e.getMessage());
            return false;
        }
    }

    // READ
    public List<Buku> tampilkanSemuaBuku() {
        List<Buku> daftarBuku = new ArrayList<>();
        String sql = "SELECT * FROM buku";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Buku b = new Buku(
                        rs.getString("id_koleksi"),
                        rs.getString("judul"),
                        rs.getString("penulis"),
                        rs.getInt("tahun_terbit"),
                        rs.getInt("stok")
                );
                daftarBuku.add(b);
            }

        } catch (SQLException e) {
            System.out.println("Gagal mengambil data buku: " + e.getMessage());
        }
        return daftarBuku;
    }

    //READ ID
    public Buku cariBukuById(String idKoleksi) {
        String sql = "SELECT * FROM buku WHERE id_koleksi = ?";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, idKoleksi);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Buku(
                            rs.getString("id_koleksi"),
                            rs.getString("judul"),
                            rs.getString("penulis"),
                            rs.getInt("tahun_terbit"),
                            rs.getInt("stok")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("Gagal mencari buku: " + e.getMessage());
        }
        return null; // tidak ditemukan
    }

    //UPDATE
    public boolean updateBuku(Buku buku) {
        String sql = "UPDATE buku SET judul = ?, penulis = ?, tahun_terbit = ?, stok = ? WHERE id_koleksi = ?";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, buku.getJudul());
            ps.setString(2, buku.getPenulis());
            ps.setInt(3, buku.getTahunTerbit());
            ps.setInt(4, buku.getStok());
            ps.setString(5, buku.getIdKoleksi());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Gagal update buku: " + e.getMessage());
            return false;
        }
    }

    // DELETE
    public boolean hapusBuku(String idKoleksi) {
        String sql = "DELETE FROM buku WHERE id_koleksi = ?";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, idKoleksi);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Gagal menghapus buku: " + e.getMessage());
            return false;
        }
    }
}