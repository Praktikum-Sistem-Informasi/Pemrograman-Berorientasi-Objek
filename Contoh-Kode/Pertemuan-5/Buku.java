// ===========================================================
// Topik: Polymorphism (Overriding & Overloading)
// Letakkan file ini pada src/model/Buku.java
// ===========================================================

package model;

// Buku adalah SUPERCLASS (kelas induk) bagi BukuCetak dan EBook
public class Buku {

    // idBuku ditandai 'final' karena nilainya tidak boleh berubah
    // setelah objek dibuat. Karena final, atribut ini WAJIB diisi
    // lewat constructor dan tidak disediakan setter untuknya.
    private final String idBuku;

    // protected: hanya bisa diakses langsung oleh kelas ini
    // dan kelas turunannya (BukuCetak, EBook), tidak oleh kelas luar.
    protected String judul;
    protected String penulis;
    protected int tahunTerbit;

    // Constructor Superclass
    public Buku(String idBuku, String judul, String penulis, int tahunTerbit) {
        this.idBuku = idBuku;
        setJudul(judul);
        setPenulis(penulis);
        setTahunTerbit(tahunTerbit);
    }

    // ----- Getter & Setter (Encapsulation) -----

    // Tidak ada setIdBuku() karena idBuku bersifat final
    public String getIdBuku() {
        return idBuku;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        if (judul != null && !judul.trim().isEmpty()) {
            this.judul = judul;
        } else {
            System.out.println(">> ERROR: Judul tidak boleh kosong!");
        }
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        if (penulis != null && !penulis.trim().isEmpty()) {
            this.penulis = penulis;
        } else {
            System.out.println(">> ERROR: Penulis tidak boleh kosong!");
        }
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(int tahunTerbit) {
        if (tahunTerbit >= 1900 && tahunTerbit <= 2026) {
            this.tahunTerbit = tahunTerbit;
        } else {
            System.out.println(">> ERROR: Tahun terbit harus antara 1900-2026!");
        }
    }

    // ----- METHOD OVERLOADING -----
    // Dua method dengan NAMA SAMA (tampilkanInfo) tapi DAFTAR PARAMETER berbeda.
    // Java memilih method mana yang dijalankan berdasarkan jumlah/tipe argumen saat method dipanggil (dicek saat compile-time).

    // Versi 1: tanpa parameter -> tampilan lengkap.
    // Method ini TIDAK final, sehingga bisa di-OVERRIDE oleh subclass
    public void tampilkanInfo() {
        System.out.println("ID Buku      : " + idBuku);
        System.out.println("Judul        : " + judul);
        System.out.println("Penulis      : " + penulis);
        System.out.println("Tahun Terbit : " + tahunTerbit);
    }

    // Versi 2 (overload): dengan parameter boolean -> bisa pilih versi ringkas
    public void tampilkanInfo(boolean ringkas) {
        if (ringkas) {
            System.out.println(judul + " (" + idBuku + ")");
        } else {
            tampilkanInfo(); // memanggil versi tanpa parameter di atas
        }
    }

    // 'final' pada method berarti method ini TIDAK BOLEH diubah perilakunya oleh kelas turunan mana pun (BukuCetak, EBook, dst).
    // Cocok untuk aturan/label baku yang sifatnya mutlak sama untuk seluruh jenis buku.
    public final void cetakStatusAset() {
        System.out.println(">> Status Aset: Terdaftar sebagai koleksi perpustakaan");
    }
}