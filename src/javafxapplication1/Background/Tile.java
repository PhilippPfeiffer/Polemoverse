
package javafxapplication1.Background;

import javafx.scene.shape.Rectangle;

/**
 *
 * @author Philipp
 */
public class Tile extends BackgroundTile{
    
    public Tile(double posX, double posY, double movementModifier, double width, double height) {
    
        setPos(posX, posY);
        setMovementModifier(movementModifier);
        
        Rectangle a = new Rectangle();
        a.setX(0);
        a.setY(0);
        a.setWidth(width);
        a.setHeight(height);
        
        setShape(a);
        
    }
    
}
