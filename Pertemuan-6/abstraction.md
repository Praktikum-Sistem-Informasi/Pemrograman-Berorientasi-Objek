![Header](../assets/Header.png)

# Topik 8 - Abstraction

---

## 🎯 Tujuan Pembelajaran

Setelah mengikuti pertemuan ini, Anda diharapkan mampu:

1. Memahami konsep abstraksi (*Abstraction*) dalam Pemrograman Berorientasi Objek.
2. Membedakan rancangan program (*what to do*) dengan detail implementasi (*how to do*).
3. Menggunakan `abstract class` dan `abstract method` sebagai kerangka identitas umum bagi kelas turunan.
4. Menggunakan `interface` dan kata kunci `implements` sebagai kontrak kemampuan lintas objek.
5. Membuat standar atau kerangka aplikasi (kontrak) yang konsisten sebelum kode dikembangkan lebih lanjut.

---

## 🔑 KATA KUNCI UTAMA (KEY WORDS)

* **`abstract`** : Penanda class atau method sebagai bagian dari rancangan yang belum memiliki implementasi lengkap.
* **`abstract class`** : Kelas induk yang tidak bisa dibuat objeknya (instansiasi) secara langsung; berfungsi sebagai DNA/kerangka dasar.
* **`abstract method`** : Method tanpa isi yang memaksa (*force*) kelas turunannya untuk membuat implementasi spesifik.
* **`interface`** : Murni sebuah kontrak standar fungsionalitas; mewajibkan class yang memakainya untuk memiliki kemampuan tertentu.
* **`implements`** : Kata kunci untuk menyetujui dan menjalankan kontrak dari sebuah antarmuka (*interface*).

---

## 📂 RESOURCES (SUMBER KODE DEMO)

> 💡 **File demo tersedia di `Contoh-Kode/Pertemuan-6/`**

| **File** | **Deskripsi** |
|---|---|
| `Pinjamable.java` | Interface (Kontrak kemampuan peminjaman) |
| `Unduhable.java` | Interface (Kontrak kemampuan pengunduhan) |
| `Buku.java` | Abstract Class (Kerangka identitas dasar buku) |
| `BukuCetak.java` | Subclass dari `Buku`, mengimplementasikan `Pinjamable` |
| `EBook.java` | Subclass dari `Buku`, mengimplementasikan `Unduhable` |
| `BukuController.java` | Logika pengelolaan data dan demonstrasi polimorfisme/interface |
| `BukuView.java` | Antarmuka pengguna (I/O CLI) |
| `MainApp.java` | Entry point program (Penghubung MVC) |

---

## 📋 PERSIAPAN SEBELUM MEMULAI

Sebelum memulai materi ini, pastikan Anda sudah memahami dasar-dasar pemrograman Java dari materi sebelumnya, terutama:

- [ ] Apache NetBeans IDE / IDE pilihan sudah terbuka dan JDK terkonfigurasi dengan benar.
- [ ] Memahami konsep *Class*, *Object*, dan *Access Modifier*.
- [ ] Memahami konsep *Inheritance* (Pewarisan) menggunakan kata kunci *extends*, `super`, dan `final`, seperti pada `Buku`, `BukuCetak`, dan `EBook` di Pertemuan 5.
- [ ] Memahami *Method Overriding* dan *Method Overloading*.
- [ ] Memahami dasar *Polymorphism*.
- [ ] Memahami aturan *Package* dan *Import*, karena proyek ini menggunakan struktur multi-folder (MVC).

---

## 🚀 PART 1: Pemahaman Konsep

```
                  ┌──────────────────────────────┐
                  │    Buku (Abstract Class)     │
                  └──────────────┬───────────────┘
                                 │ (extends)
         ┌───────────────────────┴───────────────────────┐
         │                                               │
┌────────┴────────┐                             ┌────────┴────────┐
│  Objek BukuCetak │                             │   Objek EBook   │
└────────┬────────┘                             └────────┬────────┘
         │ (implements)                                  │ (implements)
┌────────┴────────┐                             ┌────────┴────────┐
│    Pinjamable   │                             │    Unduhable    │
│   (Interface)   │                             │   (Interface)   │
└─────────────────┘                             └─────────────────┘

```

