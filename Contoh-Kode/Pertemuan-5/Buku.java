// ===========================================================
// Topik: Polimorphism
// Letakkan file ini pada src/model/Buku.java
// ===========================================================

package model;

public class Buku extends Koleksi {
    private String penulis;
    private int stok;

    public Buku(String idKoleksi, String judul, int tahunTerbit, String penulis, int stok) {
        super(idKoleksi, judul, tahunTerbit);
        this.penulis = penulis;
        this.stok = stok;
    }

    // DYNAMIC POLYMORPHISM: METHOD OVERRIDING
    // Mengubah perilaku method milik Superclass agar sesuai dengan Buku
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo(); // Memanggil tampilan dasar Koleksi
        System.out.printf("| Penulis: %-15s | Stok: %-3d [JENIS: BUKU]\n", penulis, stok);
    }

    public String getPenulis() { return penulis; }
    public int getStok() { return stok; }
}