
public class RoundShot {

    private double radius; // round shot
    private double mass; // round shot
    private static final double dragCoefficient = 0.5; // cannon -assuming it is a sphere - spheres usually have a drag coefficient of 0.5

    public double getRadius() {
        return radius;
    }

    public double getMass() {
        return mass;
    }

    public static double getDragCoefficient() {
        return dragCoefficient;
    }

    public void setRadius(double radius) {

        if (radius <= 0 || radius > 0.25) {
            throw new IllegalArgumentException("Invalid radius value. Radius must be greater than zero and less than 0.25.");
        } else {
            this.radius = radius;
        }
    }

    public void setMass(double mass) {
        if (mass <= 0 || mass > 50) {
            throw new IllegalArgumentException("Invalid mass value. Mass must be greater than zero.");
        } else {
            this.mass = mass;
        }
    }

    public double[] dragForce(double[] flowVelocity) {
        // flow velocity = [x,y,z]
        double density = 1.225; // assuming air density at sea level = 1.225 kg / m^3
        double[] dragForce = new double[3];
        double dragForceMagnitude;

        if (radius <= 0) {
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


}
