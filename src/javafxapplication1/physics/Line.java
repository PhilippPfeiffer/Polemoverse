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
public class Line {
    
    private double[] pointA;
    private double[] pointB;
    
    public Line(double[] pointA, double[] pointB) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public double[] getPointA() {
        return pointA;
    }

    public void setPointA(double[] pointA) {
        this.pointA = pointA;
    }

    public double[] getPointB() {
        return pointB;
    }

    public void setPointB(double[] pointB) {
        this.pointB = pointB;
    }
    
    
    
}
