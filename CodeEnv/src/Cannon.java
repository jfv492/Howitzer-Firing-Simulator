
public class Cannon {

    private double[] barrelPose; // [x, y, z, orientation] , cannon
    private double initialSpeed; // cannon
    private double[] externalForce; // [x, y, z] , cannon


    public double[] getBarrelPose() {
        return barrelPose;
    }

    public double getInitialSpeed() {
        return initialSpeed;
    }

    public double[] getExternalForce() {
        return externalForce;
    }

    public void setBarrelPose(double x, double y, double z, double angle) {
        this.barrelPose = new double[]{x, y, z, angle};
    }


    public void setInitialSpeed(double initialSpeed) {
        if (initialSpeed <= 0) { // security feature
            throw new IllegalArgumentException("Initial Speed cant be 0.");
        } else {
            this.initialSpeed = initialSpeed;
        }
    }

    public void setExternalForce(double x, double y, double z) {
        if (x == 0 && y == 0 && z == 0) { // security feature
            throw new IllegalArgumentException("External force cannot be 0. There has to be some kind of external Force.");
        } else {
            this.externalForce = new double[]{x, y, z};
        }
    }

}
