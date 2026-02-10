package BusinessLogic.Entities;

// Req 3: Gen del MoleGen (XX o XY)
// Si usted es hombre → un Gen (XX o XY)
public class gmGen {
    private String gmTipo; // "XX" o "XY"

    public gmGen(String gmTipo) {
        this.gmTipo = gmTipo;
    }

    public String gmGetTipo() { return gmTipo; }
    public void   gmSetTipo(String gmTipo) { this.gmTipo = gmTipo; }

    @Override
    public String toString() {
        return "Gen[tipo=" + gmTipo + "]";
    }
}
