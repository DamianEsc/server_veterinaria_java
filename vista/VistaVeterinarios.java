package vista;

import dominio.Veterinario;
import dominio.GestionVeterinario;
import com.formdev.flatlaf.FlatDarkLaf;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VistaVeterinarios extends JFrame {

    private GestionVeterinario gestion;

    private JLabel labelId;
    private JTextField txtId;
    private JTextField txtNombre;
    private JPasswordField txtContraseña;
    private JTextField txtEspecialidad;

    private JLabel labelNombre;
    private JLabel labelContraseña;
    private JLabel labelEspecialidad;

    private JButton btnGuardar;
    private JButton btnEliminar;
    private JButton btnModificar;

    private JTable tablaVeterinarios;
    private DefaultTableModel modeloTablaVeterinarios;

    public VistaVeterinarios(GestionVeterinario gestion) {

        FlatDarkLaf.setup();

        getContentPane().setBackground(
            UIManager.getColor("Panel.background")
        );

        this.gestion = gestion;

        setTitle("Formulario de Veterinarios");
        setSize(500, 430);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        initComponents();
        initEvents();
    }

    private void initComponents() {

        // ID
        labelId = new JLabel("ID:");
        labelId.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelId.setBounds(50, 30, 80, 20);

        txtId = new JTextField();
        txtId.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtId.setBounds(150, 30, 300, 22);


        // Nombre
        labelNombre = new JLabel("Nombre:");
        labelNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelNombre.setBounds(50, 60, 80, 20);

        txtNombre = new JTextField();
        txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtNombre.setBounds(150, 60, 300, 22);


        // Contraseña
        labelContraseña = new JLabel("Contraseña:");
        labelContraseña.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelContraseña.setBounds(50, 90, 100, 20);

        txtContraseña = new JPasswordField();
        txtContraseña.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtContraseña.setBounds(150, 90, 300, 22);


        // Especialidad
        labelEspecialidad = new JLabel("Especialidad:");
        labelEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelEspecialidad.setBounds(50, 120, 100, 20);

        txtEspecialidad = new JTextField();
        txtEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtEspecialidad.setBounds(150, 120, 300, 22);


        // Botón Guardar
        btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnGuardar.setBounds(155, 160, 90, 25);


        // Botón Modificar
        btnModificar = new JButton("Modificar");
        btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnModificar.setBounds(255, 160, 90, 25);


        // Botón Eliminar
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnEliminar.setBounds(355, 160, 90, 25);


        // Tabla
        modeloTablaVeterinarios = new DefaultTableModel(
            new String[]{
                "ID",
                "Nombre",
                "Contraseña",
                "Especialidad"
            },
            0
        ) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        tablaVeterinarios = new JTable(modeloTablaVeterinarios);
        tablaVeterinarios.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablaVeterinarios.getTableHeader().setReorderingAllowed(false);
        JScrollPane scrollTablaVeterinarios =new JScrollPane(tablaVeterinarios);
        scrollTablaVeterinarios.setBounds(25, 205, 450, 150);

        // Agregar componentes
        getContentPane().add(labelId);
        getContentPane().add(txtId);

        getContentPane().add(labelNombre);
        getContentPane().add(txtNombre);

        getContentPane().add(labelContraseña);
        getContentPane().add(txtContraseña);

        getContentPane().add(labelEspecialidad);
        getContentPane().add(txtEspecialidad);

        getContentPane().add(btnGuardar);
        getContentPane().add(btnModificar);
        getContentPane().add(btnEliminar);

        getContentPane().add(scrollTablaVeterinarios);
    }

    private void initEvents() {
    // GUARDAR
btnGuardar.addActionListener(e -> {
            try {
        String nombre = txtNombre.getText();
        String contraseña = new String(txtContraseña.getPassword());
        String especialidad = txtEspecialidad.getText();

        Veterinario veterinario =new Veterinario(0, nombre, contraseña, especialidad);
        int id = gestion.guardar(veterinario);

        if (id != -1) {
            JOptionPane.showMessageDialog(this, "Veterinario guardado con ID: " + id);
            limpiarFormulario();
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(this,"Error al guardar el veterinario.");
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
        });

        // ELIMINAR
btnEliminar.addActionListener(e -> {
    try {
        int id = Integer.parseInt(txtId.getText());

        boolean eliminado = gestion.eliminar(id);

        if (eliminado) {
            JOptionPane.showMessageDialog(this,"Veterinario eliminado.");
            limpiarFormulario();
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar el veterinario.");
        }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });


        // MODIFICAR
btnModificar.addActionListener(e -> {
    try {
        int id = Integer.parseInt(txtId.getText());
        String nombre = txtNombre.getText();
        String contraseña = new String(txtContraseña.getPassword());
        String especialidad = txtEspecialidad.getText();

        Veterinario veterinario = new Veterinario(id, nombre, contraseña, especialidad);

        boolean modificado = gestion.actualizar(veterinario);

        if (modificado) {
            JOptionPane.showMessageDialog(this, "Veterinario modificado.");
            limpiarFormulario();
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Error al modificar.");
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
});

}

    public void actualizarTabla() {
        try {
        ArrayList<Veterinario> listaVeterinarios = gestion.listar();
        modeloTablaVeterinarios.setRowCount(0);

        for (Veterinario veterinario : listaVeterinarios) {
            modeloTablaVeterinarios.addRow(new Object[]{
                veterinario.getId(),
                veterinario.getNombre(),
                veterinario.getContraseña(),
                veterinario.getEspecialidad()
             });
        }
    } catch (Exception e) {
            e.printStackTrace();
    }
    }

    public void limpiarFormulario() {
        txtId.setText("");
        txtNombre.setText("");
        txtContraseña.setText("");
        txtEspecialidad.setText("");
    }
}