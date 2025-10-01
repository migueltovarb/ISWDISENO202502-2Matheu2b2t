package fabrica;
public class Chasis {
    private double peso;
    private Material material;

    public Chasis() {
        this.peso = 500.0; // Valor por defecto
        this.material = Material.ACERO; // Valor por defecto
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Chasis{peso=" + peso + ", material=" + material + "}";
    }
}