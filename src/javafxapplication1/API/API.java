
package javafxapplication1.API;

import UI.Cursor;
import javafxapplication1.Background.BackgroundObject;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafxapplication1.Collections.BackgroundObjects;
import javafxapplication1.Collections.Figures;
import javafxapplication1.Collections.Platforms;
import javafxapplication1.Collections.Polygons;
import javafxapplication1.Collections.Projectiles;
import javafxapplication1.entities.Figure;
import javafxapplication1.physics.Polygon;
import javafxapplication1.platforms.Platform;
import projectiles.Projectile;
import weapons.Weapon;


/**
 *
 * @author Philipp
 */
public class API {
    
    Figures figures;
    Platforms platforms;
    ArrayList<BackgroundObjects> backgroundLayers;
    Projectiles projectiles;
    Polygons polygons;
    Pane root;
    ArrayList<Circle> dots = new ArrayList<>();
    ArrayList<Weapon> weapons = new ArrayList<>();
    Cursor cursor;
    
    public API(Pane root) {
        figures = new Figures();
        platforms = new Platforms();
        backgroundLayers = new ArrayList<>();
        projectiles = new Projectiles();
        polygons = new Polygons();
        this.root = root;
        this.cursor = new Cursor();
    }
    
    public Pane addToPane() {
        
        /**
         * Add all background shapes to roots
         */
        for (BackgroundObjects backgroundObjects : backgroundLayers) {
            Iterator<BackgroundObject> iter_3 = backgroundObjects.getAllBackgroundObjectsList().iterator();
            while(iter_3.hasNext()) {
                BackgroundObject currentBackgroundObject = iter_3.next();
                root.getChildren().add(currentBackgroundObject.getShape());
            }
        }
        
        /**
         * Add all figures to root
         */
        ArrayList<Figure> allFigures = figures.getAllFiguresList();
        Iterator<Figure> iter_1 = allFigures.iterator();
        while(iter_1.hasNext()) {
            Figure currentFigure = iter_1.next();
            //root.getChildren().add(currentFigure.getShapeGroup());
            root.getChildren().addAll(currentFigure.getShapes());
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
        
        /**
         * Add all projectiles to root
         */
        ArrayList<Projectile> allProjectiles = projectiles.getAllProjectilesList();
        Iterator<Projectile> iter_3 = allProjectiles.iterator();
        while(iter_3.hasNext()) {
            Projectile currentProjectile = iter_3.next();
            ArrayList<Shape> allShapes = currentProjectile.getShapes();
            Iterator<Shape> innerIter = allShapes.iterator();
            while(innerIter.hasNext()) {
                Shape currentShape = innerIter.next();
                root.getChildren().add(currentShape);
            }
        }
        
        /**
         * Add all polygons to root
         */
        ArrayList<Polygon> allPolygons = polygons.getAllPolygonsList();
        Iterator<Polygon> iter_4 = allPolygons.iterator();
        while(iter_4.hasNext()) {
            Polygon currentPolygon = iter_4.next();
            ArrayList<Shape> allShapes = currentPolygon.getShapes();
            Iterator<Shape> innerIter = allShapes.iterator();
            while(innerIter.hasNext()) {
                Shape currentShape = innerIter.next();
                root.getChildren().add(currentShape);
            }
        }
        
        return root;
    }
    
    public void addPolygon(Polygon polygon) {
        polygons.addPolygon(polygon);
    }
    
    public void addPolygonLive(Polygon polygon) {
        polygons.addPolygon(polygon);
        addShapesToPane(polygon);
    }
    
    public void addFigure(Figure figure) {
        figures.addFigure(figure);
    }
    
    public void addPlatform(Platform platform) {
        platforms.addPlatform(platform);
    }
    
    public void addProjectile(Projectile projectile) {
        projectiles.addProjectile(projectile);
        addShapesToPane(projectile);
    }
    
    public void addShapesToPane(Polygon polygon) {
        ArrayList<Shape> allShapes = polygon.getShapes();
        Iterator<Shape> shapeIter = allShapes.iterator();
        while(shapeIter.hasNext()) {
            Shape currentShape = shapeIter.next();
            root.getChildren().add(currentShape);
        }
    }
    
    public void addShapesToPane(Projectile projectile) {
        ArrayList<Shape> allShapes = projectile.getShapes();
        Iterator<Shape> shapeIter = allShapes.iterator();
        while(shapeIter.hasNext()) {
            Shape currentShape = shapeIter.next();
            root.getChildren().add(currentShape);
        }
    }
    
    public Projectiles getProjectiles() {
        return projectiles;
    }
    
    public Figures getFigures() {
        return figures;
    }
    
    public Platforms getPlatforms() {
        return platforms;
    }
    
    public Polygons getPolygons() {
        return polygons;
    }
    
    public void moveAllPlatforms(double deltaX, double deltaY) {
        platforms.moveAllPlatforms(deltaX, deltaY);
    }
    
    public void moveAllProjectiles(double deltaX, double deltaY) {
        projectiles.moveAllProjectiles(deltaX, deltaY);
    }
    
    public void moveAllFigures(double deltaX, double deltaY) {
        figures.moveAllFigures(deltaX, deltaY);
    }
    
    public void moveAllPolygons(double deltaX, double deltaY) {
        polygons.moveAllPolygons(deltaX, deltaY);
    }
    
    public void createBackgroundlayers(int number) {
        for(int i = 0; i < number; i++) {
            backgroundLayers.add(new BackgroundObjects(1.0-(1.0/(2.0+i))));
        }
    }
    
    public void addBackgroundObjectToLayer(int layer, BackgroundObject backgroundObject) {
        backgroundLayers.get(layer).addBackgroundObject(backgroundObject);
    }
    
    public void moveBackground(double deltaX, double deltaY) {
        backgroundLayers.stream().forEach((backgroundObjects) -> {
            backgroundObjects.moveAllBackgroundObjects(deltaX, deltaY);
        });
    }
    
    public void moveEverything(double deltaX, double deltaY) {
        moveAllPlatforms(deltaX, deltaY);
        moveAllFigures(deltaX, deltaY);
        moveAllProjectiles(deltaX, deltaY);
        moveAllPolygons(deltaX, deltaY);
        moveBackground(deltaX, deltaY);
        moveDots(deltaX, deltaY);
    }
    
    public void drawDot(double[] pos, double radius) {
        Circle a = new Circle(pos[0],pos[1],radius);
        a.setFill(Color.DARKSALMON);
        dots.add(a);
        root.getChildren().add(a);
    }
    
    public void moveDots(double deltaX, double deltaY) {
        for(Circle dot : dots) {
            dot.setCenterX(dot.getCenterX() + deltaX);
            dot.setCenterY(dot.getCenterY() + deltaY);
        }
    }
    
    public Cursor getCursor() {
        return cursor;
    }
    
    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }
    
}
