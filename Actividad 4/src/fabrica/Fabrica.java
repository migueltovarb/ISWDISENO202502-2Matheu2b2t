package fabrica;
public class Fabrica {
    private String nombre;
    private Planta[] plantas;

    public Fabrica(String nombre, Planta[] plantas) {
        this.nombre = nombre;
        this.plantas = plantas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Planta[] getPlantas() {
        return plantas;
    }

    public void setPlantas(Planta[] plantas) {
        this.plantas = plantas;
    }

    public Carro fabricarCarro(Color color) {
        // Lógica para fabricar un carro
        return new Carro(color);
    }

    @Override
    public String toString() {
        return "Fabrica{nombre='" + nombre + "'}";
    }
}