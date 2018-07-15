package pe.edu.upc.t_sis_app_estudiante.models;

public class Advisor_Detail {
    private String dni;
    private int code_university;
    private int code_grade;
    private int year_egress;

    public Advisor_Detail(String dni, int code_university, int code_grade, int year_egress) {
        this.dni = dni;
        this.code_university = code_university;
        this.code_grade = code_grade;
        this.year_egress = year_egress;
    }

    public Advisor_Detail(String dni, int code_university, int code_grade) {
        this.dni = dni;
        this.code_university = code_university;
        this.code_grade = code_grade;
        this.year_egress = 0;
    }

    public Advisor_Detail() {
        this.dni = "";
        this.code_university = 0;
        this.code_grade = 0;
        this.year_egress = 0;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getCode_university() {
        return code_university;
    }

    public void setCode_university(int code_university) {
        this.code_university = code_university;
    }

    public int getCode_grade() {
        return code_grade;
    }

    public void setCode_grade(int code_grade) {
        this.code_grade = code_grade;
    }

    public int getYear_egress() {
        return year_egress;
    }

    public void setYear_egress(int year_egress) {
        this.year_egress = year_egress;
    }
}
