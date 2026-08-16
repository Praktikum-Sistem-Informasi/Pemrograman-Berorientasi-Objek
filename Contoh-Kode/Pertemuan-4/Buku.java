// ===========================================================
// Topik: Inheritance
// Letakkan file ini pada src/model/Buku.java
// ===========================================================

package model;

// Buku IS-A Koleksi
public class Buku extends Koleksi {
    // Atribut spesifik khusus Buku
    private String penulis;
    private int stok;

    // Constructor Subclass
    public Buku(String idKoleksi, String judul, int tahunTerbit, String penulis, int stok) {
        // Pemanggilan constructor induk (Koleksi) wajib baris pertama
        super(idKoleksi, judul, tahunTerbit); 
        this.penulis = penulis;
        setStok(stok); // Validasi enkapsulasi dari P3
    }

    public void setStok(int stok) {
        if (stok >= 0) {
            this.stok = stok;
        } else {
            System.out.println(">> ERROR: Stok tidak boleh negatif!");
            this.stok = 0;
        }
    }

    public String getPenulis() { return penulis; }
    public int getStok() { return stok; }

    // Method spesifik menambahkan info khas Buku
    public void tampilkanInfoBuku() {
        super.tampilkanInfo(); // Memanggil method milik Superclass
        System.out.printf("| Penulis: %-15s | Stok: %-3d\n", penulis, stok);
    }
}