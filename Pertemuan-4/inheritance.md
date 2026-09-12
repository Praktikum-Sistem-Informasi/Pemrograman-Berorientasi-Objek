![Header](../assets/Header.png)

# Topik 6 - Inheritance

---

## 🎯 Tujuan Pembelajaran

Setelah mengikuti pertemuan ini, Anda diharapkan mampu:

1. ✅ Memahami konsep pewarisan (*Inheritance*), hirarki kelas, dan hubungan *IS-A* dalam PBO.
2. ✅ Mengimplementasikan kata kunci `extends` untuk membina kelas induk (*Superclass*) dan kelas anak (*Subclass*).
3. ✅ Menggunakan kata kunci `super` untuk memanggil konstruktor, method, dan atribut milik kelas induk.
4. ✅ Memahami fungsi dan dampak kata kunci `final` pada variabel, method, dan kelas.
5. ✅ Menerapkan hak akses `protected` untuk pembagian atribut pada kelas turunan.

---

## 🔑 KATA KUNCI UTAMA (KEY WORDS)

Pada materi ini, terdapat 3 kata kunci utama yang wajib Anda pahami fungsi dan dampaknya:

* **`extends`** : Kata kunci untuk membina hubungan pewarisan antara kelas anak (*Subclass*) dan kelas induk (*Superclass*).
* **`super`**   : Variabel referensi khusus untuk memanggil *constructor* (`super()`) atau mengakses method/atribut milik kelas induk (`super.method()`).
* **`final`**   : Pengunci sifat absolut. Digunakan agar nilai variabel tidak bisa diubah, method tidak bisa di-*override*, atau kelas tidak bisa diwarisi.

---

## 📂 RESOURCES

> 💡 **File demo tersedia di folder `Contoh-Kode/Pertemuan-4`**

| File | Deskripsi |
| :--- | :--- |
| `Buku.java` | *Superclass* (Kelas Induk) penyedia atribut dan method umum |
| `BukuCetak.java` | *Subclass 1* turunan dari `Buku` untuk media fisik |
| `EBook.java` | *Subclass 2* turunan dari `Buku` untuk media digital |
| `MainApp.java` | Kelas utama untuk pengujian hubungan *IS-A* |

---

## 📋 PERSIAPAN SEBELUM MEMULAI

- [ ] Apache NetBeans IDE / IDE pilihan sudah terbuka.
- [ ] JDK terkonfigurasi dengan benar.
- [ ] Memahami konsep *Access Modifier* (`private`, `public`, `protected`) dan *Encapsulation* dari Pertemuan 3.

---

## 🚀 PART 1: Pemahaman Konsep

```text
          ┌─────────────────────────┐
          │     Buku (Superclass)   │  ← Induk (Atribut Umum: idBuku, judul, penulis, tahunTerbit)
          └────────────┬────────────┘
                       │
         ┌─────────────┴─────────────┐
         │ (extends)                 │ (extends)
┌────────┴────────┐         ┌────────┴────────┐
│BukuCetak(Subclass)│         │ EBook(Subclass) │  ← Anak (Atribut Spesifik)
└─────────────────┘         └─────────────────┘

```

> 📌 **ANALOGI DUNIA NYATA:**
> * **Buku** adalah cetakan umum. **BukuCetak** *IS-A* (adalah sebuah) **Buku**. **EBook** *IS-A* (adalah sebuah) **Buku**.
> * BukuCetak dan EBook tidak perlu membuat ulang atribut `idBuku`, `judul`, `penulis`, atau `tahunTerbit` dari nol. Mereka cukup **mewarisi** sifat dari kelas `Buku`.
> 
> 

---

### 1. Apa itu Inheritance (Pewarisan)?

*Inheritance* adalah mekanisme di mana sebuah kelas (*Subclass*) menerima/mewarisi atribut (*field*) dan perilaku (*method*) dari kelas lain (*Superclass*).

* **Hubungan *IS-A*:** Merupakan syarat mutlak pewarisan. Contoh: `BukuCetak` *IS-A* `Buku` (Buku Cetak adalah sebuah Buku) atau `Mobil` *IS-A* `Kendaraan`.
* **Single Inheritance di Java:** Java **tidak mendukung** *Multiple Inheritance* menggunakan kelas biasa (satu kelas anak tidak bisa `extends` ke dua kelas induk sekaligus) untuk menghindari konflik kode (*Diamond Problem*).
* **Hak Akses `protected`:** Atribut bertipe `protected` pada kelas induk dapat diakses langsung oleh semua kelas anak (*subclass*) maupun kelas lain di package yang sama, namun tertutup bagi kelas luar di beda package.

