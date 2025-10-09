package AdministarSalas;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {

    private String nombre;
    private String codigoInstitucional;
    private String programaAcademico;
    private List<Reserva> reservas;

    public Estudiante() {
        this.reservas = new ArrayList<>();
    }

    public Estudiante(String nombre, String codigoInstitucional, String programaAcademico) {
        this.nombre = nombre;
        this.codigoInstitucional = codigoInstitucional;
        this.programaAcademico = programaAcademico;
        this.reservas = new ArrayList<>();
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCodigoInstitucional() { return codigoInstitucional; }

    public void setCodigoInstitucional(String codigoInstitucional) { this.codigoInstitucional = codigoInstitucional; }

    public String getProgramaAcademico() { return programaAcademico; }

    public void setProgramaAcademico(String programaAcademico) { this.programaAcademico = programaAcademico; }

    public List<Reserva> getReservas() { return reservas; }

    public void setReservas(List<Reserva> reservas) { this.reservas = reservas; }

    public List<Reserva> consultarHistorialReservas() { return reservas; }

    public void agregarEstudiante(Estudiante estudiante) { }
}
