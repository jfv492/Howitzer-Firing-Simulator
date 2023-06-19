/*
Group Member: Jasmeet Singh, Ahras Ali, Bulbul Arora
 */


public class Simulator {

    //declaring the private classes
    private double mass;
    private double velocity;
    private double externalForce;
    private double dragForce;
    private double dragCoefficient;
    private double density;
    private double area;
    private double flowVelocity;
    private double gravity;


    //making a constructor to ensure the variables are intialized
    public Simulator(double mass, double velocity, double externalForce, double dragForce, double dragCoefficient,
                     double density, double area, double flowVelocity, double gravity){

        this.mass = mass;
        this.velocity = velocity;
        this.externalForce = externalForce;
        this.dragForce = dragForce;
        this.dragCoefficient = dragCoefficient;
        this.density = density;
        this.area = area;
        this. flowVelocity = flowVelocity;
        this.gravity = gravity;
    }


/*
3 functions ==>
mass*velocity = external_force + drag_force + mass*gravity ---1
drag_force = (-0.5)*drag_coefficient*density*area*flow_velocity ---2
 */

    public double getMomentum(){
        //mass*velocity = external_force + drag_force + mass*gravity ---1

        double p = externalForce + dragForce + mass*gravity;
        return p;
    }

    public double getDragForce(){
        //drag_force = (-0.5)*drag_coefficient*density*area*flow_velocity ---2
        this.dragForce = (-0.5) * dragCoefficient * density * area * flowVelocity;
        return this.dragForce;

    }

//    public static void main(String[] args){
//
//    }

}
