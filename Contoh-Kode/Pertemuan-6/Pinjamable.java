// ===========================================================
// Topik: Abstraction
// Letakkan file ini pada src/model/Pinjamable.java
// ===========================================================

package model;

public interface Pinjamable {
    // Kontrak fungsi murni yang wajib diimplementasikan oleh kelas turunan
    void pinjam();
    void kembalikan();
}