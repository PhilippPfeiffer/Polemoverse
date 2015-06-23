
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
    
    /**
     * Test for intersectLines method of clas VecMath.
     */
    @Test
    public void testIntersectLines() {
        double thickness = 10.0;
        
        double[] startPos1 = {0.0,0.0};
        double[] startPos2 = {0.25,0.25};
        double[] startPos3 = {5.0,5.0};
        
        double[] point1 = {0.0,0.0};
        double[] point2 = {0.0,10.0};
        double[] point3 = {10.0,0.0};
        double[] point4 = {10.0,10.0};
        double[] point5 = {13.324,14.324};
        double[] point6 = {15.0,20.0};
        double[] point7 = {23.0,19.0};
        
        PolygonLine line1 = new PolygonLine(startPos1, point4, point1, thickness);
        PolygonLine line2 = new PolygonLine(startPos1, point3, point2, thickness);
        
        PolygonLine line3 = new PolygonLine(startPos2, point1, point2, thickness);
        PolygonLine line4 = new PolygonLine(startPos3, point1, point2, thickness);
        
        PolygonLine line5 = new PolygonLine(startPos3, point1, point2, thickness);
        PolygonLine line6 = new PolygonLine(startPos3, point1, point2, thickness);
        
        PolygonLine line7 = new PolygonLine(startPos1, point5, point1, thickness);
        
        PolygonLine line8 = new PolygonLine(startPos1, point1, point4, thickness);
        PolygonLine line9 = new PolygonLine(startPos1, point6, point7, thickness);
        
        double[] result1 = vecMath.intersectLines(line1, line2);
        double[] result2 = vecMath.intersectLines(line3, line4);
        double[] result3 = vecMath.intersectLines(line5, line6);
        double[] result4 = vecMath.intersectLines(line7, line2);
        double[] result5 = vecMath.intersectLines(line8, line9);
        
        assertEquals("Intersection1_X", 5.0, result1[0], 0.001);
        assertEquals("Intersection1_Y", 5.0, result1[1], 0.001);
        
        assertNull("Intersection2", result2);
        
        assertNull("Intersection3", result3);
        
        assertEquals("Intersection4_X", 4.819155092592593, result4[0], 0.001);
        assertEquals("Intersection4_Y", 5.180844907407407, result4[1], 0.001);
        
        assertEquals("Intersection5_X", 19.444444444444443, result5[0], 0.001);
        assertEquals("Intersection5_Y", 19.444444444444443, result5[1], 0.001);
    }
    
    @Test
    public void testGetBoundingBox() {
        double[] point1 = {0.0,0.0};
        double[] point2 = {0.0,10.0};
        double[] point3 = {10.0,0.0};
        double[] point4 = {10.0,10.0};
        double[] point5 = {-10.0,-10.0};
        
        double[] result1 = vecMath.getBoundingBox(point1, point2);
        double[] result2 = vecMath.getBoundingBox(point1, point4);
        double[] result3 = vecMath.getBoundingBox(point4, point5);
        
        assertEquals("Box1x1", 0.0, result1[0], 0.001);
        assertEquals("Box1y1", 0.0, result1[1], 0.001);
        assertEquals("Box1x2", 0.0, result1[2], 0.001);
        assertEquals("Box1y2", 10.0, result1[3], 0.001);
        
        assertEquals("Box2x1", 0.0, result2[0], 0.001);
        assertEquals("Box2y1", 0.0, result2[1], 0.001);
        assertEquals("Box2x2", 10.0, result2[2], 0.001);
        assertEquals("Box2y2", 10.0, result2[3], 0.001);
        
        assertEquals("Box3x1", -10.0, result3[0], 0.001);
        assertEquals("Box3y1", -10.0, result3[1], 0.001);
        assertEquals("Box3x2", 10.0, result3[2], 0.001);
        assertEquals("Box3y2", 10.0, result3[3], 0.001);
    }
    
    @Test
    public void testIsPointInBoundingBox() {
        
        double[] point1 = {10.0,10.0};
        double[] point2 = {-10.0,-10.0};
        double[] point3 = {0.0,0.0};
        double[] point4 = {5.0,5.0};
        
        double[] box1 = vecMath.getBoundingBox(point1, point2);
        
        assertTrue("isInBox1", vecMath.isPointInBoundingBox(point1, point2, point4));
        assertTrue("isInBox1", vecMath.isPointInBoundingBox(point3, point1, point4));
        assertTrue("isInBox1", vecMath.isPointInBoundingBox(point1, point1, point1));
        assertFalse("isInBox1", vecMath.isPointInBoundingBox(point1, point4, point2));
        assertFalse("isInBox1", vecMath.isPointInBoundingBox(point1, point4, point3));
        
    }
    
    @Test
    public void testGetNormalVec() {
        double[] vector1 = {10.0,10.0};
        
        double[] nVec1Left = vecMath.getNormalVecLeft(vector1);
        double[] nVec1Right = vecMath.getNormalVecRight(vector1);
        
        double[] nVec2Left = vecMath.getNormalVecLeft(nVec1Left);
        double[] nVec2eft = vecMath.getNormalVecRight(nVec1Right);
        
        assertEquals("X", 10.0, nVec1Left[0], 0.001);
        assertEquals("Y", -10.0, nVec1Left[1], 0.001);
        assertEquals("X", -10.0, nVec1Right[0], 0.001);
        assertEquals("Y", 10.0, nVec1Right[1], 0.001);
        
        assertEquals("X", -10.0, nVec2Left[0], 0.001);
        assertEquals("Y", -10.0, nVec2Left[1], 0.001);
        assertEquals("X", -10.0, nVec2eft[0], 0.001);
        assertEquals("Y", -10.0, nVec2eft[1], 0.001);
    }
}
