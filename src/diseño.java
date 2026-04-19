import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class diseño extends JFrame {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JTextField descripcion;
    private JTextField correo;
    private JTextField fecha;
    private JRadioButton diario;
    private JRadioButton semanal;
    private JRadioButton mensual;
    private JCheckBox alarmaCheckBox;
    private JButton guardarButton;
    private JButton limpiarButton;
    private JTable tabla_eventos;
    private JTable table2;




    public Container getPanel() {
        return panel1;
    }

    public void setTable2(JTable table2) {this.table2 = table2;}
    public void setTable1(JTable table1) {this.tabla_eventos = table1;}
    public JTextField getdescripcion() {return descripcion;}
    public void setdescripcion(JTextField descripcion) {this.descripcion = descripcion;}
    public JTextField getcorreo() {return correo;}
    public void setcorreo(JTextField correo) {this.correo = correo;}
    public JTextField getfecha() {return fecha;}
    public void setfecha(JTextField fecha) {this.fecha = fecha;}
    public JRadioButton getdiario() {return diario;}
    public void setdiario(JRadioButton diario) {this.diario = diario;}
    public JRadioButton getsemanal() {return semanal;}
    public void setsemanal(JRadioButton semanal) {this.semanal = semanal;}
    public JRadioButton getmensual() {return mensual;}
    public JCheckBox getAlarmaCheckBox() {return alarmaCheckBox;}
    public void setAlarmaCheckBox(JCheckBox alarmaCheckBox) {this.alarmaCheckBox = alarmaCheckBox;}
    public JButton getGuardarButton() {return guardarButton;}
    public void setGuardarButton(JButton guardarButton) {this.guardarButton = guardarButton;}
    public JButton getLimpiarButton() {return limpiarButton;}
    public void setLimpiarButton(JButton limpiarButton) {this.limpiarButton = limpiarButton;}

    public void limpiar(){
        descripcion.setText("");
        correo.setText("");
        fecha.setText("");
        alarmaCheckBox.setSelected(false);
    }
    controlador controlador;

    public diseño() {
        modelo_nuevo_evento modelo_nuevo_evento= new modelo_nuevo_evento();
        controlador=new controlador(this,modelo_nuevo_evento);

        add(modelo_nuevo_evento);
        setVisible(true);
//        tabbedPane1.addTab("evntos",modelo_nuevo_evento);
//        add(tabbedPane1);
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(descripcion.getText());
                System.out.println(correo.getText());
                System.out.println(fecha.getText());
                System.out.println(alarmaCheckBox.isSelected());
            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                limpiar();
            }
        });
    }





}



