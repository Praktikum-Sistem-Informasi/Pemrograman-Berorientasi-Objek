<img width="1080" height="96" alt="image" src="https://github.com/user-attachments/assets/651a9846-af0c-4643-86df-c39b129057cf" />

# Topik 9 - Struktur Proyek MVC

---

## 🎯 Tujuan Pembelajaran

Setelah mengikuti pertemuan ini, Anda diharapkan mampu:

1. ✅ Memahami konsep arsitektur **MVC (Model–View–Controller)** pada Java.
2. ✅ Menjelaskan konsep arsitektur **MVC (Model-View-Controller)** dalam pengembangan aplikasi Java
3. ✅ Merancang struktur **MVC** pada Java.

---

## 🔑 KATA KUNCI UTAMA (KEY WORDS)

Pada materi ini, terdapat beberapa kata kunci utama yang perlu dipahami fungsi dan penggunaannya:

* **model** : Bagian yang bertugas mengatur, menyimpan, dan mengambil data. Model berisi semua aturan bisnis dan berinteraksi langsung dengan data. Model tidak peduli bagaimana data tersebut akan ditampilkan.
* **view** : Bagian yang bertugas menampilkan informasi kepada pengguna contohnya UI (User Interface). View hanya menerima data yang sudah siap disajikan dan menampilkannya dalam bentuk layar, tombol, atau halaman. View tidak memproses data.
* **controller** : Bagian yang bertugas sebagai otak yang menghubungkan View dan Model. Controller menerima input dari pengguna, memprosesnya, meminta data yang diperlukan ke Model, lalu mengirimkan hasilnya kembali ke View untuk ditampilkan.
---

## 📂 RESOURCES

💡 **Kode demo tersedia di materi ini silahkan ikuti `PART 2: Langkah Live Coding`**

| **File** | **Deskripsi** |
|---|---|
| `model/Buku.java` | Kelas representasi data Buku |
| `view/BukuView.java` | Kelas untuk mencetak/menampilkan data ke konsol |
| `scontroller/BukuController.java` | Kelas pengendali alur data dari Model ke View |
| `main/Main.java` | Kelas utama untuk inisiasi komponen dan pengujian aplikasi |

---

## 📋 PERSIAPAN SEBELUM MEMULAI

Sebelum memulai materi ini, pastikan Anda sudah memahami dasar-dasar pemrograman Java dari materi sebelumnya, terutama:

- [ ] Apache NetBeans IDE / IDE pilihan sudah terbuka.
- [ ] JDK terkonfigurasi dengan benar.
- [ ] Memahami konsep Class, Object, dan Access Modifier dari pertemuan sebelumnya.

---

## PART 1: Pemahaman Konsep
```
perpustakaan-mvc/
└── src/main/java/
    │
    ├── main/                    ← titik masuk aplikasi
    │   └── MainApp.java         ← merangkai Model + View + Controller, lalu dijalankan
    │
    ├── model/                   ← lapisan DATA & BISNIS
    │   ├── Buku.java            ← entitas: id_buku, judul, penulis, tahun_terbit, stok
    │
    ├── view/                    ← lapisan TAMPILAN
    │   └── BukuView.java        ← input dari user & tampilkan data ke konsol
    │
    └── controller/               ← lapisan PENGHUBUNG
        └── BukuController.java  ← terima permintaan dari View, panggil Model, kirim hasil balik ke View
```

> 📌 ANALOGI DUNIA NYATA — Perpustakaan:
> - Model adalah rak buku: tempat data buku (judul, penulis, stok) benar-benar disimpan dan diolah, termasuk aturan seperti "stok tidak boleh minus".
> - View adalah layar pencarian: tempat pengunjung melihat daftar buku dan memasukkan permintaan, tanpa tahu cara data itu diolah.
> - Controller adalah petugas perpustakaan: menerima permintaan dari meja sirkulasi (View), meneruskan ke rak buku (Model), lalu menyampaikan hasilnya kembali ke pengunjung lewat View.

Mengapa MVC Penting?
Jika program mulai besar, menaruh logika data, desain interface, dan pemrosesan data di dalam satu file akan membuatnya sangat kacau dan berantakan. MVC memisahkan ketiga hal tersebut agar mudah dikelola dan diperbaiki.

## PART 2: Langkah Live Coding
### Step 1: Membuat Struktur Package
```
    main/                        ← Package
    │   └── Main.java            
    │
    ├── model/                   ← Package
    │   ├── Buku.java                
    │
    ├── view/                    ← Package
    │   └── BukuView.java        
    │
    └── controller/              ← Package
        └── BukuController.java  
```

### Step 2: Membuat Model (model/Buku.java)

