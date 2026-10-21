import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.SwingUtilities;
import vista.*;
import dominio.*;

public class TestAbrirVista {
    
    public static void main(String[] args) {
        GestionConsulta gestionConsulta = new GestionConsulta();
        try {
            FlatDarkLaf.setup();
            System.out.println("FlatLaf aplicado OK: " + FlatDarkLaf.class.getName());
            SwingUtilities.invokeLater(() -> {
                VistaConsultas ventana = new VistaConsultas(gestionConsulta);
                ventana.actualizarTabla();
                ventana.setVisible(true);
                System.out.println("Ventana abierta, titulo=" + ventana.getTitle());
                /*
                new Timer(3000, e -> {
                    ventana.dispose();
                    System.exit(0);
                }).start();
                */
            });
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(2);
        }
    }
}
