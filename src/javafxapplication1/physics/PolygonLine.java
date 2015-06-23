
package javafxapplication1.physics;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeLineCap;

/**
 *
 * @author Philipp
 */
public class PolygonLine {
    
    VecMath vecMath = new VecMath();
    private double[] pointA;
    private double[] pointB;
    private double[] relativePointA;
    private double[] relativePointB;
    private double[] vec;
    private double[] nVec1;
    private double[] nVec2;
    private double thickness;
    Line line = new Line();
    
    public PolygonLine(double[] pos, double[] pointA, double[] pointB, double thickness) {
        this.thickness = thickness;
        this.pointA = vecMath.addVec(pos, pointA);
        this.pointB = vecMath.addVec(pos, pointB);
        this.relativePointA = pointA;
        this.relativePointB = pointB;
        this.vec = vecMath.getVecToPoint(pointA, pointB);
        this.nVec1 = vecMath.getNormalVecLeft(vec);
        this.nVec2 = vecMath.getNormalVecRight(vec);
        Line newLine = new Line();
        newLine.setStartX(pointA[0] + pos[0]);
        newLine.setStartY(pointA[1] + pos[1]);
        newLine.setEndX(pointB[0] + pos[0]);
        newLine.setEndY(pointB[1] + pos[1]);
        newLine.setStrokeLineCap(StrokeLineCap.ROUND);
        newLine.setStroke(Color.MIDNIGHTBLUE);
        newLine.setStrokeWidth(5);
        this.line = newLine;
    }

    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }
    
    public double[] getVec() {
        return vec;
    }

    public void setVec(double[] vec) {
        this.vec = vec;
    }

    public double[] getnVec1() {
        return nVec1;
    }

    public void setnVec1(double[] nVec1) {
        this.nVec1 = nVec1;
    }

    public double[] getnVec2() {
        return nVec2;
    }

    public void setnVec2(double[] nVec2) {
        this.nVec2 = nVec2;
    }
    
    

    public double[] getRelativePointA() {
        return relativePointA;
    }

    public void setRelativePointA(double[] relativePointA) {
        this.relativePointA = relativePointA;
    }

    public double[] getRelativePointB() {
        return relativePointB;
    }

    public void setRelativePointB(double[] relativePointB) {
        this.relativePointB = relativePointB;
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
    
    public Shape getShape() {
        return line;
    }
    
    public void setShape(Line line) {
        this.line = line;
    }
    
    public void setPointA_X(double x) {
        pointA[0] = x;
    }
    
    public void setPointA_Y(double y) {
        pointA[1] = y;
    }
    
    public void setPointB_X(double x) {
        pointB[0] = x;
    }
    
    public void setPointB_Y(double y) {
        pointB[1] = y;
    }
    
    public double getPointA_X() {
        return pointA[0];
    }
    
    public double getPointA_Y() {
        return pointA[1];
    }
    
    public double getPointB_X() {
        return pointB[0];
    }
    
    public double getPointB_Y() {
        return pointB[1];
    }
    
    public void setLine(Line line) {
        this.line = line;
    }
    
    public Line getLine() {
        return line;
    }
    
    public void move(double deltaX, double deltaY) {
        double newPointA_X = getPointA_X() + deltaX;
        double newPointA_Y = getPointA_Y() + deltaY;
        double newPointB_X = getPointB_X() + deltaX;
        double newPointB_Y = getPointB_Y() + deltaY;
        setPointA_X(newPointA_X);
        setPointA_Y(newPointA_Y);
        setPointB_X(newPointB_X);
        setPointB_Y(newPointB_Y);
        line.setStartX(newPointA_X);
        line.setStartY(newPointA_Y);
        line.setEndX(newPointB_X);
        line.setEndY(newPointB_Y);
    }
    
}
