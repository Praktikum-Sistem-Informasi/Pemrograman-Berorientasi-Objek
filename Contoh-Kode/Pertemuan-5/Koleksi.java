// ===========================================================
// Topik: Polimorphism
// Letakkan file ini pada src/model/Koleksi.java
// ===========================================================

package model;

public class Koleksi {
    protected String idKoleksi;
    protected String judul;
    protected int tahunTerbit;

    public Koleksi(String idKoleksi, String judul, int tahunTerbit) {
        this.idKoleksi = idKoleksi;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }

    // Method yang akan di-OVERRIDE oleh kelas anak
    public void tampilkanInfo() {
        System.out.printf("ID: %-5s | Judul: %-22s | Tahun: %-4d ", 
                idKoleksi, judul, tahunTerbit);
    }

    // =========================================================================
    // CONTOH METHOD OVERLOADING (Nama sama, parameter berbeda dalam 1 kelas)
    // =========================================================================
    
    // Overload 1: Cari berdasarkan kata kunci judul
    public boolean cocokData(String kataKunci) {
        return this.judul.toLowerCase().contains(kataKunci.toLowerCase());
    }

    // Overload 2: Cari berdasarkan tahun terbit persis
    public boolean cocokData(int tahun) {
        return this.tahunTerbit == tahun;
    }

    // Getter
    public String getIdKoleksi() { return idKoleksi; }
    public String getJudul() { return judul; }
    public int getTahunTerbit() { return tahunTerbit; }
}