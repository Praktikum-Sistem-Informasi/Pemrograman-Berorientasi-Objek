<img width="1080" height="96" alt="image" src="https://github.com/user-attachments/assets/651a9846-af0c-4643-86df-c39b129057cf" />

# Topik 3 - Package, Class, dan Object

---

## 🎯 Tujuan Pembelajaran

Setelah mengikuti pertemuan ini, Anda diharapkan mampu:

1. ✅ Memahami konsep dasar *Object-Oriented Programming* (OOP): **Class** sebagai cetak biru dan **Object** sebagai wujud nyata.
2. ✅ Memahami anatomi sebuah *Class*, yaitu **Atribut** (*field*) dan **Method**.
3. ✅ Mengimplementasikan proses instansiasi objek menggunakan kata kunci **`new`**.
4. ✅ Memahami dan membuat **Constructor** untuk inisialisasi objek.
5. ✅ Mengelompokkan berkas Java ke dalam **Package** agar struktur proyek rapi dan terorganisir.
6. ✅ Menerapkan konsep class & object ke dalam studi kasus nyata: sistem CRUD sederhana (Perpustakaan) menggunakan `ArrayList`.

> 📌 **Batasan (Scope):** Pengenalan konsep dasar OOP — murni berfokus pada pemahaman *class*, *object*, dan *package*. *Access modifier* (`private`, `public`, `protected`) belum dibahas mendalam di sini agar mahasiswa fokus pada fondasi utama objek.

> 🎯 **Target Output Mahasiswa:** Mampu merancang dan mengubah objek di dunia nyata (contoh: `Mahasiswa` atau `Mobil`) menjadi struktur kode Java yang teratur dan tersusun rapi di dalam *package*.

---

## 🔑 KATA KUNCI UTAMA (KEY WORDS)

