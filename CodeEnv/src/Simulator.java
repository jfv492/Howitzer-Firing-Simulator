/*
Group Member: Jasmeet Singh, Ahras Ali, Bulbul Arora
 */


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


}


//making a constructor to ensure the variables are intialized







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
