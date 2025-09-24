package book;

public class Programa {
    public static void main(String[] args) {
        // Crear autor
        Author autor = new Author("Gabriel García Márquez", "gabo@example.com", 'm');

        // Crear libro con cantidad inicial
        Book libro = new Book("Cien Años de Soledad", autor, 120000.0, 50);

        System.out.println("Libro creado:");
        System.out.println(libro);

        // Modificar precio y cantidad
        libro.setPrice(135000.0);
        libro.setQty(60);

        System.out.println("\nLibro actualizado:");
        System.out.println(libro);

        // Acceder a información del autor desde el libro
        System.out.println("\nDetalles del autor:");
        System.out.println("Nombre: " + libro.getAuthor().getName());
        System.out.println("Email: " + libro.getAuthor().getEmail());
        System.out.println("Género: " + libro.getAuthor().getGender());
    }
}