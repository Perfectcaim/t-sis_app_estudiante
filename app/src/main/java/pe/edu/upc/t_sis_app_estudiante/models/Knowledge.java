package pe.edu.upc.t_sis_app_estudiante.models;

public class Knowledge {
    private String dni;
    private int code_career;
    private String theme;
    private String description;
    private double price;

    public Knowledge(String dni, int code_career, String theme, String description, double price) {
        this.dni = dni;
        this.code_career = code_career;
        this.theme = theme;
        this.description = description;
        this.price = price;
    }

    public Knowledge(String dni, int code_career) {
        this.dni = dni;
        this.code_career = code_career;
        this.theme = "";
        this.description = "";
        this.price = 0;
    }

    public Knowledge() {
        this.dni = "";
        this.code_career = 0;
        this.theme = "";
        this.description = "";
        this.price = 0;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getCode_career() {
        return code_career;
    }

    public void setCode_career(int code_career) {
        this.code_career = code_career;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
