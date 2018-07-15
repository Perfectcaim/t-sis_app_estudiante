package pe.edu.upc.t_sis_app_estudiante.models;

public class Advisor {
    private String dni_advisor;
    private String name;
    private String lastname;
    private String email;
    private String address;
    private String pasword;
    private String phone;
    private String card;
    private String credit_card;
    private Double latitude;
    private Double longitude;
    private int status_advisor;
    private Double prom_score;
    private String token;
    private String picture;


    public Advisor(String dni_advisor, String name, String lastname, String email, String address, String pasword,
                   String phone, String card, String credit_card, Double latitude, Double longitude,
                   int status_advisor, Double prom_score, String token, String picture) {
        this.dni_advisor = dni_advisor;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.pasword = pasword;
        this.phone = phone;
        this.card = card;
        this.credit_card = credit_card;
        this.latitude = latitude;
        this.longitude = longitude;
        this.status_advisor = status_advisor;
        this.prom_score = prom_score;
        this.token = token;
        this.picture = picture;
    }

    public Advisor(String email, String pasword) {
        this.dni_advisor = "";
        this.name = "";
        this.lastname = "";
        this.email = email;
        this.address = "";
        this.pasword = pasword;
        this.phone = "";
        this.card = "";
        this.credit_card = "";
        this.latitude = 0.0;
        this.longitude = 0.0;
        this.status_advisor = 0;
        this.prom_score = prom_score;
        this.token = token;
        this.picture = picture;
    }


    public String getDni_advisor() {
        return dni_advisor;
    }

    public void setDni_advisor(String dni_advisor) {
        this.dni_advisor = dni_advisor;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getCredit_card() {
        return credit_card;
    }

    public void setCredit_card(String credit_card) {
        this.credit_card = credit_card;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public int getStatus_advisor() {
        return status_advisor;
    }

    public void setStatus_advisor(int status_advisor) {
        this.status_advisor = status_advisor;
    }

    public Double getProm_score() {
        return prom_score;
    }

    public void setProm_score(Double prom_score) {
        this.prom_score = prom_score;
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

    @Override
    public String toString() {
        return "Advisor{" +
                "dni_advisor='" + dni_advisor + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", pasword='" + pasword + '\'' +
                ", phone='" + phone + '\'' +
                ", card='" + card + '\'' +
                ", credit_card='" + credit_card + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", status_advisor=" + status_advisor +
                ", prom_score=" + prom_score +
                ", token='" + token + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }


//    private String dni;
//    private String email;
//    private String password;
//    private String name;
//    private String lastname;
//    private String address;
//    private String phone;
//    private String card;
//    private String credit_card;
//    private double latitude;
//    private double longitude;
//    private int status;
//    private Double prom;
//    private String token;
//    private String picture;
//
//    public Advisor(String dni, String email, String password, String name, String lastname, String address, String phone,
//                   String card, String credit_card, double latitude, double longitude, int status, Double prom,
//                   String token, String picture) {
//        this.dni = dni;
//        this.email = "";
//        this.password = "";
//        this.name = name;
//        this.lastname = lastname;
//        this.address = address;
//        this.phone = "";
//        this.card = "";
//        this.credit_card = "";
//        this.latitude = 1;
//        this.longitude = 1;
//        this.status = 1;
//        this.prom = 0.0;
//        this.token = "";
//        this.picture = "";
//    }
//
//    public Advisor() {
//        this.dni = "";
//        this.email = "";
//        this.password = "";
//        this.name = "";
//        this.lastname = "";
//        this.address = "";
//        this.phone = "";
//        this.card = "";
//        this.credit_card = "";
//        this.latitude = 0;
//        this.longitude = 0;
//        this.status = 0;
//        this.prom = 0.0;
//        this.token = "";
//        this.picture = "";
//    }
//
//    public Advisor(String dni) {
//        this.dni = dni;
//        this.name = "";
//        this.address = "";
//        this.lastname = "";
//        this.email = "";
//        this.password = "";
//        this.phone = "";
//        this.card = "";
//        this.credit_card = "";
//        this.latitude = 0;
//        this.longitude = 0;
//        this.status = 0;
//        this.prom = 0.0;
//        this.token = "";
//        this.picture = "";
//    }
//
//    public String getDni() {
//        return dni;
//    }
//
//    public void setDni(String dni) {
//        this.dni = dni;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getCard() {
//        return card;
//    }
//
//    public void setCard(String card) {
//        this.card = card;
//    }
//
//    public String getCredit_card() {
//        return credit_card;
//    }
//
//    public void setCredit_card(String credit_card) {
//        this.credit_card = credit_card;
//    }
//
//    public double getLatitude() {
//        return latitude;
//    }
//
//    public void setLatitude(double latitude) {
//        this.latitude = latitude;
//    }
//
//    public double getLongitude() {
//        return longitude;
//    }
//
//    public void setLongitude(double longitude) {
//        this.longitude = longitude;
//    }
//
//    public int getStatus() {
//        return status;
//    }
//
//    public void setStatus(int status) {
//        this.status = status;
//    }
//
//    public Double getProm() {
//        return prom;
//    }
//
//    public void setProm(Double prom) {
//        this.prom = prom;
//    }
//
//    public String getToken() {
//        return token;
//    }
//
//    public void setToken(String token) {
//        this.token = token;
//    }
//
//    public String getPicture() {
//        return picture;
//    }
//
//    public void setPicture(String picture) {
//        this.picture = picture;
//    }
}
