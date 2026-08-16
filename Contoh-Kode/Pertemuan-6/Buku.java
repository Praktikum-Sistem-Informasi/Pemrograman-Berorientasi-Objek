// ===========================================================
// Topik: Abstraction
// Letakkan file ini pada src/model/Buku.java
// ===========================================================

package model;

public class Buku extends Koleksi implements Pinjamable {
    private String penulis;
    private int stok;

    public Buku(String idKoleksi, String judul, int tahunTerbit, String penulis, int stok) {
        super(idKoleksi, judul, tahunTerbit);
        this.penulis = penulis;
        this.stok = stok;
    }

    // Implementasi Abstract Method dari Koleksi
    @Override
    public void tampilkanInfo() {
        System.out.printf("ID: %-5s | Judul: %-20s | Tahun: %-4d | Penulis: %-15s | Stok: %-3d [BUKU]\n", 
                idKoleksi, judul, tahunTerbit, penulis, stok);
    }

    // Implementasi Interface Pinjamable
    @Override
    public void pinjam() {
        if (stok > 0) {
            stok--;
            System.out.println(">> SUCCESS: Buku '" + judul + "' berhasil dipinjam. Sisa stok: " + stok);
        } else {
            System.out.println(">> ERROR: Stok buku '" + judul + "' sedang habis!");
        }
    }

    @Override
    public void kembalikan() {
        stok++;
        System.out.println(">> SUCCESS: Buku '" + judul + "' dikembalikan. Stok sekarang: " + stok);
    }

    public String getPenulis() { return penulis; }
    public int getStok() { return stok; }
}