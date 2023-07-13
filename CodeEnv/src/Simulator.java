/*
Group Member: Jasmeet Singh, Ahras Ali, Bulbul Arora
 */

import java.util.*;

public class Simulator {

    private static final double GRAVITY = 9.81; // m/s^2
    private static final double dragCoefficient = 0.5; // assuming it is a sphere - spheres usually have a drag coefficient of 0.5

    private double[] barrelPose; // [x, y, z, orientation]
    private double radius;
    private double mass;
    private double initialSpeed;
    private double[] externalForce; // [x, y, z]
    private boolean inProgressSimulation = true;

    public void setBarrelPose(double x, double y, double z, double angle) {
        this.barrelPose = new double[]{x, y, z, angle};
    }

    public void setRadius(double radius) {

        if (radius <= 0 || radius > 0.25) {
            throw new IllegalArgumentException("Invalid radius value. Radius must be greater than zero and less than 0.25.");
        } else {
            this.radius = radius;
        }
    }

    public void setMass(double mass) {
        if (mass <= 0 || mass > 10) {
            throw new IllegalArgumentException("Invalid mass value. Mass must be greater than zero.");
        } else {
            this.mass = mass;
        }
    }


    public void setInitialSpeed(double initialSpeed) {
        if (initialSpeed <= 0) {
            throw new IllegalArgumentException("Initial Speed cant be 0.");
        } else {
            this.initialSpeed = initialSpeed;
        }
    }

    public void setExternalForce(double x, double y, double z) {
        if (x == 0 && y == 0 && z == 0) {
            throw new IllegalArgumentException("External force cannot be 0. There has to be some kind of external Force.");
        } else {
            this.externalForce = new double[]{x, y, z};
        }
    }

    public double[] dragForce(double[] flowVelocity) {
        // flow velocity = [x,y,z]
        double density = 1.225; // assuming air density at sea level = 1.225 kg / m^3
        double[] dragForce = new double[3];
        double dragForceMagnitude;

        if (radius <= 0) {
//            System.err.println("Radius cannot be less than or equal to 0.");
            return null;
        }
        double area = Math.PI * radius * radius; // pi*r^2

        double flowVelocityMagnitude = Math.sqrt(
                flowVelocity[0] * flowVelocity[0] +
                        flowVelocity[1] * flowVelocity[1] +
                        flowVelocity[2] * flowVelocity[2]);  // sqrt(x^2 + y^2 + z^2)


        // this is a guard
        if (flowVelocityMagnitude != 0) {
            double[] unit = new double[]{ // unit vector for drag force.
                    flowVelocity[0] / flowVelocityMagnitude,
                    flowVelocity[1] / flowVelocityMagnitude,
                    flowVelocity[2] / flowVelocityMagnitude
            };

            dragForceMagnitude = -0.5 * dragCoefficient * density * area * flowVelocityMagnitude * flowVelocityMagnitude;

            for (int i = 0; i < 3; i++) {
                dragForce[i] = dragForceMagnitude * unit[i]; // magnitude * x unit component ...
            }

        } else {
            throw new IllegalArgumentException("flow velocity cannot be 0");
            //return null;
        }

        return dragForce;

    }

    public double[] simulation() {
        // initial position
        double max = 0;
        boolean b = true;

        if (!inProgressSimulation) {
            return null;
        }
        // trigger
        inProgressSimulation = true;
        double[] p = new double[]{barrelPose[0], barrelPose[1], barrelPose[2], max};

        // calculating the intial velocity, we are assuming there is no intial y 
        double[] velocity = new double[]{initialSpeed * Math.cos(barrelPose[3]), initialSpeed * Math.sin(barrelPose[3]), 0};

        //Using the while to to ensure the projectile lands on the ground 
        while (p[2] >= 0) {
            double[] dragForce = dragForce(velocity);
            if (dragForce == null) {
                System.err.println("The drag Force could not be calculated. Simulation cannot be completed.");
                return null;
            }
            double acceleration[];
            // Using the formula: 𝑚𝑣'(𝑡)  =  𝑓(𝑡)  +  𝑓d(𝑡)  +  𝑚𝑔
            if (mass != 0) {
                acceleration = new double[]{(externalForce[0] + dragForce[0] + (mass * GRAVITY)) / mass,
                        (externalForce[1] + dragForce[1] + (mass * GRAVITY)) / mass,
                        (externalForce[2] + dragForce[2] + (mass * GRAVITY)) / mass};
            } else {
                System.err.println("Mass Value cannot be 0.");
                return null;
            }

            // In this for loop we are updating our position and velocity    
            for (int i = 0; i < 3; i++) {
                p[i] += velocity[i];
                velocity[i] += acceleration[i];
            }

            if (velocity[2] < 0 && b == true) {
                max = p[2];
                b = false;
            }
            // on downward trajectory. - guard
            if (p[2] < 0) {
                break;
            }

        }

        p[3] = max;

        inProgressSimulation = false;

        //p now contains position[x], pos[y], pos[z] and the height of the projectile at the highest point.
        return p;

    }

    public static void main(String[] args) {
        Simulator simulator = new Simulator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("First enter Barrel Position and angle:");
        System.out.println("x:");
        double x = scanner.nextDouble();
        System.out.println("y:");
        double y = scanner.nextDouble();
        System.out.println("z:");
        double z = scanner.nextDouble();
        System.out.println("Angle set to pi/4");
        simulator.setBarrelPose(x, y, z, Math.PI / 4);

        System.out.println("Enter Radius of Projectile:");
        double radius = scanner.nextDouble();
        simulator.setRadius(radius);

        System.out.println("Enter Mass of Projectile:");
        double mass = scanner.nextDouble();
        simulator.setMass(mass);


        System.out.println("Enter Initial Speed:");
        double initSpeed = scanner.nextDouble();
        simulator.setInitialSpeed(initSpeed);

        System.out.println("Enter the External Force");
        System.out.println("x:");
        x = scanner.nextDouble();
        System.out.println("y:");
        y = scanner.nextDouble();
        System.out.println("z:");
        z = scanner.nextDouble();
        simulator.setExternalForce(x, y, z);

        double[] position = simulator.simulation();

        System.out.println("Firing in Progress");

        System.out.println("The position of the projectile after the simulation is: " + position[0] + ", " + position[1] + ", " + position[2]);

    }


}
