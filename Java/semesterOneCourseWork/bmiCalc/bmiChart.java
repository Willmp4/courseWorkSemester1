package Java.semesterOneCourseWork.bmiCalc;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class bmiChart extends JFrame {

  ImageIcon Chart = new ImageIcon("BMIchart.jfif");
  private JPanel contentPane;

  public bmiChart() {
    // Creates new object named BMIChart
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(1, 1, 800, 600);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setLayout(new BorderLayout(0, 0));
    setContentPane(contentPane);

    JLabel lb = new JLabel("");
    contentPane.add(lb, BorderLayout.CENTER);
    lb.setIcon(Chart);
    // Sets the image of chart
    // And gets set visible when bmiChart button is pressed

  }

  public static void main(String[] args) {
    EventQueue.invokeLater(
      new Runnable() {
        public void run() {
          try {
            bmiChart frame = new bmiChart();
            frame.setVisible(true);
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      }
    );
  }
}
