/*
Group Member: Jasmeet Singh, Ahras Ali, Bulbul Arora
 */
//simulator
import java.io.IOException;
import java.util.*;
import java.io.FileWriter;

public class Simulator {

    private static final double GRAVITY = 9.81; // m/s^2 stay in simulator
    private boolean inProgressSimulation = true; // stay in simulator, guard, the simulator will only run if the "switch is on"

    public double[] simulation(Cannon cannon, RoundShot round_shot) {
        // initial position
        double max = 0;
        double step = 0.1; // steps of time,
        double totalTime = 0;  // node 1


        if (!inProgressSimulation) { // node 2
            return null;
        }
        // trigger
        inProgressSimulation = true;
        double[] barrelPose = cannon.getBarrelPose();
        double initialSpeed = cannon.getInitialSpeed();
        double[] externalForce = cannon.getExternalForce();
        double[] p = new double[]{barrelPose[0], barrelPose[1], barrelPose[2], max}; // p contains the position(x,y,z) and the max z component, which is the max height the projectile reaches.

        // calculating the initial velocity, we are assuming there is no initial z
        double[] velocity = new double[]{0, initialSpeed * Math.cos(barrelPose[3]), initialSpeed * Math.sin(barrelPose[3])}; // node 3

        //Using the while to to ensure the projectile lands on the ground
        while (p[2] >= 0) { // node 5
            double[] dragForce = round_shot.dragForce(velocity); // first interaction with a different module
            if (dragForce == null) { // node 6
                System.err.println("The drag Force could not be calculated. Simulation cannot be completed.");
                return null;
            }
            double acceleration[];
            // Using the formula: mv' = force_external + force_drag + m*g
            if (round_shot.getMass() != 0) {// change
                if ((externalForce[0] * dragForce[0]) <= 0) { // 9
                    acceleration = new double[]{ // if drag force is negative.
                            (externalForce[0] + dragForce[0]) / round_shot.getMass(),
                            (externalForce[1] + dragForce[1]) / round_shot.getMass(),
                            (externalForce[2] + dragForce[2]) / round_shot.getMass() - GRAVITY
                    };
                } else {
                    acceleration = new double[]{ // if the returned drag force is not negrative, because drag will always be on the opposite side.
                            (externalForce[0] - dragForce[0]) / round_shot.getMass(),
                            (externalForce[1] - dragForce[1]) / round_shot.getMass(),
                            (externalForce[2] - dragForce[2]) / round_shot.getMass() - GRAVITY
                    };

                }
            } else {
                System.err.println("Mass Value cannot be 0.");
                return null;
            }
            // In this for loop we are updating our position and velocity
            for (int i = 0; i < 3; i++) { // node 10

                p[i] += velocity[i] * step;
                if ((acceleration[2] * step *step ) <= 0 && p[2] > max && i == 2) { // show the max height of the projectile.
                    max = p[2];
                }
                velocity[i] += acceleration[i] * step *step;
            }


            totalTime += step; // not showing the total time right now.
            System.out.println(p[0] + " " + p[1] + " " + p[2] + " ");

            if(p[2] < 0){
                p[2] = 0;
                break;
            }
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
