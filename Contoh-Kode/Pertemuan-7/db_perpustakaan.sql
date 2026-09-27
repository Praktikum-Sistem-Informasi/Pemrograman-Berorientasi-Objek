CREATE DATABASE db_perpustakaan;
USE db_perpustakaan;

CREATE TABLE buku (
    id_buku VARCHAR(20) PRIMARY KEY,
    judul VARCHAR(100) NOT NULL,
    penulis VARCHAR(100) NOT NULL,
    tahun_terbit INT NOT NULL,
    stok INT NOT NULL
);

INSERT INTO buku (id_buku, judul, penulis, tahun_terbit, stok) VALUES
('B001', 'Belajar Java untuk Pemula', 'Budi Santoso', 2023, 10),
('B002', 'Penerapan Konsep OOP', 'Andi Wijaya', 2024, 15),
('B003', 'Database MySQL Dasar', 'Citra Lestari', 2022, 5);
