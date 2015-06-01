
package javafxapplication1.Collections;

import javafxapplication1.Background.BackgroundObject;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Philipp
 */
public class BackgroundObjects {
    
    private double movementModifier;
    
    private ArrayList<BackgroundObject> allBackgroundObjectsList;
    private HashMap<String, ArrayList<BackgroundObject>> allBackgroundObjects;
    
    public BackgroundObjects(double movementModifier) {
        this.movementModifier = movementModifier;
        allBackgroundObjectsList = new ArrayList<>();
        allBackgroundObjects = new HashMap();
        allBackgroundObjects.put("Tiles", new ArrayList<>());
    }
    
    public HashMap<String, ArrayList<BackgroundObject>> getAllBackgroundObjects() {
        return allBackgroundObjects;
    }
    
    public ArrayList<BackgroundObject> getAllBackgroundObjectsList() {
        return allBackgroundObjectsList;
    }
    
    public void addBackgroundObject(BackgroundObject backgroundObject) {
        allBackgroundObjectsList.add(backgroundObject);
        switch (backgroundObject.getType()) {
            case "Tile": allBackgroundObjects.get("Tiles").add(backgroundObject);
                break;
        }
    }
    
    public void moveAllBackgroundObjects(double deltaX, double deltaY) {

        for(BackgroundObject backgroundObject : allBackgroundObjectsList) {
            backgroundObject.move(deltaX*movementModifier, deltaY*movementModifier);

            
        }
    }
}