---

### 2. Mengapa Inheritance Penting?

* **Fondasi Utama PBO:** Merupakan salah satu pilar inti PBO yang menjadi syarat wajib untuk memahami `Polymorphism` dan `Abstraction`.
* **Efisiensi Kode:** Mencegah duplikasi kode. Atribut dan method umum cukup ditulis sekali di Superclass dan langsung digunakan oleh seluruh `Subclass`.
* **Kemudahan Perawatan (Maintainability):** Jika ada perubahan logika umum, Anda cukup memperbarui kelas induknya saja tanpa perlu mengubah puluhan kelas anak satu per satu.

---

### 3. Pendalaman Kata Kunci `super`

Kata kunci `super` adalah variabel referensi yang digunakan untuk merujuk langsung ke objek dari **Kelas Induk (*Superclass*)**. Ada dua kegunaan utama `super`:

1. **`super(...)` — Memanggil Constructor Induk:**
* Digunakan di dalam *constructor subclass* untuk meneruskan data ke *constructor superclass*.
* **Aturan Mutlak:** Pemanggilan `super(...)` **WAJIB** diletakkan di **baris pertama** di dalam *constructor subclass*.


2. **`super.method()` atau `super.atribut` — Mengakses Anggota Induk:**
* Digunakan untuk memanggil *method* atau *atribut* milik induk yang tertutup/berbenturan nama dengan anggota di kelas anak.



---

### 4. Pendalaman Kata Kunci `final`

Kata kunci `final` digunakan untuk membatasi pewarisan dan modifikasi. `final` dapat diterapkan pada 3 tingkatan:

| Penerapan `final` | Fungsi / Dampak |
| --- | --- |
| **`final` Variable** | Nilainya menjadi konstanta (tidak dapat diubah setelah diinisialisasi). |
| **`final` Method** | Method tersebut **tidak dapat di-override** (didefinisikan ulang) oleh kelas anak. |
| **`final` Class** | Kelas tersebut **tidak dapat diwarisi** (`extends`) oleh kelas mana pun. |

```java
// Contoh Final Class (Tidak bisa diturunkan lagi)
public final class PerpustakaanPusat {
    // ...
}

// Error kompilasi jika dicoba:
// public class CabangPerpustakaan extends PerpustakaanPusat {} // ERROR!

```

---

## 💻 PART 2: Live Coding

### Step 1: Membuat Superclass (`src/model/Buku.java`)

```java
package model;

public class Buku {
    // Protected: dapat diakses langsung oleh kelas turunan (subclass)
    protected String idBuku;
    protected String judul;
    protected String penulis;
    protected int tahunTerbit;

    // Constructor Superclass
    public Buku(String idBuku, String judul, String penulis, int tahunTerbit) {
        this.idBuku = idBuku;
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
    }

    // Method umum (dapat dipanggil subclass via super.tampilkanInfo())
    public void tampilkanInfo() {
        System.out.printf("ID: %-6s | Judul: %-25s | Penulis: %-15s | Tahun: %-4d ", 
                idBuku, judul, penulis, tahunTerbit);
    }

    // Example final method: method ini tidak boleh di-override oleh kelas anak mana pun
    public final void cetakStatusAset() {
        System.out.println("Item ini merupakan koleksi resmi Perpustakaan.");
    }

    // Getter & Setter
    public String getIdBuku() { return idBuku; }
    public String getJudul() { return judul; }
    public String getPenulis() { return penulis; }
    public int getTahunTerbit() { return tahunTerbit; }
}

```

---

### Step 2: Membuat Subclass 1 (`src/model/BukuCetak.java`)

