package Inventario;

import java.util.Scanner;

public class InventarioSupermercado {

    public static final int MAX_PRODUCTOS = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String[] nombres = new String[MAX_PRODUCTOS];
        int[] cantidades = new int[MAX_PRODUCTOS];


        System.out.println("Menu De Registro De Productos");
        for (int i = 0; i < MAX_PRODUCTOS; i++) {
            System.out.println("Producto " + (i + 1) + ": ");
            nombres[i] = sc.nextLine();


            int cantidad;
            do {
                System.out.println("Cantidad disponible de " + nombres[i] + ": ");
                cantidad = sc.nextInt();
                if (cantidad < 0) {
                    System.out.println("La cantidad que ingrese no puede ser negativa.");
                }
            } while (cantidad < 0);
            cantidades[i] = cantidad;
            sc.nextLine(); 
        }


        int opcion = 0;
        while (opcion != 5) {
            System.out.println("Menu del inventario");
            System.out.println("1. Mostrar productos y existencias");
            System.out.println("2. Buscar producto por nombre y cantidad ");
            System.out.println("3. Actualizar inventario");
            System.out.println("4. alerta si el producto es menor a 10");
            System.out.println("5. Salir");
            System.out.print("seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1: 
                    int total = 0; 
                    System.out.println(" Inventario completo ");
                    for (int i = 0; i < MAX_PRODUCTOS; i++) {
                        System.out.println(nombres[i] + "  " + cantidades[i]);
                        total += cantidades[i];
                    }
                    System.out.println("Total de productos en inventario: " + total);
                    break;

                case 2: 
                    System.out.print("Ingrese el nombre del producto a buscar: ");
                    String buscado = sc.nextLine();
                    boolean encontrado = false;
                    for (int i = 0; i < MAX_PRODUCTOS; i++) {
                        if (nombres[i].equalsIgnoreCase(buscado)) {
                            System.out.println(" " + nombres[i] + " tiene " + cantidades[i] + " unidades.");
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Nombre del producto a actualizar: ");
                    String actualizar = sc.nextLine();
                    boolean existe = false;
                    for (int i = 0; i < MAX_PRODUCTOS; i++) {
                        if (nombres[i].equalsIgnoreCase(actualizar)) {
                            System.out.print("Cantidad a sumar (+) o restar (-): ");
                            int cambio = sc.nextInt();
                            sc.nextLine();
                            if (cantidades[i] + cambio < 0) {
                                System.out.println("No se puede tener cantidad negativa.");
                            } else {
                                cantidades[i] += cambio;
                                System.out.println("Nuevo ingreso de " + nombres[i] + ": " + cantidades[i]);
                            }
                            existe = true;
                        }
                    }
                    if (!existe) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Alertas de baja existencia (< 10)");
                    boolean alerta = false;
                    for (int i = 0; i < MAX_PRODUCTOS; i++) {
                        if (cantidades[i] < 10) {
                            System.out.println("alerta " + nombres[i] + cantidades[i] + " unidades.");
                            alerta = true;
                        }
                    }
                    if (!alerta) {
                        System.out.println("No hay productos con baja existencia.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }
        sc.close();
    }
}