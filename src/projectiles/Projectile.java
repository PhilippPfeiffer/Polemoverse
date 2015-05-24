/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectiles;

import java.util.ArrayList;
import javafx.scene.shape.Shape;

/**
 *
 * @author Philipp
 */
public interface Projectile {
    
    public void setCaliber(double caliber);
    public void setVelocity(double velocity);
    public void setRange(double range);
    public void setVector(double[] vector);
    public void setPosX(double posX);
    public void setPosY(double posY);
    public void setPos(double[] pos);
    public void setType(String type);
    public void setShapes(ArrayList<Shape> shapes);
    
    public double getCaliber();
    public double getVelocity();
    public double getRange();
    public double[] getVector();
    public double getPosX();
    public double getPosY();
    public double[] getPos(); 
    public String getType();
    public ArrayList<Shape> getShapes();
    
    public void move(double deltaX, double deltaY);
    
    public void addShape(Shape shape);
    
    public void initializeBoxes();
}
