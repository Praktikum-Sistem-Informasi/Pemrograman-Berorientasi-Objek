<img width="1080" height="96" alt="image" src="https://github.com/user-attachments/assets/651a9846-af0c-4643-86df-c39b129057cf" />

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

> 💡 **File demo tersedia di folder `contoh_kode/pertemuan_4`**

| File | Deskripsi |
| :--- | :--- |
| `src/model/Koleksi.java` | *Superclass* (Kelas Induk) penyedia atribut umum |
| `src/model/Buku.java` | *Subclass 1* turunan dari `Koleksi` |
| `src/model/Majalah.java` | *Subclass 2* turunan dari `Koleksi` |
| `src/main/MainApp.java` | Kelas utama untuk pengujian hubungan *IS-A* |

---

## 📋 PERSIAPAN SEBELUM MEMULAI

- [ ] Apache NetBeans IDE / IDE pilihan sudah terbuka.
- [ ] JDK terkonfigurasi dengan benar.
- [ ] Memahami konsep *Access Modifier* (`private`, `public`, `protected`) dan *Encapsulation* dari Pertemuan 3.

---

## 🚀 PART 1: Pemahaman Konsep


```
          ┌─────────────────────────┐
          │  Koleksi (Superclass)   │  ← Induk (Atribut Umum: id, judul, tahun)
          └────────────┬────────────┘
                       │
         ┌─────────────┴─────────────┐
         │ (extends)                 │ (extends)
┌────────┴────────┐         ┌────────┴────────┐
│  Buku (Subclass)│         │Majalah(Subclass)│  ← Anak (Atribut Spesifik)
└─────────────────┘         └─────────────────┘

```

> 📌 **ANALOGI DUNIA NYATA:**
> - **Koleksi** adalah cetakan umum. **Buku** *IS-A* (adalah sebuah) **Koleksi**. **Majalah** *IS-A* (adalah sebuah) **Koleksi**.
> - Buku dan Majalah tidak perlu membuat ulang atribut `idKoleksi`, `judul`, atau `tahunTerbit` dari nol. Mereka cukup **mewarisi** sifat dari kelas `Koleksi`.

---

### 1. Apa itu Inheritance (Pewarisan)?
*Inheritance* adalah mekanisme di mana sebuah kelas (*Subclass*) menerima/mewarisi atribut (*field*) dan perilaku (*method*) dari kelas lain (*Superclass*).

* **Hubungan *IS-A*:** Merupakan syarat mutlak pewarisan. Contoh: `Buku` *IS-A* `Koleksi` (Buku adalah sebuah Koleksi) atau `Mobil` *IS-A* `Kendaraan`.
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
| :--- | :--- |
| **`final` Variable** | Nilainya menjadi konstanta (tidak dapat diubah setelah diinisialisasi). |
| **`final` Method** | Method tersebut **tidak dapat di-override** (didefinisikan ulang) oleh kelas anak. |
| **`final` Class** | Kelas tersebut **tidak dapat diwarisi** (`extends`) oleh kelas mana pun. |

```java
// Contoh Final Class (Tidak bisa diturunkan lagi)
public final class Universe {
    // ...
}

// Error kompilasi jika dicoba:
// public class Galaksi extends Universe {} // ERROR!

```

---

## 💻 PART 2: Live Coding 

### Step 1: Membuat Superclass (`src/model/Koleksi.java`)

```java
package model;

public class Koleksi {
    // Protected: dapat diakses langsung oleh kelas turunan (subclass)
    protected String idKoleksi;
    protected String judul;
    protected int tahunTerbit;

    // Constructor Superclass
    public Koleksi(String idKoleksi, String judul, int tahunTerbit) {
        this.idKoleksi = idKoleksi;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }

    // Method umum (dapat dipanggil subclass via super.tampilkanInfo())
    public void tampilkanInfo() {
        System.out.printf("ID: %-6s | Judul: %-25s | Tahun: %-4d ", 
                idKoleksi, judul, tahunTerbit);
    }

    // Example final method: method ini tidak boleh di-override oleh kelas anak mana pun
    public final void cetakJenisKoleksi() {
        System.out.println("Item ini merupakan aset resmi Perpustakaan.");
    }

    // Getter & Setter
    public String getIdKoleksi() { return idKoleksi; }
    public String getJudul() { return judul; }
    public int getTahunTerbit() { return tahunTerbit; }
}

```

---

### Step 2: Membuat Subclass 1 (`src/model/Buku.java`)

