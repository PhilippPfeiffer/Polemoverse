/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1.API;

import java.util.ArrayList;
import java.util.Iterator;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafxapplication1.Collections.Figures;
import javafxapplication1.Collections.Platforms;
import javafxapplication1.entities.Figure;
import platforms.Platform;


/**
 *
 * @author Philipp
 */
public class API {
    
    Figures figures;
    Platforms platforms;
    
    public API() {
        figures = new Figures();
        platforms = new Platforms();
    }
    
    public Pane addToPane(Pane root) {
        
        /**
         * Add all figures to root
         */
        ArrayList<Figure> allFigures = figures.getAllFiguresList();
        Iterator<Figure> iter_1 = allFigures.iterator();
        while(iter_1.hasNext()) {
            Figure currentFigure = iter_1.next();
            root.getChildren().add(currentFigure.getShapeGroup());
//            ArrayList<Shape> allShapes = currentFigure.getShapes();
//            Iterator<Shape> innerIter = allShapes.iterator();
//            while(innerIter.hasNext()) {
//                Shape currentShape = innerIter.next();
//                root.getChildren().add(currentShape);
//            }
        }
        
        /**
         * Add all platforms to root
         */
        ArrayList<Platform> allPlatforms = platforms.getAllPlatformsList();
        Iterator<Platform> iter_2 = allPlatforms.iterator();
        while(iter_2.hasNext()) {
            Platform currentPlatform = iter_2.next();
            ArrayList<Shape> allShapes = currentPlatform.getShapes();
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
    
    public void addPlatform(Platform platform) {
        platforms.addPlatform(platform);
    }
    
    public Figures getFigures() {
        return figures;
    }
    
    public Platforms getPlatforms() {
        return platforms;
    }
    
    
    
    
}
