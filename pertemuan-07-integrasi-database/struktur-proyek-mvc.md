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

**model : Bagian yang bertugas mengatur, menyimpan, dan mengambil data. Model berisi semua aturan bisnis dan berinteraksi langsung dengan data. Model tidak peduli bagaimana data tersebut akan ditampilkan. seperti rak atau gudang Tempat di mana semua buku disimpan dan dicatat.
view : Bagian yang bertugas menampilkan informasi kepada pengguna contohnya UI (User Interface). View hanya menerima data yang sudah siap disajikan dan menampilkannya dalam bentuk layar, tombol, atau halaman. View tidak memproses data. Seperti meja layanan yang dilihat dan disentuh oleh pengunjung. Misalnya, monitor tempat pengunjung mengetik judul buku, atau form peminjaman.
controller : Bagian yang bertugas sebagai otak yang menghubungkan View dan Model. Controller menerima input dari pengguna, memprosesnya, meminta data yang diperlukan ke Model, lalu mengirimkan hasilnya kembali ke View untuk ditampilkan. Seperti Pustakawan atau orang yang berjaga di meja layanan. Ia menerima permintaan pengunjung, lalu memprosesnya.

---

## 📂 RESOURCES

💡 **File demo tersedia di folder `contoh_kode/pertemuan_1/`**

| **File** | **Deskripsi** |
|---|---|
| `src/pertemuan1/Array.java` | Kelas demonstrasi penggunaan Array |
| `src/pertemuan1/ArrayList.java` | Kelas demonstrasi penggunaan ArrayList |
| `src/pertemuan1/PerbandinganArray.java` | Kelas demonstrasi perbedaan Array dan ArrayList

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
    │   └── BukuService.java     ← aturan bisnis: tambah, cari, pinjam, validasi stok
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
    │   └── BukuService.java     
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
## Challenge Praktikan
---
