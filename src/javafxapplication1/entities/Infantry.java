
package javafxapplication1.entities;

import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafxapplication1.API.API;
import javafxapplication1.API.PrintWriter;
import javafxapplication1.platforms.Platform;
import weapons.Weapon;

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
    private double maxSpeedBase = 500.0;
    
    private double maxVerticalSpeed = 1000.0;
    private double minVerticalSpeed = -1000.0;
    private double verticalSpeed = 0.0;
    private double verticalVelocity = 0.0;
    private double verticalVelocityIncrease = 30.0;
    
    private double height;
    private double width;
    
    private double cooldownTime = 0;
    
    private boolean moving = false;
    private String direction = "right";
    
    private boolean falling = true;
    private boolean jumping = false;
    private boolean sprinting = false;
    
    private double positionX;
    private double positionY;
    
    private API api;
    
    private boolean isPlayer = false;
    private boolean isCoolingDown = false;
    private boolean isShooting = false;
    private boolean isReloading = false;
   
    private ArrayList<Weapon> weapons = new ArrayList<>();
    private Weapon currentWeapon = null;
    
    private PrintWriter printWriter = new PrintWriter();
    
    @Override
    public void tickDownCooldownTime() {
        if(cooldownTime>0) {
            setCoolingDown(true);
            cooldownTime--;
            if(isReloading && cooldownTime <= 0) {
                reload();
            }
        } else setCoolingDown(false);
    }
    
    @Override
    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);
        if(currentWeapon == null) {
            setCurrentWeapon(weapon);
        }
    }
    
    @Override
    public Weapon getWeapon(int index) {
        return weapons.get(index);
    }
    
    @Override
    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }
    
    @Override
    public void setWeapons(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }
    
    @Override
    public void move(double x, double y, double speed, double velocity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void move(double x, double y) {
        double newX = positionX + x;
        double newY = positionY + y;
        setPosition(newX, newY);
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
        double[] position = {positionX, positionY};
        return position;
    }

    @Override
    public double getPositionX() {
        return positionX;
    }

    @Override
    public double getPositionY() {
        return positionY;
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
        positionX = position[0];
        positionY = position[1];
    }

    @Override
    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    @Override
    public void setPositionY(double positionY) {
        this.positionY = positionY;
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

    @Override
    public boolean getFalling() {
        return falling;
    }

    @Override
    public void setFalling(boolean falling) {
        this.falling = falling;
    }

    @Override
    public void fall() {
        if(falling) {
            if(verticalSpeed < maxVerticalSpeed) {
                double tmpVerticalSpeed = verticalSpeed + verticalVelocityIncrease;
                if(tmpVerticalSpeed >= maxVerticalSpeed) {
                verticalSpeed = maxVerticalSpeed;
                } else {
                    verticalSpeed = tmpVerticalSpeed;
                }
            }  
        }
        
    }

    @Override
    public double getVerticalVelocity() {
        return verticalVelocity;
    }

    @Override
    public void setVerticalVelocity(double verticalVelocity) {
        this.verticalVelocity = verticalVelocity;
    }

    @Override
    public double getVerticalSpeed() {
        return verticalSpeed;
    }

    @Override
    public void setVerticalSpeed(double verticalSpeed) {
        this.verticalSpeed = verticalSpeed;
    }

    @Override
    public void stop() {
        speed = 0.0;
        verticalSpeed = 0.0;
        velocity = 0.0;
        verticalVelocity = 0.0;
    }

    @Override
    public void jump() {
        if(!jumping) {
            verticalSpeed = -800.0;
            jumping = true;
        }
    }

    @Override
    public boolean getJumping() {
        return jumping;
    }

    @Override
    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    @Override
    public boolean getSprinting() {
        return sprinting;
    }

    @Override
    public void setSprinting(boolean sprinting) {
        this.sprinting = sprinting;
        if(sprinting) {
            maxSpeed = maxSpeedBase*2;
            minSpeed = -maxSpeedBase*2;
        } else {
            maxSpeed = maxSpeedBase;
            minSpeed = -maxSpeedBase;
        }
            
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public void handleCollision(Platform platform) {
        String platformType = platform.getType();
        switch (platformType) {
            case "Floor": 
                verticalSpeed = 0;
                move(0,-0.1);
                checkbounds();
                break;
        }
    }

    @Override
    public void setPosition(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        updateShapePositions();
    }
    
    public void checkbounds() {
        
        boolean collisionDetected = false;
        Shape verticalBox = shapes.get(0);
        Shape horizontalBox = shapes.get(1);
        Shape boundingBox = shapes.get(2);
        Shape fallBox = shapes.get(3);
        
        for (Platform platform : api.getPlatforms().getAllPlatformsList()) {
            for (Shape static_bloc : platform.getShapes()) {
                if (static_bloc != verticalBox) {
                    if (static_bloc.getBoundsInParent().intersects(verticalBox.getBoundsInParent())) {
                        collisionDetected = true;
                        String platformType = api.getPlatforms().getAllPlatformsList().get(0).getType();
                        switch (platformType) {
                            case "Floor": 
                                verticalSpeed = 0;
                                move(0,-0.5);
                                checkbounds();
                                setFalling(false);
                                break;
                        }
                    }
                }
                if(!static_bloc.getBoundsInParent().intersects(fallBox.getBoundsInParent())){
                        setFalling(true);
                }
            }   
        }
        
        if (collisionDetected) {
            verticalBox.setFill(Color.BLUE);
            setFalling(false);
        } else {
            verticalBox.setFill(Color.GREEN);
        }
        
    }
    
    @Override
    public API getAPI() {
        return api;
    }

    @Override
    public void setAPI(API api) {
        this.api = api;
    }

    @Override
    public void updateShapePositions() {
        for(Shape shape : shapes) {
            shape.setTranslateX(positionX);
            shape.setTranslateY(positionY);
        }
    }

    @Override
    public void initializeBoxes() {
        //vertical rectangle
        Rectangle a = new Rectangle();
        a.setX((getWidth()/2)-(getWidth()/3/2));
        a.setY(0);
        a.setWidth(getWidth()/3);
        a.setHeight(getHeight());
        
        //horizontal rectangle
        Rectangle b = new Rectangle ();
        b.setX(0);
        b.setY(getHeight()/3);
        b.setWidth(getWidth());
        b.setHeight(getHeight()/3);
        
        //bounding box
        Rectangle c = new Rectangle();
        c.setX(0);
        c.setY(0);
        c.setWidth(getWidth());
        c.setHeight(getHeight());
        c.setOpacity(0.5);
        
        //bottom feeler
        Rectangle d = new Rectangle();
        d.setX(getWidth()/3);
        d.setY(getHeight());
        d.setWidth(getWidth()/3);
        d.setHeight(5);
        d.setOpacity(0.5);
        d.setFill(Color.RED);
        
        //top feeler
        Rectangle e = new Rectangle();
        e.setX(getWidth()/3);
        e.setY(-5);
        e.setWidth(getWidth()/3);
        e.setHeight(5);
        e.setOpacity(0.5);
        e.setFill(Color.RED);
        
        //right feeler
        Rectangle f = new Rectangle();
        f.setX(getWidth());
        f.setY(getHeight()/3);
        f.setWidth(5);
        f.setHeight(getHeight()/3);
        f.setOpacity(0.5);
        f.setFill(Color.RED);
        
        //left feeler
        Rectangle g = new Rectangle();
        g.setX(-5);
        g.setY(getHeight()/3);
        g.setWidth(5);
        g.setHeight(getHeight()/3);
        g.setOpacity(0.5);
        g.setFill(Color.RED);
        
        addShape(a);
        addShape(b);
        addShape(c);
        addShape(d);
        addShape(e);
        addShape(f);
        addShape(g);
    }
    
    @Override
    public void initializeStates() {
        addState("standing_default", "standing_default");
        addState("standing_alert", "standing_alert");
        addState("standing_aiming", "standing_aiming");
        addState("standing_firing", "standing_firing");
        addState("crouching_alert", "crouching_alert");
        addState("crouching_aiming", "crouching_aiming");
        addState("crouching_firing", "crouching_firing");
        addState("running", "running");
        addState("sprinting", "sprinting");
    }

    @Override
    public void shoot() {
        if(isShooting) {
            if(!isCoolingDown && currentWeapon.getShotsInMagazine() > 0) {
                double[] startPos = getPosition();
                double[] targetPos = {api.getCursor().getxPos(), api.getCursor().getyPos()};
                currentWeapon.fire(startPos, targetPos);
                currentWeapon.decreaseShots(1);
                if(!isReloading) {
                    setCooldownTime(currentWeapon.getFireRate());
                }
                System.out.println(printWriter.toString(api.getCursor().getPos()));
                if(currentWeapon.getShotsInMagazine() <= 0) {
                    reload();
                }
            } 
        }
    }

    @Override
    public boolean isPlayer() {
        return isPlayer;
    }

    @Override
    public void setAsPlayer(boolean isPlayer) {
        this.isPlayer = isPlayer;
    }

    @Override
    public void setCooldownTime(double cooldownTime) {
        this.cooldownTime = cooldownTime;
    }

    @Override
    public double getCooldownTime() {
        return cooldownTime;
    }

    @Override
    public void setCurrentWeapon(Weapon weapon) {
        this.currentWeapon = weapon;
    }

    @Override
    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    @Override
    public boolean isCoolingDown() {
        return isCoolingDown;
    }

    @Override
    public void setCoolingDown(boolean isCoolingDown) {
        this.isCoolingDown = isCoolingDown;
    }

    @Override
    public boolean isShooting() {
        return isShooting;
    }

    @Override
    public void setShooting(boolean isShooting) {
        this.isShooting = isShooting;
    }

    @Override
    public void changeWeaponSlot(int slot) {
        if(slot>=0 && slot<weapons.size() && !isShooting) {
            setCurrentWeapon(weapons.get(slot));
            setCooldownTime(0.0);
        }
    }

    @Override
    public void reload() {
        if(!isReloading()) {
            setCooldownTime(currentWeapon.getReloadTime());
            setReloading(true);
        } else if(isReloading && getCooldownTime() <= 0) {
            currentWeapon.reload();
            setReloading(false);
        }
    }

    @Override
    public boolean isReloading() {
        return isReloading;
    }

    @Override
    public void setReloading(boolean isReloading) {
        this.isReloading = isReloading;
    }
}
