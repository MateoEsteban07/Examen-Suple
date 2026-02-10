package BusinessLogic.Entities;

import BusinessLogic.Interfaces.IgmEntrenar;
import Infrastructure.gmCMD;

public class gmLeopardoGuamani extends gmLeopardo implements IgmEntrenar {

    public gmLeopardoGuamani() {
        super();
        this.gmMutado = true;
        // Despues de la mutacion, obtiene extremidad
        this.gmCola = new gmCola();
    }

    public gmLeopardoGuamani(String gmNombre, String gmEspecie, int gmEdad, String gmSexo) {
        super(gmNombre, gmEspecie, gmEdad, gmSexo);
        this.gmMutado = true;
        // Despues de la mutacion, obtiene extremidad
        this.gmCola = new gmCola();
    }

    // Req 8: 1 entrenamiento para ambas armas (Mateo termina en vocal)
  @Override
    public void gmEntrenar(gmArma1 gmArmaUno, gmArma2 gmArmaDos) {
        if (gmCola != null) {
            gmCola.gmSetArmaUno(gmArmaUno);
            gmCola.gmSetArmaDos(gmArmaDos);
            this.gmEntrenado = true;
            
            gmCMD.gmImprimir("GOOD : LeopardoGuamani " + gmNombre + " entrenado con exito.");
        } else {
            gmCMD.gmImprimir("ERROR: No se puede entrenar, no tiene extremidad (Cola).");
        }
    }

    @Override
    public void gmShow() {
        String gmInfo = "LeopardoGuamani: " + gmNombre
                + " | Especie: " + gmEspecie
                + " | Edad: " + gmEdad
                + " | Sexo: " + gmSexo
                + " | Extremidad: " + (gmCola != null ? "Si" : "No")
                + " | Entrenado: " + (gmEntrenado ? "Si" : "No")
                + " | Disparos: " + gmNumeroDisparos;
        gmCMD.gmImprimir(gmInfo);
    }

    @Override
    public String toString() {
        return "LeopardoGuamani[nombre=" + gmNombre + ", especie=" + gmEspecie
             + ", edad=" + gmEdad + ", sexo=" + gmSexo + "]";
    }
    
}
