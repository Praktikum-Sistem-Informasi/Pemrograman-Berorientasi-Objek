// ===========================================================
// Topik: Inheritance
// Letakkan file ini pada src/model/Buku.java
// ===========================================================

package model;

// Majalah IS-A Koleksi
public class Majalah extends Koleksi {
    // Atribut spesifik khusus Majalah
    private int edisi;

    // Constructor Subclass
    public Majalah(String idKoleksi, String judul, int tahunTerbit, int edisi) {
        super(idKoleksi, judul, tahunTerbit); // Mengirim data ke konstruktor Koleksi
        this.edisi = edisi;
    }

    public int getEdisi() { return edisi; }

    // Method spesifik menambahkan info khas Majalah
    public void tampilkanInfoMajalah() {
        super.tampilkanInfo(); // Memanggil method milik Superclass
        System.out.printf("| Edisi: Vol. %-3d\n", edisi);
    }
}