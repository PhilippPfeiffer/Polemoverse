/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectiles;

import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafxapplication1.physics.ProjectilePhysics;

/**
 *
 * @author Philipp
 */
public abstract class Bullet implements Projectile {
    
    private double caliber = 0.0;
    private double velocity = 0.0;
    private double range = 0.0;
    private double[] vector = {0.0,0.0};
    private double posX = 0.0;
    private double posY = 0.0;
    private double[] pos = {0.0,0.0};
    private String type = "Bullet";
    private ArrayList<Shape> shapes = new ArrayList<>();
    ProjectilePhysics projectilePhysics = new ProjectilePhysics();

    @Override
    public void setCaliber(double caliber) {
        this.caliber = caliber;
    }

    @Override
    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    @Override
    public void setRange(double range) {
        this.range = range;
    }

    @Override
    public void setVector(double[] vector) {
        this.vector = vector;
    }

    @Override
    public double getCaliber() {
        return caliber;
    }

    @Override
    public double getVelocity() {
        return velocity;
    }

    @Override
    public double getRange() {
        return range;
    }

    @Override
    public double[] getVector() {
        return vector;
    }

    @Override
    public void setPosX(double posX) {
        this.posX = posX;
    }

    @Override
    public void setPosY(double posY) {
        this.posY = posY;
    }

    @Override
    public void setPos(double[] pos) {
        this.pos = pos;
        setPosX(pos[0]);
        setPosY(pos[1]);
        updateShapePositions();
    }

    @Override
    public double getPosX() {
        return posX;
    }

    @Override
    public double getPosY() {
        return posY;
    }

    @Override
    public double[] getPos() {
        double[] newPos = {getPosX(),getPosY()};
        return newPos;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }
    
    @Override
    public void move(double deltaX, double deltaY) {
        
        double newX = posX + deltaX;
        double newY = posY + deltaY;
        double[] newPos1 = {newX, newY};
        setPos(newPos1);
        
        double[] newPos2 = projectilePhysics.move(this);
        setPos(newPos2);
    }

    @Override
    public void setShapes(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }

    @Override
    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    @Override
    public void addShape(Shape shape) {
        shapes.add(shape);
    }
    
    @Override
    public void updateShapePositions() {
        for(Shape shape : shapes) {
            shape.setTranslateX(getPosX());
            shape.setTranslateY(getPosY());
        }
    }
    
    @Override
    public void initializeBoxes() {
        Rectangle a = new Rectangle();
        a.setX(0);
        a.setY(0);
        a.setWidth(10);
        a.setHeight(10);
        a.setOpacity(0.5);
        a.setFill(Color.RED);
        
        addShape(a);
    }
}