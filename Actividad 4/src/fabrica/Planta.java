package fabrica;
public class Planta {
    private String tamanoLlantasQueFabrica;
    private TipoLanta tipoLlantasQueFabrica;
    private double pesoChasisQueSueleFabricar;
    private Material materialQueUsa;
    private Color[] coloresQueSueleUtilizar;

    public Planta(String tamanoLlantasQueFabrica, TipoLanta tipoLlantasQueFabrica, double pesoChasisQueSueleFabricar, Material materialQueUsa, Color[] coloresQueSueleUtilizar) {
        this.tamanoLlantasQueFabrica = tamanoLlantasQueFabrica;
        this.tipoLlantasQueFabrica = tipoLlantasQueFabrica;
        this.pesoChasisQueSueleFabricar = pesoChasisQueSueleFabricar;
        this.materialQueUsa = materialQueUsa;
        this.coloresQueSueleUtilizar = coloresQueSueleUtilizar;
    }

    public String getTamanoLlantasQueFabrica() {
        return tamanoLlantasQueFabrica;
    }

    public void setTamanoLlantasQueFabrica(String tamanoLlantasQueFabrica) {
        this.tamanoLlantasQueFabrica = tamanoLlantasQueFabrica;
    }

    public TipoLanta getTipoLlantasQueFabrica() {
        return tipoLlantasQueFabrica;
    }

    public void setTipoLlantasQueFabrica(TipoLanta tipoLlantasQueFabrica) {
        this.tipoLlantasQueFabrica = tipoLlantasQueFabrica;
    }

    public double getPesoChasisQueSueleFabricar() {
        return pesoChasisQueSueleFabricar;
    }

    public void setPesoChasisQueSueleFabricar(double pesoChasisQueSueleFabricar) {
        this.pesoChasisQueSueleFabricar = pesoChasisQueSueleFabricar;
    }

    public Material getMaterialQueUsa() {
        return materialQueUsa;
    }

    public void setMaterialQueUsa(Material materialQueUsa) {
        this.materialQueUsa = materialQueUsa;
    }

    public Color[] getColoresQueSueleUtilizar() {
        return coloresQueSueleUtilizar;
    }

    public void setColoresQueSueleUtilizar(Color[] coloresQueSueleUtilizar) {
        this.coloresQueSueleUtilizar = coloresQueSueleUtilizar;
    }

    @Override
    public String toString() {
        return "Planta{tamanoLlantasQueFabrica='" + tamanoLlantasQueFabrica + "'}";
    }
}