```java
package model;

public class Buku {
    private String idBuku;
    private String judul;
    private String penulis;
    private int tahunTerbit;
    private int stok;

    public Buku(String idBuku, String judul, String penulis, int tahunTerbit, int stok) {
            this.idBuku = idBuku;
            this.judul = judul;
            this.penulis = penulis;
            this.tahunTerbit = tahunTerbit;
            this.stok = stok;
    }

    public String getIdBuku() {
        return idBuku;
    }
    public void setIdBuku(String idBuku) {
        this.idBuku = idBuku;
    }

    public String getJudul() {
        return judul;
    }
    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }
    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }
    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    public int getStok() {
        return stok;
    }
    public void setStok(int stok) {
        this.stok = stok;
    }
        
}
```
### Step 3: Membuat View (view/BukuView.java)
```java
package view;

public class BukuView {  
    public void cetakDetailBuku(String id, String judul, String penulis, int tahun, int stok) {
        System.out.println("=====================================");
        System.out.println("         DETAIL BUKU PERPUS          ");
        System.out.println("=====================================");
        System.out.println("ID Buku       : " + id);
        System.out.println("Judul         : " + judul);
        System.out.println("Penulis       : " + penulis);
        System.out.println("Tahun Terbit  : " + tahun);
        System.out.println("Sisa Stok     : " + stok);
        System.out.println("=====================================\n");
    }
}
```
### Step 4: Membuat Controller (controller/BukuController.java)
```
package controller;

import java.util.ArrayList;
import model.Buku;
import view.BukuView;

public class BukuController {
    private ArrayList<Buku> daftarBuku;
    private BukuView view;

    public BukuController(BukuView view) {
        this.daftarBuku = new ArrayList<>();
        this.view = view;
    }

    public void tambahBuku(Buku bukuBaru) {
        daftarBuku.add(bukuBaru);
    }

    public void updateStokBuku(String idBuku, int stokBaru) {
        for (Buku buku : daftarBuku) {
            if (buku.getIdBuku().equals(idBuku)) {
                buku.setStok(stokBaru);
                System.out.println("Stok buku dengan ID " + idBuku + " berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Buku dengan ID " + idBuku + " tidak ditemukan.");
    }

    public void tampilkanSemuaBuku() {
        System.out.println("\n=== DAFTAR BUKU PERPUSTAKAAN ===");
        if (daftarBuku.isEmpty()) {
            System.out.println("Buku masih kosong.");
        } else {
            for (Buku buku : daftarBuku) {
                view.cetakDetailBuku(
                    buku.getIdBuku(), 
                    buku.getJudul(), 
                    buku.getPenulis(), 
                    buku.getTahunTerbit(), 
                    buku.getStok()
                );
            }
        }
    }
}
```
### Step 5: Menjalankan Kelas Utama (main/Main.java)
```
package main;

import model.Buku;
import view.BukuView;
import controller.BukuController;

public class Main {
    public static void main(String[] args) {
        BukuView viewBuku = new BukuView();
        BukuController controller = new BukuController(viewBuku);

        controller.tambahBuku(new Buku("B-001", "Belajar Jarkom", "Bang Faris", 2026, 15));
        controller.tambahBuku(new Buku("B-002", "Belajar SBD", "Mbak Rini", 2026, 8));
        controller.tambahBuku(new Buku("B-003", "Belajar PBO", "Bang Rizky", 2026, 10));

        controller.tampilkanSemuaBuku();
        
        controller.updateStokBuku("B-002", 7); 
        controller.updateStokBuku("B-999", 5); 
    }
}
```
---

