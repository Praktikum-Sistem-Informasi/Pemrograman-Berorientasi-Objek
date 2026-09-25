// ===========================================================
// Topik: Abstraction
// Letakkan file ini pada src/model/BukuCetak.java
// ===========================================================

package model;

// 'extends Buku' -> tetap mewarisi (Inheritance, materi sebelumnya).
// 'implements Pinjamable' -> BukuCetak berjanji memenuhi KONTRAK
// interface Pinjamable, karena buku fisik memang bisa dipinjam.
public class BukuCetak extends Buku implements Pinjamable {

    private int jumlahHalaman;
    private String lokasiRak;

    // Status peminjaman: dibutuhkan supaya pinjam()/kembalikan() punya
    // sesuatu untuk diubah.
    private boolean sedangDipinjam = false;

    public BukuCetak(String idBuku, String judul, String penulis, int tahunTerbit,
                      int jumlahHalaman, String lokasiRak) {
        super(idBuku, judul, penulis, tahunTerbit);
        setJumlahHalaman(jumlahHalaman);
        setLokasiRak(lokasiRak);
    }

    // ----- Getter & Setter -----

    public int getJumlahHalaman() {
        return jumlahHalaman;
    }

    public void setJumlahHalaman(int jumlahHalaman) {
        if (jumlahHalaman > 0) {
            this.jumlahHalaman = jumlahHalaman;
        } else {
            System.out.println(">> ERROR: Jumlah halaman harus lebih dari 0!");
            this.jumlahHalaman = 1;
        }
    }

    public String getLokasiRak() {
        return lokasiRak;
    }

    public void setLokasiRak(String lokasiRak) {
        if (lokasiRak != null && !lokasiRak.trim().isEmpty()) {
            this.lokasiRak = lokasiRak;
        } else {
            System.out.println(">> ERROR: Lokasi rak tidak boleh kosong!");
        }
    }

    // ----- WAJIB: implementasi abstract method milik Buku -----
    @Override
    public void tampilkanInfo() {
        System.out.println("------------------------------------------");
        System.out.println("[KATEGORI: BUKU CETAK]");
        cetakDataDasar(); // method konkrit yang dipinjam dari Buku
        System.out.println("Jml Halaman  : " + jumlahHalaman + " hlm");
        System.out.println("Lokasi Rak   : " + lokasiRak);
        cetakStatusAset();
        System.out.println("------------------------------------------");
    }

    // ----- WAJIB: implementasi interface Pinjamable -----
    @Override
    public void pinjam() {
        if (!sedangDipinjam) {
            sedangDipinjam = true;
            System.out.println(">> SUCCESS: Buku '" + judul + "' berhasil dipinjam.");
        } else {
            System.out.println(">> ERROR: Buku '" + judul + "' sedang dipinjam orang lain!");
        }
    }

    @Override
    public void kembalikan() {
        if (sedangDipinjam) {
            sedangDipinjam = false;
            System.out.println(">> SUCCESS: Buku '" + judul + "' telah dikembalikan.");
        } else {
            System.out.println(">> INFO: Buku '" + judul + "' memang belum dipinjam.");
        }
    }
}
