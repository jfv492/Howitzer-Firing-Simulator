
public class Cannon {

    public double[] barrelPose; // [x, y, z, orientation] , cannon
    public double initialSpeed; // cannon

    public double[] getBarrelPose() {
        return barrelPose;
    }

    public double getInitialSpeed() {
        return initialSpeed;
    }

    public double[] getExternalForce() {
        return externalForce;
    }

    public double[] externalForce; // [x, y, z] // cannon


    public void setBarrelPose(double x, double y, double z, double angle) {
        this.barrelPose = new double[]{x, y, z, angle};
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

}
