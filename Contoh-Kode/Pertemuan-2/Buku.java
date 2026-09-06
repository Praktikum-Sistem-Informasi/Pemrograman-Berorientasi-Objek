// ===========================================================
// Topik: Package, Class, Object
// Letakkan file ini pada src/model/Buku.java
// ===========================================================

package model;

public class Buku {

    // 1. Atribut (State)
    // Pada tahap ini atribut masih dapat diakses langsung dari luar class
    String idBuku;
    String judul;
    String penulis;
    int tahunTerbit;
    int stok;

    // 2. Constructor
    // Method khusus untuk menginisialisasi objek saat pemanggilan 'new'
    public Buku(String idBuku, String judul, String penulis, int tahunTerbit, int stok) {
        this.idBuku = idBuku;
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
        this.stok = stok;
    }

    // 3. Method untuk menampilkan detail buku
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
