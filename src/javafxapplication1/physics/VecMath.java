
package javafxapplication1.physics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

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
     * Returns the length of a given vector.
     * @param vec
     * @return double
     */
    public double getVecLength(double[] vec) {
        return Math.sqrt(Math.pow(vec[0], 2.0)+Math.pow(vec[1], 2.0));
    }
    
    /**
     * Returns the left normal vector of the given vector
     * @param vec
     * @return double[]
     */
    public double[] getNormalVecLeft(double[] vec) {
        return rotateVec(vec, 270.0);
    }
    
    /**
     * Returns the right normal vector of the given vector
     * @param vec
     * @return double[]
     */
    public double[] getNormalVecRight(double[] vec) {
        return rotateVec(vec, 90.0);
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
     * Wraps a box around a line and returns the box in a double array. 
     * The array is structured as {x1,y1,x2,y2}.
     * @param lineStart
     * @param lineEnd
     * @return 
     */
    public double[] getBoundingBox(double[] lineStart, double[] lineEnd) {
        double[] box = {0.0,0.0,0.0,0.0};
        
        box[0] = Math.min(lineStart[0], lineEnd[0]);
        box[1] = Math.min(lineStart[1], lineEnd[1]);
        box[2] = Math.max(lineStart[0], lineEnd[0]);
        box[3] = Math.max(lineStart[1], lineEnd[1]);
        
        return box;
    }
    
    /**
     * Checks if a point is within the bounding box of a line.
     * @param lineStart
     * @param lineEnd
     * @param point
     * @return boolean
     */
    public boolean isPointInBoundingBox(double[] lineStart, double[] lineEnd, double[] point) {
        double[] box = getBoundingBox(lineStart, lineEnd);
        double epsilon = 0.01;
        if(point[0]>= box[0]-epsilon && point[0]<=box[2]+epsilon  && point[1]>=box[1]-epsilon  && point[1]<=box[3]+epsilon ) {
            return true;
        } else return false;  
    }
    
    /**
     * Intersects two lines and returns the point at which they intersect, if
     * they intersect. Returns null, if there is no intersction
     * @param line1Start
     * @param line1End
     * @param line2
     * @return double[] point if intersection occurs. Null if not.
     */
    public double[] intersectLines(double[] line1Start, double[] line1End, Line line2) {
                
        double x1 = line1Start[0];
        double y1 = line1Start[1];
        double x2 = line1End[0];
        double y2 = line1End[1];
        double x3 = line2.getStartX();
        double y3 = line2.getStartY();
        double x4 = line2.getEndX();
        double y4 = line2.getEndY();
        
        double[] line2Start = {line2.getStartX(),line2.getStartY()};
        double[] line2End = {line2.getEndX(), line2.getEndY()};
        
        double d = (x1-x2)*(y3-y4) - (y1-y2)*(x3-x4);
        if (d == 0) return null;
    
        double xi = ((x3-x4)*(x1*y2-y1*x2)-(x1-x2)*(x3*y4-y3*x4))/d;
        double yi = ((y3-y4)*(x1*y2-y1*x2)-(y1-y2)*(x3*y4-y3*x4))/d;
        
        double[] point = {xi, yi};
        if(isPointInBoundingBox(line1Start, line1End, point) && 
                isPointInBoundingBox(line2Start, line2End, point)) {
            return point;
        } else return null;
    }
    
    /**
     * Intersects two lines and returns the point at which they intersect, if
     * they intersect. Returns null, if there is no intersction
     * @param line1
     * @param line2
     * @return double[] point if intersection occurs. Null if not.
     */
    public double[] intersectLines(PolygonLine line1, PolygonLine line2) {
        
        double x1 = line1.getPointA()[0];
        double y1 = line1.getPointA()[1];
        double x2 = line1.getPointB()[0];
        double y2 = line1.getPointB()[1];
        double x3 = line2.getPointA()[0];
        double y3 = line2.getPointA()[1];
        double x4 = line2.getPointB()[0];
        double y4 = line2.getPointB()[1];
        
        double d = (x1-x2)*(y3-y4) - (y1-y2)*(x3-x4);
        if (d == 0) return null;
    
        double xi = ((x3-x4)*(x1*y2-y1*x2)-(x1-x2)*(x3*y4-y3*x4))/d;
        double yi = ((y3-y4)*(x1*y2-y1*x2)-(y1-y2)*(x3*y4-y3*x4))/d;
        
        double[] point = {xi, yi};
        return point;
    }
    
    public Shape buildBoundingBox(double[] pos, ArrayList<PolygonLine> lines) {
        Rectangle a = new Rectangle();
        ArrayList<Double> xValues = new ArrayList<>();
        ArrayList<Double> yValues = new ArrayList<>();
        
        for(PolygonLine currentLine : lines) {
            xValues.add(currentLine.getRelativePointA()[0]);
            xValues.add(currentLine.getRelativePointB()[0]);
            yValues.add(currentLine.getRelativePointA()[1]);
            yValues.add(currentLine.getRelativePointB()[1]);
        }
        
        if(xValues.size()<1||yValues.size()<1) {
            a.setX(pos[0]);
            a.setY(pos[1]);
            a.setWidth(0);
            a.setHeight(0);
        } else {
            Collections.sort(xValues);
            Collections.sort(yValues);
            double xMin = xValues.get(0);
            double xMax = xValues.get(xValues.size()-1);
            double yMin = yValues.get(0);
            double yMax = yValues.get(yValues.size()-1);
            
            a.setX(xMin);
            a.setY(yMin);
            a.setWidth(xMax - xMin);
            a.setHeight(yMax - yMin);
            a.setOpacity(0.5);
            System.out.println(a.getX()+" "+a.getY()+" "+a.getWidth()+" "+a.getHeight());
        }
        
        return a;
    }
    
}
