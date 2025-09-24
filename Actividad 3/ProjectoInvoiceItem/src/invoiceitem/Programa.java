package invoiceitem;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Crear un ítem de factura de ejemplo
        InvoiceItem item = new InvoiceItem("A001", "Teclado mecánico", 2, 150_000.0);

        System.out.println("Item creado:");
        System.out.println(item);
        System.out.println("Total actual: " + item.getTotal());

        // Actualizar cantidad
        System.out.print("\nNueva cantidad: ");
        int nuevaQty = sc.nextInt();
        item.setQty(nuevaQty);

        // Actualizar precio unitario
        System.out.print("Nuevo precio unitario: ");
        double nuevoPrecio = sc.nextDouble();
        item.setUnitPrice(nuevoPrecio);

        // Mostrar resultado
        System.out.println("\nItem actualizado:");
        System.out.println(item);
        System.out.println("Nuevo total: " + item.getTotal());

        sc.close();
    }
}