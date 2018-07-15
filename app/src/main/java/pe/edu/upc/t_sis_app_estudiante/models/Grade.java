package pe.edu.upc.t_sis_app_estudiante.models;

public class Grade {
    private int code;
    private String description;

    public Grade(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public Grade(int code) {
        this.code = code;
        this.description = "";
    }

    public Grade() {
        this.code = 0;
        this.description = "";
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
