/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Background;

import javafx.scene.shape.Shape;

/**
 *
 * @author Philipp
 */
public interface BackgroundObject {
    
    public void move(double deltaX, double deltaY);
    public void setMovementModifier(double rate);
    public void setType(String type);
    public void setPosX(double newPosX);
    public void setPosY(double newPosY);
    public void setPos(double newPosX, double newPosY);
    public void setShape(Shape shape);
    
    public double getMovementModifier();
    public String getType();
    public double getPosX();
    public double getPosY();
    public double[] getPos();
    public Shape getShape();
    
    
}
