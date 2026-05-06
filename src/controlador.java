import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class controlador {
    private diseno capa_diseno;
    private modelo_nuevo_evento capa_modelo;


    public controlador(diseno capa_diseno,modelo_nuevo_evento capa_modelo){
        this.capa_diseno = capa_diseno;
        this.capa_modelo = capa_modelo;
        //modelo=new DefaultTableModel();
        rellenar_campo();
    }

    public void rellenar_campo(){
        if (capa_diseno.descripcion.getText().isEmpty()||capa_diseno.correo.getText().isEmpty()){
            System.out.println();

        }
        capa_diseno.getGuardarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //"descripcion", "correo", "fecha", "frecuencia", "alarma"
                String descripcion= capa_diseno.descripcion.getText();
                String correo= capa_diseno.correo.getText();
                String fecha= capa_diseno.fecha.getText();
                String frecuencia="";//capa_diseno.diario.isSelected() ? "s":"n";
                Boolean alarma=capa_diseno.getAlarmaCheckBox().isSelected();

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
                //capa_modelo.crear_tabla(descripcion,correo,fecha,alarma);

                crear_tabla(descripcion,correo,fecha,frecuencia,alarma);
            }
        });
//        String descripcion= String.valueOf(capa_diseno.getdescripcion());
//        String correo= String.valueOf(capa_diseno.getcorreo());
//        String fecha= String.valueOf(capa_diseno.getfecha());
//        Boolean alarma=capa_diseno.getAlarmaCheckBox().isSelected();

//        String data[]=modelo_nuevo_evento.crear_tabla(descripcion,correo,fecha, String.valueOf(alarma));
//        capa_diseno.setTabla_eventos();

                //descripcion.getText(),correo.getText(),fecha.getText(),"",alarmaCheckBox.isSelected()
    }
    public void crear_tabla(String descripcion, String correo, String fecha,String frecuencia, Boolean alarma) {
        String data[] = {descripcion,correo,fecha,frecuencia,Boolean.toString(alarma)};                                                                  //(alarmaCheckBox.isSelected()) ? "true":"false"
        DefaultTableModel tb=(DefaultTableModel)capa_diseno.tabla_ver_eventos.getModel();
        tb.addRow(data);
        //System.out.println(String.valueOf(capa_diseno.getdescripcion()));
    }
}
