package DataAccess.DTO;

public class gmUsuarioDTO {
    private int    gmIdUsuario;
    private String gmNombre;
    private String gmUsername;
    private String gmPassword;

    public gmUsuarioDTO() {}

    public gmUsuarioDTO(int gmIdUsuario, String gmNombre, String gmUsername, String gmPassword) {
        this.gmIdUsuario = gmIdUsuario;
        this.gmNombre    = gmNombre;
        this.gmUsername   = gmUsername;
        this.gmPassword   = gmPassword;
    }

    public int    gmGetIdUsuario() { return gmIdUsuario; }
    public void   gmSetIdUsuario(int gmIdUsuario) { this.gmIdUsuario = gmIdUsuario; }
    public String gmGetNombre()    { return gmNombre; }
    public void   gmSetNombre(String gmNombre) { this.gmNombre = gmNombre; }
    public String gmGetUsername()   { return gmUsername; }
    public void   gmSetUsername(String gmUsername) { this.gmUsername = gmUsername; }
    public String gmGetPassword()  { return gmPassword; }
    public void   gmSetPassword(String gmPassword) { this.gmPassword = gmPassword; }
}
