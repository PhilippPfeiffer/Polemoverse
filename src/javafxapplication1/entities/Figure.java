/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1.entities;

import javafx.scene.shape.*;
import java.util.ArrayList;
import javafx.scene.Group;
import javafxapplication1.API.API;
import platforms.Platform;

/**
 *
 * @author Philipp
 */
public interface Figure {
        
    public void move(double x, double y, double speed, double velocity);
    public void move(double x, double y);
    public void translate(double x, double y, boolean interpolate);
    
    public String getState();
    public double[] getPosition();
    public double getPositionX();
    public double getPositionY();
    public double getVelocity();
    public double getSpeed();
    public ArrayList<Shape> getShapes();
    public Shape getShape(int index);
    public String getType();
    public double[] getMovementVector();
    public double getMaxSpeed();
    public double getMinSpeed();
    public boolean getMoving();
    public String getDirection();
    public boolean getFalling();
    public double getVerticalVelocity();
    public double getVerticalSpeed();
    public boolean getJumping();
    public boolean getSprinting();
    public Group getShapeGroup();
    public double getHeight();
    public double getWidth();
    
    public void setState(String state);
    public void setPosition(double[] position);
    public void setPosition(double positionX, double positionY);
    public void setPositionX(double positionX);
    public void setPositionY(double positionY);
    public void setVelocity(double velocity);
    public void setSpeed(double speed);
    public void setShapes(ArrayList<Shape> shapes);
    public void addShape(Shape shape);
    public void removeShape(Shape shape);
    public void removeShape(int index);
    public void addState(String key, String state);
    public void setMovementVector(double vecX, double vecY);
    public void setMaxSpeed(double maxSpeed);
    public void setMinSpeed(double minSpeed);
    public void setMoving(boolean moving);
    public void setDirection(String direction);
    public void setFalling(boolean falling);
    public void setVerticalVelocity(double verticalVelocity);
    public void setVerticalSpeed(double verticalSpeed);
    public void setJumping(boolean jumping);
    public void setSprinting(boolean sprinting);
    public void addShapeToGroup(Shape shape);
    public void setHeight(double height);
    public void setWidth(double width);
    
    public void increaseSpeed();
    public void decreaseSpeed();
    
    public void moveRight();
    public void moveLeft();
    
    public void fall();
    
    public void stop();
    
    public void jump();
    
    public void handleCollision(Platform platform);
    
    public void setAPI(API api);
    
    
    
    
}
