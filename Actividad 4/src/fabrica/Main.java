package fabrica;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        // Crear una planta y la fábrica (igual que tu ejemplo)
        Planta planta1 = new Planta(
                "R16",
                TipoLanta.CARRETERA,   // Mantengo tu enum tal como lo tienes
                500.0,
                Material.ACERO,
                new Color[]{Color.ROJO, Color.AZUL}
        );
        Fabrica fabrica = new Fabrica("Fabrica de Autos", new Planta[]{planta1});

        // Mostrar opciones válidas
        System.out.println("Colores disponibles: " + Arrays.toString(Color.values()));
        Color color = null;

        // Bucle simple hasta que el usuario ingrese un color válido
        while (color == null) {
            System.out.print("Ingrese el color del carro: ");
            String entrada = scanner.nextLine().trim().toUpperCase(Locale.ROOT);
            try {
                color = Color.valueOf(entrada);
            } catch (IllegalArgumentException ex) {
                System.out.println("Color inválido. Intente de nuevo. Opciones: " + Arrays.toString(Color.values()));
            }
        }

        // Fabricar el carro
        Carro carro = fabrica.fabricarCarro(color);
        System.out.println("Carro fabricado: " + carro);

        scanner.close();
    }
}