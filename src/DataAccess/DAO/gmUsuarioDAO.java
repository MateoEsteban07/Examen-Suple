package DataAccess.DAO;

import DataAccess.DTO.gmUsuarioDTO;

public class gmUsuarioDAO {

    public gmUsuarioDTO gmLogin(String gmUsername, String gmPassword) {
        // Acceso por defecto: "patmic" / "patmic1234"
        if ("patmic".equals(gmUsername) && "1234".equals(gmPassword)) {
            return new gmUsuarioDTO(1, "Patricio Michael", "patmic", "1234");
        }
        return null;
    }
}
