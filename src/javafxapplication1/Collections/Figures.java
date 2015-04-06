/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1.Collections;

import java.util.ArrayList;
import java.util.HashMap;
import javafxapplication1.entities.Figure;

/**
 *
 * @author Philipp
 */
public class Figures {
    
    private HashMap<String, ArrayList<Figure>> allFigures;
    
    public Figures() {
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
        ArrayList<Figure> allFigures = new ArrayList<>();
        allFigures.addAll(this.allFigures.get("Infantry"));
        allFigures.addAll(this.allFigures.get("Cavalry"));
        allFigures.addAll(this.allFigures.get("Tanks"));
        allFigures.addAll(this.allFigures.get("Vehicles"));
        return allFigures;
    }
    
    public void addFigure(Figure figure) {
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
    
    
}