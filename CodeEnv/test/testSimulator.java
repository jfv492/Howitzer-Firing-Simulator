 import static org.junit.jupiter.api.Assertions.*;

 import org.junit.jupiter.api.Test;

 class testSimulator {

     // Boundary Value Testing
     // Generalized Boundary Value testing
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

    @Test
     public void testDragCoefficient_Zero(){
         // checking with min value
         Simulator simulator = new Simulator();
         simulator.setBarrelPose(0, 0, 0, Math.PI/4);
         simulator.setRadius(0.5);
         simulator.setMass(1);
         simulator.setExternalForce(1,1,1);
         simulator.setDragCoefficient(0);
         simulator.setInitialSpeed(10);
         double [] results = simulator.simulation();
         assertNull(results);
     }

     @Test
     public void testDragCoefficient_Nominal(){
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
     public void testDragCoefficient_PositiveInfinity(){
         // checking with nominal value
         Simulator simulator = new Simulator();
         simulator.setBarrelPose(0, 0, 0, Math.PI/4);
         simulator.setRadius(0.5);
         simulator.setMass(1);
         simulator.setExternalForce(1,1,1);
         simulator.setDragCoefficient(Double.POSITIVE_INFINITY);
         simulator.setInitialSpeed(10);
         double [] results = simulator.simulation();
         assertNotNull(results);
     }

    @Test
     public void testInitialSpeed_Zero(){
         // checking with min value
         Simulator simulator = new Simulator();
         simulator.setBarrelPose(0, 0, 0, Math.PI/4);
         simulator.setRadius(0.5);
         simulator.setMass(1);
         simulator.setExternalForce(1,1,1);
         simulator.setDragCoefficient(0.5);
         simulator.setInitialSpeed(0);
         double [] results = simulator.simulation();
         assertNull(results);
     }

    @Test
     public void testInitialSpeed_Nominal(){
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
     public void testIntialSpeed_PositiveInfinity(){
         // checking with nominal value
         Simulator simulator = new Simulator();
         simulator.setBarrelPose(0, 0, 0, Math.PI/4);
         simulator.setRadius(0.5);
         simulator.setMass(1);
         simulator.setExternalForce(1,1,1);
         simulator.setDragCoefficient(0.5);
         simulator.setInitialSpeed(Double.POSITIVE_INFINITY);
         double [] results = simulator.simulation();
         assertNotNull(results);
     }

    @Test
     public void testExternalForce_NegativeInfinity(){
         // checking with min value
         Simulator simulator = new Simulator();
         simulator.setBarrelPose(0, 0, 0, Math.PI/4);
         simulator.setRadius(0.5);
         simulator.setMass(1);
         simulator.setExternalForce(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
         simulator.setDragCoefficient(0.5);
         simulator.setInitialSpeed(10);
         double [] results = simulator.simulation();
         assertNotNull(results);
     }

    @Test
     public void testExternalForce_Zero(){
         // checking with zero value
         Simulator simulator = new Simulator();
         simulator.setBarrelPose(0, 0, 0, Math.PI/4);
         simulator.setRadius(0.5);
         simulator.setMass(1);
         simulator.setExternalForce(0,0,0);
         simulator.setDragCoefficient(0.5);
         simulator.setInitialSpeed(10);
         double [] results = simulator.simulation();
         assertNotNull(results);
     }

    @Test
     public void testExternalForce_Nominal(){
         // checking with zero value
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
     public void testExternalForce_PositiveInfinity(){
         // checking with max+ value
         Simulator simulator = new Simulator();
         simulator.setBarrelPose(0, 0, 0, Math.PI/4);
         simulator.setRadius(0.5);
         simulator.setMass(1);
         simulator.setExternalForce(Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY);
         simulator.setDragCoefficient(0.5);
         simulator.setInitialSpeed(10);
         double [] results = simulator.simulation();
         assertNotNull(results);
     }

 }
