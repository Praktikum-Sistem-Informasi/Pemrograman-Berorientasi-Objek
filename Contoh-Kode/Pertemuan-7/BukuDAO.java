// ===========================================================
// Topik: Integrasi Database
// Letakkan file ini pada src/dao/BukuDAO.java
// ===========================================================

package model;
import config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BukuDAO {

    //CREATE
    public void tambahBuku(Buku buku) {
        String sql = "INSERT INTO buku (id_buku, judul, penulis, tahun_terbit, stok) VALUES (?, ?, ?, ?, ?)";
        Connection conn = Koneksi.getConnection();

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, buku.getIdBuku());
            pstmt.setString(2, buku.getJudul());
            pstmt.setString(3, buku.getPenulis());
            pstmt.setInt(4, buku.getTahunTerbit());
            pstmt.setInt(5, buku.getStok());

            pstmt.executeUpdate();
            System.out.println("Buku berhasil ditambahkan!");
        } catch (SQLException e) {
            System.out.println("Gagal menambah buku - " + e.getMessage());
        }
    }

    //READ (by ID)
    public Buku cariBukuById(String idBuku) {
        String sql = "SELECT * FROM buku WHERE id_buku = ?";
        Buku buku = null;
        Connection conn = Koneksi.getConnection();

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idBuku);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    buku = new Buku();
                    buku.setIdBuku(rs.getString("id_buku"));
                    buku.setJudul(rs.getString("judul"));
                    buku.setPenulis(rs.getString("penulis"));
                    buku.setTahunTerbit(rs.getInt("tahun_terbit"));
                    buku.setStok(rs.getInt("stok"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Gagal mencari buku - " + e.getMessage());
        }
        return buku;
    }

    //READ (all)
    public List<Buku> getAllBuku() {
        List<Buku> listBuku = new ArrayList<>();
        String sql = "SELECT * FROM buku";
        Connection conn = Koneksi.getConnection();

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Buku buku = new Buku();
                buku.setIdBuku(rs.getString("id_buku"));
                buku.setJudul(rs.getString("judul"));
                buku.setPenulis(rs.getString("penulis"));
                buku.setTahunTerbit(rs.getInt("tahun_terbit"));
                buku.setStok(rs.getInt("stok"));
                listBuku.add(buku);
            }
        } catch (SQLException e) {
            System.out.println("Gagal mengambil data buku - " + e.getMessage());
        }
        return listBuku;
    }

    //UPDATE
    public void updateBuku(Buku buku) {
        String sql = "UPDATE buku SET judul=?, penulis=?, tahun_terbit=?, stok=? WHERE id_buku=?";
        Connection conn = Koneksi.getConnection();

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, buku.getJudul());
            pstmt.setString(2, buku.getPenulis());
            pstmt.setInt(3, buku.getTahunTerbit());
            pstmt.setInt(4, buku.getStok());
            pstmt.setString(5, buku.getIdBuku());

            int barisBerubah = pstmt.executeUpdate();
            if (barisBerubah > 0) {
                System.out.println("Data buku berhasil diubah!");
            } else {
                System.out.println("ID buku tidak ditemukan.");
            }
        } catch (SQLException e) {
            System.out.println("Gagal mengubah data buku - " + e.getMessage());
        }
    }

    //DELETE
    public void hapusBuku(String idBuku) {
        String sql = "DELETE FROM buku WHERE id_buku=?";
        Connection conn = Koneksi.getConnection();

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idBuku);

            int barisBerubah = pstmt.executeUpdate();
            if (barisBerubah > 0) {
                System.out.println("Buku berhasil dihapus!");
            } else {
                System.out.println("ID buku tidak ditemukan.");
            }
        } catch (SQLException e) {
            System.out.println("Gagal menghapus buku - " + e.getMessage());
        }
    }
}
