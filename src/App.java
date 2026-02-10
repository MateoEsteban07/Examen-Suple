import ConsoleApp.gmLogin;
import UserInterface.gmMutaGenoForm;
import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        // Req 1: Sistema inicia en consola solicitando autenticacion
        gmLogin gmLoginService = new gmLogin();

        if (gmLoginService.gmAutenticar()) {
            // Req 1: Si autenticacion valida → presenta interfaz grafica
            SwingUtilities.invokeLater(() -> {
                gmMutaGenoForm gmForm = new gmMutaGenoForm();
                gmForm.setVisible(true);
            });
        } else 
            System.exit(0);
        }
    }