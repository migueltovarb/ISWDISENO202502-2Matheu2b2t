package author;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Crear un autor con datos iniciales
        Author autor = new Author("Gabriel Garcia", "gabriel@example.com", 'm');

        System.out.println("Autor creado:");
        System.out.println(autor);

        // Modificar email
        System.out.print("\nIngrese un nuevo email para el autor: ");
        String nuevoEmail = sc.nextLine();
        autor.setEmail(nuevoEmail);

        System.out.println("\nAutor actualizado:");
        System.out.println(autor);

        // Mostrar datos individuales
        System.out.println("\nNombre: " + autor.getName());
        System.out.println("Email: " + autor.getEmail());
        System.out.println("Género: " + autor.getGender());

        sc.close();
    }
}