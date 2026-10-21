package vista;

import dominio.Mascota;
import dominio.GestionMascota;
import com.formdev.flatlaf.FlatDarkLaf;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

// [USER_IMPORTS_START]
//  ESCRIBE TUS IMPORTS AQUI (Ej: import java.io.*;)
    // ----------------------------------------------------
// [USER_IMPORTS_END]

public class VistaMascotas extends JFrame {

    private GestionMascota gestion;

    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JTextField txtEspecie;
    private JTextField txtRaza;
    private JTextField txtGenero;
    private JTextField txtPeso;
    private JTextField txtIdDueno;
    private JLabel labelId;
    private JLabel labelNombre;
    private JLabel labelEdad;
    private JLabel labelEspecie;
    private JLabel labelRaza;
    private JLabel labelGenero;
    private JLabel labelPeso;
    private JLabel labelIdDueno;
    private JButton btnGuardar;
    private JButton btnEliminar;
    private JButton btnModificar;
    private JTable tablaMascotas;
    private DefaultTableModel modeloTablaMascotas;

// [USER_DECLS_START]
//  DECLARA TUS VARIABLES AQUI (Ej: private int contador;)
    // ----------------------------------------------------
// [USER_DECLS_END]

    public VistaMascotas(GestionMascota gestion) {
        // Look & Feel FlatLaf
        FlatDarkLaf.setup();
        getContentPane().setBackground(UIManager.getColor("Panel.background"));
        this.gestion = gestion;
        setTitle("Formulario de Mascotas");
        setSize(500, 560);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        initComponents();
        initEvents();
    }

    private void initComponents() {
        labelId = new JLabel("ID: ");
        labelId.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelId.setBounds(50, 30, 90, 20);
        txtId = new JTextField();
        txtId.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtId.setBounds(150, 30, 300, 22);

        labelNombre = new JLabel("Nombre:");
        labelNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelNombre.setBounds(50, 60, 90, 20);
        txtNombre = new JTextField();
        txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtNombre.setBounds(150, 60, 300, 22);

        labelEdad = new JLabel("Edad:");
        labelEdad.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelEdad.setBounds(50, 90, 90, 20);
        txtEdad = new JTextField();
        txtEdad.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtEdad.setBounds(150, 90, 300, 22);

        labelEspecie = new JLabel("Especie:");
        labelEspecie.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelEspecie.setBounds(50, 120, 90, 20);
        txtEspecie = new JTextField();
        txtEspecie.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtEspecie.setBounds(150, 120, 300, 22);

        labelRaza = new JLabel("Raza:");
        labelRaza.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelRaza.setBounds(50, 150, 90, 20);
        txtRaza = new JTextField();
        txtRaza.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtRaza.setBounds(150, 150, 300, 22);

        labelGenero = new JLabel("Género:");
        labelGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelGenero.setBounds(50, 180, 90, 20);
        txtGenero = new JTextField();
        txtGenero.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtGenero.setBounds(150, 180, 300, 22);

        labelPeso = new JLabel("Peso (kg):");
        labelPeso.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelPeso.setBounds(50, 210, 90, 20);
        txtPeso = new JTextField();
        txtPeso.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtPeso.setBounds(150, 210, 300, 22);

        labelIdDueno = new JLabel("ID Dueño:");
        labelIdDueno.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelIdDueno.setBounds(50, 240, 90, 20);
        txtIdDueno = new JTextField();
        txtIdDueno.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtIdDueno.setBounds(150, 240, 300, 22);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnGuardar.setBounds(155, 280, 90, 25);
        btnModificar = new JButton("Modificar");
        btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnModificar.setBounds(255, 280, 90, 25);
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnEliminar.setBounds(355, 280, 90, 25);

        modeloTablaMascotas = new DefaultTableModel(
            new String[]{"ID", "Nombre", "Edad", "Especie", "Raza", "Género", "Peso", "ID Dueño"}, 0
        ) {
            @Override public boolean isCellEditable(int row, int col) { return false; }
        };
        tablaMascotas = new JTable(modeloTablaMascotas);
        tablaMascotas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablaMascotas.getTableHeader().setReorderingAllowed(false);
        JScrollPane scroll_tablaMascotas = new JScrollPane(tablaMascotas);
        scroll_tablaMascotas.setBounds(25, 320, 450, 170);

        getContentPane().add(labelId);
        getContentPane().add(txtId);
        getContentPane().add(labelNombre);
        getContentPane().add(txtNombre);
        getContentPane().add(labelEdad);
        getContentPane().add(txtEdad);
        getContentPane().add(labelEspecie);
        getContentPane().add(txtEspecie);
        getContentPane().add(labelRaza);
        getContentPane().add(txtRaza);
        getContentPane().add(labelGenero);
        getContentPane().add(txtGenero);
        getContentPane().add(labelPeso);
        getContentPane().add(txtPeso);
        getContentPane().add(labelIdDueno);
        getContentPane().add(txtIdDueno);
        getContentPane().add(btnGuardar);
        getContentPane().add(btnModificar);
        getContentPane().add(btnEliminar);
        getContentPane().add(scroll_tablaMascotas);
    }

