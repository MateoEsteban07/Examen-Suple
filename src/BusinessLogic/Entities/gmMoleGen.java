package BusinessLogic.Entities;

// Req 3: Molecula sintetica MoleGen = Chip + Gen
// Si usted es hombre → un Gen (XX o XY)
public class gmMoleGen {
    private gmChip gmChip;
    private gmGen  gmGen;

    public gmMoleGen(gmChip gmChip, gmGen gmGen) {
        this.gmChip = gmChip;
        this.gmGen  = gmGen;
    }

    public gmChip gmGetChip() { return gmChip; }
    public void   gmSetChip(gmChip gmChip) { this.gmChip = gmChip; }
    public gmGen  gmGetGen()  { return gmGen; }
    public void   gmSetGen(gmGen gmGen) { this.gmGen = gmGen; }

    @Override
    public String toString() {
        return "MoleGen[chip=" + gmChip + ", gen=" + gmGen + "]";
    }
}
