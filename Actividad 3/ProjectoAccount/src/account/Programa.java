package account;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Crear dos cuentas
        Account cuenta1 = new Account("C001", "Juan Perez", 5000);
        Account cuenta2 = new Account("C002", "Maria Lopez", 2000);

        System.out.println("Estado inicial:");
        System.out.println(cuenta1);
        System.out.println(cuenta2);

        // Ingresar dinero a cuenta1
        System.out.print("\nIngrese cantidad a acreditar en cuenta1: ");
        int credito = sc.nextInt();
        cuenta1.credit(credito);
        System.out.println("Después del crédito: " + cuenta1);

        // Retirar dinero de cuenta1
        System.out.print("\nIngrese cantidad a debitar en cuenta1: ");
        int debito = sc.nextInt();
        cuenta1.debit(debito);
        System.out.println("Después del débito: " + cuenta1);

        // Transferencia de cuenta1 a cuenta2
        System.out.print("\nIngrese cantidad a transferir de cuenta1 a cuenta2: ");
        int transferir = sc.nextInt();
        cuenta1.transferTo(cuenta2, transferir);

        System.out.println("\nDespués de la transferencia:");
        System.out.println(cuenta1);
        System.out.println(cuenta2);

        sc.close();
    }
}