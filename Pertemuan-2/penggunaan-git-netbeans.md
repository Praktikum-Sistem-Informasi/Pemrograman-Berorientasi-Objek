<img width="1080" height="96" alt="image" src="https://github.com/user-attachments/assets/651a9846-af0c-4643-86df-c39b129057cf" />

# Topik 4 - Penggunaan GIT pada NetBeans

---

## 🎯 Tujuan Pembelajaran

Setelah mengikuti pertemuan ini, Anda diharapkan mampu:

1. ✅ Memahami konsep dasar **Version Control System (VCS)** dan manfaatnya dalam pengembangan software.
2. ✅ Menginisialisasi **repositori Git lokal** untuk proyek Java di NetBeans.
3. ✅ Melakukan **Clone** (mengunduh) proyek dari GitHub ke NetBeans.
4. ✅ Memahami alur kerja Git: *Working Directory* → *Staging Area* → *Local Repository* → *Remote Repository*.
5. ✅ Melakukan operasi dasar Git — **Commit**, **Push**, dan **Pull** — melalui antarmuka (GUI) NetBeans.
6. ✅ Memahami fungsi dan cara pemakaian berkas **`.gitignore`**.
7. ✅ Menyelesaikan **merge conflict** sederhana melalui antarmuka NetBeans.

> 📌 **Batasan (Scope):** Materi ini berfokus penuh pada penggunaan antarmuka visual (GUI) Git bawaan NetBeans IDE beserta integrasinya dengan GitHub. **Belum** membahas perintah Git kompleks via terminal/CLI (`git rebase`, `git cherry-pick`) atau *branching strategy* tingkat lanjut (Git Flow), agar mahasiswa fokus pada manajemen repositori tingkat dasar.

> 🎯 **Target Output Mahasiswa:** Mampu mengunggah proyek Java lokal ke GitHub (**push**), mengambil/membuka proyek dari repositori GitHub ke NetBeans (**clone**), serta melakukan sinkronisasi kode (**pull**) secara mandiri dari dalam NetBeans.

---

## 🔑 KATA KUNCI UTAMA (KEY WORDS)

* **`Version Control System (VCS)`** : Sistem yang mencatat riwayat perubahan berkas dari waktu ke waktu, sehingga perubahan bisa dilacak, dibandingkan, bahkan dikembalikan ke versi sebelumnya.
* **`Repository (Repo)`**            : "Wadah" proyek yang dilacak oleh Git, berisi seluruh riwayat perubahan berkas.
* **`Commit`**                      : Menyimpan "snapshot" perubahan beserta pesan keterangan ke *Local Repository*.
* **`Push`**                        : Mengirim commit dari *Local Repository* menuju *Remote Repository* (GitHub).
* **`Pull`**                        : Mengambil sekaligus menggabungkan perubahan terbaru dari *Remote Repository* ke proyek lokal.
* **`Clone`**                       : Mengunduh salinan *penuh* sebuah repository (beserta riwayatnya) dari GitHub ke komputer, biasanya dilakukan **sekali** di awal.
* **`Staging Area`**                : Area "antara" tempat berkas yang sudah `add` menunggu untuk di-*commit*.
* **`.gitignore`**                  : Berkas konfigurasi berisi daftar file/folder yang **tidak** perlu dilacak oleh Git.
* **`Merge Conflict`**               : Situasi ketika Git tidak bisa otomatis menggabungkan dua perubahan berbeda pada baris yang sama di sebuah file.

---

## 📂 RESOURCES

| Kebutuhan | Keterangan |
| :--- | :--- |
| Akun GitHub | Aktif dan sudah bisa login (disarankan siapkan *Personal Access Token* untuk autentikasi). |
| Proyek Java NetBeans | Bisa memakai proyek dari Pertemuan 2 sebelumnya (studi kasus Buku). |
| Plugin Git NetBeans | Umumnya sudah terpasang bawaan pada NetBeans versi terbaru (memakai JGit, sehingga instalasi Git terpisah bersifat opsional). |

---

## 📋 PERSIAPAN SEBELUM MEMULAI

- [ ] NetBeans IDE sudah terbuka dengan sebuah proyek Java aktif.
- [ ] Akun GitHub sudah dibuat dan siap dipakai.
- [ ] Sudah menyiapkan *Personal Access Token* (PAT) GitHub — karena GitHub tidak lagi menerima autentikasi password biasa untuk operasi Git via HTTPS.
- [ ] Koneksi internet stabil (dibutuhkan untuk Push, Pull, Clone).

---

## 🚀 PART 1: Pemahaman Konsep

