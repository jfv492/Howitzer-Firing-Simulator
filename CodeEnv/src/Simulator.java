/*
Group Member: Jasmeet Singh, Ahras Ali, Bulbul Arora
 */


public class Simulator {

    //declaring the private classes
    private double mass;
    private double radius;
    private double pos_x;
    private double pos_y;
    private double velocity;
    private double externalForce;
    private double dragForce;
    private double dragCoefficient;
    //    private double density;
//    private double area;
//    private double flowVelocity;
    private double gravity;


    //making a constructor to ensure the variables are intialized


    public Simulator(double mass, double radius, double pos_x, double pos_y, double velocity,
                     double externalForce, double dragForce, double dragCoefficient, double gravity) {
        this.mass = mass;
        this.radius = radius;
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.velocity = velocity;
        this.externalForce = externalForce;
        this.dragForce = dragForce;
        this.dragCoefficient = dragCoefficient;
        this.gravity = gravity;
    }

    public Simulator() {
        mass = 0;
        this.radius = 0;
        this.pos_x = 0;
        this.pos_y = 0;
        velocity = 0;
        externalForce = 0;
        dragForce = 0;
        dragCoefficient = 0;
        gravity = 9.8;
    }


/*
mass*velocity = external_force + drag_force + mass*gravity ---1
drag_force = (-0.5)*drag_coefficient*density*area*flow_velocity ---2
 */

    public double getMomentum() {
        //mass*velocity = external_force + drag_force + mass*gravity ---1

        double p = externalForce + dragForce + mass * gravity;
        return p;
    }

    public double calculateDragForce(double density, double area, double flowVelocity) {
        //drag_force = (-0.5)*drag_coefficient*density*area*flow_velocity ---2
        this.dragForce = (-0.5) * dragCoefficient * density * area * flowVelocity;
        return this.dragForce;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public double getExternalForce() {
        return externalForce;
    }

    public void setExternalForce(double externalForce) {
        this.externalForce = externalForce;
    }

    public void setDragForce(double dragForce) {
        this.dragForce = dragForce;
    }

    public double getDragCoefficient() {
        return dragCoefficient;
    }

    public void setDragCoefficient(double dragCoefficient) {
        this.dragCoefficient = dragCoefficient;
    }

    public double getGravity() {
        return gravity;
    }

    public void setGravity(double gravity) {
        this.gravity = gravity;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getPos_x() {
        return pos_x;
    }

    public void setPos_x(double pos_x) {
        this.pos_x = pos_x;
    }

    public double getPos_y() {
        return pos_y;
    }

    public void setPos_y(double pos_y) {
        this.pos_y = pos_y;
    }

    public double getDragForce() {
        return dragForce;
    }

//    public static void main(String[] args){
//
//    }

}