> 📌 **ANALOGI DUNIA NYATA:**
> * **Abstract Class** ibarat Identitas Absolut (*"Adalah sebuah..."*). `BukuCetak` *adalah sebuah* Buku. `EBook` *adalah sebuah* Buku. Keduanya mewarisi DNA dan atribut dasar yang sama (punya Judul, Penulis, Tahun Terbit).
> * **Interface** ibarat Kontrak Kemampuan (*"Bisa melakukan..."*). `BukuCetak` *bisa dipinjam* (`Pinjamable`), sedangkan `EBook` *bisa diunduh* (`Unduhable`) — dua kemampuan yang sama sekali berbeda, meski keduanya sama-sama "Buku". Di masa depan, perpustakaan bisa saja meminjamkan `Payung`. `Payung` bukan bacaan (beda DNA), tapi bisa saja diberi kemampuan `Pinjamable` yang sama.
> 
> 

---

### 1. Apa itu Abstraction (Abstraksi)?

Abstraksi adalah teknik dalam Pemrograman Berorientasi Objek untuk menyembunyikan detail implementasi yang rumit dan hanya menampilkan fungsionalitas esensial kepada pengguna. Abstraksi memisahkan antara rancangan aturan (**WHAT TO DO**) dengan detail pengerjaannya (**HOW TO DO**).

* **Abstract Class vs Interface:**

| Karakteristik | Abstract Class | Interface |
| --- | --- | --- |
| **Fokus Utama** | Kerangka dasar untuk objek beridentitas sama. | Standar kemampuan untuk lintas objek. |
| **Atribut/Variabel** | Bisa menyimpan *state* (variabel biasa). | Hanya bisa menyimpan konstanta (`public static final`). |
| **Method** | Bisa berisi method biasa & *abstract method*. | Murni berisi *abstract method* (kontrak kosong). |
| **Pewarisan** | Menggunakan `extends` (Maksimal 1 Induk). | Menggunakan `implements` (Bisa banyak antarmuka). |

---

### 2. Mengapa Abstraction Penting?

* **Standardisasi Kode:** Memaksa programmer (khususnya jika bekerja dalam tim) untuk mengikuti rancangan metode yang sudah ditetapkan oleh arsitek perangkat lunak.
* **Mencegah Instansiasi yang Tidak Masuk Akal:** Mencegah pembuatan objek dari kelas yang sifatnya masih terlalu umum (misal: Anda tidak bisa membuat wujud fisik dari sekadar "Buku" yang abstrak, harus spesifik "BukuCetak" atau "EBook").
* **Polimorfisme Tingkat Lanjut:** Memungkinkan sistem memproses berbagai objek yang sama sekali tidak memiliki hubungan darah/genetik, asalkan mereka menandatangani kontrak *Interface* yang sama.

---

### 3. Pendalaman Abstract Class & Method

`abstract class` digunakan ketika beberapa kelas memiliki data atau perilaku umum, tetapi kelas tersebut belum sempurna untuk dijadikan sebuah objek utuh.

1. **Aturan Instansiasi:** Kelas abstrak **tidak bisa** dibuat menjadi objek menggunakan keyword `new`.
2. **Kewajiban Subclass:** Jika sebuah `abstract class` memiliki `abstract method` (method tanpa `{ }`), maka kelas anaknya **wajib** mendefinisikan ulang (meng-*override*) method tersebut. Jika menolak, kelas anak harus ikut dijadikan *abstract*.
3. **Boleh Tetap Punya Method Konkrit:** Selain *abstract method*, sebuah `abstract class` boleh tetap memiliki method biasa yang sudah lengkap isinya — berguna untuk logika yang memang sama di semua kelas anak (contoh: `cetakDataDasar()` di `Buku.java`).

```java
// Contoh deklarasi
public abstract class Buku {
    // Method konkrit: logika sudah lengkap, dipakai bersama semua anak
    protected void cetakDataDasar() {
        System.out.println("Judul: " + judul);
    }

    // Abstract method: memaksa anak membuat isinya sendiri
    public abstract void tampilkanInfo(); 
}

```

---

### 4. Pendalaman Interface

`interface` adalah bentuk abstraksi paling murni. Ia bukan sebuah kelas, melainkan sebuah kontrak perjanjian.

