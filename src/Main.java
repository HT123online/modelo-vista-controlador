import javax.swing.*;

public class Main extends JFrame {
 public static void main(String[] args) {
  // Crear ventana
  JFrame frame = new JFrame("Mi Formulario Swing");

  // Instanciar el formulario
  diseño form = new diseño();

  // Usar el panel del formulario como contenido
  frame.setContentPane(form.getPanel());

  // Configuración básica
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.pack(); // Ajusta al tamaño preferido de los componentes
  frame.setVisible(true);
 }
}
