
package javafxapplication1.platforms;

import javafx.scene.shape.Rectangle;

/**
 *
 * @author Philipp
 */
public class Floor_1 extends Floor {
    
    public Floor_1(double posX, double posY, double width, double height, double angle) {
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
