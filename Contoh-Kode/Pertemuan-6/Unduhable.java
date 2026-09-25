// ===========================================================
// Topik: Abstraction (Interface)
// Letakkan file ini pada src/model/Unduhable.java
// ===========================================================

package model;

// Interface kedua, kontrak yang berbeda dari Pinjamable.
// Menunjukkan bahwa tiap subclass boleh punya "kemampuan" (interface)
// yang berbeda-beda sesuai kebutuhannya masing-masing.
public interface Unduhable {
    void unduh();
}
