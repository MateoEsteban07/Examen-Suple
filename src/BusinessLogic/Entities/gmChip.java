package BusinessLogic.Entities;

// Req 3: Chip del MoleGen con IdChip
public class gmChip {
    private String gmIdChip;

    public gmChip(String gmIdChip) {
        this.gmIdChip = gmIdChip;
    }

    public String gmGetIdChip() { return gmIdChip; }
    public void   gmSetIdChip(String gmIdChip) { this.gmIdChip = gmIdChip; }

    @Override
    public String toString() {
        return "Chip[idChip=" + gmIdChip + "]";
    }
}
