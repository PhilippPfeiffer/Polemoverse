/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1.physics;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
        VecMath vecMath = new VecMath();
        
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
        
    }

    /**
     * Test of addVec method, of class VecMath.
     */
    @Test
    public void testAddVec_doubleArr_double() {
        
    }

    /**
     * Test of subVec method, of class VecMath.
     */
    @Test
    public void testSubVec_doubleArr_doubleArr() {
        
    }

    /**
     * Test of subVec method, of class VecMath.
     */
    @Test
    public void testSubVec_doubleArr_double() {
        
    }

    /**
     * Test of getDistance method, of class VecMath.
     */
    @Test
    public void testGetDistance() {
        
    }

    /**
     * Test of getVecToPoint method, of class VecMath.
     */
    @Test
    public void testGetVecToPoint() {
        
    }

    /**
     * Test of getVecLength method, of class VecMath.
     */
    @Test
    public void testGetVecLength() {
        
    }

    /**
     * Test of normalize method, of class VecMath.
     */
    @Test
    public void testNormalize() {
        
    }

    /**
     * Test of dotProduct method, of class VecMath.
     */
    @Test
    public void testDotProduct() {
        
    }
    
}
