import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class testSimulator {

    // Boundary Value Testing
    // Generalized Boundary Value testing
    //Made a slight change
    @Test
    public void testBarrelPose_NegativeInfinity() { //testing barrel pose with a min value
        // checking with min- value
        Simulator simulator = new Simulator();
        Cannon cannon = new Cannon();
        RoundShot round_shot = new RoundShot();
        cannon.setBarrelPose(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 0);
        round_shot.setRadius(0.25);
        round_shot.setMass(1);
        cannon.setExternalForce(10, 10, 10);
        cannon.setInitialSpeed(10);
        double[] results = simulator.simulation(cannon, round_shot);
        assertNotNull(results);
    }

    @Test
    public void testBarrelPose_Zero() { //tyesting barrel pose with a nominal value
        // checking with nominal value
        Simulator simulator = new Simulator();
        Cannon cannon = new Cannon();
        RoundShot round_shot = new RoundShot();
        cannon.setBarrelPose(0, 0, 0, Math.PI / 4);
        round_shot.setRadius(0.25);
        round_shot.setMass(10);
        cannon.setExternalForce(100, 100, 0);
        cannon.setInitialSpeed(10);
        double[] results = simulator.simulation(cannon,round_shot);
        System.out.println(results[0] + " " + results[1] + " " + results[2] + " " + results[3]);
        assertNotEquals(new double[]{0, 0, 0}, results);
    }
//
//    @Test
//    public void testBarrelPose_PositiveInfinity() { //testing barrel pose with a max value
//        // checking with max+ value
//        Simulator simulator = new Simulator();
//        Cannon cannon = new Cannon();
//        RoundShot round_shot = new RoundShot();
//        cannon.setBarrelPose(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0);
//        round_shot.setRadius(0.25);
//        round_shot.setMass(1);
//        cannon.setExternalForce(100, 100, 0);
//        cannon.setInitialSpeed(10);
//        double[] results = simulator.simulation(cannon, round_shot);
//        assertNotNull(results);
//    }

    @Test
    public void testRadius_Zero() {  // > 0 and less = 0.25
        // checking with min value
        Simulator simulator = new Simulator();
        Cannon cannon = new Cannon();
        RoundShot round_shot = new RoundShot();
        cannon.setBarrelPose(0, 0, 0, Math.PI / 4);
        round_shot.setMass(1);
        cannon.setExternalForce(100, 100, 100);
        cannon.setInitialSpeed(10);
        double[] results = simulator.simulation(cannon, round_shot);
        assertThrows(IllegalArgumentException.class, () -> round_shot.setRadius(0));
    }

    @Test
    public void testRadius_Nominal() {
        // checking with nominal value
        Simulator simulator = new Simulator();
        Cannon cannon = new Cannon();
        RoundShot round_shot = new RoundShot();
        cannon.setBarrelPose(0, 0, 0, Math.PI / 4);
        round_shot.setRadius(0.25);
        round_shot.setMass(10);
        cannon.setExternalForce(100, 100, 0);
        cannon.setInitialSpeed(10);
        double[] results = simulator.simulation(cannon, round_shot);
        System.out.println(results[0] + " " + results[1] + " " + results[2] + " " + results[3]);
        assertNotNull(results);
    }

    @Test
    public void testRadius_PositiveInfinity() {
        // checking with max value
        Simulator simulator = new Simulator();
        Cannon cannon = new Cannon();
        RoundShot round_shot = new RoundShot();
        cannon.setBarrelPose(0, 0, 0, Math.PI / 4);
        round_shot.setMass(1);
        cannon.setExternalForce(100, 100, 100);
        cannon.setInitialSpeed(10);
        double[] results = simulator.simulation(cannon,round_shot);
        assertThrows(IllegalArgumentException.class, () -> round_shot.setRadius(Double.POSITIVE_INFINITY));
    }

    @Test
    public void testMass_Zero() {
        // checking with min value
        Simulator simulator = new Simulator();
        Cannon cannon = new Cannon();
        RoundShot round_shot = new RoundShot();
        cannon.setBarrelPose(0, 0, 0, Math.PI / 4);
        round_shot.setRadius(0.25);
        cannon.setExternalForce(100, 100, 0);
        cannon.setInitialSpeed(10);
        double[] results = simulator.simulation(cannon,round_shot);
        assertThrows(IllegalArgumentException.class, () -> round_shot.setMass(0));

    }

    @Test
    public void testMass_Nominal() {
        // checking with nominal value
        Simulator simulator = new Simulator();
        Cannon cannon = new Cannon();
        RoundShot round_shot = new RoundShot();
        cannon.setBarrelPose(0, 0, 0, Math.PI / 4);
        round_shot.setRadius(0.25);
        round_shot.setMass(10);
        cannon.setExternalForce(100, 100, 0);
        cannon.setInitialSpeed(10);
        double[] results = simulator.simulation(cannon,round_shot);
        System.out.println(results[0] + " " + results[1] + " " + results[2] + " " + results[3]);
        assertNotNull(results);
    }

    @Test
    public void testMass_PositiveInfinity() {
        // checking with max value
        Simulator simulator = new Simulator();
        Cannon cannon = new Cannon();
        RoundShot round_shot = new RoundShot();
        cannon.setBarrelPose(0, 0, 0, Math.PI / 4);
        round_shot.setRadius(0.25);
        cannon.setExternalForce(100, 100, 0);
        cannon.setInitialSpeed(10);
        double[] results = simulator.simulation(cannon,round_shot);
        assertThrows(IllegalArgumentException.class, () -> round_shot.setMass(Double.POSITIVE_INFINITY));

    }


    @Test
    public void testInitialSpeed_Zero() {
        // checking with min value
        Simulator simulator = new Simulator();
        Cannon cannon = new Cannon();
        RoundShot round_shot = new RoundShot();
        assertThrows(IllegalArgumentException.class, () -> cannon.setInitialSpeed(0));
    }

    @Test
    public void testInitialSpeed_Nominal() {
        // checking with nominal value
        Simulator simulator = new Simulator();
        Cannon cannon = new Cannon();
        RoundShot round_shot = new RoundShot();
        cannon.setBarrelPose(0, 0, 0, Math.PI / 4);
        round_shot.setRadius(0.25);
        round_shot.setMass(1);
        cannon.setExternalForce(100, 100, 0);
        cannon.setInitialSpeed(10);
        double[] results = simulator.simulation(cannon,round_shot);
        assertNotNull(results);
    }

    @Test
    public void testIntialSpeed_PositiveInfinity() {
        // checking with nominal value
        Simulator simulator = new Simulator();
        Cannon cannon = new Cannon();
        RoundShot round_shot = new RoundShot();
        cannon.setBarrelPose(0, 0, 0, Math.PI / 4);
        round_shot.setRadius(0.25);
        round_shot.setMass(1);
        cannon.setExternalForce(100, 100, 0);
        cannon.setInitialSpeed(Double.POSITIVE_INFINITY);
        double[] results = simulator.simulation(cannon,round_shot);
        System.out.println(results[0] + " " + results[1] + " " + results[2] + " " + results[3]);
        assertNotNull(results);
    }

    @Test
    public void testExternalForce_NegativeInfinity() {
        // checking with min value
        Simulator simulator = new Simulator();
        Cannon cannon = new Cannon();
        RoundShot round_shot = new RoundShot();
        cannon.setBarrelPose(0, 0, 0, Math.PI / 4);
        round_shot.setRadius(0.25);
        round_shot.setMass(1);
        cannon.setExternalForce(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
        cannon.setInitialSpeed(10);
        double[] results = simulator.simulation(cannon,round_shot);
        assertNotNull(results);
    }

    @Test
    public void testExternalForce_Zero() {
        // checking with zero value
        Simulator simulator = new Simulator();
        Cannon cannon = new Cannon();
        RoundShot round_shot = new RoundShot();
        assertThrows(IllegalArgumentException.class, () -> cannon.setExternalForce(0,0,0));
    }

    @Test
    public void testExternalForce_Nominal() {
        // checking with zero value
        Simulator simulator = new Simulator();
        Cannon cannon = new Cannon();
        RoundShot round_shot = new RoundShot();
        cannon.setBarrelPose(0, 0, 0, Math.PI / 4);
        round_shot.setRadius(0.25);
        round_shot.setMass(1);
        cannon.setExternalForce(100, 100, 0);
        cannon.setInitialSpeed(10);
        double[] results = simulator.simulation(cannon,round_shot);
        assertNotNull(results);
    }

    @Test
    public void testExternalForce_PositiveInfinity() {
        // checking with max+ value
        Simulator simulator = new Simulator();
        Cannon cannon = new Cannon();
        RoundShot round_shot = new RoundShot();
        cannon.setBarrelPose(0, 0, 0, Math.PI / 4);
        round_shot.setRadius(0.25);
        round_shot.setMass(1);
        cannon.setExternalForce(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        cannon.setInitialSpeed(10);
        double[] results = simulator.simulation(cannon,round_shot);
        assertNotNull(results);
    }


}

