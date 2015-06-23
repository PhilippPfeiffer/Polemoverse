
package javafxapplication1.entities;

/**
 * 
 * @author Philipp
 */
public class Player extends Infantry {
    
    public Player(double positionX, double positionY) {
        
        setAsPlayer(true);
                
        setPosition(positionX, positionY);
        
        setWidth(150);
        setHeight(200);
        
        initializeStates();
        
        initializeBoxes();
        }
}
