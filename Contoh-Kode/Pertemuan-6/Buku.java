// ===========================================================
// Topik: Abstraction
// Letakkan file ini pada src/model/Buku.java
// ===========================================================

package model;

// 'abstract' pada class berarti Buku TIDAK BISA di-instansiasi langsung
// (tidak boleh ada "new Buku(...)"). Buku hanya boleh dipakai lewat
// turunannya (BukuCetak, EBook) yang sudah "lengkap".
public abstract class Buku {

    private final String idBuku;

    protected String judul;
    protected String penulis;
    protected int tahunTerbit;

    public Buku(String idBuku, String judul, String penulis, int tahunTerbit) {
        this.idBuku = idBuku;
        setJudul(judul);
        setPenulis(penulis);
        setTahunTerbit(tahunTerbit);
    }

    // ----- Getter & Setter (Encapsulation) -----

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

    // Method KONKRIT biasa (ada isinya): tetap dipakai bersama oleh semua
    // subclass supaya tidak perlu menulis ulang cetak data dasar.
    protected void cetakDataDasar() {
        System.out.println("ID Buku      : " + idBuku);
        System.out.println("Judul        : " + judul);
        System.out.println("Penulis      : " + penulis);
        System.out.println("Tahun Terbit : " + tahunTerbit);
    }

    // ----- ABSTRACT METHOD -----
    // Tidak punya isi/body (diakhiri titik koma). Setiap subclass
    // (BukuCetak, EBook) DIPAKSA membuat implementasinya sendiri,
    // karena tiap jenis buku punya cara tampil yang berbeda.
    public abstract void tampilkanInfo();

    // Overload tetap boleh ada meski versi tanpa parameternya abstract.
    // Saat tampilkanInfo() dipanggil di baris di bawah, Java otomatis
    // menjalankan versi milik objek aslinya (BukuCetak/EBook) -> polymorphism.
    public void tampilkanInfo(boolean ringkas) {
        if (ringkas) {
            System.out.println(judul + " (" + idBuku + ")");
        } else {
            tampilkanInfo();
        }
    }

    // 'final' pada method berarti method ini TIDAK BOLEH diubah
    // perilakunya oleh kelas turunan mana pun.
    public final void cetakStatusAset() {
        System.out.println(">> Status Aset: Terdaftar sebagai koleksi perpustakaan");
    }
}
