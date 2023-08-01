import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

// import org.jfree.chart.ChartFactory;
// import org.jfree.chart.ChartPanel;
// import org.jfree.chart.JFreeChart;
// import org.jfree.chart.plot.PlotOrientation;
// import org.jfree.data.xy.XYSeries;
// import org.jfree.data.xy.XYSeriesCollection;


/*
 * References:
 *  1. https://www.youtube.com/watch?v=5o3fMLPY7qY
 *  2. https://www.youtube.com/watch?v=Kmgo00avvEw
 *  3. https://www.youtube.com/watch?v=iE8tZ0hn2Ws
 */

public class SimulatorGUI {
    private int fireCount = 0;
    private Simulator simulator;
    private double[] position; // Declare position variable at the class level

    public SimulatorGUI() {
        JFrame frame = new JFrame();
        JButton button = new JButton("Launch Projectile");
        JLabel label = new JLabel("Number of Fires: 0");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                simulator = new Simulator();

                // User input code starts here
                JPanel inputPanel = new JPanel(new GridLayout(0, 2));

                JTextField xField = new JTextField(10);
                JTextField yField = new JTextField(10);
                JTextField zField = new JTextField(10);
                JTextField angleField = new JTextField(10);
                JTextField radiusField = new JTextField(10);
                JTextField massField = new JTextField(10);
                JTextField initialSpeedField = new JTextField(10);
                JTextField externalForceXField = new JTextField(10);
                JTextField externalForceYField = new JTextField(10);
                JTextField externalForceZField = new JTextField(10);

                inputPanel.add(new JLabel("Enter the Barrel Position at X: "));
                inputPanel.add(xField);
                inputPanel.add(new JLabel("Enter the Barrel Position at Y: "));
                inputPanel.add(yField);
                inputPanel.add(new JLabel("Enter the Barrel Position at Z: "));
                inputPanel.add(zField);
                inputPanel.add(new JLabel("Enter the angle of Barrel (in radians): "));
                inputPanel.add(angleField);
                inputPanel.add(new JLabel("Enter the radius of the projectile: "));
                inputPanel.add(radiusField);
                inputPanel.add(new JLabel("Enter the mass of the projectile: "));
                inputPanel.add(massField);
                inputPanel.add(new JLabel("Enter the Initial Speed: "));
                inputPanel.add(initialSpeedField);
                inputPanel.add(new JLabel("Enter the value of External Force at X: "));
                inputPanel.add(externalForceXField);
                inputPanel.add(new JLabel("Enter the value of External Force at Y:"));
                inputPanel.add(externalForceYField);
                inputPanel.add(new JLabel("Enter the value of External Force at Z:"));
                inputPanel.add(externalForceZField);

                int result = JOptionPane.showConfirmDialog(frame, inputPanel, "Enter Values",
                        JOptionPane.OK_CANCEL_OPTION);
                // User input code ends here

                if (result == JOptionPane.OK_OPTION) {
                    double setBarrelPoseX = Double.parseDouble(xField.getText());
                    double setBarrelPoseY = Double.parseDouble(yField.getText());
                    double setBarrelPoseZ = Double.parseDouble(zField.getText());
                    double setAngle = Double.parseDouble(angleField.getText());
                    double setRadius = Double.parseDouble(radiusField.getText());
                    double setMass = Double.parseDouble(massField.getText());
                    double setInitialSpeed = Double.parseDouble(initialSpeedField.getText());
                    double setExternalForceX = Double.parseDouble(externalForceXField.getText());
                    double setExternalForceY = Double.parseDouble(externalForceYField.getText());
                    double setExternalForceZ = Double.parseDouble(externalForceZField.getText());

                    Cannon cannon = new Cannon();
                    RoundShot round_shot = new RoundShot();
                    cannon.setBarrelPose(setBarrelPoseX, setBarrelPoseY, setBarrelPoseZ, setAngle);
                    round_shot.setRadius(setRadius);
                    round_shot.setMass(setMass);
                    cannon.setInitialSpeed(setInitialSpeed);
                    cannon.setExternalForce(setExternalForceX, setExternalForceY, setExternalForceZ);

                    position = simulator.simulation(cannon, round_shot);

                    double[] xValue = new double[position.length / 3];
                    double[] yValue = new double[position.length / 3];
                    for (int i = 0; i < position.length / 3; i++) {
                        xValue[i] = position[i * 3];
                        yValue[i] = position[i * 3 + 1];
                    }

                   // double maxHeight = getMaxHeight(yValue);

                    // Convert the maximum height to meters (adjust the scale factor as needed)
                    double scaleFactor = 50; // Assuming the scale is 50
                   // maxHeight /= scaleFactor;

                    // Display the results
                    StringBuilder showResults = new StringBuilder();
                    showResults.append("The position of the projectile after the simulation is:\n");
                    showResults.append("x: ").append(position[0]).append(", ");
                    showResults.append("y: ").append(position[1]).append(", ");
                    showResults.append("z: ").append(position[2]).append("\n");
                    showResults.append("\n Maximum Height Achieved by the Projectile: ").append(position[3]).append(" meters");
                    JOptionPane.showMessageDialog(frame, showResults.toString());

                    try {
                        String s = "Position of the projectile, " + position[0] + "," + position[1] + "," + position[2] + "\n" + "Max Height, "+ position[3];
                        saveResultsToCSV(s);
                        generateExcelFile();
                        System.out.println("CSV and Excel files generated successfully!");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        System.err.println("An error occurred while generating CSV and Excel files.");
                    }

                   fireCount++;
                    label.setText("Number of Fires: " + fireCount);

                   // frame.revalidate();
                   // frame.repaint();
                }
            }
        });

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Simulator Projection");
        frame.pack();
        frame.setVisible(true);




    }

//    private double getMaxHeight(double[] yValue) {
//        double maxHeight = yValue[0];
//        for (int i = 1; i < yValue.length; i++) {
//            if (yValue[i] > maxHeight) {
//                maxHeight = yValue[i];
//            }
//        }
//        return maxHeight;
//    }

     public void saveResultsToCSV(String s) throws IOException {
         String outputFilePath = "output.csv";

         try (PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath, true))) {
             writer.println(s);
         }
     }

     public void generateExcelFile() {
         String inputFilePath = "output.csv";
         String outputFilePath = "output.xlsx";

         try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
              FileWriter fileWriter = new FileWriter(outputFilePath);
              PrintWriter printWriter = new PrintWriter(fileWriter)) {

             String line;
             while ((line = br.readLine()) != null) {
                 String[] data = line.split(",");
                 for (String datum : data) {
                     printWriter.print(datum + "\t"); // Use tab as delimiter for Excel
                 }
                 printWriter.println(); // Move to the next row
             }

         } catch (IOException e) {
             e.printStackTrace();
         }
     }


    public static void main(String[] args) {
        new SimulatorGUI();
        // String workingDirectory = System.getProperty("user.dir");
        // System.out.println("Current working directory: " + workingDirectory);
    }
}