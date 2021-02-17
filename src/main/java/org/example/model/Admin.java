package org.example.model;


public class Admin
{
    private int idAdmin ;
    private String namaAdmin;
    private String password;
    private String alamatAdmin;
    private String emailAdmin;
    private String teleponAdmin;

    public Admin() {
    }

    public Admin(int idAdmin, String namaAdmin, String password, String alamatAdmin, String emailAdmin, String teleponAdmin, int status) {
        this.idAdmin = idAdmin;
        this.namaAdmin = namaAdmin;
        this.password = password;
        this.alamatAdmin = alamatAdmin;
        this.emailAdmin = emailAdmin;
        this.teleponAdmin = teleponAdmin;
        this.status = status;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNamaAdmin() {
        return namaAdmin;
    }

    public void setNamaAdmin(String namaAdmin) {
        this.namaAdmin = namaAdmin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlamatAdmin() {
        return alamatAdmin;
    }

    public void setAlamatAdmin(String alamatAdmin) {
        this.alamatAdmin = alamatAdmin;
    }

    public String getEmailAdmin() {
        return emailAdmin;
    }

    public void setEmailAdmin(String emailAdmin) {
        this.emailAdmin = emailAdmin;
    }

    public String getTeleponAdmin() {
        return teleponAdmin;
    }

    public void setTeleponAdmin(String teleponAdmin) {
        this.teleponAdmin = teleponAdmin;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private int status;
}
