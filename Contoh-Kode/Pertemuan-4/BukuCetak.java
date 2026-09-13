// ===========================================================
// Topik: Inheritance (Pewarisan)
// Letakkan file ini pada src/model/BukuCetak.java
// ===========================================================

package model;

// 'extends' artinya BukuCetak MEWARISI seluruh atribut & method milik Buku.
// Relasi ini disebut IS-A: "BukuCetak IS-A Buku".
public class BukuCetak extends Buku {

    // Atribut khusus BukuCetak (tidak dimiliki Buku, jadi tidak perlu
    // ditulis ulang idBuku/judul/penulis/tahunTerbit di sini)
    private int jumlahHalaman;
    private String lokasiRak;

    // Constructor Subclass
    public BukuCetak(String idBuku, String judul, String penulis, int tahunTerbit, int jumlahHalaman, String lokasiRak) {
        // 'super(...)' memanggil constructor milik Buku (induk).
        // WAJIB menjadi baris pertama di dalam constructor subclass.
        super(idBuku, judul, penulis, tahunTerbit);

        setJumlahHalaman(jumlahHalaman);
        setLokasiRak(lokasiRak);
    }

    // ----- Getter & Setter khusus BukuCetak -----

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

    // Method khusus BukuCetak (nama berbeda dari method di Buku,
    // BUKAN overriding) yang menambahkan info khas buku fisik.
    public void tampilkanInfoBukuCetak() {
        System.out.println("------------------------------------------");
        System.out.println("[KATEGORI: BUKU CETAK]");
        // 'super.tampilkanInfo()' memanggil method milik Superclass
        // agar tidak perlu menulis ulang logikanya di sini.
        super.tampilkanInfo();
        System.out.println("Jml Halaman  : " + jumlahHalaman + " hlm");
        System.out.println("Lokasi Rak   : " + lokasiRak);
        // Method final dari Superclass juga tetap bisa dipanggil
        cetakStatusAset();
        System.out.println("------------------------------------------");
    }
}