1. **Semua Bebas, Semua Wajib:** Kelas yang menandatangani kontrak (`implements`) diwajibkan menyediakan implementasi untuk **seluruh** method yang tercantum pada *Interface* tersebut.
2. **Variabel sebagai Konstanta Mutlak:** Jika Anda mendeklarasikan variabel di dalam *Interface*, Java secara implisit menganggapnya sebagai `public static final`. Nilainya tidak bisa diubah (*immutable*).
3. **Satu Kelas, Banyak Interface Berbeda:** `BukuCetak` menandatangani kontrak `Pinjamable`, sedangkan `EBook` menandatangani kontrak `Unduhable` yang sama sekali berbeda — inilah kelenturan *interface* yang tidak dimiliki *abstract class* (yang cuma boleh satu induk).

```java
// Contoh deklarasi kontrak
public interface Pinjamable {
    void pinjam();
    void kembalikan();
}

public interface Unduhable {
    void unduh();
}

```

---

### 5. Memadukan Pewarisan (Extends) dan Kontrak (Implements)

Dalam Java, satu kelas **hanya boleh** memiliki satu *Superclass* (Single Inheritance), namun **boleh** menandatangani banyak kontrak *Interface* sekaligus.

Kata kunci `extends` selalu ditulis mendahului `implements`.

```java
public class BukuCetak extends Buku implements Pinjamable {
    // Mewarisi atribut dari Buku
    // Wajib meng-override tampilkanInfo() dari Buku
    // Wajib meng-override pinjam() dan kembalikan() dari Pinjamable
}

```

---

## 💻 PART 2: Live Coding

### Step 1: Membuat Kontrak Kemampuan (Interface)

Buat file **`src/model/Pinjamable.java`** dan **`src/model/Unduhable.java`**. Dua interface ini bertindak sebagai standar fungsionalitas: satu untuk benda yang bisa dipinjam, satu untuk yang bisa diunduh.

```java
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

```

```java
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

```

---

### Step 2: Membuat Kerangka Dasar (Abstract Class)

Buat file **`src/model/Buku.java`**. Kelas ini bertindak sebagai DNA/Identitas dasar untuk semua jenis buku di perpustakaan — melanjutkan langsung `Buku` dari Pertemuan 5 (lengkap dengan `final`, *encapsulation*, dan *method overloading*-nya), sekarang dijadikan `abstract`.

```java
// ===========================================================
// Topik: Abstraction
// Letakkan file ini pada src/model/Buku.java
// ===========================================================

package model;

// 'abstract' pada class berarti Buku TIDAK BISA di-instansiasi langsung
// (tidak boleh ada "new Buku(...)"). Buku hanya boleh dipakai lewat
// turunannya (BukuCetak, EBook) yang sudah "lengkap".
public abstract class Buku {

    private final String idBuku;

    protected String judul;
    protected String penulis;
    protected int tahunTerbit;

    public Buku(String idBuku, String judul, String penulis, int tahunTerbit) {
        this.idBuku = idBuku;
        setJudul(judul);
        setPenulis(penulis);
        setTahunTerbit(tahunTerbit);
    }

    // ----- Getter & Setter (Encapsulation) -----

    public String getIdBuku() {
        return idBuku;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        if (judul != null && !judul.trim().isEmpty()) {
            this.judul = judul;
        } else {
            System.out.println(">> ERROR: Judul tidak boleh kosong!");
        }
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        if (penulis != null && !penulis.trim().isEmpty()) {
            this.penulis = penulis;
        } else {
            System.out.println(">> ERROR: Penulis tidak boleh kosong!");
        }
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(int tahunTerbit) {
        if (tahunTerbit >= 1900 && tahunTerbit <= 2026) {
            this.tahunTerbit = tahunTerbit;
        } else {
            System.out.println(">> ERROR: Tahun terbit harus antara 1900-2026!");
        }
    }

    // Method KONKRIT biasa (ada isinya): tetap dipakai bersama oleh semua
    // subclass supaya tidak perlu menulis ulang cetak data dasar.
    protected void cetakDataDasar() {
        System.out.println("ID Buku      : " + idBuku);
        System.out.println("Judul        : " + judul);
        System.out.println("Penulis      : " + penulis);
        System.out.println("Tahun Terbit : " + tahunTerbit);
    }

    // ----- ABSTRACT METHOD -----
    // Tidak punya isi/body (diakhiri titik koma). Setiap subclass
    // (BukuCetak, EBook) DIPAKSA membuat implementasinya sendiri,
    // karena tiap jenis buku punya cara tampil yang berbeda.
    public abstract void tampilkanInfo();

    // Overload tetap boleh ada meski versi tanpa parameternya abstract.
    // Saat tampilkanInfo() dipanggil di baris di bawah, Java otomatis
    // menjalankan versi milik objek aslinya (BukuCetak/EBook) -> polymorphism.
    public void tampilkanInfo(boolean ringkas) {
        if (ringkas) {
            System.out.println(judul + " (" + idBuku + ")");
        } else {
            tampilkanInfo();
        }
    }

    // 'final' pada method berarti method ini TIDAK BOLEH diubah
    // perilakunya oleh kelas turunan mana pun.
    public final void cetakStatusAset() {
        System.out.println(">> Status Aset: Terdaftar sebagai koleksi perpustakaan");
    }
}

```

