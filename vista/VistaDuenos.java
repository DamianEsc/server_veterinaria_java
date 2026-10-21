package vista;

import dominio.Dueno;
import dominio.GestionDueno;
import com.formdev.flatlaf.FlatDarkLaf;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

// [USER_IMPORTS_START]
//  ESCRIBE TUS IMPORTS AQUI (Ej: import java.io.*;)
    // ----------------------------------------------------
// [USER_IMPORTS_END]

public class VistaDuenos extends JFrame {

    private GestionDueno gestion;

    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtCi;
    private JTextField txtTelefono;
    private JTextField txtEmail;
    private JLabel labelId;
    private JLabel labelNombre;
    private JLabel labelCi;
    private JLabel labelTelefono;
    private JLabel labelEmail;
    private JButton btnGuardar;
    private JButton btnEliminar;
    private JButton btnModificar;
    private JTable tablaDuenos;
    private DefaultTableModel modeloTablaDuenos;

// [USER_DECLS_START]
//  DECLARA TUS VARIABLES AQUI (Ej: private int contador;)
    // ----------------------------------------------------
// [USER_DECLS_END]

    public VistaDuenos(GestionDueno gestion) {
        // Look & Feel FlatLaf
        FlatDarkLaf.setup();
        getContentPane().setBackground(UIManager.getColor("Panel.background"));
        this.gestion = gestion;
        setTitle("Formulario de Dueños");
        setSize(500, 430);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        initComponents();
        initEvents();
    }

    private void initComponents() {
        labelId = new JLabel("ID: ");
        labelId.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelId.setBounds(50, 30, 80, 20);
        txtId = new JTextField();
        txtId.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtId.setBounds(150, 30, 300, 22);
        txtNombre = new JTextField();
        txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtNombre.setBounds(150, 60, 300, 22);
        txtCi = new JTextField();
        txtCi.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtCi.setBounds(150, 90, 300, 22);
        txtTelefono = new JTextField();
        txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtTelefono.setBounds(150, 120, 300, 22);
        txtEmail = new JTextField();
        txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtEmail.setBounds(150, 150, 300, 22);
        labelNombre = new JLabel("Nombre:");
        labelNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelNombre.setBounds(50, 60, 80, 20);
        labelCi = new JLabel("CI:");
        labelCi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelCi.setBounds(50, 90, 80, 20);
        labelTelefono = new JLabel("Teléfono:");
        labelTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelTelefono.setBounds(50, 120, 80, 20);
        labelEmail = new JLabel("Email:");
        labelEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
        labelEmail.setBounds(50, 150, 80, 20);
        btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnGuardar.setBounds(155, 190, 90, 25);
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnEliminar.setBounds(355, 190, 90, 25);
        btnModificar = new JButton("Modificar");
        btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnModificar.setBounds(255, 190, 90, 25);
        modeloTablaDuenos = new DefaultTableModel(
            new String[]{"ID", "Nombre", "CI", "Teléfono", "Email"}, 0
        ) {
            @Override public boolean isCellEditable(int row, int col) { return false; }
        };
        tablaDuenos = new JTable(modeloTablaDuenos);
        tablaDuenos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablaDuenos.getTableHeader().setReorderingAllowed(false);
        JScrollPane scroll_tablaDuenos = new JScrollPane(tablaDuenos);
        scroll_tablaDuenos.setBounds(25, 230, 450, 150);
        getContentPane().add(labelId);
        getContentPane().add(txtId);
        getContentPane().add(txtNombre);
        getContentPane().add(txtCi);
        getContentPane().add(txtTelefono);
        getContentPane().add(txtEmail);
        getContentPane().add(labelNombre);
        getContentPane().add(labelCi);
        getContentPane().add(labelTelefono);
        getContentPane().add(labelEmail);
        getContentPane().add(btnGuardar);
        getContentPane().add(btnEliminar);
        getContentPane().add(btnModificar);
        getContentPane().add(scroll_tablaDuenos);
    }

    private void initEvents() {
        // [USER_ACTION_START:btnGuardar]
btnGuardar.addActionListener(e -> {
            try {
        String nombre = txtNombre.getText();
        String ci = txtCi.getText();
        String telefono = txtTelefono.getText(); 
        String email = txtEmail.getText();

        Dueno dueno = new Dueno(0, nombre, ci, telefono, email);
        int id = gestion.guardar(dueno);

        if (id != -1) {
            JOptionPane.showMessageDialog(this, "Dueño guardado con ID: " + id);
            limpiarFormulario();
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Error al guardar el dueño.");
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
        });
        // [USER_ACTION_END:btnGuardar]

        // [USER_ACTION_START:btnEliminar]
btnEliminar.addActionListener(e -> {
    try {
        // TODO: Obtén la ID desde txtId usando Integer.parseInt()
        int id = Integer.parseInt(txtId.getText());

        // Llamamos al método eliminar de la gestión (retorna boolean)
        boolean eliminado = gestion.eliminar(id);

        if (eliminado) {
            JOptionPane.showMessageDialog(this, "Dueño eliminado.");
            limpiarFormulario();
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar el dueño.");
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
});
        // [USER_ACTION_END:btnEliminar]

        // [USER_ACTION_START:btnModificar]
btnModificar.addActionListener(e -> {
    try {
        // 1. Obtén la ID desde txtId usando Integer.parseInt()
        int id = Integer.parseInt(txtId.getText());
        // 2. Lee los datos restantes (nombre, email, telefono, direccion)
        String nombre = txtNombre.getText();
        String ci = txtCi.getText();
        String telefono = txtTelefono.getText();
        String email = txtEmail.getText();

        // 3. Instancia el objeto Dueno con los datos recopilados
        Dueno dueno = new Dueno(id, nombre, ci, telefono, email);

        // 4. Llama al método actualizar de la gestión (retorna boolean)
        boolean modificado = gestion.actualizar(dueno);

        if (modificado) {
            JOptionPane.showMessageDialog(this, "Dueño modificado.");
            limpiarFormulario();
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Error al modificar.");
        }
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
        ArrayList<Dueno> listaDuenos = gestion.listar();
        modeloTablaDuenos.setRowCount(0); // Limpia la tabla visual
        
        for (Dueno dueno : listaDuenos) {
            modeloTablaDuenos.addRow(new Object[] {
                dueno.getId(),
                dueno.getNombre(),
                dueno.getCi(),
                dueno.getTelefono(),
                dueno.getEmail()
            });
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    public void limpiarFormulario() {
        this.txtId.setText("");
        this.txtNombre.setText("");
        this.txtCi.setText("");
        this.txtTelefono.setText("");
        this.txtEmail.setText("");
    }
// [USER_METHODS_END]
}