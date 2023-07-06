/*
Group Member: Jasmeet Singh, Ahras Ali, Bulbul Arora
 */

import java.util.*;

public class Simulator {

    private static final double GRAVITY = 9.81; // m/s^2

    private double[] barrelPose; // [x, y, z, orientation]
    private double radius;
    private double mass;
    private double dragCoefficient;
    private double initialSpeed;
    private double[] externalForce; // [x, y, z]

    private boolean inProgressSimulation = true;

    public void setBarrelPose(double x, double y, double z, double angle) {
        this.barrelPose = new double[]{x, y, z, angle};
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setDragCoefficient(double dragCoefficient) {
        this.dragCoefficient = dragCoefficient;
    }

    public void setInitialSpeed(double initialSpeed) {
        this.initialSpeed = initialSpeed;
    }

    public void setExternalForce(double x, double y, double z) {
        this.externalForce = new double[]{x, y, z};
    }

    public double[] dragForce(double[] flowVelocity) {
        // flow velocity = [x,y,z]
        double density = 1.225; // assuming air density at sea level = 1.225 kg / m^3
        double[] dragForce = new double[3];
        double dragForceMagnitude;

        if(radius <= 0){
            System.err.println("radius cannot be less than or equal to 0.");
            return null;
        }
        double area = Math.PI * radius * radius; // pi*r^2

        double flowVelocityMagnitude = Math.sqrt(
                flowVelocity[0] * flowVelocity[0] +
                        flowVelocity[1] * flowVelocity[1] +
                        flowVelocity[2] * flowVelocity[2]);  // sqrt(x^2 + y^2 + z^2)


        // this is a guard
        if(flowVelocityMagnitude != 0) {
            double[] unit = new double[]{ // unit vector for drag force.
                    flowVelocity[0] / flowVelocityMagnitude,
                    flowVelocity[1] / flowVelocityMagnitude,
                    flowVelocity[2] / flowVelocityMagnitude
            };

            if (dragCoefficient == 0){
                System.out.println("Could not calculate drag coefficient. The Drag coefficient should not be 0");
                return null;
            }

            dragForceMagnitude = -0.5 * this.dragCoefficient * density * area * flowVelocityMagnitude * flowVelocityMagnitude;

            for(int i =0; i<3; i++){
                dragForce[i] = dragForceMagnitude*unit[i]; // magnitude * x unit component ...
            }

        }
        else{
            System.err.println("Flow Velocity is 0");
            return null;
        }

        return dragForce;

    }

    public double [] simulation(){
        // initial position
        if(!inProgressSimulation){
            return null;
        }
        // trigger
        inProgressSimulation = true;
        double [] p = new double [] {barrelPose[0], barrelPose[1],barrelPose[2]};

        // calculating the intial velocity, we are assuming there is no intial y 
        double [] velocity = new double[] {initialSpeed * Math.cos(barrelPose[3]),initialSpeed * Math.sin(barrelPose[3]), 0};

        //Using the while to to ensure the projectile lands on the ground 
        while (p[2] >= 0){
            double [] dragForce = dragForce(velocity);
            if(dragForce == null){
                System.err.println("The drag Force could not be calculated. Simulation cannot be completed.");
                return null;
            }
            double acceleration[];
            // Using the formula: 𝑚𝑣'(𝑡)  =  𝑓(𝑡)  +  𝑓d(𝑡)  +  𝑚𝑔
            if(mass != 0) {
                acceleration = new double[]{(externalForce[0] + dragForce[0] + (mass * GRAVITY)) / mass,
                        (externalForce[1] + dragForce[1] + (mass * GRAVITY)) / mass,
                        (externalForce[2] + dragForce[2] + (mass * GRAVITY)) / mass};
            }
            else{
                System.err.println("Mass Value cannot be 0.");
                return null;
            }

            // In this for loop we are updating our position and velocity    
            for (int i = 0; i<3; i++)
            {
                p[i] += velocity[i];
                velocity[i] += acceleration[i];               
            }

            // on downward trajectory. - guard
            if(velocity[2] <= 0 ){
                break;
            }

        }

        inProgressSimulation = false;

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
        simulator.setBarrelPose(x,y,z,Math.PI/4);

        System.out.println("Enter Radius of Projectile:");
        double radius = scanner.nextDouble();
        simulator.setRadius(radius);

        System.out.println("Enter Mass of Projectile:");
        double mass = scanner.nextDouble();
        simulator.setMass(mass);

        System.out.println("Enter Drag Coefficient:");
        double dragC = scanner.nextDouble();
        simulator.setDragCoefficient(dragC);

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
        simulator.setExternalForce(x,y,z);

        double[] position = simulator.simulation();

        System.out.println("Firing in Progress");
        
        System.out.println("The position of the projectile after the simulation is: " + position[0] + ", "+position[1]+", "+position[2]);
        
    }


}
