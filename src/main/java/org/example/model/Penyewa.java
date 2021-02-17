package org.example.model;

public class Penyewa {
    private int idPenyewa;
    private String namaPenyewa;
    private String alamatPenyewa;
    private String emailPenyewa;
    private String teleponPenyewa;
    private int status;

    public Penyewa() {
    }

    public Penyewa(int idPenyewa, String namaPenyewa, String alamatPenyewa, String emailPenyewa, String teleponPenyewa, int status) {
        this.idPenyewa = idPenyewa;
        this.namaPenyewa = namaPenyewa;
        this.alamatPenyewa = alamatPenyewa;
        this.emailPenyewa = emailPenyewa;
        this.teleponPenyewa = teleponPenyewa;
        this.status = status;
    }

    public Penyewa(String namaPenyewa, String alamatPenyewa, String emailPenyewa, String teleponPenyewa) {
        this.idPenyewa = 0;
        this.namaPenyewa = namaPenyewa;
        this.alamatPenyewa = alamatPenyewa;
        this.emailPenyewa = emailPenyewa;
        this.teleponPenyewa = teleponPenyewa;
        this.status = 1;
    }

    public int getIdPenyewa() {
        return idPenyewa;
    }

    public void setIdPenyewa(int idPenyewa) {
        this.idPenyewa = idPenyewa;
    }

    public String getNamaPenyewa() {
        return namaPenyewa;
    }

    public void setNamaPenyewa(String namaPenyewa) {
        this.namaPenyewa = namaPenyewa;
    }

    public String getAlamatPenyewa() {
        return alamatPenyewa;
    }

    public void setAlamatPenyewa(String alamatPenyewa) {
        this.alamatPenyewa = alamatPenyewa;
    }

    public String getEmailPenyewa() {
        return emailPenyewa;
    }

    public void setEmailPenyewa(String emailPenyewa) {
        this.emailPenyewa = emailPenyewa;
    }

    public String getTeleponPenyewa() {
        return teleponPenyewa;
    }

    public void setTeleponPenyewa(String teleponPenyewa) {
        this.teleponPenyewa = teleponPenyewa;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