> 📌 **ANALOGI DUNIA NYATA:**
> Bayangkan Git seperti fitur **"riwayat versi"** pada Google Docs. Setiap kali kamu menekan "Save" dengan catatan ("Commit"), dokumen tersimpan sebagai satu titik riwayat yang bisa dibuka/dibandingkan lagi kapan pun. **Push** ibarat mengunggah dokumen itu ke Google Drive bersama (server) supaya rekan satu tim bisa melihatnya. **Pull** ibarat menyegarkan dokumen di laptopmu dengan versi terbaru yang sudah diedit rekan tim di Drive.

### 1. Mengapa Version Control System Penting?

* **Riwayat perubahan tercatat:** Setiap commit punya jejak "apa yang berubah, kapan, dan siapa yang mengubah".
* **Bisa kembali ke versi sebelumnya:** Jika ada perubahan yang keliru/merusak program, cukup kembalikan ke commit sebelumnya.
* **Kolaborasi tim:** Beberapa orang bisa bekerja pada proyek yang sama tanpa saling menimpa pekerjaan orang lain secara sembarangan.
* **Backup di remote:** Kode yang sudah di-push ke GitHub aman tersimpan meski laptop lokal bermasalah.

---

### 2. Alur Kerja Git (4 Area Utama)

```
┌───────────────┐  git add   ┌───────────────┐  git commit  ┌───────────────────┐  git push  ┌────────────────────┐
│Working Directory│ ────────▶ │ Staging Area  │ ───────────▶ │ Local Repository   │ ─────────▶ │ Remote Repository   │
│ (file yg sedang │            │ (file "siap   │              │ (riwayat commit di │            │  (GitHub)           │
│  kamu edit)      │            │  disimpan")   │              │  komputer sendiri) │            │                     │
└───────────────┘            └───────────────┘              └────────────────────┘            └────────────────────┘
                                                                        ▲                                  │
                                                                        └───────────── git pull ───────────┘
```

* **Working Directory** → file-file proyek yang sedang kamu sunting sehari-hari.
* **Staging Area** → tempat "menandai" file mana saja yang ingin ikut disimpan pada commit berikutnya (pada NetBeans, ini adalah langkah **centang file** di jendela Commit).
* **Local Repository** → riwayat commit yang tersimpan **di komputer sendiri** (folder tersembunyi `.git`).
* **Remote Repository** → riwayat commit yang tersimpan di **server** (GitHub), bisa diakses oleh semua anggota tim.

> 📌 **`Clone`** adalah cara untuk menyalin *Remote Repository* langsung menjadi *Working Directory* + *Local Repository* baru di komputer — dipakai saat kamu belum punya salinan proyek itu sama sekali.

---

### 3. Fungsi Berkas `.gitignore`

Tidak semua file dalam folder proyek perlu dilacak Git — contohnya hasil kompilasi (`.class`), folder `build/`/`dist/`, atau berkas konfigurasi privat IDE. File-file ini bisa dibuat ulang kapan saja dari source code, sehingga **tidak perlu** ikut disimpan/di-push ke GitHub. Daftar pengecualian ini dituliskan di berkas `.gitignore` pada root proyek:

```
/build/
/dist/
/nbproject/private/
*.class
```

> ⚠️ Sebaiknya `.gitignore` dibuat **sebelum commit pertama**. Jika sebuah file sudah terlanjur ter-*commit* lebih dulu, menambahkannya ke `.gitignore` belakangan tidak akan menghentikan Git melacak file tersebut — file itu harus dihapus dulu dari pelacakan (*untrack*) secara manual.

---

## 💻 PART 2: Live Praktikum (Langkah GUI di NetBeans)

### Step 1: Inisialisasi Repository Lokal

1. Klik kanan pada nama proyek di panel **Projects**.
2. Pilih **Versioning ▸ Initialize Git Repository...** (atau **Team ▸ Git ▸ Initialize Repository...**).
3. NetBeans akan membuat folder tersembunyi `.git` di root proyek — tanda proyek sudah menjadi *Local Repository*.

---

### Step 2: Membuat `.gitignore`

1. Buat berkas baru bernama `.gitignore` pada root folder proyek (bisa lewat **File ▸ New File ▸ Other ▸ Empty File**).
2. Isi dengan daftar file/folder yang ingin dikecualikan (contoh sudah ditulis di Part 1).
3. Simpan berkas — mulai saat ini, file/folder yang cocok dengan daftar tersebut tidak akan muncul sebagai "perlu di-commit".

---

### Step 3: Staging & Commit Perubahan

1. Klik kanan pada nama proyek ▸ **Git ▸ Commit...**
2. Pada jendela yang muncul, **centang** file-file yang ingin disertakan (proses *staging*).
3. Isi kolom **Commit Message** dengan deskripsi singkat & jelas (contoh: `"Menambahkan class Buku dan menu CRUD"`).
4. Klik tombol **Commit**.

