
package javafxapplication1.Background;

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
