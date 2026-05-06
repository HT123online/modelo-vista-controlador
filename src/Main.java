import javax.swing.*;

public class Main{
 public static void main(String[] args) {

  SwingUtilities.invokeLater(new Runnable() {
   @Override
   public void run() {
    createGUI();
   }
  });

 }
 private static void createGUI(){
      diseno ui=new diseno();
      JPanel root=ui.getRootPanel();
      JFrame frame=new JFrame();
      frame.setContentPane(root);
      frame.pack();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
  }
}

