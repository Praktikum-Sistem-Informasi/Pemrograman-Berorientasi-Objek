// ===========================================================
// Topik: Package, Class, Object
// Letakkan file ini pada src/model/Buku.java
// ===========================================================

package model;

public class Buku {
    String idBuku;
    String judul;
    String penulis;
    int tahunTerbit;
    int stok;
    
    public Buku(String idBuku, String judul, String penulis, int tahunTerbit, int stok) {
        this.idBuku = idBuku;
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
        this.stok = stok;
    }

    public void tampilkanInfo() {
        System.out.println("-------------------------------");
        System.out.println("ID Buku      : " + this.idBuku);
        System.out.println("Judul        : " + this.judul);
        System.out.println("Penulis      : " + this.penulis);
        System.out.println("Tahun Terbit : " + this.tahunTerbit);
        System.out.println("Stok         : " + this.stok);
        System.out.println("-------------------------------");
    }
}
