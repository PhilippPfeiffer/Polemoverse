/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1.physics;

import java.util.Random;

/**
 *
 * @author Philipp
 */
public class VecMath {
    
    /**
     * Multiplies a given vector with a given scalar and returns the resulting
     * vector.
     * @param vector
     * @param scalar
     * @return double[]
     */
    public double[] multiplyVec(double[] vector, double scalar) {
        double[] newVec = {0,0};
        newVec[0] = vector[0] * scalar;
        newVec[1] = vector[1] * scalar;
        return newVec;
    }
    
    /**
     * Adds two given vectors and returns the resulting vector.
     * @param vector1
     * @param vector2
     * @return double[]
     */
    public double[] addVec(double[] vector1, double[] vector2) {
        double[] newVec = {0,0};
        newVec[0] = vector1[0] + vector2[0];
        newVec[1] = vector1[1] + vector2[1];
        return newVec;
    }
    
    /**
     * Adds a given scalar to a given vector and returns the resulting vector.
     * @param vector
     * @param scalar
     * @return double[]
     */
    public double[] addVec(double[] vector, double scalar) {
        double[] newVec = {0,0};
        newVec[0] = vector[0] + scalar;
        newVec[1] = vector[1] + scalar;
        return newVec;
    }
    
    /**
     * Subtracts a given vector from another given vector. Vector2 is
     * subtracted from vector1 and the resulting vector is returned.
     * @param vector1
     * @param vector2
     * @return double[]
     */
    public double[] subVec(double[] vector1, double[] vector2) {
        double[] newVec = {0,0};
        newVec[0] = vector1[0] - vector2[0];
        newVec[1] = vector1[1] - vector2[1];
        return newVec;
    }
    
    /**
     * Subtracts a given scalar from a given vecor and returns the resulting
     * vector.
     * @param vector
     * @param scalar
     * @return double[]
     */
    public double[] subVec(double[] vector, double scalar) {
        double[] newVec = {0,0};
        newVec[0] = vector[0] - scalar;
        newVec[1] = vector[1] - scalar;
        return newVec;
    }
    
    /**
     * Returns the distance between two given points.
     * @param vector1
     * @param vector2
     * @return double
     */
    public double getDistance(double[] vector1, double[] vector2) {
        return Math.sqrt(Math.pow((vector2[0]-vector1[0]), 2.0)+Math.pow((vector2[1]-vector1[1]), 2.0));
    }
    
    /**
     * Returns the vector between two given points.
     * @param point1
     * @param point2
     * @return double[]
     */
    public double[] getVecToPoint(double[] point1, double[] point2) {
        double x = point2[0] - point1[0];
        double y = point2[1] - point1[1];
        double[] vec = {x,y};
        return vec;
    }
       
    /**
     * eturns the length of a given vector.
     * @param vec
     * @return double
     */
    public double getVecLength(double[] vec) {
        return Math.sqrt(Math.pow(vec[0], 2.0)+Math.pow(vec[1], 2.0));
    }
    
    /**
     * Normalizes and returns a given vector.
     * @param vec
     * @return double[]
     */
    public double[] normalize(double[] vec) {
        double vecLength = getVecLength(vec);
        double x = vec[0]/vecLength;
        double y = vec[1]/vecLength;
        vec[0] = x;
        vec[1] = y;
        return vec;
    }
    
    /**
     * Returns the dot product of two given vectors.
     * @param vec1
     * @param vec2
     * @return double
     */
    public double dotProduct(double[] vec1, double[] vec2) {
        double dotProduct = (vec1[0]*vec2[0])+(vec1[1]*vec2[1]);
        return dotProduct;
    }
    
    /**
     * Rotates a given vector by the given degrees. Negative degrees are 
     * permitted.
     * @param vec
     * @param degrees
     * @return double[]
     */
    public double[] rotateVec(double[] vec, double degrees) {
        double theta = Math.toRadians(degrees);
        double[] rotatedVec = {Math.cos(theta)*vec[0]-Math.sin(theta)*vec[1], Math.sin(theta)*vec[0]+Math.cos(theta)*vec[1]};
        return rotatedVec;
    }
    
    /**
     * Finds and returns the angle between two vectors.
     * @param vec1
     * @param vec2
     * @return double
     */
    public double getAngle(double[] vec1, double[] vec2) {
        double theta1 = Math.atan2(vec1[0], vec1[1]);
        double theta2 = Math.atan2(vec2[0], vec2[1]);
        double theta = theta1 - theta2;
        theta = Math.toDegrees(theta);
        if(theta < 0) {
            theta = 360.0 + theta;
        }
        return theta;
    }
    
    /**
     * Returns a double value randomly chose from within the given interval.
     * Negative and positive values are possible.
     * @param interval
     * @return double
     */
    public double randomizeAngle(double interval) {
        double rangeMin = -interval/2;
        double rangeMax = interval/2;
        Random random = new Random();
        double randomValue = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
        return randomValue;
    }
    
    /**
     * Intersects two lines and returns the point at which they intersect, if
     * they intersect. Returns null, if there is no intersction
     * @param line1
     * @param line2
     * @return double[] point if intersection occurs. Null if not.
     */
    public double[] intersectLines(Line line1, Line line2) {
        
        double A_X = line1.getPointA()[0];
        double A_Y = line1.getPointA()[1];
        double B_X = line1.getPointB()[0];
        double B_Y = line1.getPointB()[1];
        double C_X = line2.getPointA()[0];
        double C_Y = line2.getPointA()[1];
        double D_X = line2.getPointB()[0];
        double D_Y = line2.getPointB()[1];
        
        double d = (A_X-B_X)*(C_Y-D_Y) - (A_Y-B_Y)*(C_X-D_Y);
        if (d == 0) return null;
        
        double xi = ((C_X-D_X)*(A_X*B_Y-A_Y*B_X)-(A_X-B_X)*(C_X*D_Y-C_Y*D_X))/d;
        double yi = ((C_Y-D_Y)*(A_X*B_Y-A_Y*B_X)-(A_Y-B_Y)*(C_X*D_Y-C_Y*D_X))/d;
        
        double[] point = {xi, yi};
        return point;
    }
    
}
