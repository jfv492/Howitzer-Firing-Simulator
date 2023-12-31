import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class equivalenceClassTesting {

// Equivalence Class Testing

    @Test
    public void validInputforSimulator(){
        Simulator simulator = new Simulator();

        //setup for validating the inputs
        simulator.setBarrelPose(0,0,0, Math.PI / 4);
        simulator.setRadius(0.25);
        simulator.setMass(0.5);
        simulator.setDragCoefficient(0.5);
        simulator.setInitialSpeed(10);
        simulator.setExternalForce(0,0,0);

        double [] position = simulator.simulation();

        assertNotNull(position);

        assertEquals(7.0710678118654755, position[0], 0.001);
        assertEquals(7.071067811865475, position[1], 0.001);
        assertEquals(0, position[2], 0.001);
    }

    @Test 
    public void testRadiusValue(){
        Simulator simulator = new Simulator();

        //Negative Value
        try {
            assertThrows(IllegalArgumentException.class, () -> {simulator.setRadius(-0.5);});
        } catch (IllegalArgumentException e) {
            System.out.println("radius out of bounds. ");
        }

        //Zero Value
        try {
            assertThrows(IllegalArgumentException.class, () -> {simulator.setRadius(0);});
        } catch (IllegalArgumentException e) {
            System.out.println("radius out of bounds. ");
        }

        //Exceeding Value
        try {
            assertThrows(IllegalArgumentException.class, () -> {simulator.setRadius(1);});
        } catch (IllegalArgumentException e) {
            System.out.println("radius out of bounds. ");
        }
    }

    @Test 
    public void testMassValue(){
        Simulator simulator = new Simulator();

        //Negative Value
        try {
            assertThrows(IllegalArgumentException.class, () -> {simulator.setMass(-0.5);});
        } catch (IllegalArgumentException e) {
            System.out.println("mass out of bounds. ");
        }

        //Zero Value
        try {
            assertThrows(IllegalArgumentException.class, () -> {simulator.setMass(0);});
        } catch (IllegalArgumentException e) {
            System.out.println("mass out of bounds. ");
        }

        //Exceeding Value
        try {
            assertThrows(IllegalArgumentException.class, () -> {simulator.setMass(11);});
        } catch (IllegalArgumentException e) {
            System.out.println("mass out of bounds. ");
        }

    }

    @Test
    public void testIntialSpeedNegativeValue(){
        Simulator simulator = new Simulator();

        //setup for validating the inputs
        simulator.setBarrelPose(0,0,0, Math.PI / 4);
        simulator.setRadius(0.25);
        simulator.setMass(0.5);
        simulator.setDragCoefficient(0.5);
        simulator.setInitialSpeed(-0.5);
        simulator.setExternalForce(0,0,0);

        double [] position = simulator.simulation();

        assertNotNull(position);

        assertEquals(0, position[0], 0.001);
        assertEquals(0, position[1], 0.001);
        assertEquals(0, position[2], 0.001);

    }

    @Test
    public void testExternalForceNegativeValue_XComponent(){
        Simulator simulator = new Simulator();

        //setup for validating the inputs
        simulator.setBarrelPose(0,0,0, Math.PI / 4);
        simulator.setRadius(0.25);
        simulator.setMass(0.5);
        simulator.setDragCoefficient(0.5);
        simulator.setInitialSpeed(10);
        simulator.setExternalForce(-10,0,0);

        double [] position = simulator.simulation();

        assertNotNull(position);
    }

    @Test
    public void testExternalForceNegativeValue_YComponent(){
        Simulator simulator = new Simulator();

        //setup for validating the inputs
        simulator.setBarrelPose(0,0,0, Math.PI / 4);
        simulator.setRadius(0.25);
        simulator.setMass(0.5);
        simulator.setDragCoefficient(0.5);
        simulator.setInitialSpeed(10);
        simulator.setExternalForce(0,-10,0);

        double [] position = simulator.simulation();

        assertNotNull(position);
    }

    @Test
    public void testExternalForceNegativeValue_ZComponent(){
        Simulator simulator = new Simulator();

        //setup for validating the inputs
        simulator.setBarrelPose(0,0,0, Math.PI / 4);
        simulator.setRadius(0.25);
        simulator.setMass(0.5);
        simulator.setDragCoefficient(0.5);
        simulator.setInitialSpeed(10);
        simulator.setExternalForce(0,0,-10);

        double [] position = simulator.simulation();

        assertNotNull(position);
    }

}
