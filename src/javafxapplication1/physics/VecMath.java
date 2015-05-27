/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1.physics;

/**
 *
 * @author Philipp
 */
public class VecMath {
    
    public double[] multiplyVec(double[] vector, double scalar) {
        double[] newVec = {0,0};
        newVec[0] = vector[0] * scalar;
        newVec[1] = vector[1] * scalar;
        return newVec;
    }
    
    public double[] addVec(double[] vector1, double[] vector2) {
        double[] newVec = {0,0};
        newVec[0] = vector1[0] + vector2[0];
        newVec[1] = vector1[1] + vector2[1];
        return newVec;
    }
    
    public double[] addVec(double[] vector, double scalar) {
        double[] newVec = {0,0};
        newVec[0] = vector[0] + scalar;
        newVec[1] = vector[1] + scalar;
        return newVec;
    }
    
    public double[] subVec(double[] vector1, double[] vector2) {
        double[] newVec = {0,0};
        newVec[0] = vector1[0] - vector2[0];
        newVec[1] = vector1[1] - vector2[1];
        return newVec;
    }
    
    public double[] subVec(double[] vector, double scalar) {
        double[] newVec = {0,0};
        newVec[0] = vector[0] - scalar;
        newVec[1] = vector[1] - scalar;
        return newVec;
    }
    
    public double getDistance(double[] vector1, double[] vector2) {
        return Math.sqrt(Math.pow((vector2[0]-vector1[0]), 2.0)+Math.pow((vector2[1]-vector1[1]), 2.0));
    }
    
    public double[] getVecToPoint(double[] point1, double[] point2) {
        double x = point2[0] - point1[0];
        double y = point2[1] - point1[1];
        double[] vec = {x,y};
        return vec;
    }
    
    public double getVecLength(double[] vec) {
        return Math.sqrt(Math.pow(vec[0], 2.0)+Math.pow(vec[1], 2.0));
    }
    
    public double[] normalize(double[] vec) {
        double vecLength = getVecLength(vec);
        double x = vec[0]/vecLength;
        double y = vec[1]/vecLength;
        vec[0] = x;
        vec[1] = y;
        return vec;
    }
    
    public double dotProduct(double[] vec1, double[] vec2) {
        double dotProduct = (vec1[0]*vec2[0])+(vec1[1]*vec2[1]);
        return dotProduct;
    }
    
}