```java
package model;

// BukuCetak IS-A Buku
public class BukuCetak extends Buku {
    // Atribut spesifik khusus Buku Cetak
    private int jumlahHalaman;
    private String lokasiRak;

    // Constructor Subclass
    public BukuCetak(String idBuku, String judul, String penulis, int tahunTerbit, int jumlahHalaman, String lokasiRak) {
        // super(...) WAJIB di baris pertama untuk menginstansiasi induk
        super(idBuku, judul, penulis, tahunTerbit); 
        this.jumlahHalaman = jumlahHalaman;
        this.lokasiRak = lokasiRak;
    }

    public int getJumlahHalaman() { return jumlahHalaman; }
    public String getLokasiRak() { return lokasiRak; }

    // Method spesifik memanfaatkan super.tampilkanInfo()
    public void tampilkanInfoBukuCetak() {
        super.tampilkanInfo(); // Memanggil method milik Superclass (Buku)
        System.out.printf("| Halaman: %-3d | Rak: %-6s\n", jumlahHalaman, lokasiRak);
    }
}

```

---

### Step 3: Membuat Subclass 2 (`src/model/EBook.java`)

```java
package model;

// EBook IS-A Buku
public class EBook extends Buku {
    // Atribut spesifik khusus EBook
    private double ukuranFileMB;
    private String formatFile;

    // Constructor Subclass
    public EBook(String idBuku, String judul, String penulis, int tahunTerbit, double ukuranFileMB, String formatFile) {
        // super(...) WAJIB di baris pertama untuk menginstansiasi induk
        super(idBuku, judul, penulis, tahunTerbit); 
        this.ukuranFileMB = ukuranFileMB;
        this.formatFile = formatFile;
    }

    public double getUkuranFileMB() { return ukuranFileMB; }
    public String getFormatFile() { return formatFile; }

    // Method spesifik memanfaatkan super.tampilkanInfo()
    public void tampilkanInfoEBook() {
        super.tampilkanInfo(); // Memanggil method milik Superclass (Buku)
        System.out.printf("| Size: %-4.1f MB | Format: %-4s\n", ukuranFileMB, formatFile);
    }
}

```

---

### Step 4: Menjalankan Kelas Utama (`src/main/MainApp.java`)

```java
package main;

import model.BukuCetak;
import model.EBook;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("        PERTEMUAN 4: INHERITANCE (PEWARISAN)     ");
        System.out.println("=================================================\n");

        // 1. Instansiasi Objek BukuCetak (Subclass 1)
        BukuCetak buku1 = new BukuCetak("BC001", "Pemrograman Java", "James Gosling", 2023, 450, "Rak A1");

        // 2. Instansiasi Objek EBook (Subclass 2)
        EBook ebook1 = new EBook("EB001", "Struktur Data Java", "Robert Lafore", 2024, 12.5, "PDF");

        System.out.println("--- DAFTAR BUKU PERPUSTAKAAN ---");
        
        // Menampilkan Info Buku Cetak
        buku1.tampilkanInfoBukuCetak();

        // Menampilkan Info EBook
        ebook1.tampilkanInfoEBook();

        // Pembuktian Hubungan IS-A & Pemanggilan Final Method
        System.out.println("\n--- PEMBUKTIAN REUSABILITAS & FINAL METHOD ---");
        System.out.println("Judul Buku Cetak (via getJudul Superclass) : " + buku1.getJudul());
        System.out.println("Penulis EBook    (via getPenulis Superclass): " + ebook1.getPenulis());
        buku1.cetakStatusAset(); // Memanggil final method dari Superclass
    }
}

```

---

## ⚡ PART 3: EKSPERIMEN ERROR

### 🎯 Eksperimen 1: Memindahkan Posisi `super()`

**Tindakan:** Pada `BukuCetak.java`, pindahkan baris `super(idBuku, judul, penulis, tahunTerbit);` ke bawah setelah `this.jumlahHalaman = jumlahHalaman;`.

```java
public BukuCetak(String idBuku, String judul, String penulis, int tahunTerbit, int jumlahHalaman, String lokasiRak) {
    this.jumlahHalaman = jumlahHalaman;
    super(idBuku, judul, penulis, tahunTerbit); // Pindah ke baris kedua
    this.lokasiRak = lokasiRak;
}

```

* **Hasil:** Error Kompilasi (`call to super must be first statement in constructor`).
* **Pelajaran:** Induk harus diinisialisasi terlebih dahulu sebelum kelas anak dikonstruksi.

---

### 🎯 Eksperimen 2: Mencoba Meng-extends Final Class

