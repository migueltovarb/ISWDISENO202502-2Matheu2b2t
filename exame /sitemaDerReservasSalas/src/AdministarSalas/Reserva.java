package AdministarSalas;

import java.util.Date;
import java.sql.Time;

public class Reserva {

    private Estudiante estudiante;
    private SalaEstudio salaReservada;
    private Date fecha;
    private Time hora;

    public Reserva() { }

    public Reserva(Estudiante estudiante, SalaEstudio salaReservada, Date fecha, Time hora) {
        this.estudiante = estudiante;
        this.salaReservada = salaReservada;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Estudiante getEstudiante() { return estudiante; }

    public void setEstudiante(Estudiante estudiante) { this.estudiante = estudiante; }

    public SalaEstudio getSalaReservada() { return salaReservada; }

    public void setSalaReservada(SalaEstudio salaReservada) { this.salaReservada = salaReservada; }

    public Date getFecha() { return fecha; }

    public void setFecha(Date fecha) { this.fecha = fecha; }

    public Time getHora() { return hora; }

    public void setHora(Time hora) { this.hora = hora; }

    public boolean validarReserva() {
        if (estudiante == null || salaReservada == null || fecha == null || hora == null) return false;
        if (estudiante.getNombre() == null || estudiante.getNombre().isBlank()) return false;
        if (estudiante.getCodigoInstitucional() == null || estudiante.getCodigoInstitucional().isBlank()) return false;
        if (estudiante.getProgramaAcademico() == null || estudiante.getProgramaAcademico().isBlank()) return false;
        return true;
    }
}