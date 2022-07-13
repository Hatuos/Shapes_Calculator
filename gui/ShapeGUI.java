package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import shape.twodshapes.*;

/**
 * <p>
 *  Class for the implementation of the graphical interface
 *  </p>
 *
 *  <p>
 *  The class sets out the methods needed to:
 *  <ul>
 *  <li> Initialise GUI for geometric shapes </li>
 *  </ul>
 *  </p>
 *
 *  @since 20/10/21
 *  @version 1.0
 */


public class ShapeGUI extends JFrame
{
  //Attributes
  private JPanel panel;

  /**
   * Default constructor
   */
  public ShapeGUI()
  {
    initUI();
  }


  private void initUI()
  {

    panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));  // Allows absolute positioning

    // Panel for the selection of figures
    JPanel shapePanel = new JPanel();
    shapePanel.setLayout(new BoxLayout(shapePanel, BoxLayout.X_AXIS));
    final JLabel shapeLabel = new JLabel("Select a Shape: ");
    final String shapeOptions[] = {"Circle", "Square", "Triangle"};
    final JComboBox<String> shapeList = new JComboBox<String>(shapeOptions);
    shapePanel.add(shapeLabel);
    shapePanel.add(shapeList);
    panel.add(shapePanel);

    // Panel for the area section
    final JPanel areaPanel = new JPanel();
    areaPanel.setLayout(new BoxLayout(areaPanel, BoxLayout.X_AXIS));
    final JLabel areaLabel = new JLabel("Calculate Area: ");
    final JPanel areaParametersPanel = new JPanel();
    areaParametersPanel.setLayout(new BoxLayout(areaParametersPanel, BoxLayout.Y_AXIS));
    areaPanel.add(areaLabel);
    areaPanel.add(areaParametersPanel);
    panel.add(areaPanel);

    // Panel for the perimeter section
    JPanel perimeterPanel = new JPanel();
    JLabel perimeterLabel = new JLabel("Calculate Perimeter: ");
    final JPanel perimeterParametersPanel = new JPanel();
    perimeterParametersPanel.setLayout(new BoxLayout(perimeterParametersPanel, BoxLayout.Y_AXIS));
    perimeterPanel.add(perimeterLabel);
    perimeterPanel.add(perimeterParametersPanel);
    panel.add(perimeterPanel);

    setupCircle(areaParametersPanel, perimeterParametersPanel);

    // Event Detector - Figure selection
    shapeList.addItemListener(new ItemListener()
    {
      public void itemStateChanged(ItemEvent event)
      {
        if (event.getStateChange() == ItemEvent.SELECTED)
        {
          areaParametersPanel.removeAll();
          perimeterParametersPanel.removeAll();
          String shapeName = (String) shapeList.getSelectedItem();

          if(shapeName.equals("Circle"))
            setupCircle(areaParametersPanel, perimeterParametersPanel);
          else if(shapeName.equals("Square"))
            setupSquare(areaParametersPanel, perimeterParametersPanel);
          else
            setupTriangle(areaParametersPanel, perimeterParametersPanel);
        }
      }
    });

    add(panel);
    pack();
    setTitle("Shape Calculator");
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  private void setupTriangle(JPanel areaParametersPanel, JPanel perimeterParametersPanel)
  {
    // Panels for the sides of the triangle
    JPanel sideAPanel = new JPanel();
    sideAPanel.setLayout(new BoxLayout(sideAPanel, BoxLayout.X_AXIS));
    JLabel sideALabel = new JLabel("Enter sideA here: ");
    final JTextField sideABox = new JTextField(24);
    sideAPanel.add(sideALabel);
    sideAPanel.add(sideABox);

    JPanel sideBPanel = new JPanel();
    sideBPanel.setLayout(new BoxLayout(sideBPanel, BoxLayout.X_AXIS));
    JLabel sideBLabel = new JLabel("Enter sideB here: ");
    final JTextField sideBBox = new JTextField(24);
    sideBPanel.add(sideBLabel);
    sideBPanel.add(sideBBox);

    JPanel sideCPanel = new JPanel();
    sideCPanel.setLayout(new BoxLayout(sideCPanel, BoxLayout.X_AXIS));
    JLabel sideCLabel = new JLabel("Enter sideC here: ");
    final JTextField sideCBox = new JTextField(24);
    sideCPanel.add(sideCLabel);
    sideCPanel.add(sideCBox);

    // Resolution area panel
    JPanel areaSolutionPanel = new JPanel();
    areaSolutionPanel.setLayout(new BoxLayout(areaSolutionPanel, BoxLayout.X_AXIS));
    JButton solveAreaButton = new JButton("Solve");
    final JTextField areaSolutionField = new JTextField(24);
    areaSolutionField.setBackground(Color.WHITE);
    areaSolutionField.setEditable(false);

    areaSolutionPanel.add(solveAreaButton);
    areaSolutionPanel.add(areaSolutionField);
    areaParametersPanel.add(sideAPanel);
    areaParametersPanel.add(sideBPanel);
    areaParametersPanel.add(sideCPanel);
    areaParametersPanel.add(areaSolutionPanel);

    solveAreaButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent event)
      {
        Triangle triangle = null;
        try
        {
          triangle = new Triangle(Double.parseDouble(sideABox.getText()), Double.parseDouble(sideBBox.getText()), Double.parseDouble(sideCBox.getText()));
        } catch (Exception e)
        {
          e.printStackTrace();
        }
        areaSolutionField.setText(triangle.calculateArea()+"");
      }
    });

    JPanel perimeterSolutionPanel = new JPanel();
    perimeterSolutionPanel.setLayout(new BoxLayout(perimeterSolutionPanel, BoxLayout.X_AXIS));
    JButton solvePerimeterButton = new JButton("Solve");
    final JTextField perimeterSolutionField = new JTextField(24);
    perimeterSolutionField.setBackground(Color.WHITE);
    perimeterSolutionField.setEditable(false);

    perimeterSolutionPanel.add(solvePerimeterButton);
    perimeterSolutionPanel.add(perimeterSolutionField);

    solvePerimeterButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent event)
      {
        Triangle triangle = null;
        try
        {
          triangle = new Triangle(Double.parseDouble(sideABox.getText()), Double.parseDouble(sideBBox.getText()), Double.parseDouble(sideCBox.getText()));
        } catch (Exception e)
        {
          e.printStackTrace();
        }
        perimeterSolutionField.setText(triangle.calculatePerimeter()+"");
      }
    });

    perimeterParametersPanel.add(perimeterSolutionPanel);

    areaParametersPanel.revalidate();
    areaParametersPanel.repaint();
    perimeterParametersPanel.revalidate();
    perimeterParametersPanel.repaint();
    pack();
  }


  private void setupSquare(JPanel areaParametersPanel, JPanel perimeterParametersPanel)
  {
    JPanel areaSidePanel = new JPanel();
    areaSidePanel.setLayout(new BoxLayout(areaSidePanel, BoxLayout.X_AXIS));
    JLabel areaSideLabel = new JLabel("Enter side here: ");
    final JTextField areaSideBox = new JTextField(24);
    areaSidePanel.add(areaSideLabel);
    areaSidePanel.add(areaSideBox);


    JPanel areaSolutionPanel = new JPanel();
    areaSolutionPanel.setLayout(new BoxLayout(areaSolutionPanel, BoxLayout.X_AXIS));
    JButton solveAreaButton = new JButton("Solve");
    final JTextField areaSolutionField = new JTextField(24);
    areaSolutionField.setBackground(Color.WHITE);
    areaSolutionField.setEditable(false);

    areaSolutionPanel.add(solveAreaButton);
    areaSolutionPanel.add(areaSolutionField);
    areaParametersPanel.add(areaSidePanel);
    areaParametersPanel.add(areaSolutionPanel);

    solveAreaButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent event)
      {
        Square square = new Square(Double.parseDouble(areaSideBox.getText()));
        areaSolutionField.setText(square.calculateArea()+"");
      }
    });

    JPanel perimeterSolutionPanel = new JPanel();
    perimeterSolutionPanel.setLayout(new BoxLayout(perimeterSolutionPanel, BoxLayout.X_AXIS));
    JButton solvePerimeterButton = new JButton("Solve");
    final JTextField perimeterSolutionField = new JTextField(24);
    perimeterSolutionField.setBackground(Color.WHITE);
    perimeterSolutionField.setEditable(false);

    perimeterSolutionPanel.add(solvePerimeterButton);
    perimeterSolutionPanel.add(perimeterSolutionField);

    solvePerimeterButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent event) {
        Square square = new Square(Double.parseDouble(areaSideBox.getText()));
        perimeterSolutionField.setText(square.calculatePerimeter()+"");
      }
    });

    perimeterParametersPanel.add(perimeterSolutionPanel);

    areaParametersPanel.revalidate();
    areaParametersPanel.repaint();
    perimeterParametersPanel.revalidate();
    perimeterParametersPanel.repaint();
    pack();
  }

  private void setupCircle(JPanel areaParametersPanel, JPanel perimeterParametersPanel)
  {
    JPanel areaRadiusPanel = new JPanel();
    areaRadiusPanel.setLayout(new BoxLayout(areaRadiusPanel, BoxLayout.X_AXIS));
    JLabel areaRadiusLabel = new JLabel("Enter radius here: ");
    final JTextField areaRadiusBox = new JTextField(24);
    areaRadiusPanel.add(areaRadiusLabel);
    areaRadiusPanel.add(areaRadiusBox);

    JPanel areaSolutionPanel = new JPanel();
    areaSolutionPanel.setLayout(new BoxLayout(areaSolutionPanel, BoxLayout.X_AXIS));
    JButton solveAreaButton = new JButton("Solve");
    final JTextField areaSolutionField = new JTextField(24);
    areaSolutionField.setBackground(Color.WHITE);
    areaSolutionField.setEditable(false);

    areaSolutionPanel.add(solveAreaButton);
    areaSolutionPanel.add(areaSolutionField);
    areaParametersPanel.add(areaRadiusPanel);
    areaParametersPanel.add(areaSolutionPanel);

    solveAreaButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent event)
      {
        Circle circle = new Circle(Double.parseDouble(areaRadiusBox.getText()));
        areaSolutionField.setText(circle.calculateArea()+"");
      }
    });

    JPanel perimeterSolutionPanel = new JPanel();
    perimeterSolutionPanel.setLayout(new BoxLayout(perimeterSolutionPanel, BoxLayout.X_AXIS));
    JButton solvePerimeterButton = new JButton("Solve");
    final JTextField perimeterSolutionField = new JTextField(24);
    perimeterSolutionField.setBackground(Color.WHITE);
    perimeterSolutionField.setEditable(false);

    perimeterSolutionPanel.add(solvePerimeterButton);
    perimeterSolutionPanel.add(perimeterSolutionField);

    solvePerimeterButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        Circle circle = new Circle(Double.parseDouble(areaRadiusBox.getText()));
        perimeterSolutionField.setText(circle.calculatePerimeter()+"");
      }
    });

    perimeterParametersPanel.add(perimeterSolutionPanel);

    areaParametersPanel.revalidate();
    areaParametersPanel.repaint();
    perimeterParametersPanel.revalidate();
    perimeterParametersPanel.repaint();
    pack();
  }


}
