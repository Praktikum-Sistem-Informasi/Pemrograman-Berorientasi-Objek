// ===========================================================
// Topik: Abstraction
// Letakkan file ini pada src/model/Majalah.java
// ===========================================================

package model;

public class Majalah extends Koleksi {
    private int edisi;

    public Majalah(String idKoleksi, String judul, int tahunTerbit, int edisi) {
        super(idKoleksi, judul, tahunTerbit);
        this.edisi = edisi;
    }

    // Implementasi Abstract Method dari Koleksi
    @Override
    public void tampilkanInfo() {
        System.out.printf("ID: %-5s | Judul: %-20s | Tahun: %-4d | Edisi: Vol. %-9d [MAJALAH]\n", 
                idKoleksi, judul, tahunTerbit, edisi);
    }

    public int getEdisi() { return edisi; }
}