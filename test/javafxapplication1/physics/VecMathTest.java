
package javafxapplication1.physics;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Philipp
 */
public class VecMathTest {
    
    VecMath vecMath = new VecMath();
    
    
    public VecMathTest() {
    }
    
    /**
     * Test of multiplyVec method, of class VecMath.
     */
    @Test
    public void testMultiplyVec() {
        
        double vector1[] = {1.0,1.0};
        
        double scalar1 = 1.0;
        double scalar2 = 2.5;
        double scalar3 = -1.0;
        
        double[] resultVector = vecMath.multiplyVec(vector1, scalar1);
        
        assertEquals("X ", 1.0, resultVector[0], 0.001);
        assertEquals("Y ", 1.0, resultVector[1], 0.001);
        
        resultVector = vecMath.multiplyVec(vector1, scalar2);
        
        assertEquals("X ", 2.5, resultVector[0], 0.001);
        assertEquals("Y ", 2.5, resultVector[1], 0.001);
        
        resultVector = vecMath.multiplyVec(vector1, scalar3);
        
        assertEquals("X ", -1.0, resultVector[0], 0.001);
        assertEquals("Y ", -1.0, resultVector[1], 0.001);
    }

    /**
     * Test of addVec method, of class VecMath.
     */
    @Test
    public void testAddVec_doubleArr_doubleArr() {
        double vector1[] = {1.0,1.0};
        double vector2[] = {1.5,-2.0};
        
        double[] resultVector1 = vecMath.addVec(vector1, vector1);
        double[] resultVector2 = vecMath.addVec(vector2, vector2);
        double[] resultVector3 = vecMath.addVec(vector1, vector2);
        
        assertEquals("X ", 2.0, resultVector1[0], 0.001);
        assertEquals("Y ", 2.0, resultVector1[1], 0.001);
        
        assertEquals("X ", 3.0, resultVector2[0], 0.001);
        assertEquals("Y ", -4.0, resultVector2[1], 0.001);
        
        assertEquals("X ", 2.5, resultVector3[0], 0.001);
        assertEquals("Y ", -1.0, resultVector3[1], 0.001);
    }

    /**
     * Test of addVec method, of class VecMath.
     */
    @Test
    public void testAddVec_doubleArr_double() {
        double vector1[] = {1.0,1.0};
        
        double scalar1 = 1.0;
        double scalar2 = 2.5;
        double scalar3 = -2.0;
        
        double[] resultVector1 = vecMath.addVec(vector1, scalar1);
        double[] resultVector2 = vecMath.addVec(vector1, scalar2);
        double[] resultVector3 = vecMath.addVec(vector1, scalar3);
        
        assertEquals("X ", 2.0, resultVector1[0], 0.001);
        assertEquals("Y ", 2.0, resultVector1[1], 0.001);
        
        assertEquals("X ", 3.5, resultVector2[0], 0.001);
        assertEquals("Y ", 3.5, resultVector2[1], 0.001);
        
        assertEquals("X ", -1.0, resultVector3[0], 0.001);
        assertEquals("Y ", -1.0, resultVector3[1], 0.001);
    }

    /**
     * Test of subVec method, of class VecMath.
     */
    @Test
    public void testSubVec_doubleArr_doubleArr() {
        double vector1[] = {1.0,1.0};
        double vector2[] = {1.5,-2.0};
        
        double[] resultVector1 = vecMath.subVec(vector1, vector1);
        double[] resultVector2 = vecMath.subVec(vector2, vector2);
        double[] resultVector3 = vecMath.subVec(vector1, vector2);
        
        assertEquals("X ", 0.0, resultVector1[0], 0.001);
        assertEquals("Y ", 0.0, resultVector1[1], 0.001);
        
        assertEquals("X ", 0.0, resultVector2[0], 0.001);
        assertEquals("Y ", 0.0, resultVector2[1], 0.001);
        
        assertEquals("X ", -0.5, resultVector3[0], 0.001);
        assertEquals("Y ", 3.0, resultVector3[1], 0.001);
    }

    /**
     * Test of subVec method, of class VecMath.
     */
    @Test
    public void testSubVec_doubleArr_double() {
        double vector1[] = {1.0,1.0};
        
        double scalar1 = 1.0;
        double scalar2 = 2.5;
        double scalar3 = -2.0;
        
        double[] resultVector1 = vecMath.subVec(vector1, scalar1);
        double[] resultVector2 = vecMath.subVec(vector1, scalar2);
        double[] resultVector3 = vecMath.subVec(vector1, scalar3);
        
        assertEquals("X ", 0.0, resultVector1[0], 0.001);
        assertEquals("Y ", 0.0, resultVector1[1], 0.001);
        
        assertEquals("X ", -1.5, resultVector2[0], 0.001);
        assertEquals("Y ", -1.5, resultVector2[1], 0.001);
        
        assertEquals("X ", 3.0, resultVector3[0], 0.001);
        assertEquals("Y ", 3.0, resultVector3[1], 0.001);
    }

