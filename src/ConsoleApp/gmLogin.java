package ConsoleApp;

import DataAccess.DAO.gmUsuarioDAO;
import DataAccess.DTO.gmUsuarioDTO;
import Infrastructure.gmAppMSG;
import Infrastructure.gmCMD;
import Infrastructure.gmCMDInput;

// Req 1: Sistema inicia en consola solicitando autenticacion
// Cedula y clave, max 3 intentos, acceso: "patmic"/"1234"
public class gmLogin {
    private String gmNombreUsuario;
    private String gmCedulaUsuario;

    public boolean gmAutenticar() {
        int gmIntentos = 0;
        final int gmMAX_INTENTOS = 3;

        System.out.println("========================================");
        System.out.println("     GuamaniMutaGeno - Autenticacion    ");
        System.out.println("========================================");

        while (gmIntentos < gmMAX_INTENTOS) {
            String gmUser = gmCMDInput.gmLeerInput("Ingrese Cedula o Username: ");
            String gmPass = gmCMDInput.gmLeerInput("Ingrese Clave: ");

            gmUsuarioDAO gmDao = new gmUsuarioDAO();
            gmUsuarioDTO gmDto = gmDao.gmLogin(gmUser, gmPass);

            if (gmDto != null) {
                gmCMD.gmImprimir(gmAppMSG.gmMSG_LOGIN_EXITO);
                gmNombreUsuario = gmDto.gmGetNombre();
                gmCedulaUsuario = gmUser;
                return true;
            } else {
                gmCMD.gmImprimir(gmAppMSG.gmMSG_LOGIN_FALLO);
                gmIntentos++;
                System.out.println("Intentos restantes: " + (gmMAX_INTENTOS - gmIntentos));
            }
        }
        gmCMD.gmImprimir(gmAppMSG.gmMSG_MAX_INTENTOS);
        return false;
    }

    public String gmGetNombreUsuario() { return gmNombreUsuario; }
    public String gmGetCedulaUsuario() { return gmCedulaUsuario; }
}
