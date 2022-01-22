package Java.semesterOneCourseWork.bmiCalc;

/**
 * This is a programme to calculate a BMI result for the user. This programme extends JFrame which allows me to use
 * Action Listener and use all the components of a JFrame. The programme takes in two inputs(weight and height). And using
 * either the imperial system or the metric system and using the respective formulas.
 * @author William Bruckmann
 */
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class bmiCalcJFrame extends JFrame {

  public int index;
  public static boolean System = true; // True for metric and false for imperial.
  public static JPanel contentPane; // To add all the JLabels on to to make them visible
  public static JTextField Height, Result, Weight; // To get the user input using Jframe
  public static JLabel HeightLbl, WeightLbl, Title, BmiLbl; // To display the fields the user should enter in
  public static JRadioButton Metric = new JRadioButton("Metric"); // To change systems of calcing the bmi
  public static JRadioButton Imperial = new JRadioButton("Imperial");

  public bmiCalcJFrame() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 407, 324);
    contentPane = new JPanel();
    contentPane.setBackground(Color.LIGHT_GRAY);
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    Title = new JLabel("Body Mass Index");
    Title.setFont(new Font("Tahoma", Font.PLAIN, 33));
    Title.setBounds(10, -5, 276, 88);
    contentPane.add(Title); // This is the title

    HeightLbl = new JLabel("Enter height in CM");
    HeightLbl.setFont(new Font("Segoe UI Light", Font.BOLD, 16));
    HeightLbl.setBounds(31, 91, 232, 29);
    contentPane.add(HeightLbl); // This is display where to enter height, default kg

    WeightLbl = new JLabel("Enter weight in KG");
    WeightLbl.setFont(new Font("Segoe UI Light", Font.BOLD, 16));
    WeightLbl.setBounds(31, 131, 232, 33);
    contentPane.add(WeightLbl); // This is display where to enter weight ,default kg

    BmiLbl = new JLabel("Your BMI");
    BmiLbl.setFont(new Font("Segoe UI Light", Font.BOLD, 16));
    BmiLbl.setBounds(31, 175, 108, 33);
    contentPane.add(BmiLbl); // Where the Bmi will be displayed

    Height = new JTextField();
    Height.setBounds(274, 94, 96, 32);
    contentPane.add(Height);
    Height.setColumns(10); // To grab user input for height

    Weight = new JTextField();
    Weight.setBounds(274, 134, 96, 33);
    contentPane.add(Weight);
    Weight.setColumns(10); // To grab user input for weight

    Result = new JTextField();
    Result.setBounds(123, 178, 96, 33);
    contentPane.add(Result);
    Result.setColumns(10);

    JButton calculate = new JButton("Calculate BMI");
    calculate.addActionListener(
      new ActionListener() {
        // This is the logic for the calculation
        public void actionPerformed(ActionEvent e) {
          if (!Height.getText().equals("") && !Weight.getText().equals("")) {
            if (
              CheckNumber(Height.getText(), true) && // pass the input, true means float or int
              CheckNumber(Weight.getText(), true)
            ) {
              String BMI = CalcBMI();
              Result.setText(BMI);
            } else {
              Title.setFont((new Font("Tahoma", Font.PLAIN, 20)));
              Typo("Enter only Digits");
            }
          } else {
            Typo("Fill areas");
          }
        } // end of action pressed
      }
    );
    calculate.setBounds(10, 219, 113, 23);
    contentPane.add(calculate);

    JButton reset = new JButton("Reset ");
    reset.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          Height.setText(null);
          Weight.setText(null);
          Result.setText(null);
          Result.setBackground(Color.WHITE);
          Title.setText("Body Mass Index");
          Title.setForeground(Color.BLACK);
        }
      }
    );
    reset.setBounds(133, 219, 113, 23);
    contentPane.add(reset);

    JButton BMIChart = new JButton("BMI Chart");
    BMIChart.addActionListener(
      new ActionListener() {
        // Button to diplay a BMI chart to show user where they are on the chart
        public void actionPerformed(ActionEvent e) {
          new bmiChart().setVisible(true);
          // When pressed will set BMIChart to true making it visible
        }
      }
    );
    BMIChart.setBounds(262, 219, 108, 23);
    contentPane.add(BMIChart);

    Metric = new JRadioButton("Metric");
    Metric.setSelected(true);
    Metric.addActionListener(
      new ActionListener() {
        // To change calc methode to metric
        public void actionPerformed(ActionEvent e) {
          System = true;
          Height.setText(null);
          Weight.setText(null);
          Result.setText(null);
          Result.setBackground(null);
          HeightLbl.setText("Enter Height in CM");
          WeightLbl.setText("Enter Weight in KG");
          // Resets all Text boxs(to get user input) to nothing and makes system = true;
          // which is default
        }
      }
    );
    Metric.setBounds(282, 11, 111, 23);
    contentPane.add(Metric);

    Imperial = new JRadioButton("Imperial");
    Imperial.addActionListener(
      new ActionListener() {
        // To change to imperial system
        public void actionPerformed(ActionEvent e) {
          System = false;
          Height.setText(null);
          Weight.setText(null);
          Result.setText(null);
          Result.setBackground(null);
          HeightLbl.setText("Enter Height in Feet.Inches");
          WeightLbl.setText("Enter Weight in Pounds");
          // Does what metric button does but makes system to false.
        }
      }
    );
    Imperial.setBounds(282, 37, 111, 23);
    contentPane.add(Imperial);

    ButtonGroup system = new ButtonGroup();
    system.add(Metric);
    system.add(Imperial);
  } //End of JFrame

  // End of Jframe display
  // Logic
  public static String CalcBMI() {
    // Methode to calc BMi
    float height = Float.parseFloat(Height.getText());
    float weight = Float.parseFloat(Weight.getText());
    // Changes string to float
    if (System) {
      height /= 100;
      // Changes height to cm from meters
    } else {
      height *= 12;
      weight *= 703;
      // Calc to feet and inches and weight in pounds
    }
    float index = (float) (weight / (height * height));
    // BMI formula

    // If statmenst to change the backround colour of result to corasponing colours
    if (index <= 24.9) {
      Result.setOpaque(true);
      Result.setBackground(Color.GREEN);
      Result.setForeground(Color.BLACK);
    } else if (index <= 29.9) {
      Result.setOpaque(true);
      Result.setBackground(Color.YELLOW);
      Result.setForeground(Color.BLACK);
    } else if (index <= 34.9) {
      Result.setOpaque(true);
      Result.setBackground(Color.ORANGE);
      Result.setForeground(Color.BLACK);
    } else if (index <= 39.9) {
      Result.setOpaque(true);
      Result.setBackground(Color.RED);
      Result.setForeground(Color.BLACK);
    } else {
      Result.setOpaque(true);
      Result.setBackground(Color.RED);
      Result.setForeground(Color.BLACK);
    }
    String bmi = String.format("%.2f", index);
    // Make the result of bmi to 2sf.
    return bmi;
  }

  public static void Typo(String error) {
    Title.setText(error); // passed string changes the colour
    Title.setForeground(Color.RED); // as this is used for error control, changes text colour to red
  }

  public static boolean CheckNumber(String string, boolean floatInt) {
    if (floatInt) { // checking for floating number
      try { // test the following code for exception errors
        Float.parseFloat(string); // try to parse a floating number from user input
      } catch (Exception e) { // exception error was cought, user input is invalid
        return false; // return false boolean to event system, it warns the user
      }
    } // end of floating number check
    else { // checking for integer
      try { // check for exceptions
        Integer.parseInt(string); // parse an integer from user input
      } catch (Exception e) { // exception caught, without this the program would terminate with an error
        return false; // return a false boolean to event to warn the user
      }
    } // end of integer check
    return true; // no exceptions caught, user input is correct, return a true boolean
  } // end of number check

  public static void main(String[] args) {
    EventQueue.invokeLater(
      new Runnable() {
        public void run() {
          try {
            bmiCalcJFrame frame = new bmiCalcJFrame();
            frame.setVisible(true);
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      }
    );
  }
}
