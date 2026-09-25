// ===========================================================
// Topik: Abstraction
// Letakkan file ini pada src/model/EBook.java
// ===========================================================

package model;

// 'extends Buku' -> tetap mewarisi.
// 'implements Unduhable' -> EBook berjanji memenuhi kontrak Unduhable,
// karena format digital memang bisa diunduh (beda dengan BukuCetak yang
// bisa DIPINJAM, bukan diunduh).
public class EBook extends Buku implements Unduhable {

    private double ukuranFileMB;
    private String formatFile;

    public EBook(String idBuku, String judul, String penulis, int tahunTerbit,
                 double ukuranFileMB, String formatFile) {
        super(idBuku, judul, penulis, tahunTerbit);
        setUkuranFileMB(ukuranFileMB);
        setFormatFile(formatFile);
    }

    // ----- Getter & Setter -----

    public double getUkuranFileMB() {
        return ukuranFileMB;
    }

    public void setUkuranFileMB(double ukuranFileMB) {
        if (ukuranFileMB > 0) {
            this.ukuranFileMB = ukuranFileMB;
        } else {
            System.out.println(">> ERROR: Ukuran file harus lebih dari 0!");
            this.ukuranFileMB = 0.1;
        }
    }

    public String getFormatFile() {
        return formatFile;
    }

    public void setFormatFile(String formatFile) {
        if (formatFile != null && !formatFile.trim().isEmpty()) {
            this.formatFile = formatFile;
        } else {
            System.out.println(">> ERROR: Format file tidak boleh kosong!");
        }
    }

    // ----- WAJIB: implementasi abstract method milik Buku -----
    @Override
    public void tampilkanInfo() {
        System.out.println("------------------------------------------");
        System.out.println("[KATEGORI: E-BOOK]");
        cetakDataDasar(); // method konkrit yang dipinjam dari Buku
        System.out.println("Ukuran File  : " + ukuranFileMB + " MB");
        System.out.println("Format File  : " + formatFile);
        cetakStatusAset();
        System.out.println("------------------------------------------");
    }

    // ----- WAJIB: implementasi interface Unduhable -----
    @Override
    public void unduh() {
        System.out.println(">> SUCCESS: EBook '" + judul + "' (" + formatFile
                + ", " + ukuranFileMB + " MB) berhasil diunduh.");
    }
}