---

### Step 3: Implementasi ("How to Do") pada Kelas Anak

Buat dua subclass di dalam **`src/model/`**, yaitu `BukuCetak.java` dan `EBook.java`.

**A. Subclass BukuCetak (Mewarisi Identitas & Menjalankan Kontrak Pinjamable)**

```java
// ===========================================================
// Topik: Abstraction
// Letakkan file ini pada src/model/BukuCetak.java
// ===========================================================

package model;

// 'extends Buku' -> tetap mewarisi (Inheritance, materi sebelumnya).
// 'implements Pinjamable' -> BukuCetak berjanji memenuhi KONTRAK
// interface Pinjamable, karena buku fisik memang bisa dipinjam.
public class BukuCetak extends Buku implements Pinjamable {

    private int jumlahHalaman;
    private String lokasiRak;

    // Status peminjaman: dibutuhkan supaya pinjam()/kembalikan() punya
    // sesuatu untuk diubah.
    private boolean sedangDipinjam = false;

    public BukuCetak(String idBuku, String judul, String penulis, int tahunTerbit,
                      int jumlahHalaman, String lokasiRak) {
        super(idBuku, judul, penulis, tahunTerbit);
        setJumlahHalaman(jumlahHalaman);
        setLokasiRak(lokasiRak);
    }

    // ----- Getter & Setter -----

    public int getJumlahHalaman() {
        return jumlahHalaman;
    }

    public void setJumlahHalaman(int jumlahHalaman) {
        if (jumlahHalaman > 0) {
            this.jumlahHalaman = jumlahHalaman;
        } else {
            System.out.println(">> ERROR: Jumlah halaman harus lebih dari 0!");
            this.jumlahHalaman = 1;
        }
    }

    public String getLokasiRak() {
        return lokasiRak;
    }

    public void setLokasiRak(String lokasiRak) {
        if (lokasiRak != null && !lokasiRak.trim().isEmpty()) {
            this.lokasiRak = lokasiRak;
        } else {
            System.out.println(">> ERROR: Lokasi rak tidak boleh kosong!");
        }
    }

    // ----- WAJIB: implementasi abstract method milik Buku -----
    @Override
    public void tampilkanInfo() {
        System.out.println("------------------------------------------");
        System.out.println("[KATEGORI: BUKU CETAK]");
        cetakDataDasar(); // method konkrit yang dipinjam dari Buku
        System.out.println("Jml Halaman  : " + jumlahHalaman + " hlm");
        System.out.println("Lokasi Rak   : " + lokasiRak);
        cetakStatusAset();
        System.out.println("------------------------------------------");
    }

    // ----- WAJIB: implementasi interface Pinjamable -----
    @Override
    public void pinjam() {
        if (!sedangDipinjam) {
            sedangDipinjam = true;
            System.out.println(">> SUCCESS: Buku '" + judul + "' berhasil dipinjam.");
        } else {
            System.out.println(">> ERROR: Buku '" + judul + "' sedang dipinjam orang lain!");
        }
    }

    @Override
    public void kembalikan() {
        if (sedangDipinjam) {
            sedangDipinjam = false;
            System.out.println(">> SUCCESS: Buku '" + judul + "' telah dikembalikan.");
        } else {
            System.out.println(">> INFO: Buku '" + judul + "' memang belum dipinjam.");
        }
    }
}

```

**B. Subclass EBook (Mewarisi Identitas & Menjalankan Kontrak Unduhable)**

```java
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

```

> 📌 **Catatan:** `BukuCetak` cuma implement `Pinjamable`, dan `EBook` cuma implement `Unduhable` — masing-masing punya kontrak yang berbeda, meski sama-sama turunan `Buku`.

