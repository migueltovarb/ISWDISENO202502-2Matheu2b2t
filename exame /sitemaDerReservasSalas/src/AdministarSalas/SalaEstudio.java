package AdministarSalas;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalaEstudio {

    private static final List<SalaEstudio> REPOSITORIO_SALAS = new ArrayList<>();

    private int numeroSala;
    private int capacidadMaxima;
    private boolean disponibilidad;
    private List<Reserva> reservas;

    public SalaEstudio() {
        this.reservas = new ArrayList<>();
    }

    public SalaEstudio(int numeroSala, int capacidadMaxima, boolean disponibilidad) {
        this.numeroSala = numeroSala;
        this.capacidadMaxima = capacidadMaxima;
        this.disponibilidad = disponibilidad;
        this.reservas = new ArrayList<>();
    }

    public int getNumeroSala() { return numeroSala; }

    public void setNumeroSala(int numeroSala) { this.numeroSala = numeroSala; }

    public int getCapacidadMaxima() { return capacidadMaxima; }

    public void setCapacidadMaxima(int capacidadMaxima) { this.capacidadMaxima = capacidadMaxima; }

    public boolean getDisponibilidad() { return disponibilidad; }

    public void setDisponibilidad(boolean disponibilidad) { this.disponibilidad = disponibilidad; }

    public List<SalaEstudio> mostrarSalasDisponibles() {
        List<SalaEstudio> disponibles = new ArrayList<>();
        for (SalaEstudio s : REPOSITORIO_SALAS) {
            if (s.getDisponibilidad()) disponibles.add(s);
        }
        return disponibles;
    }

    public void agregarSala(SalaEstudio sala) {
        if (sala == null) return;
        for (SalaEstudio s : REPOSITORIO_SALAS) {
            if (s.getNumeroSala() == sala.getNumeroSala()) return;
        }
        REPOSITORIO_SALAS.add(sala);
    }

    public Reserva reservarSala(Estudiante estudiante, Date fecha, Time hora) {
        if (!this.disponibilidad) return null;
        if (estudiante == null || fecha == null || hora == null) return null;


        for (Reserva rEst : estudiante.getReservas()) {
            if (rEst.getFecha().equals(fecha) && rEst.getHora().equals(hora)) {
                return null;
            }
        }


        for (Reserva r : reservas) {
            if (r.getFecha().equals(fecha) && r.getHora().equals(hora)) {
                return null; 
            }
        }

        Reserva nueva = new Reserva(estudiante, this, fecha, hora);
        if (!nueva.validarReserva()) return null;

        this.reservas.add(nueva);
        estudiante.getReservas().add(nueva);
        return nueva;
    }

    public static List<SalaEstudio> getRepositorioSalas() { return REPOSITORIO_SALAS; }
    public List<Reserva> getReservasInternas() { return reservas; }
}