    private void initEvents() {
        // [USER_ACTION_START:btnGuardar]
btnGuardar.addActionListener(e -> {
    try {
        String nombre = txtNombre.getText();
        int edad = Integer.parseInt(txtEdad.getText());
        String especie = txtEspecie.getText();
        String raza = txtRaza.getText();
        String genero = txtGenero.getText();
        double peso = Double.parseDouble(txtPeso.getText().replace(',', '.'));
        int idDueno = Integer.parseInt(txtIdDueno.getText());

        Mascota mascota = new Mascota(0, nombre, edad, especie, raza, genero, peso, idDueno);
        int id = gestion.guardar(mascota);

        if (id != -1) {
            JOptionPane.showMessageDialog(this, "Mascota guardada con ID: " + id);
            limpiarFormulario();
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Error al guardar la mascota.");
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Edad, peso e ID Dueño deben ser números.");
    } catch (Exception ex) {
        ex.printStackTrace();
    }
});
        // [USER_ACTION_END:btnGuardar]

        // [USER_ACTION_START:btnEliminar]
btnEliminar.addActionListener(e -> {
    try {
        int id = Integer.parseInt(txtId.getText());

        boolean eliminado = gestion.eliminar(id);

        if (eliminado) {
            JOptionPane.showMessageDialog(this, "Mascota eliminada.");
            limpiarFormulario();
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar la mascota.");
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "El ID debe ser un número.");
    } catch (Exception ex) {
        ex.printStackTrace();
    }
});
        // [USER_ACTION_END:btnEliminar]

        // [USER_ACTION_START:btnModificar]
btnModificar.addActionListener(e -> {
    try {
        int id = Integer.parseInt(txtId.getText());
        String nombre = txtNombre.getText();
        int edad = Integer.parseInt(txtEdad.getText());
        String especie = txtEspecie.getText();
        String raza = txtRaza.getText();
        String genero = txtGenero.getText();
        double peso = Double.parseDouble(txtPeso.getText().replace(',', '.'));
        int idDueno = Integer.parseInt(txtIdDueno.getText());

        Mascota mascota = new Mascota(id, nombre, edad, especie, raza, genero, peso, idDueno);

        boolean modificado = gestion.actualizar(mascota);

        if (modificado) {
            JOptionPane.showMessageDialog(this, "Mascota modificada.");
            limpiarFormulario();
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Error al modificar.");
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "ID, edad, peso e ID Dueño deben ser números.");
    } catch (Exception ex) {
        ex.printStackTrace();
    }
});
        // [USER_ACTION_END:btnModificar]

    }

// [USER_METHODS_START]
//  AGREGA TUS METODOS PERSONALIZADOS AQUI
    // ----------------------------------------------------
    public void actualizarTabla() {
        try {
            ArrayList<Mascota> listaMascotas = gestion.listar();
            modeloTablaMascotas.setRowCount(0); // Limpia la tabla visual

            for (Mascota mascota : listaMascotas) {
                modeloTablaMascotas.addRow(new Object[] {
                    mascota.getId(),
                    mascota.getNombre(),
                    mascota.getEdad(),
                    mascota.getEspecie(),
                    mascota.getRaza(),
                    mascota.getGenero(),
                    mascota.getPeso(),
                    mascota.getId_dueno()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void limpiarFormulario() {
        this.txtId.setText("");
        this.txtNombre.setText("");
        this.txtEdad.setText("");
        this.txtEspecie.setText("");
        this.txtRaza.setText("");
        this.txtGenero.setText("");
        this.txtPeso.setText("");
        this.txtIdDueno.setText("");
    }
// [USER_METHODS_END]
}