---

### Step 4: Menangani Logika Polimorfik (Controller)

Buat file **`src/controller/BukuController.java`**. Perhatikan metode `prosesPinjamBuku()` dan `prosesUnduhBuku()` yang mendemonstrasikan kekuatan *Interface* untuk masing-masing kontrak.

```java
package controller;

import model.Buku;
import model.BukuCetak;
import model.EBook;
import model.Pinjamable;
import model.Unduhable;
import java.util.ArrayList;

public class BukuController {
    private ArrayList<Buku> listBuku = new ArrayList<>();

    public BukuController() {
        // Dummy Data Awal (constructor sama persis dengan Buku/BukuCetak/EBook)
        listBuku.add(new BukuCetak("BC001", "Pemrograman Java", "James Gosling", 2023, 350, "Rak A-1"));
        listBuku.add(new EBook("EB001", "Belajar Python Otodidak", "Guido van Rossum", 2024, 12.5, "PDF"));
    }

    public ArrayList<Buku> getAllBuku() {
        return listBuku;
    }

    public void tambahBuku(Buku b) {
        listBuku.add(b);
    }

    public Buku cariById(String id) {
        for (Buku b : listBuku) {
            if (b.getIdBuku().equalsIgnoreCase(id)) {
                return b;
            }
        }
        return null;
    }

    public void prosesPinjamBuku(String id) {
        Buku b = cariById(id);
        if (b == null) {
            System.out.println(">> ERROR: ID Buku tidak ditemukan!");
        } else if (b instanceof Pinjamable) {
            // Downcasting aman untuk mengakses kemampuan dari Interface
            ((Pinjamable) b).pinjam();
        } else {
            System.out.println(">> ERROR: Buku jenis ini (" + b.getClass().getSimpleName() + ") TIDAK BISA dipinjam!");
        }
    }

    public void prosesUnduhBuku(String id) {
        Buku b = cariById(id);
        if (b == null) {
            System.out.println(">> ERROR: ID Buku tidak ditemukan!");
        } else if (b instanceof Unduhable) {
            ((Unduhable) b).unduh();
        } else {
            System.out.println(">> ERROR: Buku jenis ini (" + b.getClass().getSimpleName() + ") TIDAK BISA diunduh!");
        }
    }
}

```

---

### Step 5: Menjalankan Aplikasi (View & Main)

Buat antarmuka dan *entry point* program di *package* masing-masing.

**A. Antarmuka (View) - `src/view/BukuView.java`**

```java
package view;

import controller.BukuController;
import model.Buku;
import model.BukuCetak;
import model.EBook;
import java.util.Scanner;

public class BukuView {
    private BukuController controller;
    private Scanner scanner;

    public BukuView(BukuController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void renderMenu() {
        boolean berjalan = true;
        while (berjalan) {
            System.out.println("\n==========================================");
            System.out.println("   SISTEM PERPUSTAKAAN (P6: MVC & ABSTRAKSI)");
            System.out.println("==========================================");
            System.out.println("1. Tampilkan Semua Buku");
            System.out.println("2. Tambah Buku Cetak Baru");
            System.out.println("3. Tambah EBook Baru");
            System.out.println("4. Pinjam Buku (Interface Pinjamable Demo)");
            System.out.println("5. Unduh EBook (Interface Unduhable Demo)");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu (1-6): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("\n--- DAFTAR BUKU PERPUSTAKAAN ---");
                    for (Buku b : controller.getAllBuku()) {
                        b.tampilkanInfo();
                    }
                    break;
                case 2:
                    System.out.println("\n--- TAMBAH BUKU CETAK BARU ---");
                    System.out.print("ID Buku      : "); String id = scanner.nextLine();
                    System.out.print("Judul Buku   : "); String judul = scanner.nextLine();
                    System.out.print("Penulis      : "); String penulis = scanner.nextLine();
                    System.out.print("Tahun Terbit : "); int tahun = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Jml Halaman  : "); int halaman = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Lokasi Rak   : "); String rak = scanner.nextLine();

                    controller.tambahBuku(new BukuCetak(id, judul, penulis, tahun, halaman, rak));
                    System.out.println(">> SUCCESS: Buku cetak berhasil ditambahkan!");
                    break;
                case 3:
                    System.out.println("\n--- TAMBAH EBOOK BARU ---");
                    System.out.print("ID Buku      : "); String idE = scanner.nextLine();
                    System.out.print("Judul Buku   : "); String judulE = scanner.nextLine();
                    System.out.print("Penulis      : "); String penulisE = scanner.nextLine();
                    System.out.print("Tahun Terbit : "); int tahunE = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Ukuran (MB)  : "); double ukuran = scanner.nextDouble(); scanner.nextLine();
                    System.out.print("Format File  : "); String format = scanner.nextLine();

                    controller.tambahBuku(new EBook(idE, judulE, penulisE, tahunE, ukuran, format));
                    System.out.println(">> SUCCESS: EBook berhasil ditambahkan!");
                    break;
                case 4:
                    System.out.println("\n--- PINJAM BUKU ---");
                    System.out.print("Masukkan ID Buku: ");
                    String idPinjam = scanner.nextLine();
                    controller.prosesPinjamBuku(idPinjam);
                    break;
                case 5:
                    System.out.println("\n--- UNDUH EBOOK ---");
                    System.out.print("Masukkan ID Buku: ");
                    String idUnduh = scanner.nextLine();
                    controller.prosesUnduhBuku(idUnduh);
                    break;
                case 6:
                    berjalan = false;
                    System.out.println("\nSesi Selesai.");
                    break;
                default:
                    System.out.println(">> ERROR: Pilihan tidak valid!");
            }
        }
    }
}

```

