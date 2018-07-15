package pe.edu.upc.t_sis_app_estudiante.models;

public class Student {
    private String dni;
    private String email;
    private String password;
    private String name;
    private String lastname;
    private String address;
    private String phone;
    private int status;
    private String token;
    private String picture;

    public Student(String dni, String email, String password, String name, String lastname, String address, String phone,
                   int status, String token, String picture) {
        this.dni = dni;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.phone = phone;
        this.status = status;
        this.token = token;
        this.picture = picture;
    }

    public Student(String email, String password) {
        this.dni = "";
        this.email = email;
        this.password = password;
        this.name = "";
        this.lastname = "";
        this.address = "";
        this.phone = "";
        this.status = 0;
        this.token = "";
        this.picture = "";
    }

    public Student(String dni) {
        this.dni = dni;
        this.email = "";
        this.password = "";
        this.name = "";
        this.lastname = "";
        this.address = "";
        this.phone = "";
        this.status = 0;
        this.token = "";
        this.picture = "";
    }

    public Student() {
        this.dni = "";
        this.email = "";
        this.password = "";
        this.name = "";
        this.lastname = "";
        this.address = "";
        this.phone = "";
        this.status = 0;
        this.token = "";
        this.picture = "";

    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
