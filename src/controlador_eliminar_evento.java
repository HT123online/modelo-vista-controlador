import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controlador_eliminar_evento {

    private diseno capa_diseno;
    private controlador capa_controlador;

    public controlador_eliminar_evento(diseno capa_diseno){
        this.capa_diseno=capa_diseno;
        //cargar_tabla();
        crear_tabla();
    }
    public void cargar_tabla(String descripcion, String correo, String fecha, String frecuencia, Boolean alarma){
        String data[] = {descripcion,correo,fecha,frecuencia,Boolean.toString(alarma)};                                                                  //(alarmaCheckBox.isSelected()) ? "true":"false"
        capa_diseno.tabla_eliminar_evento.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(new JCheckBox()));
        DefaultTableModel tb=(DefaultTableModel)capa_diseno.tabla_eliminar_evento.getModel();
        tb.addRow(data);



    }
    public void crear_tabla(){
        capa_diseno.tabla_eliminar_evento.setModel(new DefaultTableModel(null, new String[]{"descripcion", "correo", "fecha", "frecuencia", "alarma","Desactivar"}));
        capa_diseno.getGuardarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //"descripcion", "correo", "fecha", "frecuencia", "alarma"
                String descripcion= capa_diseno.descripcion.getText();
                String correo= capa_diseno.correo.getText();
                String fecha= capa_diseno.fecha.getText();
                Boolean alarma=capa_diseno.getAlarmaCheckBox().isSelected();
                String frecuencia;

                if (capa_diseno.diario.isSelected()){
                    System.out.println("diario");
                    frecuencia="diario";
                }
                else if(capa_diseno.semanal.isSelected()){
                    System.out.println("semanal");
                    frecuencia="semanal";
                }
                else {
                    System.out.println("mensual");
                    frecuencia="mensual";
                }
                //capa_diseno.eliminar=new JCheckBox();
                //capa_modelo.crear_tabla(descripcion,correo,fecha,alarma);

                //crear_tabla(descripcion,correo,fecha,frecuencia,alarma);

                //capa_modelo.crear_tabla(descripcion,correo,fecha,alarma);
                //System.out.println(capa_diseno.eliminar=new JCheckBox());
                cargar_tabla(descripcion,correo,fecha,frecuencia,alarma);
            }
        });
    }

    public void eliminar(){

    }
}
