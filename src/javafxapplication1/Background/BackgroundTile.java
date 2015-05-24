/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1.Background;

import javafx.scene.shape.Shape;

/**
 *
 * @author Philipp
 */
public abstract class BackgroundTile implements BackgroundObject {
    
    private double movementModifier = 1.0;
    private String type = "Tile";
    private double[] pos = {0,0};
    private Shape shape;

    @Override
    public void move(double deltaX, double deltaY) {
        pos[0] = pos[0] + deltaX * movementModifier;
        pos[1] = pos[1] + deltaY * movementModifier;
        shape.relocate(pos[0] + deltaY, pos[1] + deltaY);

    }

    @Override
    public void setMovementModifier(double movementModifier) {
        this. movementModifier = movementModifier;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public double getMovementModifier() {
        return movementModifier;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setPosX(double newPosX) {
        pos[0] = newPosX;
    }

    @Override
    public void setPosY(double newPosY) {
        pos[1] = newPosY;
    }

    @Override
    public void setPos(double newPosX, double newPosY) {
        pos[0] = newPosX;
        pos[1] = newPosY;
    }

    @Override
    public double getPosX() {
        return pos[0];
    }

    @Override
    public double getPosY() {
        return pos[1];
    }

    @Override
    public double[] getPos() {
        return pos;
    }

    @Override
    public void setShape(Shape shape) {
        this.shape = shape;
    }

    @Override
    public Shape getShape() {
        return shape;
    }
    
}