    /**
     * Test of getDistance method, of class VecMath.
     */
    @Test
    public void testGetDistance() {
        double vector1[] = {1.0,1.0};
        double vector2[] = {1.5,-2.0};
        
        double resultDouble1 = vecMath.getDistance(vector1, vector1);
        double resultDouble2 = vecMath.getDistance(vector1, vector2);
        double resultDouble3 = vecMath.getDistance(vector2, vector1);
        
        assertEquals("Distance1", 0.0, resultDouble1, 0.001);
        assertEquals("Distance2", 3.04138, resultDouble2, 0.001);
        assertEquals("Distance3", 3.04138, resultDouble3, 0.001);
    }

    /**
     * Test of getVecToPoint method, of class VecMath.
     */
    @Test
    public void testGetVecToPoint() {
        double vector1[] = {1.0,1.0};
        double vector2[] = {1.5,-2.0};
        
        double[] resultVector1 = vecMath.getVecToPoint(vector1, vector1);
        double[] resultVector2 = vecMath.getVecToPoint(vector2, vector1);
        double[] resultVector3 = vecMath.getVecToPoint(vector1, vector2);
        
        assertEquals("X ", 0.0, resultVector1[0], 0.001);
        assertEquals("Y ", 0.0, resultVector1[1], 0.001);
        
        assertEquals("X ", -0.5, resultVector2[0], 0.001);
        assertEquals("Y ", 3.0, resultVector2[1], 0.001);
        
        assertEquals("X ", 0.5, resultVector3[0], 0.001);
        assertEquals("Y ", -3.0, resultVector3[1], 0.001);
    }

    /**
     * Test of getVecLength method, of class VecMath.
     */
    @Test
    public void testGetVecLength() {
        double vector1[] = {1.0,1.0};
        double vector2[] = {1.5,-2.0};
        
        double resultDouble1 = vecMath.getVecLength(vector1);
        double resultDouble2 = vecMath.getVecLength(vector2);
        
        assertEquals("Distance1", 1.414213, resultDouble1, 0.001);
        assertEquals("Distance2", 2.5, resultDouble2, 0.001);
    }

    /**
     * Test of normalize method, of class VecMath.
     */
    @Test
    public void testNormalize() {
        double vector1[] = {1.0,1.0};
        double vector2[] = {1.5,-2.0};
        
        double[] resultVector1 = vecMath.normalize(vector1);
        double[] resultVector2 = vecMath.normalize(vector2);
        
        assertEquals("X ", 0.707106, resultVector1[0], 0.001);
        assertEquals("Y ", 0.707106, resultVector1[1], 0.001);
        
        assertEquals("X ", 0.6, resultVector2[0], 0.001);
        assertEquals("Y ", -0.8, resultVector2[1], 0.001);
    }

    /**
     * Test of dotProduct method, of class VecMath.
     */
    @Test
    public void testDotProduct() {
        double vector1[] = {1.0,1.0};
        double vector2[] = {1.5,-2.0};
        
        double resultDouble1 = vecMath.dotProduct(vector1,vector2);
        
        assertEquals("Distance1", -0.5, resultDouble1, 0.001);
    }
    
    /**
     * Test of rotateVec method, of class VecMath.
     */
    @Test
    public void testRotateVec() {
        double vector[] = {1.0,1.0};
        
        double theta1 = 0;
        double theta2 = 90;
        double theta3 = -90;
        double theta4 = 180;
        
        double[] resultVector1 = vecMath.rotateVec(vector, theta1);
        double[] resultVector2 = vecMath.rotateVec(vector, theta2);
        double[] resultVector3 = vecMath.rotateVec(vector, theta3);
        double[] resultVector4 = vecMath.rotateVec(vector, theta4);
        
        assertEquals("X", 1.0, resultVector1[0], 0.001);
        assertEquals("Y", 1.0, resultVector1[1], 0.001);
        assertEquals("X", -1.0, resultVector2[0], 0.001);
        assertEquals("Y", 1.0, resultVector2[1], 0.001);
        assertEquals("X", 1.0, resultVector3[0], 0.001);
        assertEquals("Y", -1.0, resultVector3[1], 0.001);
        assertEquals("X", -1.0, resultVector4[0], 0.001);
        assertEquals("Y", -1.0, resultVector4[1], 0.001);
    }
    
    /**
     * Test of getAngle method, of class VecMath.
     */
    @Test
    public void testGetAngle() {
        double vector1[] = {3.0,3.0};
        double vector2[] = {1.0,-1.0};
        double vector3[] = {-1.0,-1.0};
        
        double resultDouble1 = vecMath.getAngle(vector1, vector2);
        double resultDouble2 = vecMath.getAngle(vector1, vector3);
        double resultDouble3 = vecMath.getAngle(vector2, vector3);
        
        assertEquals("Angle1", 270.0, resultDouble1, 0.001);
        assertEquals("Angle2", 180.0, resultDouble2, 0.001);
        assertEquals("Angle3", 270.0, resultDouble3, 0.001);
    }  
}
