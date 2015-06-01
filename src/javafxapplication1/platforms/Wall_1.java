
package javafxapplication1.platforms;

import javafx.scene.shape.Rectangle;

/**
 *
 * @author Philipp
 */
public class Wall_1 extends Wall{
    
    public Wall_1(double posX, double posY, double width, double height, double angle) {
        setPosX(posX);
        setPosY(posY);
        setWidth(width);
        setHeight(height);
        setAngle(angle);
        
        Rectangle a = new Rectangle();
        a.setX(posX);
        a.setY(posY);
        a.setWidth(width);
        a.setHeight(height);
        
        addShape(a);
    }
    
}
