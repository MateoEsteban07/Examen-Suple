package BusinessLogic.Entities;

import Infrastructure.gmCMD;


public class gmTanqueMutacion {
    private static gmTanqueMutacion gmInstancia;

    // Constructor privado (Singleton)
    private gmTanqueMutacion() {}

    // Obtener instancia unica
    public static gmTanqueMutacion gmInstance() {
        if (gmInstancia == null) {
            gmInstancia = new gmTanqueMutacion();
        }
        return gmInstancia;
    }

    // Req 4: Mutar animal. Cedula par (1753251916, ultimo digito 6)
    // e. Si IdChip es par y gen es XX → genero "Hembra"
    //    Caso contrario no muta y retorna el Animal sin cambios
    public gmLeopardo gmMutar(gmLeopardo gmLeopardo, gmMoleGen gmMoleGen) {
        try {
            int gmIdChipVal = Integer.parseInt(gmMoleGen.gmGetChip().gmGetIdChip());
            String gmGenTipo = gmMoleGen.gmGetGen().gmGetTipo();

            if (gmIdChipVal % 2 == 0 && "XX".equals(gmGenTipo)) {
                // Mutacion exitosa → LeopardoGuamani con genero "Hembra"
                gmLeopardoGuamani gmMutado = new gmLeopardoGuamani(
                    gmLeopardo.gmGetNombre(),
                    gmLeopardo.gmGetEspecie(),
                    gmLeopardo.gmGetEdad(),
                    "Hembra"
                );
                gmCMD.gmImprimir("GOOD : Mutacion exitosa. " + gmLeopardo.gmGetNombre()
                    + " → LeopardoGuamani (Hembra). IdChip=" + gmIdChipVal + " Gen=" + gmGenTipo);
                return gmMutado;
            } else {
                // No muta, retorna sin cambios
                gmCMD.gmImprimir("ERROR: Mutacion fallida. IdChip=" + gmIdChipVal
                    + " Gen=" + gmGenTipo + ". Requiere IdChip par y Gen XX. Sin cambios.");
                return gmLeopardo;
            }
        } catch (NumberFormatException e) {
            gmCMD.gmImprimir("ERROR: IdChip no valido. Debe ser un numero.");
            return gmLeopardo;
        }
    }
}
