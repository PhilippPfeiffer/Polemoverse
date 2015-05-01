/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platforms;

import java.util.ArrayList;
import javafx.scene.shape.Shape;

/**
 *
 * @author Philipp
 */
public abstract class Floor implements Platform{
    
    private final String type = "Floor";
    
    private ArrayList<Shape> shapes = new ArrayList<>();
    private double width;
    private double height;
    private double angle;
    private double posX;
    private double posY;

    @Override
    public void setShapes(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }

    @Override
    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void setAngle(double angle) {
        this.angle = angle;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getAngle() {
        return angle;
    }

    @Override
    public void setPosX(double posX) {
        this.posX = posX;
    }

    @Override
    public void setPosY(double posY) {
        this.posY = posY;
    }

    @Override
    public double getPosX() {
        return posX;
    }

    @Override
    public double getPosY() {
        return posY;
    }

    @Override
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    @Override
    public Shape getShape(int index) {
        return shapes.get(index);
    }

    @Override
    public void move(double deltaX, double deltaY) {
        
        double newX = posX + deltaX;
        double newY = posY + deltaY;
        setPosX(newX);
        setPosY(newY);
        
        for(Shape shape : shapes) {
        shape.relocate(newX, newY);
        System.out.println(shape.getBoundsInParent().getMinX() + " " +shape.getBoundsInParent().getMinY());
        }
    }
}
    
