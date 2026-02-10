package BusinessLogic.Entities;


public abstract class gmMunicion {
    protected String gmTipoMunicion;

    public gmMunicion(String gmTipoMunicion) {
        this.gmTipoMunicion = gmTipoMunicion;
    }

    public String gmGetTipoMunicion() { return gmTipoMunicion; }
    public void   gmSetTipoMunicion(String gmTipoMunicion) { this.gmTipoMunicion = gmTipoMunicion; }

    @Override
    public String toString() {
        return gmTipoMunicion;
    }
}
