// ===========================================================
// Topik: Abstraction
// Letakkan file ini pada src/model/Koleksi.java
// ===========================================================

package model;

// Abstract Class: tidak bisa di-instansiasi langsung
public abstract class Koleksi {
    protected String idKoleksi;
    protected String judul;
    protected int tahunTerbit;

    public Koleksi(String idKoleksi, String judul, int tahunTerbit) {
        this.idKoleksi = idKoleksi;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }

    // Abstract Method: memaksa semua kelas anak membuat cara tampilkanInfo nya sendiri
    public abstract void tampilkanInfo();

    // Method konkrit bawaan induk
    public String getIdKoleksi() { return idKoleksi; }
    public String getJudul() { return judul; }
    public int getTahunTerbit() { return tahunTerbit; }
}