
package javafxapplication1.platforms;

import java.util.ArrayList;
import javafx.scene.shape.Shape;

/**
 *
 * @author Philipp
 */
public interface Platform {
    
    public void setShapes(ArrayList<Shape> shapes);
    public void setWidth(double width);
    public void setHeight(double height);
    public void setAngle(double angle);
    public void setPosX(double posX);
    public void setPosY(double posY);
    
    public String getType();
    public ArrayList<Shape> getShapes();
    public double getWidth();
    public double getHeight();
    public double getAngle();
    public double getPosX();
    public double getPosY();
    
    public void addShape(Shape shape);
    public Shape getShape(int index);
    public void move(double newPosX, double newPosY);
    
}
