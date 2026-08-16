// ===========================================================
// Topik: Package, Class, Object
// Letakkan file ini pada src/model/Buku.java
// ===========================================================

package model;

public class Buku {
    // 1. Atribut (Anatomi Class)
    public String idBuku;
    public String judul;
    public String penulis;
    public int stok;

    // 2. Constructor (Method khusus untuk inisialisasi objek saat pemanggilan 'new')
    public Buku(String idBuku, String judul, String penulis, int stok) {
        this.idBuku = idBuku;
        this.judul = judul;
        this.penulis = penulis;
        this.stok = stok;
    }

    // 3. Method untuk menampilkan detail buku (Perilaku Objek)
    public void tampilkanInfo() {
        System.out.printf("%-6s | %-25s | %-20s | %-5d\n", 
                idBuku, judul, penulis, stok);
    }
}