package BusinessLogic.Interfaces;

import BusinessLogic.Entities.gmArma1;
import BusinessLogic.Entities.gmArma2;

// INTERFAZ PURA: Solo define QUÉ se hace, no CÓMO se hace.
public interface IgmEntrenar {
    // Solo la firma del metodo. 
    // No lleva 'public' explícito porque en interfaces ya lo es.
    void gmEntrenar(gmArma1 gmArmaUno, gmArma2 gmArmaDos);
}