**B. Entry Point - `src/main/MainApp.java`**

```java
package main;

import controller.BukuController;
import view.BukuView;

public class MainApp {
    public static void main(String[] args) {
        BukuController controller = new BukuController();
        BukuView view = new BukuView(controller);
        view.renderMenu();
    }
}

```

---

## ⚡ PART 3: EKSPERIMEN ERROR

Lakukan pengujian ini secara sengaja untuk melatih kemampuan *debugging* abstraksi.

### 🎯 Eksperimen 1: Instansiasi Paksa Abstract Class

**Tindakan:** Buka `BukuController.java`, pada bagian *constructor*, tambahkan data dengan memaksa pembuatan objek `Buku`.

```java
listBuku.add(new Buku("B00", "Buku Polos", "Anonim", 2026));

```

* **Hasil:** Error kompilasi: `Buku is abstract; cannot be instantiated`.
* **Pelajaran:** Kelas abstrak (kerangka dasar) tidak bisa menjadi benda nyata di memori. Harus diwujudkan lewat turunan (*concrete class*).

---

### 🎯 Eksperimen 2: Menolak Janji Abstract Method

**Tindakan:** Buka file `EBook.java`, berikan komentar `//` pada seluruh baris method `@Override public void tampilkanInfo() { ... }`.

* **Hasil:** Error kompilasi di baris nama kelas: `EBook is not abstract and does not override abstract method tampilkanInfo() in Buku`.
* **Pelajaran:** Turunan dari kelas abstrak terikat hukum wajib militer. Mereka **harus** mengimplementasikan semua *abstract method* yang diturunkan.

---

### 🎯 Eksperimen 3: Miskonsepsi Variabel Interface

**Tindakan:**

1. Buka `Pinjamable.java`, tambahkan atribut baru: `int MAKS_HARI = 7;`
2. Buka `BukuCetak.java`, di dalam method `pinjam()`, coba ubah nilainya: `MAKS_HARI = 10;`

* **Hasil:** Error kompilasi: `cannot assign a value to final variable MAKS_HARI`.
* **Pelajaran:** Berbeda dengan kelas abstrak, semua variabel yang dideklarasikan di dalam sebuah *Interface* selalu dimutlakkan sebagai `public static final` (Konstanta) oleh Java.

---

## 🚨 TROUBLESHOOTING RINGKAS

