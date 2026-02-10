package DataAccess;

import Infrastructure.gmAppConfig;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class gmDataFileHelper {
    private static final String gmFILE_PATH = gmAppConfig.gmPATH_MUNISION;
    private static List<String> gmMuniciones = null;
    private static int gmIndice = 0;

    private static void gmCargarMuniciones() {
        if (gmMuniciones == null) {
            gmMuniciones = new ArrayList<>();
            try (BufferedReader gmBr = new BufferedReader(new FileReader(gmFILE_PATH))) {
                String gmLine;
                while ((gmLine = gmBr.readLine()) != null) {
                    String gmTrimmed = gmLine.trim();
                    if (!gmTrimmed.isEmpty()) {
                        gmMuniciones.add(gmTrimmed);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error leyendo Munision.txt: " + e.getMessage());
            }
        }
    }

    public static String gmObtenerMunicion() {
        gmCargarMuniciones();
        if (gmMuniciones == null || gmMuniciones.isEmpty()) {
            return "SinMunicion";
        }
        if (gmIndice >= gmMuniciones.size()) {
            gmIndice = 0;
        }
        String gmMunicion = gmMuniciones.get(gmIndice);
        gmIndice++;
        return gmMunicion;
    }

    public static void gmResetIndice() {
        gmIndice = 0;
    }
}