* **`class`**       : Cetak biru/*blueprint* yang mendefinisikan atribut dan method suatu objek.
* **`object`**      : Wujud nyata (instansi) yang dibentuk dari sebuah class melalui `new`.
* **`new`**         : Kata kunci untuk melakukan instansiasi (membuat objek baru) dari sebuah class.
* **`constructor`** : Method khusus (nama sama dengan class, tanpa return type) yang otomatis dijalankan saat objek dibuat, dipakai untuk inisialisasi atribut.
* **`package`**     : Mekanisme pengelompokan berkas-berkas Java ke dalam satu folder/namespace agar terstruktur.
* **`ArrayList`**   : Struktur data koleksi dinamis dari Java Collection Framework, dipakai untuk menampung banyak *object* (di sini: banyak `Buku`) tanpa perlu menentukan ukuran tetap seperti array biasa.

---

## 📂 RESOURCES

> 💡 **File demo tersedia di folder `Contoh-Kode/Pertemuan-2/`**

| File | Deskripsi |
| :--- | :--- |
| `Buku.java` | *Class* (cetak biru) yang mendefinisikan atribut dan method Buku |
| `MainApp.java` | Kelas utama berisi menu CRUD (Create, Read, Update, Delete) untuk mengelola objek Buku |

---

## 📋 PERSIAPAN SEBELUM MEMULAI

- [ ] Apache NetBeans IDE / IDE pilihan sudah terbuka.
- [ ] JDK terkonfigurasi dengan benar.
- [ ] Memahami dasar sintaks Java (tipe data, variabel, perulangan `for`/`while`, percabangan `switch`).

---

## 🚀 PART 1: Pemahaman Konsep

```
   ┌───────────────────────┐          ┌───────────────────────┐
   │     Class Buku        │   new    │   Object: Buku B001    │
   │  (Cetak Biru/Blueprint)│ ───────▶ │  judul  = "Pemrograman│
   │  - idBuku              │          │           Java"        │
   │  - judul                │          │  penulis= "James      │
   │  - penulis               │          │           Gosling"    │
   │  - stok                  │          │  stok   = 5            │
   │  + tampilkanInfo()        │          └───────────────────────┘
   └───────────────────────┘   new    ┌───────────────────────┐
                              ───────▶ │   Object: Buku B002    │
                                       │  judul = "Struktur    │
                                       │           Data"        │
                                       └───────────────────────┘
```

> 📌 **ANALOGI DUNIA NYATA:**
> **Class `Buku`** ibarat **formulir kosong pendataan buku** — hanya berupa format/struktur, belum berisi data apa pun. Setiap kali kita mengisi formulir tersebut dengan data buku yang sebenarnya (lewat `new Buku(...)`), kita menciptakan **object** baru: satu buku nyata dengan id, judul, penulis, dan stoknya masing-masing.

---

### 1. Anatomi Class: Atribut dan Method

Sebuah *class* umumnya tersusun atas dua komponen utama, seperti terlihat pada `Buku.java`:

* **Atribut (*Field*)**: `idBuku`, `judul`, `penulis`, `stok` — menyimpan data/karakteristik dari objek Buku.
* **Method**: `tampilkanInfo()` — mendefinisikan perilaku objek, dalam hal ini mencetak detail buku ke layar.

---

### 2. Constructor sebagai Inisialisasi Objek

Constructor `Buku(String idBuku, String judul, String penulis, int stok)` dijalankan otomatis setiap kali kita memanggil `new Buku(...)`. Nilai yang dikirim sebagai argumen langsung dipakai untuk mengisi atribut objek melalui `this.idBuku = idBuku;`, dst.

> 📌 **Catatan `this`:** `this` merujuk ke objek yang sedang dibuat, membedakan atribut class (`this.idBuku`) dari parameter constructor yang kebetulan bernama sama (`idBuku`).

---

### 3. Instansiasi Objek dengan `new` + Menampung di `ArrayList`

Alih-alih membuat variabel objek satu-satu, program ini menampung **banyak objek Buku sekaligus** di dalam satu `ArrayList<Buku>`:

```java
ArrayList<Buku> daftarBuku = new ArrayList<>();
daftarBuku.add(new Buku("B001", "Pemrograman Java", "James Gosling", 5));
```

* `new ArrayList<>()` → instansiasi wadah/koleksi kosong.
* `new Buku(...)` → instansiasi objek Buku baru.
* `.add(...)` → memasukkan objek Buku ke dalam koleksi.

Dengan `ArrayList`, jumlah buku bisa bertambah/berkurang secara dinamis (tidak seperti array biasa yang ukurannya tetap) — cocok untuk fitur tambah dan hapus data.

---

### 4. Package: Merapikan Struktur Proyek

* `Buku.java` berada di **package `model`** (`src/model/Buku.java`) — berisi cetak biru data.
* `MainApp.java` berada di **package `main`** (`src/main/MainApp.java`) — berisi logika program & tampilan menu.
* Karena berbeda package, `MainApp` perlu **`import model.Buku;`** agar bisa memakai class `Buku`.

Pemisahan ini adalah praktik umum: **`model`** untuk class-class data/entitas, **`main`** untuk class yang menjalankan program.

---

## 💻 PART 2: Live Coding

### Step 1: Membuat Class (`src/model/Buku.java`)

```java
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
```

---

### Step 2: Menjalankan Kelas Utama (`src/main/MainApp.java`)

```java
package main;

// Import Class Buku dari package model
import model.Buku;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        // HANYA BUTUH 1 ARRAYLIST UNTUK MENAMPUNG OBJEK BUKU
        ArrayList<Buku> daftarBuku = new ArrayList<>();

        // Instansiasi Objek menggunakan kata kunci 'new' dan Constructor
        daftarBuku.add(new Buku("B001", "Pemrograman Java", "James Gosling", 5));
        daftarBuku.add(new Buku("B002", "Struktur Data", "Ada Lovelace", 3));

        Scanner scanner = new Scanner(System.in);
        boolean berjalan = true;

        while (berjalan) {
            System.out.println("\n==========================================");
            System.out.println("   SISTEM PERPUSTAKAAN (P2: CLASS & OBJECT)");
            System.out.println("==========================================");
            System.out.println("1. Tampilkan Semua Buku");
            System.out.println("2. Tambah Buku Baru");
            System.out.println("3. Cari Buku");
            System.out.println("4. Update Stok Buku");
            System.out.println("5. Hapus Buku");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu (1-6): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (pilihan) {
                case 1:
                    System.out.println("\n--- DAFTAR BUKU PERPUSTAKAAN ---");
                    if (daftarBuku.isEmpty()) {
                        System.out.println("Belum ada data buku.");
                    } else {
                        System.out.printf("%-6s | %-25s | %-20s | %-5s\n", "ID", "Judul Buku", "Penulis", "Stok");
                        System.out.println("------------------------------------------------------------------");
                        for (Buku b : daftarBuku) {
                            b.tampilkanInfo(); // Memanggil method dari objek Buku
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n--- TAMBAH BUKU BARU ---");
                    System.out.print("Masukkan ID Buku      : ");
                    String id = scanner.nextLine();
                    System.out.print("Masukkan Judul Buku   : ");
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan Nama Penulis : ");
                    String penulis = scanner.nextLine();
                    System.out.print("Masukkan Stok         : ");
                    int stok = scanner.nextInt();

                    // MENGINSTANSIASI OBJEK BARU & MENAMBAHKANNYA KE LIST
                    Buku bukuBaru = new Buku(id, judul, penulis, stok);
                    daftarBuku.add(bukuBaru);

                    System.out.println(">> SUCCESS: Objek Buku berhasil dibuat dan ditambahkan!");
                    break;

                case 3:
                    System.out.println("\n--- CARI BUKU ---");
                    System.out.print("Masukkan Kata Kunci Judul: ");
                    String kataKunci = scanner.nextLine();
                    boolean ditemukan = false;

                    for (Buku b : daftarBuku) {
                        if (b.judul.toLowerCase().contains(kataKunci.toLowerCase())) {
                            b.tampilkanInfo();
                            ditemukan = true;
                        }
                    }

                    if (!ditemukan) {
                        System.out.println(">> INFO: Buku tidak ditemukan.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- UPDATE STOK BUKU ---");
                    System.out.print("Masukkan ID Buku: ");
                    String idUpdate = scanner.nextLine();
                    Buku bukuDitemukan = null;

                    for (Buku b : daftarBuku) {
                        if (b.idBuku.equalsIgnoreCase(idUpdate)) {
                            bukuDitemukan = b;
                            break;
                        }
                    }

                    if (bukuDitemukan != null) {
                        System.out.print("Masukkan Stok Baru: ");
                        bukuDitemukan.stok = scanner.nextInt(); // Mengubah atribut objek secara langsung
                        System.out.println(">> SUCCESS: Stok buku " + bukuDitemukan.judul + " berhasil diubah!");
                    } else {
                        System.out.println(">> ERROR: ID Buku tidak ditemukan!");
                    }
                    break;

                case 5:
                    System.out.println("\n--- HAPUS BUKU ---");
                    System.out.print("Masukkan ID Buku yang akan dihapus: ");
                    String idHapus = scanner.nextLine();
                    Buku bukuHapus = null;

                    for (Buku b : daftarBuku) {
                        if (b.idBuku.equalsIgnoreCase(idHapus)) {
                            bukuHapus = b;
                            break;
                        }
                    }

                    if (bukuHapus != null) {
                        daftarBuku.remove(bukuHapus); // HANYA BUTUH 1 KALI REMOVE OBJEK!
                        System.out.println(">> SUCCESS: Buku '" + bukuHapus.judul + "' berhasil dihapus!");
                    } else {
                        System.out.println(">> ERROR: ID Buku tidak ditemukan!");
                    }
                    break;

                case 6:
                    berjalan = false;
                    System.out.println("\nSesi Pertemuan 2 Selesai. Jangan lupa Commit & Push ke GitHub!");
                    break;

                default:
                    System.out.println(">> ERROR: Pilihan tidak valid!");
            }
        }
        scanner.close();
    }
}
```

---

## ⚡ PART 3: EKSPERIMEN ERROR

### 🎯 Eksperimen 1: Menghapus `scanner.nextLine()` Setelah `nextInt()`

**Tindakan:** Hapus baris `scanner.nextLine(); // Clear buffer` tepat setelah `int pilihan = scanner.nextInt();`, lalu jalankan program dan pilih menu **2 (Tambah Buku Baru)**.

* **Hasil:** Input untuk `String id = scanner.nextLine();` **langsung terlewati** (terisi string kosong), karena karakter *newline* (`\n`) sisa penekanan Enter dari `nextInt()` masih tertinggal di buffer dan langsung "termakan" oleh `nextLine()` berikutnya.
* **Pelajaran:** Setiap kali `Scanner.nextInt()` (atau `nextDouble()`, dll) diikuti oleh `nextLine()`, wajib tambahkan `scanner.nextLine()` kosong sebagai "pembersih buffer" agar input teks berikutnya tidak ikut terlewati.

---

### 🎯 Eksperimen 2: Mengganti `idBuku.equalsIgnoreCase(...)` dengan Operator `==`

**Tindakan:** Pada bagian pencarian ID (menu 4/5), ganti `b.idBuku.equalsIgnoreCase(idUpdate)` menjadi `b.idBuku == idUpdate`.

* **Hasil:** Program tetap *compile* (tidak error), tetapi pencarian ID **menjadi tidak konsisten/kadang gagal menemukan** buku yang sebenarnya ada.
* **Pelajaran:** Operator `==` pada tipe `String` (objek) membandingkan **referensi/alamat memori**, bukan **isi teksnya**. Untuk membandingkan isi dua `String`, selalu gunakan method `.equals()` atau `.equalsIgnoreCase()`.

---

## 🚨 TROUBLESHOOTING RINGKAS

| Pesan Error / Gejala | Penyebab | Solusi |
| --- | --- | --- |
| `InputMismatchException` | User memasukkan teks pada saat program memanggil `scanner.nextInt()` (mengharapkan angka). | Pastikan input menu/stok berupa angka; tambahkan validasi input jika perlu. |
| Input teks langsung terlewati (kosong) setelah input angka | Buffer *newline* sisa `nextInt()` belum dibersihkan dengan `scanner.nextLine()`. | Tambahkan `scanner.nextLine();` kosong tepat setelah setiap `nextInt()`/`nextDouble()`. |
| `cannot find symbol: class Buku` di `MainApp.java` | Lupa menuliskan `import model.Buku;` karena `Buku` berada di package berbeda. | Tambahkan baris `import model.Buku;` di bagian atas `MainApp.java`. |
| Data buku tidak ditemukan padahal ID benar | Menggunakan `==` alih-alih `.equals()`/`.equalsIgnoreCase()` untuk membandingkan `String`. | Selalu gunakan `.equals()` atau `.equalsIgnoreCase()` saat membandingkan isi `String`. |

---

## ❓ FREQUENTLY ASKED QUESTIONS (FAQ)

**Q: Kenapa data buku ditampung di `ArrayList<Buku>`, bukan array biasa (`Buku[]`)?**

> **A:** Karena jumlah buku bisa bertambah (menu Tambah) atau berkurang (menu Hapus) selama program berjalan. Array biasa punya ukuran tetap sejak dideklarasikan, sedangkan `ArrayList` bisa berubah ukuran secara dinamis — jauh lebih fleksibel untuk kasus CRUD seperti ini.

**Q: Kenapa pencarian/pembandingan `idBuku` pakai `.equalsIgnoreCase()`, bukan `==`?**

> **A:** `String` adalah objek, sehingga `==` membandingkan apakah dua variabel menunjuk ke **objek yang sama persis di memori**, bukan apakah isinya sama. `.equals()`/`.equalsIgnoreCase()` membandingkan **isi teksnya**, itulah yang kita inginkan saat mencari data berdasarkan ID.

**Q: Apa fungsi `scanner.nextLine();` yang muncul tepat setelah `scanner.nextInt();`?**

> **A:** Untuk membersihkan karakter *newline* (Enter) yang tertinggal di buffer input setelah `nextInt()` dipanggil, supaya pemanggilan `nextLine()` berikutnya benar-benar membaca input baris baru dari user, bukan sisa buffer yang kosong.

**Q: Kenapa `Buku.java` dan `MainApp.java` dipisah ke package `model` dan `main`?**

> **A:** Ini praktik umum untuk merapikan struktur proyek: package `model` khusus menampung class-class data/entitas (cetak biru objek), sedangkan package `main` menampung class yang menjalankan logika/alur program. Pemisahan ini memudahkan proyek dibaca dan dirawat saat aplikasinya makin besar.

---

## Daftar Referensi

[1] W3Schools, "Java Classes and Objects". Tersedia di: [tautan](https://www.w3schools.com/java/java_classes.asp)

[2] W3Schools, "Java Constructors". Tersedia di: [tautan](https://www.w3schools.com/java/java_constructors.asp)

[3] W3Schools, "Java Packages". Tersedia di: [tautan](https://www.w3schools.com/java/java_packages.asp)

[4] Petani Kode, "Belajar Java OOP: Memahami Konsep Dasar OOP (untuk Pemula)". Tersedia di: [tautan](https://www.petanikode.com/java-oop/)

[5] Petani Kode, "Belajar Java OOP: Mengenal Constructor & Destructor dalam Java". Tersedia di: [tautan](https://www.petanikode.com/java-oop-constructor/)

---

## 🏆 CHALLENGE PRAKTIKAN

1. Buat program sesuai instruksi berikut:

   a) Buat class **`Mahasiswa`** pada package `model` dengan atribut `nim`, `nama`, `jurusan`, `ipk`.

   b) Buat *constructor* yang menerima keempat atribut tersebut, dan method `tampilkanInfo()`.

   c) Pada `main()` (package `main`), buat `ArrayList<Mahasiswa>` dan sediakan menu **Tambah** dan **Tampilkan Semua** (mengikuti pola pada `MainApp.java` di atas).

2. Buat program sesuai instruksi berikut:

   a) Modifikasi class **`Buku`** dengan menambahkan atribut `kategori` (mis. "Fiksi", "Non-Fiksi").

   b) Sesuaikan *constructor* dan method `tampilkanInfo()` agar ikut menampilkan `kategori`.

   c) Tambahkan **menu baru** pada `MainApp.java` untuk menampilkan buku berdasarkan `kategori` tertentu (mirip pola menu Cari Buku).

3. Buat program sesuai instruksi berikut:

   a) Buat class **`Mobil`** pada package `model` dengan atribut `plat`, `merk`, `tahun`, `statusSewa` (`boolean`).

   b) Buat *constructor*, method `tampilkanInfo()`, dan `ArrayList<Mobil>` di `main()`.

   c) Sediakan menu **Sewa Mobil** yang mengubah `statusSewa` sebuah objek Mobil menjadi `true` berdasarkan `plat` yang dicari (mengikuti pola menu Update Stok Buku).

<img width="1080" height="96" alt="image" src="https://github.com/user-attachments/assets/aac10c9a-53bf-41a8-b976-61d03b1cc115" />

<p align="center"><a href="#top">Kembali ke atas</a></p>