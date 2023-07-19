/*
Group Member: Jasmeet Singh, Ahras Ali, Bulbul Arora
 */

import java.util.*;

public class Simulator {

    private static final double GRAVITY = 9.81; // m/s^2 stay in simulator
    private boolean inProgressSimulation = true; // stay in simulator

    public double[] simulation(Cannon cannon, RoundShot round_shot) {
        // initial position
        double max = 0;
        boolean b = true;
        double step = 0.5;
        double totalTime = 0;

        if (!inProgressSimulation) {
            return null;
        }
        // trigger
        inProgressSimulation = true;
        double [] barrelPose = cannon.getBarrelPose();
        double initialSpeed = cannon.getInitialSpeed();
        double [] externalForce = cannon.getExternalForce();
        double[] p = new double[]{barrelPose[0], barrelPose[1], barrelPose[2], max};

        // calculating the intial velocity, we are assuming there is no intial z
        double[] velocity = new double[]{initialSpeed * Math.cos(barrelPose[3]), initialSpeed * Math.sin(barrelPose[3]), 0};

        //Using the while to to ensure the projectile lands on the ground 
        while (p[2] >= 0 ) {
            double[] dragForce = round_shot.dragForce(velocity); // first interaction with a different module
            if (dragForce == null) {
                System.err.println("The drag Force could not be calculated. Simulation cannot be completed.");
                return null;
            }
            double acceleration[];
            // Using the formula: 𝑚𝑣'(𝑡)  =  𝑓(𝑡)  +  𝑓d(𝑡)  +  𝑚𝑔
            if (round_shot.getMass() != 0) {
                acceleration = new double[]{(externalForce[0] + dragForce[0] + (round_shot.getMass() * GRAVITY)) / round_shot.getMass(),
                        (externalForce[1] + dragForce[1] + (round_shot.getMass() * GRAVITY)) / round_shot.getMass(),
                        (externalForce[2] + dragForce[2] + (round_shot.getMass() * GRAVITY)) / round_shot.getMass()};
            } else {
                System.err.println("Mass Value cannot be 0.");
                return null;
            }
            // In this for loop we are updating our position and velocity
            for (int i = 0; i < 3; i++) {

                p[i] += velocity[i] * step + 0.5+ acceleration[i] * step * step;
                if (acceleration[i] * step <= 0 && b == true) { // show the max height of the projectile.
                    max = p[2];
                    b = false;
                }
                velocity[i] += acceleration[i] * step;
            }

            totalTime+= step; // not showing the total time right now.


            // on downward trajectory. - guard


        }

        p[3] = max;

        inProgressSimulation = false;
        System.out.println(totalTime);

        //p now contains position[x], pos[y], pos[z] and the height of the projectile at the highest point.
        return p;

    }

//    public static void main(String[] args) {
//        Simulator simulator = new Simulator();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("First enter Barrel Position and angle:");
//        System.out.println("x:");
//        double x = scanner.nextDouble();
//        System.out.println("y:");
//        double y = scanner.nextDouble();
//        System.out.println("z:");
//        double z = scanner.nextDouble();
//        System.out.println("Angle set to pi/4");
//        simulator.setBarrelPose(x, y, z, Math.PI / 4);
//
//        System.out.println("Enter Radius of Projectile:");
//        double radius = scanner.nextDouble();
//        simulator.setRadius(radius);
//
//        System.out.println("Enter Mass of Projectile:");
//        double mass = scanner.nextDouble();
//        simulator.setMass(mass);
//
//
//        System.out.println("Enter Initial Speed:");
//        double initSpeed = scanner.nextDouble();
//        simulator.setInitialSpeed(initSpeed);
//
//        System.out.println("Enter the External Force");
//        System.out.println("x:");
//        x = scanner.nextDouble();
//        System.out.println("y:");
//        y = scanner.nextDouble();
//        System.out.println("z:");
//        z = scanner.nextDouble();
//        simulator.setExternalForce(x, y, z);
//
//        double[] position = simulator.simulation();
//
//        System.out.println("Firing in Progress");
//
//        System.out.println("The position of the projectile after the simulation is: " + position[0] + ", " + position[1] + ", " + position[2]);
//        System.out.println("The max is: "+position[3]);
//
//    }


}
