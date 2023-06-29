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
        double area = Math.PI * radius * radius; // pi*r^2

        double flowVelocityMagnitude = Math.sqrt(
                flowVelocity[0] * flowVelocity[0] +
                        flowVelocity[1] * flowVelocity[1] +
                        flowVelocity[2] * flowVelocity[2]);  // sqrt(x^2 + y^2 + z^2)

        if(flowVelocityMagnitude !=0) {
            double[] unit = new double[]{ // unit vector for drag force.
                    flowVelocity[0] / flowVelocityMagnitude,
                    flowVelocity[1] / flowVelocityMagnitude,
                    flowVelocity[2] / flowVelocityMagnitude
            };

            dragForceMagnitude = -0.5 * this.dragCoefficient * density * area * flowVelocityMagnitude * flowVelocityMagnitude;

            for(int i =0; i<3; i++){
                dragForce[i] = dragForceMagnitude*unit[i]; // magnitude * x unit component ...
            }

        }

        return dragForce;

    }

    public double [] simulation(){
        // initial position
        double [] p = new double [] {barrelPose[0], barrelPose[1],barrelPose[2]};

        // calculating the intial velocity, we are assuming there is no intial y 
        double [] velocity = new double[] {initialSpeed * Math.cos(barrelPose[3]), 0, initialSpeed * Math.sin(barrelPose[3])};

        //Using the while to to ensure the projectile lands on the ground 
        while (p[2] >= 0){
            double [] dragForce = dragForce(velocity);

            // Using the formula: 𝑚𝑣'(𝑡)  =  𝑓(𝑡)  +  𝑓 (𝑡)  +  𝑚𝑔
            double [] acceleration = new double [] {(externalForce[0] + dragForce[0] + (mass * GRAVITY)) / mass, 
                (externalForce[1] + dragForce[1] + (mass * GRAVITY)) / mass, 
                (externalForce[2] + dragForce[2] + (mass * GRAVITY)) / mass};

            // In this for loop we are updating our position and velocity    
            for (int i = 0; i<3; i++)
            {
                p[i] += velocity[i];
                velocity[i] += acceleration[i];               
            }

        }

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
        System.out.println("y:");
        z = scanner.nextDouble();
        simulator.setExternalForce(x,y,z);

        double[] position = simulator.simulation();
        
        System.out.println("The position of the projectile after the simulation is: " + position[0] + ", "+position[1]+", "+position[2]);
        
    }


}


/***************************
 * Old Code 
 **************************/

/*
mass*velocity = external_force + drag_force + mass*gravity ---1
drag_force = (-0.5)*drag_coefficient*density*area*flow_velocity ---2
 */

//    public double getMomentum() {
//        //mass*velocity = external_force + drag_force + mass*gravity ---1
//
//        double p = externalForce + dragForce + mass * gravity;
//        return p;
//    }
//
//    public double calculateDragForce(double density, double area, double flowVelocity) {
//        //drag_force = (-0.5)*drag_coefficient*density*area*flow_velocity ---2
//        this.dragForce = (-0.5) * dragCoefficient * density * area * flowVelocity;
//        return this.dragForce;
//    }
//
//    public double getMass() {
//        return mass;
//    }
//
//    public void setMass(double mass) {
//        this.mass = mass;
//    }
//
//    public double getVelocity() {
//        return velocity;
//    }
//
//    public void setVelocity(double velocity) {
//        this.velocity = velocity;
//    }
//
//    public double getExternalForce() {
//        return externalForce;
//    }
//
//    public void setExternalForce(double externalForce) {
//        this.externalForce = externalForce;
//    }
//
//    public void setDragForce(double dragForce) {
//        this.dragForce = dragForce;
//    }
//
//    public double getDragCoefficient() {
//        return dragCoefficient;
//    }
//
//    public void setDragCoefficient(double dragCoefficient) {
//        this.dragCoefficient = dragCoefficient;
//    }
//
//    public double getGravity() {
//        return gravity;
//    }
//
//    public void setGravity(double gravity) {
//        this.gravity = gravity;
//    }
//
//    public double getRadius() {
//        return radius;
//    }
//
//    public void setRadius(double radius) {
//        this.radius = radius;
//    }
//
//    public double getPos_x() {
//        return pos_x;
//    }
//
//    public void setPos_x(double pos_x) {
//        this.pos_x = pos_x;
//    }
//
//    public double getPos_y() {
//        return pos_y;
//    }
//
//    public void setPos_y(double pos_y) {
//        this.pos_y = pos_y;
//    }
//
//    public double getDragForce() {
//        return dragForce;
//    }
//
////    public static void main(String[] args){
////
////    }
//
//}
