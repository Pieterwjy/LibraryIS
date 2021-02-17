package org.example.model;

public class Buku {
    private Integer idBuku;
    private String isbn;
    private String judul;
    private String barcode;
    private Integer jumlahStok;
    private Integer status;

    public Buku() {
    }

    public Buku(String isbn, String judul, String barcode, Integer jumlahStok, Integer status) {
        this.isbn = isbn;
        this.judul = judul;
        this.barcode = barcode;
        this.jumlahStok = jumlahStok;
        this.status = status;
    }

    public Integer getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(Integer idBuku) {
        this.idBuku = idBuku;
    }

    public Buku(Integer idBuku, String isbn, String judul, String barcode, Integer jumlahStok, Integer status) {
        this.idBuku = idBuku;
        this.isbn = isbn;
        this.judul = judul;
        this.barcode = barcode;
        this.jumlahStok = jumlahStok;
        this.status = status;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Integer getJumlahStok() {
        return jumlahStok;
    }

    public void setJumlahStok(Integer jumlahStok) {
        this.jumlahStok = jumlahStok;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
