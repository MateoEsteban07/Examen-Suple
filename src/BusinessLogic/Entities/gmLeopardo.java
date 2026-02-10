package BusinessLogic.Entities;

import BusinessLogic.Interfaces.gmIMadre;
import BusinessLogic.Interfaces.gmIPadre;
import BusinessLogic.Interfaces.gmIDisparar; 
import Infrastructure.gmCMD;

public class gmLeopardo implements gmIPadre, gmIMadre, gmIDisparar {
    protected String gmNombre;
    protected String gmEspecie;
    protected int    gmEdad;
    protected String gmSexo;
    
    // Atributos específicos
    protected gmCola gmCola;        
    protected boolean gmEntrenado;  
    protected int    gmNumeroDisparos;
    protected boolean gmMutado;

    // Constructor Vacio
    public gmLeopardo() {
        this.gmNombre        = "";
        this.gmEspecie       = "";
        this.gmEdad          = 0;
        this.gmSexo          = "";
        this.gmCola          = null; 
        this.gmEntrenado     = false;
        this.gmNumeroDisparos = 0;
        this.gmMutado        = false;
    }

    // Constructor con Parametros
    public gmLeopardo(String gmNombre, String gmEspecie, int gmEdad, String gmSexo) {
        this.gmNombre        = gmNombre;
        this.gmEspecie       = gmEspecie;
        this.gmEdad          = gmEdad;
        this.gmSexo          = gmSexo;
        this.gmCola          = null; 
        this.gmEntrenado     = false;
        this.gmNumeroDisparos = 0;
        this.gmMutado        = false;
    }

    // --- MÉTODO ESPECIAL: Crecimiento de Cola (Lógica del Profesor) ---
    public void gmCrecerCola() {
        if (this.gmCola == null) {
            this.gmCola = new gmCola();
            
            // Instinto: Al crecer la cola, obtiene armas básicas automáticamente
            this.gmCola.gmSetArmaUno(new gmArma1());
            this.gmCola.gmSetArmaDos(new gmArma2());
            
            gmCMD.gmImprimir("INFO: A " + gmNombre + " le ha crecido la cola y obtiene armas por instinto.");
        }
    }

    // --- IMPLEMENTACIÓN DE gmIPadre ---
    @Override
    public void gmShow() {
        String gmInfo = "Leopardo: " + gmNombre
                + " | Especie: " + gmEspecie
                + " | Edad: " + gmEdad
                + " | Sexo: " + gmSexo
                + " | Extremidad: " + (gmCola != null ? "Si" : "No")
                + " | Entrenado: " + (gmEntrenado ? "Si" : "No")
                + " | Disparos: " + gmNumeroDisparos;
        gmCMD.gmImprimir(gmInfo);
    }

    // --- IMPLEMENTACIÓN DE gmIMadre ---
    @Override
    public String toString() {
        return "Leopardo[nombre=" + gmNombre + ", especie=" + gmEspecie
             + ", edad=" + gmEdad + ", sexo=" + gmSexo + "]";
    }

    // --- IMPLEMENTACIÓN DE gmIDisparar ---
    @Override
    public void gmDisparar(String gmTipoMunicion) {
        
        // 1. Validar si tiene cola
        if (gmCola == null) {
             gmCMD.gmImprimir("ERROR: " + gmNombre + " no tiene cola. (Intente hacerla crecer primero).");
             return;
        }

        // 2. Disparar (Sin verificar entrenamiento, solo necesita la cola)
        gmCola.gmDisparar(gmTipoMunicion);
        
        // 3. Registrar estadística
        gmNumeroDisparos++;
        gmCMD.gmImprimir("INFO : " + gmNombre + " disparo exitoso. (Total: " + gmNumeroDisparos + ")");
    }

    // Getters y Setters
    public String gmGetNombre()  { return gmNombre; }
    public void   gmSetNombre(String n) { this.gmNombre = n; }
    public String gmGetEspecie() { return gmEspecie; }
    public void   gmSetEspecie(String e) { this.gmEspecie = e; }
    public int    gmGetEdad()    { return gmEdad; }
    public void   gmSetEdad(int e) { this.gmEdad = e; }
    public String gmGetSexo()    { return gmSexo; }
    public void   gmSetSexo(String s) { this.gmSexo = s; }
    
    public gmCola gmGetExtremidad() { return gmCola; }
    public void   gmSetExtremidad(gmCola c) { this.gmCola = c; }
    public boolean gmIsEntrenado() { return gmEntrenado; }
    public void   gmSetEntrenado(boolean e) { this.gmEntrenado = e; }
    public int    gmGetNumeroDisparos() { return gmNumeroDisparos; }
    public void   gmSetNumeroDisparos(int n) { this.gmNumeroDisparos = n; }
    public boolean gmIsMutado() { return gmMutado; }
    public void   gmSetMutado(boolean m) { this.gmMutado = m; }
}