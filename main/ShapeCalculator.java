package main;
import gui.ShapeGUI;
import javax.swing.SwingUtilities;

/**
 * <p>
 *  Main class for program execution - First graphical interface in Java
 *  </p>
 *
 *  @since 10/10/21
 *  @version 1.0
 */


public class ShapeCalculator
{
  public static void main(String[] args) throws Exception
  {
    SwingUtilities.invokeLater(new Runnable()
    {
      @Override
      public void run()
      {
        ShapeGUI executable = new ShapeGUI();
        executable.setVisible(true);
      }
    });
  }
}
