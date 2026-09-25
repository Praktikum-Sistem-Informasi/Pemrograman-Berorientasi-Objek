// ===========================================================
// Topik: Abstraction (Interface)
// Letakkan file ini pada src/model/Pinjamable.java
// ===========================================================

package model;

// Interface = KONTRAK. Kelas apa pun yang 'implements' Pinjamable
// WAJIB menyediakan isi (implementasi) untuk semua method di bawah ini.
// Cocok untuk kemampuan (behaviour) yang HANYA dimiliki sebagian
// entitas (di sini: hanya buku fisik yang bisa dipinjam).
public interface Pinjamable {
    void pinjam();
    void kembalikan();
}
