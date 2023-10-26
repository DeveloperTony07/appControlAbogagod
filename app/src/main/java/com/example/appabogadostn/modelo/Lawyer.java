package com.example.appabogadostn.modelo;

public class Lawyer {

    private int id;
    private String identification, username, phone, email, password;

    public Lawyer() {
        this.id = 0;
        this.identification = "";
        this.username = "";
        this.phone = "";
        this.email = "";
        this.password = "";
    }

    public Lawyer(int id, String identification, String username, String phone, String email, String password) {
        this.id = id;
        this.identification = identification;
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Lawyer{" +
                "id=" + id +
                ", identification='" + identification + '\'' +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
