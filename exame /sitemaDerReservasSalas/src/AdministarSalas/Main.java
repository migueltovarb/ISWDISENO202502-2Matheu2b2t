package AdministarSalas;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    private static final Map<String, Estudiante> ESTUDIANTES = new HashMap<>();
    private static final Scanner SC = new Scanner(System.in);
    private static final SimpleDateFormat DF = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n=== Sistema de Reserva de Salas de Estudio ===");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Registrar sala");
            System.out.println("3. Mostrar salas disponibles");
            System.out.println("4. Reservar sala");
            System.out.println("5. Ver historial de reservas de un estudiante");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            String op = SC.nextLine().trim();
            switch (op) {
                case "1": registrarEstudiante(); break;
                case "2": registrarSala(); break;
                case "3": mostrarSalasDisponibles(); break;
                case "4": reservarSala(); break;
                case "5": verHistorial(); break;
                case "0": salir = true; break;
                default: System.out.println("Opción inválida.");
            }
        }
        System.out.println("¡Hasta luego!");
    }

    private static void registrarEstudiante() {
        System.out.print("Nombre: ");
        String nombre = SC.nextLine().trim();
        System.out.print("Código institucional: ");
        String codigo = SC.nextLine().trim();
        System.out.print("Programa académico: ");
        String programa = SC.nextLine().trim();

        if (nombre.isBlank() || codigo.isBlank() || programa.isBlank()) {
            System.out.println("No se permiten campos vacíos.");
            return;
        }
        if (ESTUDIANTES.containsKey(codigo)) {
            System.out.println("Ya existe un estudiante con ese código.");
            return;
        }
        Estudiante e = new Estudiante(nombre, codigo, programa);
        ESTUDIANTES.put(codigo, e);
        System.out.println("Estudiante registrado.");
    }

    private static void registrarSala() {
        try {
            System.out.print("Número de sala (int): ");
            int numero = Integer.parseInt(SC.nextLine().trim());
            System.out.print("Capacidad máxima (int): ");
            int cap = Integer.parseInt(SC.nextLine().trim());
            System.out.print("¿Disponible? (true/false): ");
            boolean disp = Boolean.parseBoolean(SC.nextLine().trim());

            SalaEstudio sala = new SalaEstudio(numero, cap, disp);
            sala.agregarSala(sala);
            System.out.println("Sala registrada.");
        } catch (NumberFormatException ex) {
            System.out.println("Datos numéricos inválidos.");
        }
    }

    private static void mostrarSalasDisponibles() {
        SalaEstudio helper = new SalaEstudio();
        List<SalaEstudio> disponibles = helper.mostrarSalasDisponibles();
        if (disponibles.isEmpty()) {
            System.out.println("No hay salas disponibles.");
        } else {
            System.out.println("Salas disponibles:");
            for (SalaEstudio s : disponibles) {
                System.out.println(" - Sala #" + s.getNumeroSala()
                        + " (capacidad " + s.getCapacidadMaxima() + ")");
            }
        }
    }

    private static void reservarSala() {
        try {
            System.out.print("Código institucional del estudiante: ");
            String codigo = SC.nextLine().trim();
            Estudiante est = ESTUDIANTES.get(codigo);
            if (est == null) {
                System.out.println("Estudiante no encontrado.");
                return;
            }

            System.out.print("Número de sala a reservar: ");
            int numSala = Integer.parseInt(SC.nextLine().trim());

            SalaEstudio sala = null;
            for (SalaEstudio s : SalaEstudio.getRepositorioSalas()) {
                if (s.getNumeroSala() == numSala) {
                    sala = s;
                    break;
                }
            }

            if (sala == null) {
                System.out.println("Sala no encontrada.");
                return;
            }
            if (!sala.getDisponibilidad()) {
                System.out.println("La sala no está disponible (no operativa).");
                return;
            }

            System.out.print("Fecha (yyyy-MM-dd): ");
            Date fecha = DF.parse(SC.nextLine().trim());

            System.out.print("Hora (HH:mm): ");
            String horaTxt = SC.nextLine().trim();
            if (horaTxt.length() == 5) horaTxt = horaTxt + ":00";
            Time hora = Time.valueOf(horaTxt);

            Reserva r = sala.reservarSala(est, fecha, hora);
            if (r == null) {
                System.out.println("No se pudo reservar. Posibles causas:");
                System.out.println("- El estudiante ya tiene una reserva en ese horario");
                System.out.println("- La sala ya está reservada en ese horario");
                System.out.println("- Campos inválidos");
            } else {
                System.out.println(" Reserva creada exitosamente!");
                System.out.println("Sala #" + sala.getNumeroSala()
                        + " | Fecha " + DF.format(fecha) + " | Hora " + hora.toString().substring(0, 5));
            }
        } catch (ParseException pe) {
            System.out.println("Formato de fecha inválido. Use yyyy-MM-dd.");
        } catch (IllegalArgumentException iae) {
            System.out.println("Formato de hora inválido. Use HH:mm (ej: 14:30).");
        }
    }

    private static void verHistorial() {
        System.out.print("Código institucional del estudiante: ");
        String codigo = SC.nextLine().trim();
        Estudiante est = ESTUDIANTES.get(codigo);
        if (est == null) {
            System.out.println("Estudiante no encontrado.");
            return;
        }
        List<Reserva> hist = est.consultarHistorialReservas();
        if (hist == null || hist.isEmpty()) {
            System.out.println("Sin reservas.");
            return;
        }
        System.out.println("Historial de reservas:");
        for (Reserva r : hist) {
            System.out.println(" - Sala #" + r.getSalaReservada().getNumeroSala()
                    + " | " + DF.format(r.getFecha()) + " " + r.getHora().toString().substring(0, 5));
        }
    }
}