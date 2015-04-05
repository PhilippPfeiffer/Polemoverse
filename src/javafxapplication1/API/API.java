/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1.API;

import java.util.ArrayList;
import java.util.Iterator;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Shape;
import javafxapplication1.Collections.Figures;
import javafxapplication1.entities.Figure;


/**
 *
 * @author Philipp
 */
public class API {
    
    Figures figures;
    
    public API() {
        figures = new Figures();
    }
    
    public Pane addToPane(Pane root) {
        ArrayList<Figure> allFigures = figures.getAllFiguresList();
        Iterator<Figure> iter = allFigures.iterator();
        while(iter.hasNext()) {
            Figure currentFigure = iter.next();
            ArrayList<Shape> allShapes = currentFigure.getShapes();
            Iterator<Shape> innerIter = allShapes.iterator();
            while(innerIter.hasNext()) {
                Shape currentShape = innerIter.next();
                root.getChildren().add(currentShape);
            }
        }
        return root;
    }
    
    public void addFigure(Figure figure) {
        figures.addFigure(figure);
    }
}
