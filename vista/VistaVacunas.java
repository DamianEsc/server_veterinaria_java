package vista;

import dominio.Vacuna;
import dominio.GestionVacuna;
import com.formdev.flatlaf.FlatDarkLaf;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

// [USER_IMPORTS_START]
//  ESCRIBE TUS IMPORTS AQUI (Ej: import java.io.*;)
    // ----------------------------------------------------
// [USER_IMPORTS_END]

public class VistaVacunas extends JFrame {

    private GestionVacuna gestion;

    private JTextField txtId;
    private JTextField txtTipo;
    private JTextField txtFecha;
    private JTextField txtHora;
    private JTextField txtVencimiento;
    private JTextField txtIdMascota;
    private JTextField txtIdConsulta;
    private JLabel labelId;
    private JLabel labelTipo;
    private JLabel labelFecha;
    private JLabel labelHora;
    private JLabel labelVencimiento;
    private JLabel labelIdMascota;
    private JLabel labelIdConsulta;
    private JButton btnGuardar;
    private JButton btnEliminar;
    private JButton btnModificar;
    private JTable tablaVacunas;
    private DefaultTableModel modeloTablaVacunas;

// [USER_DECLS_START]
//  DECLARA TUS VARIABLES AQUI (Ej: private int contador;)
    // ----------------------------------------------------
// [USER_DECLS_END]

    public VistaVacunas(GestionVacuna gestion) {
        // Look & Feel FlatLaf
        FlatDarkLaf.setup();
        getContentPane().setBackground(UIManager.getColor("Panel.background"));
        this.gestion = gestion;
        setTitle("Formulario de Vacunas");
        setSize(500, 520);
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

        labelTipo = new JLabel("Tipo:");
        labelTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelTipo.setBounds(50, 60, 90, 20);
        txtTipo = new JTextField();
        txtTipo.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtTipo.setBounds(150, 60, 300, 22);

        labelFecha = new JLabel("Fecha:");
        labelFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelFecha.setBounds(50, 90, 90, 20);
        txtFecha = new JTextField();
        txtFecha.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtFecha.setToolTipText("Formato: yyyy-MM-dd");
        txtFecha.setBounds(150, 90, 300, 22);

        labelHora = new JLabel("Hora:");
        labelHora.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelHora.setBounds(50, 120, 90, 20);
        txtHora = new JTextField();
        txtHora.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtHora.setToolTipText("Formato: HH:mm:ss");
        txtHora.setBounds(150, 120, 300, 22);

        labelVencimiento = new JLabel("Vencimiento:");
        labelVencimiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelVencimiento.setBounds(50, 150, 100, 20);
        txtVencimiento = new JTextField();
        txtVencimiento.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtVencimiento.setToolTipText("Formato: yyyy-MM-dd");
        txtVencimiento.setBounds(150, 150, 300, 22);

        labelIdMascota = new JLabel("ID Mascota:");
        labelIdMascota.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelIdMascota.setBounds(50, 180, 100, 20);
        txtIdMascota = new JTextField();
        txtIdMascota.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtIdMascota.setBounds(150, 180, 300, 22);

        labelIdConsulta = new JLabel("ID Consulta:");
        labelIdConsulta.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelIdConsulta.setBounds(50, 210, 100, 20);
        txtIdConsulta = new JTextField();
        txtIdConsulta.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtIdConsulta.setBounds(150, 210, 300, 22);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnGuardar.setBounds(155, 250, 90, 25);
        btnModificar = new JButton("Modificar");
        btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnModificar.setBounds(255, 250, 90, 25);
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnEliminar.setBounds(355, 250, 90, 25);

        modeloTablaVacunas = new DefaultTableModel(
            new String[]{"ID", "Tipo", "Fecha", "Hora", "Vencimiento", "ID Mascota", "ID Consulta"}, 0
        ) {
            @Override public boolean isCellEditable(int row, int col) { return false; }
        };
        tablaVacunas = new JTable(modeloTablaVacunas);
        tablaVacunas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablaVacunas.getTableHeader().setReorderingAllowed(false);
        JScrollPane scroll_tablaVacunas = new JScrollPane(tablaVacunas);
        scroll_tablaVacunas.setBounds(25, 290, 450, 170);

        getContentPane().add(labelId);
        getContentPane().add(txtId);
        getContentPane().add(labelTipo);
        getContentPane().add(txtTipo);
        getContentPane().add(labelFecha);
        getContentPane().add(txtFecha);
        getContentPane().add(labelHora);
        getContentPane().add(txtHora);
        getContentPane().add(labelVencimiento);
        getContentPane().add(txtVencimiento);
        getContentPane().add(labelIdMascota);
        getContentPane().add(txtIdMascota);
        getContentPane().add(labelIdConsulta);
        getContentPane().add(txtIdConsulta);
        getContentPane().add(btnGuardar);
        getContentPane().add(btnModificar);
        getContentPane().add(btnEliminar);
        getContentPane().add(scroll_tablaVacunas);
    }

    private void initEvents() {
        // [USER_ACTION_START:btnGuardar]
btnGuardar.addActionListener(e -> {
    try {
        String tipo = txtTipo.getText();
        String fecha = txtFecha.getText();
        String hora = txtHora.getText();
        String vencimiento = txtVencimiento.getText();
        int idMascota = Integer.parseInt(txtIdMascota.getText());
        int idConsulta = Integer.parseInt(txtIdConsulta.getText());

        Vacuna vacuna = new Vacuna(0, tipo, fecha, hora, vencimiento, idMascota, idConsulta);
        int id = gestion.guardar(vacuna);

        if (id != -1) {
            JOptionPane.showMessageDialog(this, "Vacuna guardada con ID: " + id);
            limpiarFormulario();
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Error al guardar la vacuna.");
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "ID Mascota e ID Consulta deben ser números.");
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
            JOptionPane.showMessageDialog(this, "Vacuna eliminada.");
            limpiarFormulario();
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar la vacuna.");
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
        String tipo = txtTipo.getText();
        String fecha = txtFecha.getText();
        String hora = txtHora.getText();
        String vencimiento = txtVencimiento.getText();
        int idMascota = Integer.parseInt(txtIdMascota.getText());
        int idConsulta = Integer.parseInt(txtIdConsulta.getText());

        Vacuna vacuna = new Vacuna(id, tipo, fecha, hora, vencimiento, idMascota, idConsulta);

        boolean modificado = gestion.actualizar(vacuna);

        if (modificado) {
            JOptionPane.showMessageDialog(this, "Vacuna modificada.");
            limpiarFormulario();
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Error al modificar.");
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "ID, ID Mascota e ID Consulta deben ser números.");
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
            ArrayList<Vacuna> listaVacunas = gestion.listar();
            modeloTablaVacunas.setRowCount(0); // Limpia la tabla visual

            for (Vacuna vacuna : listaVacunas) {
                modeloTablaVacunas.addRow(new Object[] {
                    vacuna.getId(),
                    vacuna.getTipo(),
                    vacuna.getFecha(),
                    vacuna.getHora(),
                    vacuna.getVencimiento(),
                    vacuna.getId_mascota(),
                    vacuna.getId_consulta()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void limpiarFormulario() {
        this.txtId.setText("");
        this.txtTipo.setText("");
        this.txtFecha.setText("");
        this.txtHora.setText("");
        this.txtVencimiento.setText("");
        this.txtIdMascota.setText("");
        this.txtIdConsulta.setText("");
    }
// [USER_METHODS_END]
}
