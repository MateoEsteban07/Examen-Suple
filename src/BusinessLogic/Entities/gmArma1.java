package BusinessLogic.Entities;

import Infrastructure.gmCMD;

public class gmArma1 {
    public void gmUsar() {
        // Efecto de sonido visual para balas
        gmCMD.gmImprimir("GOOD : [ARMA 1] Disparo percutido! (PUM!) - Municion: Bala consumida.");
    }
}