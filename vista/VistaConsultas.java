package vista;

import dominio.Consulta;
import dominio.GestionConsulta;
import com.formdev.flatlaf.FlatDarkLaf;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

// [USER_IMPORTS_START]
//  ESCRIBE TUS IMPORTS AQUI (Ej: import java.io.*;)
    // ----------------------------------------------------
// [USER_IMPORTS_END]

public class VistaConsultas extends JFrame {

    private GestionConsulta gestion;

    private JTextField txtId;
    private JTextField txtProcedimiento;
    private JTextField txtFecha;
    private JTextField txtHora;
    private JTextField txtIdMascota;
    private JTextField txtIdVeterinario;
    private JLabel labelId;
    private JLabel labelProcedimiento;
    private JLabel labelFecha;
    private JLabel labelHora;
    private JLabel labelIdMascota;
    private JLabel labelIdVeterinario;
    private JButton btnGuardar;
    private JButton btnEliminar;
    private JButton btnModificar;
    private JTable tablaConsultas;
    private DefaultTableModel modeloTablaConsultas;

// [USER_DECLS_START]
//  DECLARA TUS VARIABLES AQUI (Ej: private int contador;)
    // ----------------------------------------------------
// [USER_DECLS_END]

    public VistaConsultas(GestionConsulta gestion) {
        // Look & Feel FlatLaf
        FlatDarkLaf.setup();
        getContentPane().setBackground(UIManager.getColor("Panel.background"));
        this.gestion = gestion;
        setTitle("Formulario de Consultas");
        setSize(500, 480);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        initComponents();
        initEvents();
    }

    private void initComponents() {
        labelId = new JLabel("ID: ");
        labelId.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelId.setBounds(50, 30, 100, 20);
        txtId = new JTextField();
        txtId.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtId.setBounds(160, 30, 290, 22);

        labelProcedimiento = new JLabel("Procedimiento:");
        labelProcedimiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelProcedimiento.setBounds(50, 60, 110, 20);
        txtProcedimiento = new JTextField();
        txtProcedimiento.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtProcedimiento.setBounds(160, 60, 290, 22);

        labelFecha = new JLabel("Fecha:");
        labelFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelFecha.setBounds(50, 90, 100, 20);
        txtFecha = new JTextField();
        txtFecha.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtFecha.setToolTipText("Formato: yyyy-MM-dd");
        txtFecha.setBounds(160, 90, 290, 22);

        labelHora = new JLabel("Hora:");
        labelHora.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelHora.setBounds(50, 120, 100, 20);
        txtHora = new JTextField();
        txtHora.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtHora.setToolTipText("Formato: HH:mm:ss");
        txtHora.setBounds(160, 120, 290, 22);

        labelIdMascota = new JLabel("ID Mascota:");
        labelIdMascota.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelIdMascota.setBounds(50, 150, 100, 20);
        txtIdMascota = new JTextField();
        txtIdMascota.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtIdMascota.setBounds(160, 150, 290, 22);

        labelIdVeterinario = new JLabel("ID Veterinario:");
        labelIdVeterinario.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelIdVeterinario.setBounds(50, 180, 110, 20);
        txtIdVeterinario = new JTextField();
        txtIdVeterinario.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtIdVeterinario.setBounds(160, 180, 290, 22);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnGuardar.setBounds(155, 220, 90, 25);
        btnModificar = new JButton("Modificar");
        btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnModificar.setBounds(255, 220, 90, 25);
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnEliminar.setBounds(355, 220, 90, 25);

        modeloTablaConsultas = new DefaultTableModel(
            new String[]{"ID", "Procedimiento", "Fecha", "Hora", "ID Mascota", "ID Veterinario"}, 0
        ) {
            @Override public boolean isCellEditable(int row, int col) { return false; }
        };
        tablaConsultas = new JTable(modeloTablaConsultas);
        tablaConsultas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablaConsultas.getTableHeader().setReorderingAllowed(false);
        JScrollPane scroll_tablaConsultas = new JScrollPane(tablaConsultas);
        scroll_tablaConsultas.setBounds(25, 260, 450, 170);

        getContentPane().add(labelId);
        getContentPane().add(txtId);
        getContentPane().add(labelProcedimiento);
        getContentPane().add(txtProcedimiento);
        getContentPane().add(labelFecha);
        getContentPane().add(txtFecha);
        getContentPane().add(labelHora);
        getContentPane().add(txtHora);
        getContentPane().add(labelIdMascota);
        getContentPane().add(txtIdMascota);
        getContentPane().add(labelIdVeterinario);
        getContentPane().add(txtIdVeterinario);
        getContentPane().add(btnGuardar);
        getContentPane().add(btnModificar);
        getContentPane().add(btnEliminar);
        getContentPane().add(scroll_tablaConsultas);
    }

    private void initEvents() {
        // [USER_ACTION_START:btnGuardar]
btnGuardar.addActionListener(e -> {
    try {
        String procedimiento = txtProcedimiento.getText();
        String fecha = txtFecha.getText();
        String hora = txtHora.getText();
        int idMascota = Integer.parseInt(txtIdMascota.getText());
        int idVeterinario = Integer.parseInt(txtIdVeterinario.getText());

        Consulta consulta = new Consulta(0, procedimiento, fecha, hora, idMascota, idVeterinario);
        int id = gestion.guardar(consulta);

        if (id != -1) {
            JOptionPane.showMessageDialog(this, "Consulta guardada con ID: " + id);
            limpiarFormulario();
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Error al guardar la consulta.");
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "ID Mascota e ID Veterinario deben ser números.");
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
            JOptionPane.showMessageDialog(this, "Consulta eliminada.");
            limpiarFormulario();
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar la consulta.");
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
        String procedimiento = txtProcedimiento.getText();
        String fecha = txtFecha.getText();
        String hora = txtHora.getText();
        int idMascota = Integer.parseInt(txtIdMascota.getText());
        int idVeterinario = Integer.parseInt(txtIdVeterinario.getText());

        Consulta consulta = new Consulta(id, procedimiento, fecha, hora, idMascota, idVeterinario);

        boolean modificado = gestion.actualizar(consulta);

        if (modificado) {
            JOptionPane.showMessageDialog(this, "Consulta modificada.");
            limpiarFormulario();
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Error al modificar.");
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "ID, ID Mascota e ID Veterinario deben ser números.");
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
            ArrayList<Consulta> listaConsultas = gestion.listar();
            modeloTablaConsultas.setRowCount(0); // Limpia la tabla visual

            for (Consulta consulta : listaConsultas) {
                modeloTablaConsultas.addRow(new Object[] {
                    consulta.getId(),
                    consulta.getProcedimiento(),
                    consulta.getFecha(),
                    consulta.getHora(),
                    consulta.getId_mascota(),
                    consulta.getId_veterinario()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void limpiarFormulario() {
        this.txtId.setText("");
        this.txtProcedimiento.setText("");
        this.txtFecha.setText("");
        this.txtHora.setText("");
        this.txtIdMascota.setText("");
        this.txtIdVeterinario.setText("");
    }
// [USER_METHODS_END]
}