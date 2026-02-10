package BusinessLogic.Entities;

// Clase del Usuario Biologo segun diagrama de clases
// YanEntrenar → gmUsuarioBiologo
public class gmUsuarioBiologo {
    private String gmUsuario;
    private String gmClave;
    private String gmNombre;

    public gmUsuarioBiologo(String gmUsuario, String gmClave, String gmNombre) {
        this.gmUsuario = gmUsuario;
        this.gmClave   = gmClave;
        this.gmNombre  = gmNombre;
    }

    public String gmUsuario()   { return gmUsuario; }
    public String gmClave()     { return gmClave; }
    public String gmGetNombre() { return gmNombre; }

    // Metodo para obtener/autenticar usuario biologo
    public static gmUsuarioBiologo gmGetarUsuario(String gmUsuario, String gmClave) {
        if ("patmic".equals(gmUsuario) && "1234".equals(gmClave)) {
            return new gmUsuarioBiologo(gmUsuario, gmClave, "Patricio Michael");
        }
        return null;
    }

    @Override
    public String toString() {
        return "UsuarioBiologo[usuario=" + gmUsuario + ", nombre=" + gmNombre + "]";
    }
}
