CREATE DATABASE db_perpustakaan_mini;
USE db_perpustakaan_mini;

CREATE TABLE buku (
    id_buku VARCHAR(20) PRIMARY KEY,
    judul VARCHAR(100) NOT NULL,
    stok INT NOT NULL
);
