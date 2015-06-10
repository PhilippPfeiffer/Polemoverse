package javafxapplication1.physics;

import java.util.ArrayList;
import javafx.scene.shape.Shape;

/**
 *
 * @author Philipp
 */
public class Polygon {
    
    VecMath vecMath = new VecMath();
    private ArrayList<PolygonLine> polygonLines = new ArrayList<>();
    private Shape boundingBox;
    private double pos[] = {0.0, 0.0};
    
    public Polygon(double[] pos) {
        boundingBox = vecMath.buildBoundingBox(pos, polygonLines);
        this.pos = pos;
    }
    
    public Shape getBoundingBox() {
        return boundingBox;
    }
    
    public void setBoundingBox(Shape boundingBox) {
        this.boundingBox = boundingBox;
    }
    
    public double[] getPos() {
        return pos;
    }
    
    public void setPos(double[] pos) {
        this.pos = pos;
    }
    
    public void setPos(double posX, double posY) {
        this.pos[0] = posX;
        this.pos[1] = posY;
    }
    
    public ArrayList<PolygonLine> getPolygonLines() {
        return polygonLines;
    }
    
    public void setPolygonLines(ArrayList<PolygonLine> polygonLines) {
        this.polygonLines = polygonLines;
        setBoundingBox(vecMath.buildBoundingBox(pos, polygonLines));
    }
    
    public void addLine(PolygonLine polygonLine) {
        this.polygonLines.add(polygonLine);
        setBoundingBox(vecMath.buildBoundingBox(pos, polygonLines));
    }
    
    public void addLine(double[] pointA, double[] pointB) {
        this.polygonLines.add(new PolygonLine(pos, pointA, pointB));
        setBoundingBox(vecMath.buildBoundingBox(pos, polygonLines));
    }
    
    public PolygonLine getLine(int index) {
        return polygonLines.get(index);
    }
    
    public void removeLine(int index) {
        polygonLines.remove(index);
        setBoundingBox(vecMath.buildBoundingBox(pos, polygonLines));
    }
    
    public void removeLine(PolygonLine polygonLine) {
        polygonLines.remove(polygonLine);
        setBoundingBox(vecMath.buildBoundingBox(pos, polygonLines));
    }
    
    public void move(double deltaX, double deltaY) {
        double newX = pos[0] + deltaX;
        double newY = pos[1] + deltaY;
        setPos(newX, newY);
        polygonLines.stream().forEach((currentLine) -> {
            currentLine.move(deltaX, deltaY);
        });
        boundingBox.relocate(newX, newY);
    }
    
    public ArrayList<Shape> getShapes() {
        ArrayList<Shape> shapes = new ArrayList<>();
        polygonLines.stream().forEach((currentLine) -> {
            Shape currentShape = currentLine.getShape();
            shapes.add(currentShape);
        });
        shapes.add(boundingBox);
        return shapes;
    }
    
}