## ⚡ PART 3: EKSPERIMEN ERROR (DEBUGGING)
### 🎯 Eksperimen 1: Lupa Menginisialisasi ArrayList di Controller
Tindakan: Pada BukuController.java, buka constructor dan jadikan baris this.daftarBuku = new ArrayList<>(); sebagai komentar (tambahkan // di depannya). Lalu jalankan MainApp.java.

Hasil: Aplikasi akan crash dan menghasilkan pesan error java.lang.NullPointerException saat metode tambahBuku() dipanggil.

Pelajaran: Objek koleksi (seperti ArrayList) harus selalu diinstansiasi (new) sebelum bisa diisi data. Jika tidak, Controller tidak memiliki wadah di memori untuk menyimpan objek Model.

---

### 🎯 Eksperimen 2: Pembaruan Data Tanpa Pembaruan View (Sinkronisasi Gagal)
Tindakan: Pada MainApp.java, pada bagian simulasi peminjaman (mengubah stok), ubah nilai stok melalui Controller, tetapi jangan panggil controller.tampilkanSemuaBuku() setelahnya.

Hasil: Tidak ada error yang muncul di konsol. Namun, saat program selesai, layar tidak menampilkan stok buku terbaru.

Pelajaran: Dalam pola MVC, perubahan pada Model (state) tidak akan otomatis terlihat oleh user jika Controller tidak memerintahkan View untuk mencetak ulang (render). Ini adalah kesalahan logika (bug), bukan kesalahan sintaks.

---

## 🚨 TROUBLESHOOTING RINGKAS

| Pesan Error | Penyebab | Solusi |
| --- | --- | --- |
| `method does not override or implement...` di metode `tambahBuku()` | Wadah `ArrayList` belum dibuat di memori. | Pastikan `this.daftarBuku = new ArrayList<>();` ada di dalam constructor Controller. |
| `cannot find symbol: class ArrayList` | Kelas ArrayList belum di-import dari library bawaan Java. | Tambahkan import `java.util.ArrayList;` di baris paling atas (bawah deklarasi package). |
| Data berubah, tapi di layar tetap nilai lama | Kamu memodifikasi data di Model, tetapi lupa memperbarui tampilan. | Panggil metode dari Controller yang bertugas memperbarui View setiap kali selesai melakukan operasi ubah data (misal: panggil `tampilkanSemuaBuku()`).|
| Kesulitan melacak data | Menggunakan nama variabel yang asal-asalan atau tidak merepresentasikan objeknya. | Wajib menerapkan Clean Code. Jangan pernah menggunakan nama variabel yang aneh atau tidak bermakna (contoh: `x123`, `wadahAneh`, `data_an`u). Gunakan nama standar seperti `daftarBuku`, `bukuBaru`, atau `modelBuku`. |

---

## ❓ FREQUENTLY ASKED QUESTIONS (FAQ)

Q: Mengapa ArrayList disimpannya di dalam Controller, bukan di dalam Model Buku?
> A: Karena kelas Buku (Model) mewakili satu entitas tunggal (satu buah buku). Jika kita ingin membuat rak buku atau daftar buku, wadahnya (seperti ArrayList) dikelola oleh Controller, karena Controller-lah yang bertugas mengatur lalu lintas banyaknya data yang masuk dan keluar. (Catatan: Pada tingkat mahir, kumpulan data ini nanti akan dikelola oleh Repository / Database).

Q: Apakah View boleh tahu bahwa kita menggunakan ArrayList?
> A: Sebaiknya tidak. View tidak peduli datanya datang dari ArrayList, Array biasa, atau Database. Tugas View murni hanya menerima sepotong data (seperti ID, Judul, Penulis) lalu mencetaknya ke layar dengan format yang rapi.

Q: Jika saya punya puluhan Controller nanti, apakah file saya tidak jadi berantakan?
> A: Itulah alasan kita wajib menggunakan Package (seperti model, view, dan controller). Pembagian folder ini memastikan ratusan file Java Anda tetap terorganisasi dengan rapi layaknya laci-laci pada lemari arsip.

Q: Boleh tidak jika logika pencarian buku (berdasarkan ID) dipindah ke MainApp.java?
> A: Tidak dianjurkan. MainApp.java ibarat tombol "Power" untuk menyalakan aplikasi. Logika pencarian, penambahan, dan pengurangan data adalah logika bisnis yang merupakan tanggung jawab penuh dari Controller.

---

## 🏆 CHALLENGE PRAKTIKAN

Untuk menguji pemahaman Anda mengenai MVC dan Manipulasi Collections, selesaikan tantangan berikut:

1. Fitur Hapus Buku (Delete):

    a) Tambahkan metode baru di BukuController.java dengan nama hapusBuku(String idBuku).

    b) Logika: Gunakan perulangan atau metode bawaan ArrayList untuk mencari buku dengan ID tersebut. Jika ketemu, hapus dari list. Jika tidak, cetak pesan "Buku tidak ditemukan".
   
    c) Uji pemanggilan metode ini di MainApp.java dan tampilkan ulang daftar buku setelah penghapusan.

2. Fitur Pencarian Buku Berdasarkan Judul (Search):

    a) Tambahkan metode baru di BukuController.java dengan nama cariBuku(String keyword).

    b) Logika: Lakukan perulangan pada daftarBuku. Jika ada buku yang getJudul()-nya mengandung keyword tersebut, perintahkan View untuk menampilkannya. (Hint: gunakan .contains()).

3. Pemisahan Validasi (Advanced):
   
    a) Saat ini validasi stok tidak boleh minus masih berada di dalam parameter fungsi Controller (saat simulasi).
   
    b) Modifikasi fungsi setStok(int stok) di dalam Model Buku.java agar jika nilai yang dimasukkan kurang dari 0, nilainya otomatis menjadi 0, sehingga Controller tidak perlu melakukan pengecekan berulang-ulang.

<img width="1080" height="96" alt="image" src="https://github.com/user-attachments/assets/aac10c9a-53bf-41a8-b976-61d03b1cc115" />

<p align="center"><a href="#top">Kembali ke atas</a></p>
