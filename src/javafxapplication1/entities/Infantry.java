/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1.entities;

import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.shape.Shape;



/**
 *
 * @author Philipp
 */
public abstract class Infantry implements Figure{
    

    private final String type = "Infantry";
    private final HashMap<String, String> stateMap = new HashMap<>();
    private String currentState = "";
    ArrayList<Shape> shapes = new ArrayList<>();
    private double speed = 0.0;
    private double velocity = 0.0;
    private double velocityIncrease = 1.5;
    private double velocityDecrease = 1.5;
    private double[] movementVector = new double[] {0.0, 0.0};
    private double maxSpeed = 500.0;
    private double minSpeed = -500.0;
    private boolean moving = false;
    private String direction = "right";
   
    
    @Override
    public void move(double x, double y, double speed, double velocity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void move(double x, double y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void translate(double x, double y, boolean interpolate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getState() {
        return currentState;
    }

    @Override
    public double[] getPosition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getPositionX() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getPositionY() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getVelocity() {
        return velocity;
    }

    @Override
    public double getSpeed() {
        return speed;
    }

    @Override
    public void setState(String state) {
        if(stateMap.containsKey(state)) {
            currentState = stateMap.get(state);
        } else currentState = "default";
    }

    @Override
    public void setPosition(double[] position) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPositionX(double positionX) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPositionY(double positionY) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    @Override
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    @Override
    public Shape getShape(int index) {
        return shapes.get(index);
    }

    @Override
    public void setShapes(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }

    @Override
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    @Override
    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    @Override
    public void removeShape(int index) {
        shapes.remove(index);
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void addState(String key, String state) {
        stateMap.put(key, state);
    }

    @Override
    public double[] getMovementVector() {
        return movementVector;
    }

    @Override
    public void setMovementVector(double vecX, double vecY) {
        movementVector[0] = vecX;
        movementVector[1] = vecY;
    }

    @Override
    public double getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public double getMinSpeed() {
        return minSpeed;
    }

    @Override
    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void setMinSpeed(double minSpeed) {
        this.minSpeed = minSpeed;
    }

    @Override
    public void increaseSpeed() {
        switch (direction) {
            case "right":
                if(speed < maxSpeed) {
                    System.out.println("Increase " + speed + " " + velocity + " " + velocityIncrease);
                    velocity += velocityIncrease;
                    double tmpSpeed = speed + velocity;
                    if(tmpSpeed > maxSpeed) {
                        velocity = 0.0;
                        speed = maxSpeed;
                    } else if(tmpSpeed < minSpeed) {
                        velocity = 0.0;
                        speed = minSpeed;
                    } else {
                        speed = tmpSpeed;
                    }
                } else {
                    velocity = 0.0;
                } break;
            case "left":
                if(speed > minSpeed) {
                    System.out.println("Increase " + speed + " " + velocity + " " + velocityIncrease);
                    velocity -= velocityIncrease;
                    double tmpSpeed = speed + velocity;
                    if(tmpSpeed < minSpeed) {
                        velocity = 0.0;
                        speed = minSpeed;
                    } else if(tmpSpeed > maxSpeed) {
                        velocity = 0.0;
                        speed = maxSpeed;
                    } else {
                        speed = tmpSpeed;
                    }
                } else {
                    velocity = 0.0;
                } break;
        }
    }

    @Override
    public void decreaseSpeed() {
        String direction = "";
        if(speed > 0) {
            direction = "right";
        } else {
            direction = "left";
        }
        
        switch (direction) {
            case "right":
                if(speed != 0.0) {
                    System.out.println("Decrease " + speed + " " + velocity + " " + velocityDecrease);
                    velocity -= velocityDecrease;
                    double tmpSpeed = speed + velocity;
                    if(tmpSpeed < 0.0) {
                        velocity = 0.0;
                        speed = 0.0;
                    } else if(tmpSpeed >= maxSpeed) {
                        velocity = 0.0;
                        speed = maxSpeed;
                    } else {
                        speed = tmpSpeed;
                    }   
                } break;
            case "left":
                if(speed != 0.0) {
                    System.out.println("Decrease " + speed + " " + velocity + " " + velocityDecrease);
                    velocity += velocityDecrease;
                    double tmpSpeed = speed + velocity;
                    if(tmpSpeed > 0.0) {
                        velocity = 0.0;
                        speed = 0.0;
                    } else if(tmpSpeed <= minSpeed) {
                        velocity = 0.0;
                        speed = minSpeed;
                    } else {
                        speed = tmpSpeed;
                    } 
                } break;
                
        }
    }

    @Override
    public boolean getMoving() {
        return moving;
    }

    @Override
    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    @Override
    public void moveRight() {
        if(getMoving() == false) {
            setMoving(true);
        }
        setDirection("right");
    }

    @Override
    public void moveLeft() {
        if(getMoving() == false) {
            setMoving(true);
        }
        setDirection("left");
    }

    @Override
    public String getDirection() {
        return direction;
    }

    @Override
    public void setDirection(String direction) {
        this.direction = direction;
    }
    
}
