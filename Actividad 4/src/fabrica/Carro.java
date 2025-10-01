package fabrica;
public class Carro {
    private Color color;
    private Llantas llantas;
    private Chasis chasis;

    public Carro(Color color) {
        this.color = color;
        this.llantas = new Llantas();
        this.chasis = new Chasis();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Llantas getLlantas() {
        return llantas;
    }

    public void setLlantas(Llantas llantas) {
        this.llantas = llantas;
    }

    public Chasis getChasis() {
        return chasis;
    }

    public void setChasis(Chasis chasis) {
        this.chasis = chasis;
    }

    @Override
    public String toString() {
        return "Carro{color=" + color + "}";
    }
}