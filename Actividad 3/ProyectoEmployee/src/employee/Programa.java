package employee;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        // Crear un empleado con valores iniciales
        Employee emp = new Employee(1, "Juan", "Perez", 2000);
        
        System.out.println("Empleado creado:");
        System.out.println(emp);
        
        // Cambiar salario
        System.out.println("\nIngrese el nuevo salario del empleado:");
        int nuevoSalario = scanner.nextInt();
        emp.setSalary(nuevoSalario);
        
        System.out.println("Empleado actualizado:");
        System.out.println(emp);
        
        // Mostrar salario anual
        System.out.println("Salario anual: " + emp.getAnnualSalary());
        
        // Aumentar salario
        System.out.println("\nIngrese el porcentaje de aumento:");
        int porcentaje = scanner.nextInt();
        emp.raiseSalary(porcentaje);
        
        System.out.println("Empleado después del aumento:");
        System.out.println(emp);
        
        scanner.close();
    }
}