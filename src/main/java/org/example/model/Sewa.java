package org.example.model;

public class Sewa {
    private Integer idSewa;
    private Integer idAdmin;
    private Integer idPenyewa;
    private String tanggalSewa;
    private String tanggalJatuhTempo;
    private Integer idBuku;
    private Integer status;

    public Sewa() {
    }

    public Sewa(Integer idSewa, Integer idAdmin, Integer idPenyewa, String tanggalSewa, String tanggalJatuhTempo, Integer idBuku, Integer status) {
        this.idSewa = idSewa;
        this.idAdmin = idAdmin;
        this.idPenyewa = idPenyewa;
        this.tanggalSewa = tanggalSewa;
        this.tanggalJatuhTempo = tanggalJatuhTempo;
        this.idBuku = idBuku;
        this.status = status;
    }

    public Sewa(Integer idSewa) {
        this.idSewa = idSewa;
    }

    public Integer getIdSewa() {
        return idSewa;
    }

    public void setIdSewa(Integer idSewa) {
        this.idSewa = idSewa;
    }

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Integer getIdPenyewa() {
        return idPenyewa;
    }

    public void setIdPenyewa(Integer idPenyewa) {
        this.idPenyewa = idPenyewa;
    }

    public String getTanggalSewa() {
        return tanggalSewa;
    }

    public void setTanggalSewa(String tanggalSewa) {
        this.tanggalSewa = tanggalSewa;
    }

    public String getTanggalJatuhTempo() {
        return tanggalJatuhTempo;
    }

    public void setTanggalJatuhTempo(String tanggalJatuhTempo) {
        this.tanggalJatuhTempo = tanggalJatuhTempo;
    }

    public Integer getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(Integer idBuku) {
        this.idBuku = idBuku;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
