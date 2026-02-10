package Infrastructure;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class gmCMD {
    private static final String gmTRACER_FILE = gmAppConfig.gmPATH_TRACER;

    // Colores para la terminal de VS Code
    private static final String gmANSI_RESET  = "\u001B[0m";
    private static final String gmANSI_RED    = "\u001B[31m";
    private static final String gmANSI_BLUE   = "\u001B[34m";
    private static final String gmANSI_GREEN  = "\u001B[32m";

    public static void gmImprimir(String gmMensaje) {
        String gmTimestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String gmFullMsg = "[" + gmTimestamp + "] " + gmMensaje;

        // 1. IMPRIMIR EN TERMINAL VS CODE (Tracer visible en el editor)
        if (gmMensaje.contains("GOOD")) {
            System.out.println(gmANSI_BLUE + gmFullMsg + gmANSI_RESET);
        } else if (gmMensaje.contains("ERROR")) {
            System.out.println(gmANSI_RED + gmFullMsg + gmANSI_RESET);
        } else {
            System.out.println(gmANSI_GREEN + gmFullMsg + gmANSI_RESET);
        }

        // 2. Guardar en archivo (Req 10)
        gmGuardarEnArchivo(gmFullMsg);
    }

    private static void gmGuardarEnArchivo(String gmMensaje) {
        try (FileWriter gmFw = new FileWriter(gmTRACER_FILE, true);
             PrintWriter gmPw = new PrintWriter(gmFw)) {
            gmPw.println(gmMensaje);
        } catch (IOException e) {
            System.err.println("Error escribiendo archivo: " + e.getMessage());
        }
    }
}