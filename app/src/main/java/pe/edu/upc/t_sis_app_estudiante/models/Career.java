package pe.edu.upc.t_sis_app_estudiante.models;

public class Career {
    private int code;
    private String description;
    private int status;

    public Career(int code, String description, int status) {
        this.code = code;
        this.description = description;
        this.status = status;
    }

    public Career(int code) {
        this.code = code;
        this.description = "";
        this.status = 0;
    }

    public Career() {
        this.code = 0;
        this.description = "";
        this.status = 0;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}


