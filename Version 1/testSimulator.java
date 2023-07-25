import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testSimulator {

    // Boundary Value Testing Version 1
    @Test
    public void testBarrelPose_NegativeInfinity(){
        // checking with min- value
        Simulator simulator = new Simulator();
        simulator.setBarrelPose(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 0);
        simulator.setRadius(0.5);
        simulator.setMass(1);
        simulator.setExternalForce(1,1,1);
        simulator.setDragCoefficient(0.5);
        simulator.setInitialSpeed(10);
        double [] results = simulator.simulation();
        assertNotEquals(new double[] {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY}, results);
    }

    @Test
    public void testBarrelPose_Zero(){
        // checking with nominal value
        Simulator simulator = new Simulator();
        simulator.setBarrelPose(0, 0, 0, 0);
        simulator.setRadius(0.5);
        simulator.setMass(1);
        simulator.setExternalForce(1,1,1);
        simulator.setDragCoefficient(0.5);
        simulator.setInitialSpeed(10);
        double [] results = simulator.simulation();
        assertNotEquals(new double[] {0, 0, 0}, results);
    }

    @Test
    public void testBarrelPose_PositiveInfinity(){
        // checking with max+ value
        Simulator simulator = new Simulator();
        simulator.setBarrelPose(0, 0, 0, 0);
        simulator.setRadius(0.5);
        simulator.setMass(1);
        simulator.setExternalForce(1,1,1);
        simulator.setDragCoefficient(0.5);
        simulator.setInitialSpeed(10);
        double [] results = simulator.simulation();
        assertNotEquals(new double[] {0, 0, 0}, results);
    }

    @Test
    public void testRadius_Zero(){
        // checking with min value
        Simulator simulator = new Simulator();
        simulator.setBarrelPose(0, 0, 0, Math.PI/4);
        simulator.setRadius(0);
        simulator.setMass(1);
        simulator.setExternalForce(1,1,1);
        simulator.setDragCoefficient(0.5);
        simulator.setInitialSpeed(10);
        double [] results = simulator.simulation();
        assertNull(results);
    }

    @Test
    public void testRadius_Nominal(){
        // checking with nominal value
        Simulator simulator = new Simulator();
        simulator.setBarrelPose(0, 0, 0, Math.PI/4);
        simulator.setRadius(0.5);
        simulator.setMass(1);
        simulator.setExternalForce(1,1,1);
        simulator.setDragCoefficient(0.5);
        simulator.setInitialSpeed(10);
        double [] results = simulator.simulation();
        assertNotNull(results);
    }

    @Test
    public void testRadius_PositiveInfinity(){
        // checking with max value
        Simulator simulator = new Simulator();
        simulator.setBarrelPose(0, 0, 0, Math.PI/4);
        simulator.setRadius(Double.POSITIVE_INFINITY);
        simulator.setMass(1);
        simulator.setExternalForce(1,1,1);
        simulator.setDragCoefficient(0.5);
        simulator.setInitialSpeed(10);
        double [] results = simulator.simulation();
        assertNotNull(results);
    }

    @Test
    public void testMass_Zero(){
        // checking with min value
        Simulator simulator = new Simulator();
        simulator.setBarrelPose(0, 0, 0, Math.PI/4);
        simulator.setRadius(0.5);
        simulator.setMass(0);
        simulator.setExternalForce(1,1,1);
        simulator.setDragCoefficient(0.5);
        simulator.setInitialSpeed(10);
        double [] results = simulator.simulation();
        assertNull(results);
    }

    @Test
    public void testMass_Nominal(){
        // checking with nominal value
        Simulator simulator = new Simulator();
        simulator.setBarrelPose(0, 0, 0, Math.PI/4);
        simulator.setRadius(0.5);
        simulator.setMass(1);
        simulator.setExternalForce(1,1,1);
        simulator.setDragCoefficient(0.5);
        simulator.setInitialSpeed(10);
        double [] results = simulator.simulation();
        assertNotNull(results);
    }

    @Test
    public void testMass_PositiveInfinity(){
        // checking with max value
        Simulator simulator = new Simulator();
        simulator.setBarrelPose(0, 0, 0, Math.PI/4);
        simulator.setRadius(0.5);
        simulator.setMass(Double.POSITIVE_INFINITY);
        simulator.setExternalForce(1,1,1);
        simulator.setDragCoefficient(0.5);
        simulator.setInitialSpeed(10);
        double [] results = simulator.simulation();
        assertNotNull(results);
    }
}
