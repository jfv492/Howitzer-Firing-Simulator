import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class equivalenceClassTesting {

// Equivalence Class Testing

    @Test
    public void validInputforSimulator(){
        Simulator simulator = new Simulator();
        Cannon cannon = new Cannon();
        RoundShot round_shot = new RoundShot();
        //setup for validating the inputs
        cannon.setBarrelPose(1,1,1, Math.PI / 4);
        round_shot.setRadius(0.25);
        round_shot.setMass(0.5);
        cannon.setInitialSpeed(10);
        cannon.setExternalForce(100,100,100);

        double [] position = simulator.simulation(cannon,round_shot);

        assertNotNull(position);

//        assertEquals(-75.97332312833615, position[0], 0.001);
//        assertEquals(-75.97332312833615, position[1], 0.001);
//        assertEquals(-88.79341036242101, position[2], 0.001);
    }

    @Test
    public void testRadiusValue(){
        Simulator simulator = new Simulator();
        Cannon cannon = new Cannon();
        RoundShot round_shot = new RoundShot();
        //Negative Value
        try {
            assertThrows(IllegalArgumentException.class, () -> {round_shot.setRadius(-0.5);});
        } catch (IllegalArgumentException e) {
            System.out.println("radius out of bounds. ");
        }

        //Zero Value
        try {
            assertThrows(IllegalArgumentException.class, () -> {round_shot.setRadius(0);});
        } catch (IllegalArgumentException e) {
            System.out.println("radius out of bounds. ");
        }

        //Exceeding Value
        try {
            assertThrows(IllegalArgumentException.class, () -> {round_shot.setRadius(1);});
        } catch (IllegalArgumentException e) {
            System.out.println("radius out of bounds. ");
        }
    }

    @Test
    public void testMassValue(){
        Simulator simulator = new Simulator();
        Cannon cannon = new Cannon();
        RoundShot round_shot = new RoundShot();
        //Negative Value
        try {
            assertThrows(IllegalArgumentException.class, () -> {round_shot.setMass(-0.5);});
        } catch (IllegalArgumentException e) {
            System.out.println("mass out of bounds. ");
        }

        //Zero Value
        try {
            assertThrows(IllegalArgumentException.class, () -> {round_shot.setMass(0);});
        } catch (IllegalArgumentException e) {
            System.out.println("mass out of bounds. ");
        }

        //Exceeding Value
        try {
            assertThrows(IllegalArgumentException.class, () -> {round_shot.setMass(11);});
        } catch (IllegalArgumentException e) {
            System.out.println("mass out of bounds. ");
        }

    }

    @Test
    public void testIntialSpeedNegativeValue(){
        Simulator simulator = new Simulator();
        Cannon cannon = new Cannon();
        RoundShot round_shot = new RoundShot();
        //setup for validating the inputs


        try {
            assertThrows(IllegalArgumentException.class, () -> {cannon.setInitialSpeed(-0.5);});
        } catch (IllegalArgumentException e) {
            System.out.println("Initial speed can't be negative. ");
        }

    }

    @Test
    public void testExternalForceNegativeValue_XComponent(){
        Simulator simulator = new Simulator();
        Cannon cannon = new Cannon();
        RoundShot round_shot = new RoundShot();
        //setup for validating the inputs
        cannon.setBarrelPose(0,0,0, Math.PI / 4);
        round_shot.setRadius(0.25);
        round_shot.setMass(0.5);
        cannon.setInitialSpeed(10);
        cannon.setExternalForce(-100,0,0);

        double [] position = simulator.simulation(cannon,round_shot);

        assertNotNull(position);
    }

    @Test
    public void testExternalForceNegativeValue_YComponent(){
        Simulator simulator = new Simulator();
        Cannon cannon = new Cannon();
        RoundShot round_shot = new RoundShot();
        //setup for validating the inputs
        cannon.setBarrelPose(0,0,0, Math.PI / 4);
        round_shot.setRadius(0.25);
        round_shot.setMass(0.5);
        cannon.setInitialSpeed(10);
        cannon.setExternalForce(0,-100,0);

        double [] position = simulator.simulation(cannon,round_shot);

//        assertNotNull(position);
    }

    @Test
    public void testExternalForceNegativeValue_ZComponent(){
        Simulator simulator = new Simulator();
        Cannon cannon = new Cannon();
        RoundShot round_shot = new RoundShot();
        //setup for validating the inputs
        cannon.setBarrelPose(0,0,0, Math.PI / 4);
        round_shot.setRadius(0.25);
        round_shot.setMass(0.5);
        cannon.setInitialSpeed(10);
        cannon.setExternalForce(0,0,-100);

        double [] position = simulator.simulation(cannon,round_shot);

        assertNotNull(position);
    }

}
