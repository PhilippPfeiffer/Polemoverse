
package javafxapplication1.Collections;

import java.util.ArrayList;
import java.util.HashMap;
import javafxapplication1.entities.Figure;

/**
 *
 * @author Philipp
 */
public class Figures {
    
    private final HashMap<String, ArrayList<Figure>> allFigures;
    private final ArrayList<Figure> allFiguresList;
    
    public Figures() {
        allFiguresList = new ArrayList<>();
        allFigures = new HashMap<>();
        allFigures.put("Tanks", new ArrayList<>());
        allFigures.put("Cavalry", new ArrayList<>());
        allFigures.put("Infantry", new ArrayList<>());
        allFigures.put("Vehicles", new ArrayList<>());
    }

    public HashMap<String, ArrayList<Figure>> getAllFiguresMap() {
        return allFigures;
    }
    
    public ArrayList<Figure> getAllFiguresList() {
        ArrayList<Figure> tmpAllFigures = new ArrayList<>();
        tmpAllFigures.addAll(this.allFigures.get("Infantry"));
        tmpAllFigures.addAll(this.allFigures.get("Cavalry"));
        tmpAllFigures.addAll(this.allFigures.get("Tanks"));
        tmpAllFigures.addAll(this.allFigures.get("Vehicles"));
        return tmpAllFigures;
    }
    
    public void addFigure(Figure figure) {
        allFiguresList.add(figure);
        String type = figure.getType();
        switch (type) {
            case "Infantry": 
                allFigures.get("Infantry").add(figure);
                break;
            case "Cavalry":
                allFigures.get("Cavalry").add(figure);
                break;
            case "Tank":
                allFigures.get("Tank").add(figure);
                break;
            case "Vehicle":
                allFigures.get("Vehicle").add(figure);
                break;
        }
    }
    
    /**
     * Moves All Figures, except the player, in the given direction. Also updates
     * cooldown times and triggers shooting events.
     * @param deltaX
     * @param deltaY 
     */
    public void moveAllFigures(double deltaX, double deltaY) {
        for(Figure figure : allFiguresList) {
            if(!figure.isPlayer()){
                figure.move(deltaX, deltaY);
            }
            figure.tickDownCooldownTime();
            figure.shoot();
        }
    }
    
    
    
    
}
