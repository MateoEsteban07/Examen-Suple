package BusinessLogic.Entities;

import Infrastructure.gmCMD;

public class gmCola {
    // Las dos armas que sostiene la cola
    private gmArma1 gmArmaUno;
    private gmArma2 gmArmaDos;

    // Métodos para cargar las armas (se llaman desde gmLeopardoGuamani)
    public void gmSetArmaUno(gmArma1 arma) { this.gmArmaUno = arma; }
    public void gmSetArmaDos(gmArma2 arma) { this.gmArmaDos = arma; }

    // LÓGICA DE DISPARO SELECTIVO
    public void gmDisparar(String gmMunicion) {
        // 1. Validar que las armas existan
        if (gmArmaUno == null || gmArmaDos == null) {
            gmCMD.gmImprimir("ERROR: La cola no tiene armas cargadas para disparar.");
            return;
        }

        // 2. Enrutar según el tipo de munición (Ignoramos mayúsculas/minúsculas)
        if (gmMunicion.equalsIgnoreCase("Bala")) {
            // Munición física -> Usa Arma 1
            gmArmaUno.gmUsar(); 
        } 
        else if (gmMunicion.equalsIgnoreCase("Energia") || gmMunicion.equalsIgnoreCase("Energy")) {
            // Munición de energía -> Usa Arma 2
            gmArmaDos.gmUsar(); 
        } 
        else {
            // Si llega algo desconocido (o "SinMunicion")
            gmCMD.gmImprimir("ERROR: Municion desconocida o agotada (" + gmMunicion + ") - No se disparó.");
        }
    }
}