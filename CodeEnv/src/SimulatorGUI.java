// import javax.swing.*;
// import javax.swing.Timer;
// import java.awt.*;
// import java.util.*;
// import java.util.List;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;


// /*
//  * References:
//  *  1. https://www.youtube.com/watch?v=5o3fMLPY7qY
//  *  2. https://www.youtube.com/watch?v=Kmgo00avvEw
//  *  3. https://www.youtube.com/watch?v=iE8tZ0hn2Ws
//  */

// public class SimulatorGUI {
//     private int fireCount = 0;
//     private Trajectory trajectory;
//     private Simulator simulator;

//     public SimulatorGUI() {
//         JFrame frame = new JFrame();
//         JButton button = new JButton("Launch Projectile");
//         JLabel label = new JLabel("Number of Fires: 0");


//         button.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent e) {

//                 simulator = new Simulator();
//                 //User input starts from here

//                 // Adding a grid layout for the dialogue box
//                 JPanel inputPanel = new JPanel(new GridLayout(0, 2));

//                 // Making the text fields for the inputs
//                 JTextField xField = new JTextField(10);
//                 JTextField yField = new JTextField(10);
//                 JTextField zField = new JTextField(10);
//                 JTextField angleField = new JTextField(10);
//                 JTextField radiusField = new JTextField(10);
//                 JTextField massField = new JTextField(10);
//                 JTextField dragCoefficientField = new JTextField(10);
//                 JTextField initialSpeedField = new JTextField(10);
//                 JTextField externalForceXField = new JTextField(10);
//                 JTextField externalForceYField = new JTextField(10);
//                 JTextField externalForceZField = new JTextField(10);

//                 //Adding the labels for the text fields
//                 inputPanel.add(new JLabel("Enter the Barrel Position at X: "));
//                 inputPanel.add(xField);
//                 inputPanel.add(new JLabel("Enter the Barrel Position at Y: "));
//                 inputPanel.add(yField);
//                 inputPanel.add(new JLabel("Enter the Barrel Position at Z: "));
//                 inputPanel.add(zField);
//                 inputPanel.add(new JLabel("Enter the angle of Barrel (in radians): "));
//                 inputPanel.add(angleField);
//                 inputPanel.add(new JLabel("Enter the radius of the projectile: "));
//                 inputPanel.add(radiusField);
//                 inputPanel.add(new JLabel("Enter the mass of the projectile: "));
//                 inputPanel.add(massField);
//                 //inputPanel.add(new JLabel("Enter the Drag Coefficient Value: "));
//                 //inputPanel.add(dragCoefficientField);
//                 inputPanel.add(new JLabel("Enter the Initial Speed: "));
//                 inputPanel.add(initialSpeedField);
//                 inputPanel.add(new JLabel("Enter the value of External Force at X: "));
//                 inputPanel.add(externalForceXField);
//                 inputPanel.add(new JLabel("Enter the value of External Force at Y:"));
//                 inputPanel.add(externalForceYField);
//                 inputPanel.add(new JLabel("Enter the value of External Force at Z:"));
//                 inputPanel.add(externalForceZField);


//                 // To show the values in  separate dialogue box.
//                 int result = JOptionPane.showConfirmDialog(frame, inputPanel, "Enter Values",
//                         JOptionPane.OK_CANCEL_OPTION);


//                 // Adding a if statement to check if we got the input from the user
//                 if (result == JOptionPane.OK_OPTION) {
//                     double setBarrelPoseX = Double.parseDouble(xField.getText());
//                     double setBarrelPoseY = Double.parseDouble(yField.getText());
//                     double setBarrelPoseZ = Double.parseDouble(zField.getText());
//                     double setAngle = Double.parseDouble(angleField.getText());
//                     double setRadius = Double.parseDouble(radiusField.getText());
//                     double setMass = Double.parseDouble(massField.getText());
//                     //double setDragCoefficient = Double.parseDouble(dragCoefficientField.getText());
//                     double setInitialSpeed = Double.parseDouble(initialSpeedField.getText());
//                     double setExternalForceX = Double.parseDouble(externalForceXField.getText());
//                     double setExternalForceY = Double.parseDouble(externalForceYField.getText());
//                     double setExternalForceZ = Double.parseDouble(externalForceZField.getText());

//                     //Running the simulation
                   
//                     Cannon cannon = new Cannon();
//                     RoundShot round_shot = new RoundShot();
//                     cannon.setBarrelPose(setBarrelPoseX, setBarrelPoseY, setBarrelPoseZ, setAngle);
//                     round_shot.setRadius(setRadius);
//                     round_shot.setMass(setMass);
//                     cannon.setInitialSpeed(setInitialSpeed);
//                     cannon.setExternalForce(setExternalForceX, setExternalForceY, setExternalForceZ);

//                     double[] position = simulator.simulation(cannon,round_shot);

//                     double [] xValue = new double [position.length/3];
//                     double [] yValue = new double [position.length/3];
//                     for (int i = 0 ; i<position.length/3 ; i++)
//                     {
//                         xValue[i] = position[i *3];
//                         yValue[i] = position[i*3 +1];
//                     }

//                     Trajectory trajectoryPanel = new Trajectory(xValue, yValue);
//                     frame.add(trajectoryPanel, BorderLayout.SOUTH);

                    
                    


//                     //Display the results

//                     StringBuilder showResults = new StringBuilder();
//                     showResults.append("The position of the projectile after the simulation is: ");
//                     showResults.append("x: ").append(position[0]).append(" , ");
//                     showResults.append("y: ").append(position[1]).append(" , ");
//                     showResults.append("z: ").append(position[2]);
//                     JOptionPane.showMessageDialog(frame, showResults.toString());

