
package javafxapplication1.entities;

import javafx.scene.shape.*;
import java.util.ArrayList;
import javafxapplication1.API.API;
import javafxapplication1.platforms.Platform;
import weapons.Weapon;

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
    public double getHeight();
    public double getWidth();
    public Weapon getWeapon(int index);
    public ArrayList<Weapon> getWeapons();
    
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
    public void setHeight(double height);
    public void setWidth(double width);
    public void addWeapon(Weapon weapon);
    public void setWeapons(ArrayList<Weapon> weapons);
    
    
    public void increaseSpeed();
    public void decreaseSpeed();
    
    public void moveRight();
    public void moveLeft();
    
    public void fall();
    public void stop();
    public void jump();
    
    public void shoot();
    
    public void handleCollision(Platform platform);
    
    public API getAPI();
    public void setAPI(API api);
    
    public void updateShapePositions();
    
    public void initializeBoxes();
    public void initializeStates();

    public boolean isPlayer();
    
    public void setAsPlayer(boolean isPlayer);
    
    public void tickDownCooldownTime();
    
    public void setCooldownTime(double cooldownTime);
    
    public double getCooldownTime();
    
    public void setCurrentWeapon(Weapon weapon);
    
    public Weapon getCurrentWeapon();
    
    public boolean isCoolingDown();
    public void setCoolingDown(boolean isCoolingDown);
    public boolean isShooting();
    public void setShooting(boolean isShooting);
    
    public void changeWeaponSlot(int slot);
}
