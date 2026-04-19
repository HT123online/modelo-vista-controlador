import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.text.View;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class modelo_nuevo_evento extends JPanel {
    private static final String FILE = "listatxt";
    private List<View> views = new ArrayList<>();
    private String notice;

    private boolean DEBUG = false;

    public modelo_nuevo_evento() {
        super(new GridLayout(1,0));

        String[] columnNames = {"fecha",
                "descripcion",
                "frecuencia",
                "correo",
                "Alarma"};

        Object[][] data = {
                {"Reunión de equipo de investigación", "equipo.investigacion@uni.edu.pe",
                        "2026-04-20", "semanal", new Boolean(true)},

                {"Clase de programación avanzada", "profesor.curso@edu.pe",
                        "2026-04-22", "diario", new Boolean(false)},

                {"Taller de diseño de logos", "creativos@studio.com",
                        "2026-04-25", "mensual", new Boolean(true)},
//;;;único;sí
                {"Presentación de proyecto satelital", "nasa.spaceapps@challenge.org",
                        "2026-04-28","unico", new Boolean(true)},
//;;;semanal;no
                {"Sesión de juego y optimización", "gaming.club@community.net",
                        "2026-05-01", "semanal", new Boolean(true)}};

        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        if (DEBUG) {
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    printDebugData(table);
                }
            });
        }

        JScrollPane scrollPane = new JScrollPane(table);


        add(scrollPane);
    }

    public Vector<Vector<Object>> getEvents() throws Exception
    {
        Vector<Vector<Object>> response = new Vector<Vector<Object>>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(FILE)));
            String line = reader.readLine();

            while (line != null) {
                Vector<Object> eventInfo = new Vector<Object>();
                String[] tokens = line.split(";");

                eventInfo.add(tokens[0]);
                eventInfo.add(tokens[1]);
                //eventInfo.add(Frequency.valueOf(tokens[2]));
                eventInfo.add(tokens[3]);
                eventInfo.add(tokens[4].equals("1") ? "ON" : "OFF");

                response.add(eventInfo);
                line = reader.readLine();
                System.out.println(response);
            }

            reader.close();

        } catch (FileNotFoundException fnfe) {
            notice = "File not found";

        } catch (Exception ex) {
            notice = "There was a problem reading the event file";

        }

        return response;
    }

    private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();

        System.out.println("Value of data: ");
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("SimpleTableDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        modelo_nuevo_evento newContentPane = new modelo_nuevo_evento();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public void saveEvent(modelo_nuevo_evento event) throws Exception
    {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(FILE), true));
            writer.write(event.toString(), 0, event.toString().length());
            writer.newLine();
            writer.close();
        } catch (FileNotFoundException fnfe) {
            notice = "File not found";

        } catch (Exception ex) {


        }
    }





    public static void main(String[] args) throws Exception {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        modelo_nuevo_evento model=new modelo_nuevo_evento();
        model.getEvents();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

    }
}