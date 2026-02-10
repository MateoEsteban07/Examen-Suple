package UserInterface;

import BusinessLogic.Entities.*;
import BusinessLogic.Interfaces.IgmEntrenar;
import Infrastructure.gmCMD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// Req 9: Grupos de estudio de 5 animales en grilla
public class gmMutaGenoForm extends JFrame {
    // Componentes de la UI
    private JTextField         gmTxtTipoAnimal;   // NUEVO: Caja fija "Leopardo"
    private JTextField         gmTxtNombreAnimal; // Caja nombre "MutaGeno"
    private JTable             gmTable;
    private DefaultTableModel  gmTableModel;
    private JButton            gmBtnCrear;
    private JButton            gmBtnMutar;
    private JButton            gmBtnEntrenar;
    private JButton            gmBtnDisparar;

    // Datos
    private List<gmLeopardo>   gmListaAnimales;
    private int                gmContadorGrupo = 0;

    public gmMutaGenoForm() {
        gmListaAnimales = new ArrayList<>();

        setTitle("GuamaniMutaGeno");
        setSize(680, 600); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // ==========================================
        // PANEL SUPERIOR: Seccion Alumno (Req 1)
        // ==========================================
        JPanel gmTopPanel = new JPanel();
        gmTopPanel.setLayout(new BoxLayout(gmTopPanel, BoxLayout.Y_AXIS));
        gmTopPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));

        JLabel gmLblHeader = new JLabel("Sistema GuamaniMutaGeno:");
        gmLblHeader.setFont(new Font("SansSerif", Font.BOLD, 14));
        gmTopPanel.add(gmLblHeader);

        JPanel gmStudentPanel = new JPanel(new GridLayout(2, 2));
        gmStudentPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        gmStudentPanel.setBackground(Color.WHITE);
        gmStudentPanel.add(new JLabel("  Cedula: 1753251816"));
        gmStudentPanel.add(new JLabel("  Nombre: Mateo Guamani"));
        
        gmTopPanel.add(gmStudentPanel);
        add(gmTopPanel, BorderLayout.NORTH);

        // ==========================================
        // PANEL CENTRAL: Creacion + Tabla (Req 9)
        // ==========================================
        JPanel gmCenterPanel = new JPanel(new BorderLayout(5, 5));
        gmCenterPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        // --- PANEL DE CREACIÓN MODIFICADO ---
        JPanel gmCreatePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 5));
        gmCreatePanel.setBorder(BorderFactory.createTitledBorder("Crear Grupo"));

        // 1. Caja Fija "Leopardo" (Solo lectura)
        gmCreatePanel.add(new JLabel("Tipo:"));
        gmTxtTipoAnimal = new JTextField("Leopardo", 8);
        gmTxtTipoAnimal.setEditable(false); // No se puede escribir
        gmTxtTipoAnimal.setBackground(new Color(230, 230, 230)); // Grisaseo para indicar disabled
        gmCreatePanel.add(gmTxtTipoAnimal);

        // 2. Caja Nombre (Por defecto "MutaGeno")
        gmCreatePanel.add(new JLabel("Nombre:"));
        gmTxtNombreAnimal = new JTextField("Leopardo 1", 10); // Texto por defecto
        gmCreatePanel.add(gmTxtNombreAnimal);

        gmBtnCrear = new JButton("Crear");
        gmBtnCrear.setBackground(new Color(60, 179, 113));
        gmBtnCrear.setForeground(Color.WHITE);
        gmCreatePanel.add(gmBtnCrear);

        gmCenterPanel.add(gmCreatePanel, BorderLayout.NORTH);

        // --- TABLA MODIFICADA ---
        // Columnas nuevas: Animal (Nombre) | Mutado (Si/No) | Entrenado | Disparos
        String[] gmColNames = {"Animal", "Mutado", "Entrenado", "N\u00B0 Disparos"};
        
        gmTableModel = new DefaultTableModel(gmColNames, 0) {
            @Override
            public boolean isCellEditable(int row, int col) { return false; }
        };
        gmTable = new JTable(gmTableModel);
        gmTable.setRowHeight(25);
        gmTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Listener para Debug en VSCode
        gmTable.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting() && gmTable.getSelectedRow() != -1) {
                int fila = gmTable.getSelectedRow();
                // Ahora el nombre está en la columna 0
                String nombre = gmTable.getValueAt(fila, 0).toString();
                System.out.println(">> [VSCODE] Seleccionaste: " + nombre);
            }
        });

        JTableHeader gmHeader = gmTable.getTableHeader();
        gmHeader.setBackground(new Color(2, 48, 32));
        gmHeader.setForeground(Color.WHITE);
        
        gmCenterPanel.add(new JScrollPane(gmTable), BorderLayout.CENTER);
        add(gmCenterPanel, BorderLayout.CENTER);

        // ==========================================
        // PANEL INFERIOR: Botones
        // ==========================================
        JPanel gmBottomPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        gmBottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        gmBtnMutar = new JButton("Mutar");
        gmBtnMutar.setBackground(new Color(255, 165, 0));

        gmBtnEntrenar = new JButton("Entrenar");
        gmBtnEntrenar.setBackground(new Color(70, 130, 180));
        gmBtnEntrenar.setForeground(Color.WHITE);

        gmBtnDisparar = new JButton("Disparar");
        gmBtnDisparar.setBackground(new Color(220, 20, 60));
        gmBtnDisparar.setForeground(Color.WHITE);

        gmBottomPanel.add(gmBtnMutar);
        gmBottomPanel.add(gmBtnEntrenar);
        gmBottomPanel.add(gmBtnDisparar);

        add(gmBottomPanel, BorderLayout.SOUTH);

        // Listeners
        gmBtnCrear.addActionListener(e -> gmHandleCrear());
        gmBtnMutar.addActionListener(e -> gmHandleMutar());
        gmBtnEntrenar.addActionListener(e -> gmHandleEntrenar());
        gmBtnDisparar.addActionListener(e -> gmHandleDisparar());

        gmCMD.gmImprimir("GOOD : Interfaz grafica iniciada. (Logs visibles en Terminal)");
    }

    // ==========================================
    // METODOS DE LOGICA
    // ==========================================
    private void gmHandleCrear() {
        System.out.println(">> [VSCODE] Click en botón CREAR");
        
        String gmNombreBase = gmTxtNombreAnimal.getText().trim();
        if (gmNombreBase.isEmpty()) gmNombreBase = "MutaGeno"; // Default si lo borran
        
        gmContadorGrupo++;

        for (int i = 1; i <= 5; i++) {
            String gmNombre = gmNombreBase + "_G" + gmContadorGrupo + "_" + i;
            int gmEdad = (int) (Math.random() * 10 + 1);
            String gmSexoReal = (Math.random() > 0.5) ? "Hembra" : "Macho";

            gmLeopardo gmAnimal = new gmLeopardo(gmNombre, "Felino", gmEdad, gmSexoReal);
            gmListaAnimales.add(gmAnimal);

            // AGREGAR FILA: Animal (Nombre) | Mutado | Entrenado | Disparos
            gmTableModel.addRow(new Object[]{
                gmNombre, // Col 0: Nombre del animal
                "No",     // Col 1: Mutado (Nace No)
                "No",     // Col 2: Entrenado
                0         // Col 3: Disparos
            });
            gmAnimal.gmShow();
        }
        gmCMD.gmImprimir("GOOD : Grupo " + gmContadorGrupo + " creado (" + gmNombreBase + ").");
        // No borramos el texto para que siga diciendo "MutaGeno" o lo que puso el usuario
    }

    private void gmHandleMutar() {
        System.out.println(">> [VSCODE] Click en botón MUTAR");
        gmLeopardo gmAnimal = gmGetSelectedAnimal();
        int gmIdx = gmGetSelectedIndex();
        if (gmAnimal == null) return;

        if (gmAnimal instanceof gmLeopardoGuamani) {
            gmCMD.gmImprimir("ERROR: Animal ya mutado.");
            JOptionPane.showMessageDialog(this, "El animal ya ha sido mutado.");
            return;
        }

        String gmIdChipStr = JOptionPane.showInputDialog(this, "IdChip (Par):");
        if (gmIdChipStr == null) return;
        String gmGenTipo = JOptionPane.showInputDialog(this, "Gen (XX):");
        if (gmGenTipo == null) return;

        gmMoleGen gmMoleGenObj = new gmMoleGen(new gmChip(gmIdChipStr), new gmGen(gmGenTipo));
        gmLeopardo gmResultado = gmTanqueMutacion.gmInstance().gmMutar(gmAnimal, gmMoleGenObj);

        if (gmResultado instanceof gmLeopardoGuamani) {
            gmListaAnimales.set(gmIdx, gmResultado);
            gmUpdateTableRow(gmIdx, gmResultado);
            JOptionPane.showMessageDialog(this, "Mutacion Exitosa");
        } else {
            JOptionPane.showMessageDialog(this, "Fallo Mutacion");
        }
    }

    private void gmHandleEntrenar() {
        System.out.println(">> [VSCODE] Click en botón ENTRENAR");
        gmLeopardo gmAnimal = gmGetSelectedAnimal();
        int gmIdx = gmGetSelectedIndex();
        if (gmAnimal == null) return;

        if (gmAnimal instanceof IgmEntrenar) {
            ((IgmEntrenar) gmAnimal).gmEntrenar(new gmArma1(), new gmArma2());
            gmUpdateTableRow(gmIdx, gmAnimal);
            if(gmAnimal.gmIsEntrenado()) JOptionPane.showMessageDialog(this, "Entrenamiento Completado.");
        } else {
            gmCMD.gmImprimir("ERROR: Animal no entrenable (No es Guamani).");
            JOptionPane.showMessageDialog(this, "Solo los mutados (Guamani) pueden entrenar.");
        }
    }

    private void gmHandleDisparar() {
        System.out.println(">> [VSCODE] Click en botón DISPARAR");
        gmLeopardo gmAnimal = gmGetSelectedAnimal();
        int gmIdx = gmGetSelectedIndex();
        if (gmAnimal == null) return;

        // Auto-Crecimiento de Cola (Lógica Profe)
        if (gmAnimal.gmGetExtremidad() == null) {
            gmAnimal.gmCrecerCola(); 
        }

        String municion = DataAccess.gmDataFileHelper.gmObtenerMunicion();
        gmAnimal.gmDisparar(municion);
        gmUpdateTableRow(gmIdx, gmAnimal);
    }

    // Helpers
    private gmLeopardo gmGetSelectedAnimal() {
        int gmRow = gmTable.getSelectedRow();
        if (gmRow >= 0) {
            int gmModelRow = gmTable.convertRowIndexToModel(gmRow);
            if (gmModelRow < gmListaAnimales.size()) return gmListaAnimales.get(gmModelRow);
        }
        return null;
    }

    private int gmGetSelectedIndex() {
        int gmRow = gmTable.getSelectedRow();
        return (gmRow >= 0) ? gmTable.convertRowIndexToModel(gmRow) : -1;
    }

    private void gmUpdateTableRow(int gmIdx, gmLeopardo gmAnimal) {
        if (gmIdx >= 0) {
            // Logica para columna "Mutado"
            String esMutado = (gmAnimal instanceof gmLeopardoGuamani) ? "Si" : "No";
            
            gmTableModel.setValueAt(gmAnimal.gmGetNombre(), gmIdx, 0); // Animal
            gmTableModel.setValueAt(esMutado, gmIdx, 1);               // Mutado
            gmTableModel.setValueAt(gmAnimal.gmIsEntrenado() ? "Si" : "No", gmIdx, 2); // Entrenado
            gmTableModel.setValueAt(gmAnimal.gmGetNumeroDisparos(), gmIdx, 3); // Disparos
        }
    }
}