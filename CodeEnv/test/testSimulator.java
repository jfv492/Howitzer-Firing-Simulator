import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class testSimulator {

    // Boundary Value Testing
    // Generalized Boundary Value testing
    @Test
    public void testBarrelPose_NegativeInfinity() {
        // checking with min- value
        Simulator simulator = new Simulator();
        simulator.setBarrelPose(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 0);
        simulator.setRadius(0.25);
        simulator.setMass(1);
        simulator.setExternalForce(10, 10, 10);
        simulator.setInitialSpeed(10);
        double[] results = simulator.simulation();
        assertNotNull(results);

    }

    @Test
    public void testBarrelPose_Zero() {
        // checking with nominal value
        Simulator simulator = new Simulator();
        simulator.setBarrelPose(0, 0, 0, Math.PI / 4);
        simulator.setRadius(0.25);
        simulator.setMass(1);
        simulator.setExternalForce(100, 100, 100);
        simulator.setInitialSpeed(10);
        double[] results = simulator.simulation();
        assertNotEquals(new double[]{0, 0, 0}, results);
    }

    @Test
    public void testBarrelPose_PositiveInfinity() {
        // checking with max+ value
        Simulator simulator = new Simulator();
        simulator.setBarrelPose(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0);
        simulator.setRadius(0.25);
        simulator.setMass(1);
        simulator.setExternalForce(100, 100, 100);
        simulator.setInitialSpeed(10);
        double[] results = simulator.simulation();
        assertNotNull(results);

    }

    @Test
    public void testRadius_Zero() {
        // checking with min value
        Simulator simulator = new Simulator();
        simulator.setBarrelPose(0, 0, 0, Math.PI / 4);
//         simulator.setRadius(0);
        simulator.setMass(1);
        simulator.setExternalForce(100, 100, 100);
        simulator.setInitialSpeed(10);
        double[] results = simulator.simulation();
        assertThrows(IllegalArgumentException.class, () -> simulator.setRadius(0));
    }

    @Test
    public void testRadius_Nominal() {
        // checking with nominal value
        Simulator simulator = new Simulator();
        simulator.setBarrelPose(1, 1, 1, Math.PI / 4);
        simulator.setRadius(0.25);
        simulator.setMass(0.5);
        simulator.setExternalForce(10, 10, 10);
        simulator.setInitialSpeed(10);
        double[] results = simulator.simulation();
        System.out.println(results[0] + " " + results[1] + " " + results[2] + " " + results[3]);
        assertNotNull(results);
    }

    @Test
    public void testRadius_PositiveInfinity() {
        // checking with max value
        Simulator simulator = new Simulator();
        simulator.setBarrelPose(0, 0, 0, Math.PI / 4);
//         simulator.setRadius(Double.POSITIVE_INFINITY);
        simulator.setMass(1);
        simulator.setExternalForce(100, 100, 100);
        simulator.setInitialSpeed(10);
        double[] results = simulator.simulation();
        assertThrows(IllegalArgumentException.class, () -> simulator.setRadius(Double.POSITIVE_INFINITY));
    }

    @Test
    public void testMass_Zero() {
        // checking with min value
        Simulator simulator = new Simulator();
        simulator.setBarrelPose(0, 0, 0, Math.PI / 4);
        simulator.setRadius(0.25);
//         simulator.setMass(0);
        simulator.setExternalForce(100, 100, 100);
        simulator.setInitialSpeed(10);
        double[] results = simulator.simulation();
        assertThrows(IllegalArgumentException.class, () -> simulator.setMass(0));

    }

    @Test
    public void testMass_Nominal() {
        // checking with nominal value
        Simulator simulator = new Simulator();
        simulator.setBarrelPose(0, 0, 0, Math.PI / 4);
        simulator.setRadius(0.25);
        simulator.setMass(1);
        simulator.setExternalForce(100, 100, 100);
        simulator.setInitialSpeed(10);
        double[] results = simulator.simulation();
        assertNotNull(results);
    }

    @Test
    public void testMass_PositiveInfinity() {
        // checking with max value
        Simulator simulator = new Simulator();
        simulator.setBarrelPose(0, 0, 0, Math.PI / 4);
        simulator.setRadius(0.25);
//        simulator.setMass(Double.POSITIVE_INFINITY);
        simulator.setExternalForce(100, 100, 100);
        simulator.setInitialSpeed(10);
        double[] results = simulator.simulation();
        assertThrows(IllegalArgumentException.class, () -> simulator.setMass(Double.POSITIVE_INFINITY));

    }


    @Test
    public void testInitialSpeed_Zero() {
        // checking with min value
        Simulator simulator = new Simulator();
        simulator.setBarrelPose(0, 0, 0, Math.PI / 4);
        simulator.setRadius(0.25);
        simulator.setMass(1);
        simulator.setExternalForce(100, 100, 100);
        simulator.setInitialSpeed(0);
        double[] results = simulator.simulation();
        assertNull(results);
    }

    @Test
    public void testInitialSpeed_Nominal() {
        // checking with nominal value
        Simulator simulator = new Simulator();
        simulator.setBarrelPose(0, 0, 0, Math.PI / 4);
        simulator.setRadius(0.25);
        simulator.setMass(1);
        simulator.setExternalForce(100, 100, 100);
        simulator.setInitialSpeed(10);
        double[] results = simulator.simulation();
        assertNotNull(results);
    }

    @Test
    public void testIntialSpeed_PositiveInfinity() {
        // checking with nominal value
        Simulator simulator = new Simulator();
        simulator.setBarrelPose(0, 0, 0, Math.PI / 4);
        simulator.setRadius(0.25);
        simulator.setMass(1);
        simulator.setExternalForce(100, 100, 100);
        simulator.setInitialSpeed(Double.POSITIVE_INFINITY);
        double[] results = simulator.simulation();
        assertNotNull(results);
    }

    @Test
    public void testExternalForce_NegativeInfinity() {
        // checking with min value
        Simulator simulator = new Simulator();
        simulator.setBarrelPose(0, 0, 0, Math.PI / 4);
        simulator.setRadius(0.25);
        simulator.setMass(1);
        simulator.setExternalForce(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
        simulator.setInitialSpeed(10);
        double[] results = simulator.simulation();
        assertNotNull(results);
    }

    @Test
    public void testExternalForce_Zero() {
        // checking with zero value
        Simulator simulator = new Simulator();
        simulator.setBarrelPose(0, 0, 0, Math.PI / 4);
        simulator.setRadius(0.25);
        simulator.setMass(1);
        simulator.setExternalForce(0, 0, 0);
        simulator.setInitialSpeed(10);
        double[] results = simulator.simulation();
        assertNotNull(results);

    }

    @Test
    public void testExternalForce_Nominal() {
        // checking with zero value
        Simulator simulator = new Simulator();
        simulator.setBarrelPose(0, 0, 0, Math.PI / 4);
        simulator.setRadius(0.25);
        simulator.setMass(1);
        simulator.setExternalForce(100, 100, 100);
        simulator.setInitialSpeed(10);
        double[] results = simulator.simulation();
        assertNotNull(results);
    }

    @Test
    public void testExternalForce_PositiveInfinity() {
        // checking with max+ value
        Simulator simulator = new Simulator();
        simulator.setBarrelPose(0, 0, 0, Math.PI / 4);
        simulator.setRadius(0.25);
        simulator.setMass(1);
        simulator.setExternalForce(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        simulator.setInitialSpeed(10);
        double[] results = simulator.simulation();
        assertNotNull(results);
    }


}
