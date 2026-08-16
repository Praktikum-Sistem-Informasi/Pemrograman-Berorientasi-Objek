// ===========================================================
// Topik: Inheritance
// Letakkan file ini pada src/model/Koleksi.java
// ===========================================================

package model;

public class Koleksi {
    // Protected: dapat diakses oleh kelas turunan (subclass)
    protected String idKoleksi;
    protected String judul;
    protected int tahunTerbit;

    // Constructor Superclass
    public Koleksi(String idKoleksi, String judul, int tahunTerbit) {
        this.idKoleksi = idKoleksi;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }

    // Method umum
    public void tampilkanInfo() {
        System.out.printf("ID: %-6s | Judul: %-25s | Tahun: %-4d ", 
                idKoleksi, judul, tahunTerbit);
    }

    // Getter & Setter
    public String getIdKoleksi() { return idKoleksi; }
    public String getJudul() { return judul; }
    public int getTahunTerbit() { return tahunTerbit; }
}