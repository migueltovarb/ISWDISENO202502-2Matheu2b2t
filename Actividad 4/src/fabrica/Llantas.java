package fabrica;
public class Llantas {
    private String tamano;
    private TipoLanta tipo;

    public Llantas() {
        this.tamano = "R16"; // Valor por defecto
        this.tipo = TipoLanta.CARRETERA; // Valor por defecto
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public TipoLanta getTipo() {
        return tipo;
    }

    public void setTipo(TipoLanta tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Llantas{tamano='" + tamano + "', tipo=" + tipo + "}";
    }
}