**Tindakan:** Buat `public final class Ensiklopedia` lalu buat `public class Komik extends Ensiklopedia`.

* **Hasil:** Error Kompilasi (`cannot inherit from final model.Ensiklopedia`).
* **Pelajaran:** Class bertipe `final` bersifat absolut dan tidak bisa memiliki subclass.

---

## 🚨 TROUBLESHOOTING RINGKAS

| Pesan Error | Penyebab | Solusi |
| --- | --- | --- |
| `call to super must be first statement...` | Pemanggilan `super()` berada di bawah baris perintah lain pada *constructor*. | Pindahkan `super(...)` ke **baris paling atas** di dalam *constructor subclass*. |
| `cannot inherit from final ...` | Mencoba melakukan `extends` ke kelas bertipe `final`. | Hapus kata kunci `final` dari kelas induk jika kelas tersebut memang dirancang untuk diturunkan. |

---

## ❓ FREQUENTLY ASKED QUESTIONS (FAQ)

**Q: Kapan sebaiknya saya memakai `protected` dibanding `private` pada kelas induk?**

> **A:** Gunakan `protected` jika Anda ingin variabel/method tersebut bisa langsung dibaca dan diubah oleh *subclass* (kelas anak) di package mana pun, tetapi tetap tertutup untuk kelas umum luar. Jika variabel tersebut sensitif dan butuh validasi ketat, tetap gunakan `private` lalu sediakan method `getter/setter`.

**Q: Mengapa panggilan `super(...)` di konstruktor anak wajib berada di baris pertama?**

> **A:** Karena secara hirarki, wujud cetakan induk (*Superclass*) harus terbentuk utuh di memori komputer terlebih dahulu sebelum kelas anak (*Subclass*) menambahkan spesifikasi atribut/method baru di atasnya.

**Q: Apakah satu kelas anak di Java bisa menggunakan `extends` ke dua kelas induk sekaligus (Multiple Inheritance)?**

> **A:** Tidak bisa. Java tidak mendukung *Multiple Inheritance* menggunakan kelas biasa demi menghindari konflik kode (*Diamond Problem*). Satu kelas anak hanya boleh meng-`extends` tepat **satu** kelas induk.

**Q: Apa akibatnya jika kita menambahkan kata kunci `final` pada suatu method di Superclass?**

> **A:** Method bertipe `final` dapat diwarisi dan dipanggil oleh kelas anak, tetapi **tidak dapat di-override** (didefinisikan ulang) oleh kelas anak tersebut.

---

## Daftar Referensi

[1] W3Schools, "Java Inheritance (Subclass and Superclass)". Tersedia di: [tautan](https://www.w3schools.com/java/java_inheritance.asp)

[2] Petani Kode, "Belajar Java OOP: Memahami Konsep Hak Waris (Inheritance)". Tersedia di: [tautan](https://www.petanikode.com/java-oop-inheritance/)

---

## 🏆 CHALLENGE PRAKTIKAN

1. Buat program sesuai instruksi berikut:
a) Buat class **`Buku`** sebagai superclass yang menyimpan atribut `idBuku`, `judul`, `penulis`, dan `tahunTerbit`.
b) Buat subclass **`BukuAudio`** yang mewarisi **`Buku`**, lalu tambahkan atribut spesifik `durasiMenit` dan `narator`.
c) Buat objek **`BukuAudio`** pada `main()` dan tampilkan seluruh data bukunya.
2. Buat program sesuai instruksi berikut:
a) Buat final class **`JurnalIlmiah`** yang berisi method `tampilkanLisensi()`.
b) Coba buat subclass **`JurnalInternal`** yang mencoba `extends JurnalIlmiah`.
c) Amati dan jelaskan mengapa class **`JurnalIlmiah`** tidak bisa diwarisi.
3. Buat program sesuai instruksi berikut:
a) Buat class **`AnggotaPerpustakaan`** dengan constructor yang menerima `String nama`, serta method `sapaan()` untuk menampilkan nama anggota.
b) Buat subclass **`Mahasiswa`** dengan constructor yang memanggil `super(nama)`, lalu tambahkan atribut `nim` dan method `pinjamBuku()`.
c) Buat objek **`Mahasiswa`** di `main()` dan jalankan semua methodnya.