```java
package model;

// Buku IS-A Koleksi
public class Buku extends Koleksi {
    // Atribut spesifik khusus Buku
    private String penulis;
    private int stok;

    // Constructor Subclass
    public Buku(String idKoleksi, String judul, int tahunTerbit, String penulis, int stok) {
        // super(...) WAJIB di baris pertama untuk menginstansiasi induk
        super(idKoleksi, judul, tahunTerbit); 
        this.penulis = penulis;
        setStok(stok); 
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

    // Method spesifik memanfaatkan super.tampilkanInfo()
    public void tampilkanInfoBuku() {
        super.tampilkanInfo(); // Memanggil method milik Superclass
        System.out.printf("| Penulis: %-15s | Stok: %-3d\n", penulis, stok);
    }
}

```

---

### Step 3: Membuat Subclass 2 (`src/model/Majalah.java`)

```java
package model;

// Majalah IS-A Koleksi
public class Majalah extends Koleksi {
    private int edisi;

    public Majalah(String idKoleksi, String judul, int tahunTerbit, int edisi) {
        super(idKoleksi, judul, tahunTerbit); // Mengirim data ke constructor Koleksi
        this.edisi = edisi;
    }

    public int getEdisi() { return edisi; }

    public void tampilkanInfoMajalah() {
        super.tampilkanInfo(); // Memanggil method milik Superclass
        System.out.printf("| Edisi: Vol. %-3d\n", edisi);
    }
}

```

---

### Step 4: Menjalankan Kelas Utama (`src/main/MainApp.java`)

```java
package main;

import model.Buku;
import model.Majalah;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("        PERTEMUAN 4: INHERITANCE (PEWARISAN)     ");
        System.out.println("=================================================\n");

        // 1. Instansiasi Objek Buku (Subclass 1)
        Buku buku1 = new Buku("B001", "Pemrograman Java", 2023, "James Gosling", 5);

        // 2. Instansiasi Objek Majalah (Subclass 2)
        Majalah majalah1 = new Majalah("M001", "National Geographic", 2024, 142);

        System.out.println("--- DAFTAR KOLEKSI PERPUSTAKAAN ---");
        
        // Menampilkan Info Buku
        buku1.tampilkanInfoBuku();

        // Menampilkan Info Majalah
        majalah1.tampilkanInfoMajalah();

        // Pembuktian Hubungan IS-A & Pemanggilan Final Method
        System.out.println("\n--- PEMBUKTIAN REUSABILITAS & FINAL METHOD ---");
        System.out.println("Judul Buku (via getJudul Superclass) : " + buku1.getJudul());
        buku1.cetakJenisKoleksi(); // Memanggil final method dari Superclass
    }
}

```

---

## ⚡ PART 3: EKSPERIMEN ERROR

### 🎯 Eksperimen 1: Memindahkan Posisi `super()`

**Tindakan:** Pada `Buku.java`, pindahkan baris `super(idKoleksi, judul, tahunTerbit);` ke bawah setelah `this.penulis = penulis;`.

```java
public Buku(String idKoleksi, String judul, int tahunTerbit, String penulis, int stok) {
    this.penulis = penulis;
    super(idKoleksi, judul, tahunTerbit); // Pindah ke baris kedua
}

```

* **Hasil:** Error Kompilasi (`call to super must be first statement in constructor`).
* **Pelajaran:** Induk harus diinisialisasi terlebih dahulu sebelum kelas anak dikonstruksi.

---

### 🎯 Eksperimen 2: Mencoba Meng-extends Final Class

**Tindakan:** Buat `public final class CD` lalu buat `public class VCD extends CD`.

* **Hasil:** Error Kompilasi (`cannot inherit from final model.CD`).
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

   a) Buat class **`Kendaraan`** berisi method `jalan()` dan `berhenti()`.
  
   b) Buat subclass **`Mobil`** yang mewarisi `Kendaraan`, tambahkan method `bunyiKlakson()`.
  
   c) Buat objek **`Mobil`** pada `main()` dan jalankan semua method.
2. Buat program sesuai instruksi berikut:

   a) Buat final class **`BangunDatar`** dengan method `hitungLuas()`.
  
   b) Coba buat subclass **`Persegi`** yang `extends BangunDatar`.
  
   c) Amati dan jelaskan mengapa class **`BangunDatar`** tidak bisa diwarisi.
3. Buat program sesuai instruksi berikut:

   a) Buat class **`Orang`** dengan constructor yang menerima `String nama`, serta method `perkenalan()` untuk menampilkan nama.
   
   b) Buat subclass **`Mahasiswa`** dengan constructor yang memanggil `super(nama)`, lalu tambahkan method `belajar()`.
   
   c) Buat objek **`Mahasiswa`** di `main()` dan jalankan semua method.

<img width="1080" height="96" alt="image" src="https://github.com/user-attachments/assets/aac10c9a-53bf-41a8-b976-61d03b1cc115" />
