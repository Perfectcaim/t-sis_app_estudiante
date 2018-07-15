package pe.edu.upc.t_sis_app_estudiante.models;

import java.util.Date;

public class Available {
    private int code;
    private String dni;
    private String date;
    private int hour;
    private int status;

    public Available(int code, String dni, String date, int hour, int status) {
        this.code = code;
        this.dni = dni;
        this.date = date;
        this.hour = hour;
        this.status = status;
    }

    public Available(int code, String dni) {
        this.code = code;
        this.dni = dni;
        this.date = "";
        this.hour = 0;
        this.status = 0;
    }

    public Available() {
        this.code = 0;
        this.dni = "";
        this.date = "";
        this.hour = 0;
        this.status = 0;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