//                     fireCount++;
//                     label.setText("Number of Fires: " + fireCount);

//                     frame.revalidate();
//                     frame.repaint();

//                 }

//             }

//         });

//         JPanel panel = new JPanel();
//         panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
//         panel.setLayout(new GridLayout(0, 1));
//         panel.add(button);
//         panel.add(label);

//         frame.add(panel, BorderLayout.CENTER);

       
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setTitle("Simulator Projection");
//         frame.pack();
//         frame.setVisible(true);

        


//     }

//     private class Trajectory extends JPanel{
//                     private double [] xValue;
//                     private double [] yValue;

//                     public Trajectory (double[] xValue, double[] yValue)
//                     {
//                         this.xValue = xValue;
//                         this.yValue = yValue;
//                         setPreferredSize(new Dimension(800, 600));
//                     }

//                     @Override
//                     protected void paintComponent(Graphics g)
//                     {
//                         super.paintComponent(g);

//                         int scale = 50; 
//                         for (int i = 1; i < xValue.length; i++) {
//                             int x1 = (int) (xValue[i - 1] * scale);
//                             int y1 = (int) (yValue[i - 1] * scale);
//                             int x2 = (int) (xValue[i] * scale);
//                             int y2 = (int) (yValue[i] * scale);
//                             g.drawLine(x1, getHeight() - y1, x2, getHeight() - y2);
//                         }
                        
//                         g.setColor(Color.BLACK);
//                         //Plotting X-Axis
//                         g.drawLine(0, getHeight()-10, getWidth(), getHeight()-10);
//                         //Plotting Y-Axis
//                         g.drawLine(10,0,10,getHeight());

//                     }


//                 }


//     public static void main(String[] args) {

//         //Creating a constructor
//         new SimulatorGUI();
//     }
// }

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulatorGUI {
    private int fireCount = 0;
    private Trajectory trajectory;
    private Simulator simulator;

    public SimulatorGUI() {
        JFrame frame = new JFrame();
        JButton button = new JButton("Launch Projectile");
        JLabel label = new JLabel("Number of Fires: 0");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                simulator = new Simulator();

                // User input starts from here

                // Adding a grid layout for the dialogue box
                JPanel inputPanel = new JPanel(new GridLayout(0, 2));

                // Making the text fields for the inputs
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

                // Adding the labels for the text fields
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

                // To show the values in a separate dialogue box.
                int result = JOptionPane.showConfirmDialog(frame, inputPanel, "Enter Values",
                        JOptionPane.OK_CANCEL_OPTION);

                // Adding an if statement to check if we got the input from the user
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

                    // Running the simulation
                    Cannon cannon = new Cannon();
                    RoundShot round_shot = new RoundShot();
                    cannon.setBarrelPose(setBarrelPoseX, setBarrelPoseY, setBarrelPoseZ, setAngle);
                    round_shot.setRadius(setRadius);
                    round_shot.setMass(setMass);
                    cannon.setInitialSpeed(setInitialSpeed);
                    cannon.setExternalForce(setExternalForceX, setExternalForceY, setExternalForceZ);

                    double[] position = simulator.simulation(cannon, round_shot);

                    double[] xValue = new double[position.length / 3];
                    double[] yValue = new double[position.length / 3];
                    for (int i = 0; i < position.length / 3; i++) {
                        xValue[i] = position[i * 3];
                        yValue[i] = position[i * 3 + 1];
                    }

                    // Display the results
                    StringBuilder showResults = new StringBuilder();
                    showResults.append("The position of the projectile after the simulation is: ");
                    showResults.append("x: ").append(position[0]).append(" , ");
                    showResults.append("y: ").append(position[1]).append(" , ");
                    showResults.append("z: ").append(position[2]);
                    JOptionPane.showMessageDialog(frame, showResults.toString());

                    fireCount++;
                    label.setText("Number of Fires: " + fireCount);

                    // Create a trajectory panel and plot the trajectory
                    if (trajectory != null) {
                        frame.remove(trajectory);
                    }
                    trajectory = new Trajectory(xValue, yValue);
                    frame.add(trajectory, BorderLayout.SOUTH);
                    frame.revalidate();
                    frame.repaint();
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

    private class Trajectory extends JPanel {
        private double[] xValue;
        private double[] yValue;

        public Trajectory(double[] xValue, double[] yValue) {
            this.xValue = xValue;
            this.yValue = yValue;
            setPreferredSize(new Dimension(800, 600));
        }

        public void setTrajectoryPoints(double[] xValue, double[] yValue) {
            this.xValue = xValue;
            this.yValue = yValue;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int scale = 50;
            for (int i = 1; i < xValue.length; i++) {
                int x1 = (int) (xValue[i - 1] * scale);
                int y1 = (int) (yValue[i - 1] * scale);
                int x2 = (int) (xValue[i] * scale);
                int y2 = (int) (yValue[i] * scale);
                g.drawLine(x1, getHeight() - y1, x2, getHeight() - y2);
            }

            g.setColor(Color.BLACK);
            // Plotting X-Axis
            g.drawLine(0, getHeight() - 10, getWidth(), getHeight() - 10);
            // Plotting Y-Axis
            g.drawLine(10, 0, 10, getHeight());
        }
    }

    public static void main(String[] args) {
        // Creating a constructor
        new SimulatorGUI();
    }
}