---

### Step 4: Menghubungkan ke Remote Repository & Push Pertama Kali

1. Buat repository **kosong** terlebih dahulu di GitHub (lewat browser), lalu salin URL-nya (contoh: `https://github.com/username/nama-repo.git`).
2. Di NetBeans: klik kanan proyek ▸ **Git ▸ Remote ▸ Push...**
3. Masukkan **Repository URL** GitHub tadi, pilih branch lokal yang ingin dikirim (biasanya `main`/`master`), lalu klik **Next** hingga **Finish**.
4. Saat diminta autentikasi, masukkan username GitHub dan **Personal Access Token** (bukan password akun biasa).

---

### Step 5: Clone Proyek dari GitHub

1. Pada jendela awal NetBeans (tanpa membuka proyek tertentu), pilih **Team ▸ Git ▸ Clone...**
2. Masukkan **Repository URL** GitHub yang ingin diunduh.
3. Tentukan folder tujuan penyimpanan di komputer lokal.
4. Pilih branch yang ingin di-*clone*, lalu klik **Finish**.
5. NetBeans akan mengunduh seluruh riwayat proyek dan otomatis membukanya (jika strukturnya adalah proyek NetBeans yang valid).

---

### Step 6: Pull — Menyinkronkan Perubahan Terbaru

1. Klik kanan proyek ▸ **Git ▸ Remote ▸ Pull...**
2. Pilih remote (biasanya bernama `origin`) dan branch yang sesuai.
3. Klik **Pull** — NetBeans akan mengambil commit terbaru dari GitHub dan menggabungkannya ke proyek lokal.

---

### Step 7: Menyelesaikan Merge Conflict Sederhana

*Merge conflict* terjadi ketika dua sumber (misalnya perubahan lokal dan perubahan dari `pull`) sama-sama mengubah **baris yang sama** pada file yang sama, sehingga Git tidak bisa memutuskan versi mana yang dipakai secara otomatis.

