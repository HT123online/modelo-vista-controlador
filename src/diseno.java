import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class diseno extends JFrame {
    public JPanel panel1;
    public JTabbedPane tabbedPane1;
    public JTextField descripcion;
    public JTextField correo;
    public JTextField fecha ;
    public JRadioButton diario;
    public JRadioButton semanal;
    public JRadioButton mensual;
    public JCheckBox alarmaCheckBox;
    public JButton guardarButton;
    public JButton limpiarButton;
    public JTable tabla_eventos;
    public JTable table2;
    public JTable tabla_ver_eventos;
    public JTable tabla_eliminar_evento;
    public JButton seleccionar_todo;
    public JButton cancelar;
    public JButton eliminar;
    public JTextField ingresar_nombre;
    public JTextField ingresar_celular;
    public JRadioButton masculinoRadioButton;
    public JRadioButton femeninoRadioButton;
    public JComboBox combo_dia;
    public JTextField direccion;
    public JCheckBox aceptaLosTerminosYCheckBox;
    public JComboBox combo_mes;
    public JComboBox combo_año;

    public Container getPanel() {
        return panel1;
    }

    public JPanel getRootPanel() {
        return panel1;
    }
    public JTextField getdescripcion() {
        return descripcion;
    }
    public JTextField getcorreo() {
        return correo;
    }
    public JTextField getfecha() {
        return fecha;
    }
    public JRadioButton getdiario() {
        return diario;
    }
    public void setdiario(JRadioButton diario) {
        this.diario = diario;
    }
    public JRadioButton getsemanal() {
        return semanal;
    }
    public void setsemanal(JRadioButton semanal) {
        this.semanal = semanal;
    }
    public JRadioButton getmensual() {
        return mensual;
    }
    public JCheckBox getAlarmaCheckBox() {
        return alarmaCheckBox;
    }
    public JButton getGuardarButton() {
        return guardarButton;
    }
    public JButton getLimpiarButton() {
        return limpiarButton;
    }



    public void limpiar() {
        descripcion.setText("");
        correo.setText("");
        fecha.setText("");
        alarmaCheckBox.setSelected(false);
        diario.setSelected(true);
    }

    controlador objeto_controlador;
    controlador_eliminar_evento objeto_eliminar;
    control_registrar_invitado objeto_invitado;
    public diseno() {

        modelo_nuevo_evento modelo_nuevo_evento=new modelo_nuevo_evento();
        objeto_controlador=new controlador(this,modelo_nuevo_evento);
        objeto_eliminar=new controlador_eliminar_evento(this);
        objeto_invitado=new control_registrar_invitado(this);
        diario.setSelected(true);
        crear_tabla();
        //modelo_nuevo_evento modelo_nuevo_evento= new modelo_nuevo_evento();
        //controlador=new controlador(this,modelo_nuevo_evento);

        //add(modelo_nuevo_evento);
        //setVisible(true);
//        tabbedPane1.addTab("evntos",modelo_nuevo_evento);
//        add(tabbedPane1);
//        guardarButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                System.out.println(descripcion.getText());
////                System.out.println(correo.getText());
////                System.out.println(fecha.getText());
//                //crear_tabla();
//                //System.out.println(alarmaCheckBox.isSelected());
//                //agregar_tabla();
//                objeto_controlador.rellenar_campo();
//            }
//        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                limpiar();
            }
        });

    }

    public void crear_tabla() {
        Object[][] data = {{
            descripcion.getText(),correo.getText(),fecha.getText(),"",alarmaCheckBox.isSelected()
        }};
        tabla_ver_eventos.setModel(new DefaultTableModel(null, new String[]{"descripcion", "correo", "fecha", "frecuencia", "alarma"}));


//        String data[] ={descripcion.getText(), correo.getText(), fecha.getText()};
//        DefaultTableModel tabla_ver_eventos=(DefaultTableModel)tabla_eventos.getModel();
//        tabla_ver_eventos.addRow(data);

    }

    private void agregar_tabla() {

        String data[] = {
                descripcion.getText(), correo.getText(), fecha.getText(), "", Boolean.toString(alarmaCheckBox.isSelected())
        };                                                                  //(alarmaCheckBox.isSelected()) ? "true":"false"
        DefaultTableModel tb=(DefaultTableModel)tabla_ver_eventos.getModel();
        tb.addRow(data);


    }

}




