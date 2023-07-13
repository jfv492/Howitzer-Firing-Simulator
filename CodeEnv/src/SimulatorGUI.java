import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * References:
 *  1. https://www.youtube.com/watch?v=5o3fMLPY7qY
 *  2. https://www.youtube.com/watch?v=Kmgo00avvEw
 *  3. https://www.youtube.com/watch?v=iE8tZ0hn2Ws
 */

public class SimulatorGUI {
    private int fireCount = 0;

    public SimulatorGUI() {
        JFrame frame = new JFrame();
        JButton button = new JButton("Launch Projectile");
        JLabel label = new JLabel("Number of Fires: 0");


        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //User input starts from here

                // Adding a grid layout for the dialogue box
                JPanel inputPanel = new JPanel(new GridLayout(0, 2));

                // Making the text fields for the inputs
                JTextField xField = new JTextField(10);
                JTextField yField = new JTextField(10);
                JTextField zField = new JTextField(10);
                JTextField angleField = new JTextField(10);
                JTextField radiusField = new JTextField(10);
                JTextField massField = new JTextField(10);
                JTextField dragCoefficientField = new JTextField(10);
                JTextField initialSpeedField = new JTextField(10);
                JTextField externalForceXField = new JTextField(10);
                JTextField externalForceYField = new JTextField(10);
                JTextField externalForceZField = new JTextField(10);

                //Adding the labels for the text fields
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
                inputPanel.add(new JLabel("Enter the Drag Coefficient Value: "));
                inputPanel.add(dragCoefficientField);
                inputPanel.add(new JLabel("Enter the Initial Speed: "));
                inputPanel.add(initialSpeedField);
                inputPanel.add(new JLabel("Enter the value of External Force at X: "));
                inputPanel.add(externalForceXField);
                inputPanel.add(new JLabel("Enter the value of External Force at Y:"));
                inputPanel.add(externalForceYField);
                inputPanel.add(new JLabel("Enter the value of External Force at Z:"));
                inputPanel.add(externalForceZField);


                // To show the values in  separate dialogue box.
                int result = JOptionPane.showConfirmDialog(frame, inputPanel, "Enter Values",
                        JOptionPane.OK_CANCEL_OPTION);

                // Adding a if statement to check if we got the input from the user
                if (result == JOptionPane.OK_OPTION) {
                    double setBarrelPoseX = Double.parseDouble(xField.getText());
                    double setBarrelPoseY = Double.parseDouble(yField.getText());
                    double setBarrelPoseZ = Double.parseDouble(zField.getText());
                    double setAngle = Double.parseDouble(angleField.getText());
                    double setRadius = Double.parseDouble(radiusField.getText());
                    double setMass = Double.parseDouble(massField.getText());
                    double setDragCoefficient = Double.parseDouble(dragCoefficientField.getText());
                    double setInitialSpeed = Double.parseDouble(initialSpeedField.getText());
                    double setExternalForceX = Double.parseDouble(externalForceXField.getText());
                    double setExternalForceY = Double.parseDouble(externalForceYField.getText());
                    double setExternalForceZ = Double.parseDouble(externalForceZField.getText());

                    //Running the simulation
                    Simulator simulator = new Simulator();

                    simulator.setBarrelPose(setBarrelPoseX, setBarrelPoseY, setBarrelPoseZ, setAngle);
                    simulator.setRadius(setRadius);
                    simulator.setMass(setMass);
                    simulator.setInitialSpeed(setInitialSpeed);
                    simulator.setExternalForce(setExternalForceX, setExternalForceY, setExternalForceZ);

                    double[] position = simulator.simulation();

                    //Display the results

                    StringBuilder showResults = new StringBuilder();
                    showResults.append("The position of the projectile after the simulation is: ");
                    showResults.append("x: ").append(position[0]).append(" , ");
                    showResults.append("y: ").append(position[1]).append(" , ");
                    showResults.append("z: ").append(position[2]);
                    JOptionPane.showMessageDialog(frame, showResults.toString());

                    fireCount++;
                    label.setText("Number of Fires: " + fireCount);

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


    public static void main(String[] args) {

        //Creating a constructor
        new SimulatorGUI();
    }
}


   
    