1. NetBeans menandai file yang konflik dengan ikon khusus (biasanya berwarna merah) di panel **Projects**/**Files**.
2. Buka file tersebut — Git akan menyisipkan penanda konflik langsung di dalam kode:
   ```
   <<<<<<< HEAD
   // isi versi lokal (milikmu)
   =======
   // isi versi dari remote/branch lain
   >>>>>>> origin/main
   ```
3. Sunting manual bagian tersebut — pilih salah satu versi, gabungkan keduanya, atau tulis ulang sesuai kebutuhan.
4. **Hapus** ketiga baris penanda (`<<<<<<<`, `=======`, `>>>>>>>`) setelah selesai memutuskan.
5. Simpan file, lalu lakukan **Commit** ulang untuk menandai konflik sudah selesai diselesaikan.

---

## ⚡ PART 3: EKSPERIMEN

### 🎯 Eksperimen 1: Push Tanpa Pull Terlebih Dahulu

**Tindakan:** Saat *Remote Repository* di GitHub sudah memiliki commit baru (misal dari rekan tim atau diedit langsung di GitHub), coba langsung **Push** dari NetBeans tanpa **Pull** dulu.

* **Hasil:** Push **ditolak**, biasanya muncul pesan sejenis *"Updates were rejected because the remote contains work that you do not have locally"* (non-fast-forward).
* **Pelajaran:** Git menolak menimpa riwayat remote yang belum kamu miliki secara lokal. Selalu **Pull dulu**, baru **Push**, agar riwayat lokal & remote tetap sinkron.

---

### 🎯 Eksperimen 2: Lupa Membuat `.gitignore` Sebelum Commit Pertama

**Tindakan:** Lakukan Commit pertama tanpa membuat `.gitignore`, sehingga folder `build/` ikut ter-*commit*. Baru setelah itu tambahkan `.gitignore`.

* **Hasil:** File-file di `build/` **tetap** muncul sebagai bagian dari riwayat proyek meski `.gitignore` sudah ditambahkan, karena file itu sudah kadung dilacak (*tracked*) oleh Git sebelumnya.
* **Pelajaran:** `.gitignore` idealnya dibuat **sebelum** commit pertama kali. File yang terlanjur ter-*track* harus dihapus dulu dari daftar pelacakan Git secara manual sebelum `.gitignore` benar-benar berlaku untuknya.

---

## 🚨 TROUBLESHOOTING RINGKAS

| Pesan/Gejala | Penyebab | Solusi |
| --- | --- | --- |
| `Updates were rejected... non-fast-forward` | Ada commit baru di remote yang belum ditarik ke lokal. | Lakukan **Pull** terlebih dahulu, baru **Push** kembali. |
| Autentikasi gagal (*Authentication failed*) saat Push | GitHub tidak lagi menerima password akun biasa untuk operasi Git via HTTPS. | Gunakan **Personal Access Token (PAT)** sebagai pengganti password. |
| Folder `build/`/`dist/`/file `.class` ikut ter-commit | Belum ada `.gitignore`, atau `.gitignore` dibuat terlambat setelah file sudah ter-*track*. | Buat `.gitignore` sejak awal proyek; untuk file yang terlanjur ter-*track*, hapus dari pelacakan lalu commit ulang. |
| Muncul ikon file berwarna merah/tanda konflik | Dua sumber (lokal & remote) sama-sama mengubah baris yang sama pada file yang sama. | Buka file, sunting manual bagian di antara penanda `<<<<<<<` dan `>>>>>>>`, hapus penandanya, lalu commit ulang. |

---

## ❓ FREQUENTLY ASKED QUESTIONS (FAQ)

**Q: Apa perbedaan mendasar antara Commit dan Push?**

> **A:** *Commit* menyimpan snapshot perubahan ke **Local Repository** — masih tersimpan di komputer sendiri, belum terkirim ke GitHub. *Push* baru mengirimkan commit-commit tersebut ke **Remote Repository** (GitHub) agar bisa diakses/dilihat orang lain.

**Q: Kapan menggunakan Clone dan kapan menggunakan Pull?**

> **A:** *Clone* dipakai **sekali** di awal, untuk mengunduh salinan penuh sebuah repository yang belum pernah ada di komputer. *Pull* dipakai **berulang kali** setelahnya, untuk menyinkronkan perubahan terbaru dari remote ke proyek yang memang sudah ada secara lokal.

**Q: Kenapa file hasil compile seperti `.class` atau folder `build/` tidak perlu di-commit?**

> **A:** Karena file tersebut adalah hasil otomatis yang bisa dibuat ulang kapan saja dari source code aslinya. Ikut meng-commit file hasil build hanya membuat ukuran repository membengkak dan riwayat perubahan jadi sulit dibaca — sebaiknya dimasukkan ke `.gitignore`.

**Q: Apakah merge conflict itu sebuah error/bug pada program?**

> **A:** Bukan. *Merge conflict* adalah situasi **normal** ketika Git tidak bisa otomatis memutuskan versi mana yang benar karena dua sumber (lokal & remote) sama-sama mengubah baris yang sama. Git meminta developer memutuskan sendiri secara manual, bukan menandakan ada bug pada kode.

---

## Daftar Referensi

[1] Apache NetBeans, "Using Git in Apache NetBeans". Tersedia di: [tautan](https://netbeans.apache.org/tutorial/main/kb/docs/ide/git/)

[2] GitHub Docs, "Ignoring files". Tersedia di: [tautan](https://docs.github.com/en/get-started/git-basics/ignoring-files)

[3] GitHub Docs, "Managing your personal access tokens". Tersedia di: [tautan](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/managing-your-personal-access-tokens)

[4] Colamen, "Cara Mudah Push Project Netbeans ke Github". Tersedia di: [tautan](https://colamen.id/cara-mudah-push-project-netbeans-ke-github/)

---

## 🏆 CHALLENGE PRAKTIKAN

1. Buat langkah berikut:

   a) Buat repository baru (kosong) di akun GitHub kamu.

   b) Inisialisasi Git lokal pada proyek Java (misalnya proyek Pertemuan 2 - studi kasus Buku) di NetBeans.

   c) Hubungkan proyek tersebut ke repository GitHub yang baru dibuat, lalu lakukan **Push** pertama kali.

2. Buat langkah berikut:

   a) Buat berkas `.gitignore` pada proyek yang sama, minimal mengecualikan folder `build/`, `dist/`, dan `nbproject/private/`.

   b) Lakukan perubahan kecil pada kode (misalnya ubah teks judul menu), lalu **Commit** dan **Push** perubahan tersebut.

3. Buat langkah berikut:

   a) Pada folder/komputer lain (atau minta bantuan teman), lakukan **Clone** terhadap repository GitHub yang sama.

   b) Lakukan perubahan pada bagian kode yang berbeda dari langkah nomor 2, lalu **Commit** dan **Push** dari sana.

   c) Kembali ke proyek/komputer awal, lakukan **Pull**, dan amati perubahan yang masuk ke proyekmu.

<img width="1080" height="96" alt="image" src="https://github.com/user-attachments/assets/aac10c9a-53bf-41a8-b976-61d03b1cc115" />

<p align="center"><a href="#top">Kembali ke atas</a></p>