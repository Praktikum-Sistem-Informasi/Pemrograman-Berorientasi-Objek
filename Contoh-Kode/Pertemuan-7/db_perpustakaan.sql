CREATE DATABASE IF NOT EXISTS db_perpustakaan;
USE db_perpustakaan;

CREATE TABLE buku (
    id_koleksi   VARCHAR(10)  PRIMARY KEY,
    judul        VARCHAR(150) NOT NULL,
    penulis      VARCHAR(100) NOT NULL,
    tahun_terbit INT          NOT NULL,
    stok         INT          NOT NULL DEFAULT 0
);

INSERT INTO buku VALUES
('B001', 'Pemrograman Java Dasar', 'James Gosling', 2023, 5),
('B002', 'Struktur Data & Algoritma', 'Ada Lovelace', 2022, 3);