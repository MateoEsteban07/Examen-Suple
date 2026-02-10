package Infrastructure;

public class gmAppConfig {
    public static final String gmPATH_MUNISION;
    public static final String gmPATH_TRACER;

    static {
        java.util.Properties gmProps = new java.util.Properties();
        try (java.io.FileInputStream gmFis = new java.io.FileInputStream("app.properties")) {
            gmProps.load(gmFis);
        } catch (java.io.IOException e) {
            
        }

        String gmMunPath = gmProps.getProperty("gmPATH_MUNISION", "src/Storage/DataFiles/Munision.txt");
        if (!new java.io.File(gmMunPath).exists()) {
            if (new java.io.File("Storage/DataFiles/Munision.txt").exists()) {
                gmMunPath = "Storage/DataFiles/Munision.txt";
            }
        }
        gmPATH_MUNISION = gmMunPath;

        String gmTracerPath = gmProps.getProperty("gmPATH_TRACER", "src/Storage/DataFiles/MutaGenoTracer.txt");
        if (!new java.io.File(gmTracerPath).exists()) {
            if (new java.io.File("Storage/DataFiles/MutaGenoTracer.txt").exists()) {
                gmTracerPath = "Storage/DataFiles/MutaGenoTracer.txt";
            }
        }
        gmPATH_TRACER = gmTracerPath;
    }
}
