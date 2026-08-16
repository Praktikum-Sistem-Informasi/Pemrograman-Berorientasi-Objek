// ===========================================================
// Topik: Polimorphism
// Letakkan file ini pada src/model/Majalah.java
// ===========================================================

package model;

public class Majalah extends Koleksi {
    private int edisi;

    public Majalah(String idKoleksi, String judul, int tahunTerbit, int edisi) {
        super(idKoleksi, judul, tahunTerbit);
        this.edisi = edisi;
    }

    // DYNAMIC POLYMORPHISM: METHOD OVERRIDING
    // Mengubah perilaku method milik Superclass agar sesuai dengan Majalah
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo(); // Memanggil tampilan dasar Koleksi
        System.out.printf("| Edisi: Vol. %-11d [JENIS: MAJALAH]\n", edisi);
    }

    public int getEdisi() { return edisi; }
}