| Pesan Error | Penyebab | Solusi |
| --- | --- | --- |
| `cannot be instantiated` | Menggunakan keyword `new` pada *Abstract Class* atau *Interface*. | Pastikan instansiasi hanya dilakukan pada *Concrete Class* (`BukuCetak` / `EBook`). |
| `class is not abstract and does not override...` | Kelas turunan lupa / belum mengimplementasikan method abstrak yang dijanjikan. | Tulis ulang method tersebut berserta blok kodenya `{ }` di kelas anak, dan gunakan `@Override`. |
| `method does not override or implement a method...` | Terjadi kesalahan penulisan (*typo*), perbedaan tipe parameter, atau kembalian dari method *Superclass*/*Interface*. | Samakan nama, jumlah, dan tipe data parameter persis seperti yang tertulis di rancangan induk. |
| `cannot assign a value to final variable` | Mencoba memodifikasi/menugaskan nilai baru pada variabel yang berasal dari *Interface*. | Pindahkan atribut tersebut ke *Abstract Class* jika nilainya dirancang untuk bisa berubah (*mutable*). |

---

## ❓ FREQUENTLY ASKED QUESTIONS (FAQ)

**Q: Kapan saya mutlak harus menggunakan Interface daripada Abstract Class?**

> **A:** Ketika Anda ingin memaksa beberapa objek yang **sama sekali tidak memiliki hubungan logis/genetik** untuk memiliki kemampuan yang sama. Misalnya, Anda membuat sistem peringatan alarm. `JamWeker` (Elektronik), `AnjingPenjaga` (Hewan), dan `SensorAsap` (Perangkat Keamanan) secara klasifikasi sama sekali tidak berhubungan. Namun, ketiganya bisa diberi kemampuan `implements Alarm`.

**Q: Bolehkah sebuah kelas anak melakukan `implements` lebih dari satu Interface?**

> **A:** Sangat diperbolehkan, dan ini adalah salah satu keunggulan utama Java. Meskipun satu kelas hanya boleh menginduk (`extends`) pada SATU *abstract class*, ia boleh menandatangani BANYAK kontrak antarmuka (`implements Pinjamable, Unduhable, DapatDidenda, dll`).

**Q: Mengapa *Interface* tidak boleh berisi method yang ada isinya (sebelum Java 8)?**

> **A:** Karena peran murni *Interface* hanyalah sebagai spesifikasi dokumen/kontrak (*What to Do*), bukan instruksi logika eksekusi (*How to Do*). Implementasi selalu diserahkan kepada kelas yang menyetujui kontrak tersebut.

---

## 🔗 Daftar Referensi

[1] Oracle Docs, "Abstract Methods and Classes". Tersedia di: [tautan](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html)

[2] Oracle Docs, "Interfaces in Java". Tersedia di: [tautan](https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html)

[3] W3Schools, "Java Abstraction". Tersedia di: [tautan](https://www.w3schools.com/java/java_abstract.asp)

---

## 🏆 CHALLENGE PRAKTIKAN

**Instruksi:** Jangan menggunakan kerangka proyek di atas. Buatlah proyek Java baru (*Project from scratch*) untuk melatih insting perancangan struktur sistem Anda.

1. **Level Dasar (Membangun Antarmuka)**
Sistem perpustakaan ingin menagih denda, namun yang bisa didenda bukan hanya Buku (bisa jadi Kunci Loker atau Kartu Hilang).
* Buat interface `DapatDidenda` yang memiliki satu *abstract method* `hitungDenda(int hariTerlambat)`.
* Buat kelas konkrit (misal: `KunciLoker`) yang mengimplementasikan interface tersebut.
* Uji hasil perhitungan dendanya di method `main()`.


2. **Level Menengah (Membangun Kerangka Genetik)**
Sistem perpustakaan membutuhkan manajemen pengguna.
* Buat *Abstract Class* `Anggota` yang menyimpan `idAnggota` dan `nama`.
* Tambahkan *abstract method* `int getBatasPinjam()`.
* Buat dua *Subclass*: `Dosen` (batas pinjam 7) dan `Mahasiswa` (batas pinjam 3).
* Instansiasi masing-masing di `main()` dan cetak batas pinjamnya.


3. **Level Lanjut (Arsitektur Polimorfik Ganda)**
Perpustakaan kini berekspansi ke layanan audio.
* Buat interface baru bernama `AksesDigital` dengan method `dengarkanOnline()`.
* Buat kelas baru bernama `AudioBook`.
* Kelas `AudioBook` ini **harus** merupakan turunan (`extends`) dari kelas abstrak `Buku` (gunakan class `Buku` dari contoh modul).
* Kelas `AudioBook` ini juga **harus** mengimplementasikan **dua antarmuka sekaligus**, yaitu `Pinjamable` dan `AksesDigital`.
* Demonstrasikan logika `dengarkanOnline()` dan proses peminjaman *audiobook* berjalan dengan baik di method `main()`.

![Footer](../assets/Footer.png)

<p align="center"><a href="#top">Kembali ke atas</a></p>
