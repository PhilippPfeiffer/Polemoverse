/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1.entities;

import javafx.scene.shape.*;
import java.util.ArrayList;

/**
 *
 * @author Philipp
 */
public interface Figure {
        
    public void move(double x, double y, double speed, double velocity);
    public void move(double x, double y);
    public void translate(double x, double y, boolean interpolate);
    
    public String getState();
    public double[] getPosition();
    public double getPositionX();
    public double getPositionY();
    public double getVelocity();
    public double getSpeed();
    public ArrayList<Shape> getShapes();
    public Shape getShape(int index);
    public String getType();
    
    public void setState(String state);
    public void setPosition(double[] position);
    public void setPositionX(double positionX);
    public void setPositionY(double positionY);
    public void setVelocity();
    public double setSpeed();
    public void setShapes(ArrayList<Shape> shapes);
    public void addShape(Shape shape);
    public void removeShape(Shape shape);
    public void removeShape(int index);
    
}
