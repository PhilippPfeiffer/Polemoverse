/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1.entities;

import javafx.scene.shape.*;
import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafxapplication1.Game;

/**
 * 
 * @author Philipp
 */
public class Player extends Infantry {
    
        
    public Player(double positionX, double positionY) {
        
        setPosition(positionX, positionY);
        
        setWidth(150);
        setHeight(200);
        
        addState("standing_default", "standing_default");
        addState("standing_alert", "standing_alert");
        addState("standing_aiming", "standing_aiming");
        addState("standing_firing", "standing_firing");
        addState("crouching_alert", "crouching_alert");
        addState("crouching_aiming", "crouching_aiming");
        addState("crouching_firing", "crouching_firing");
        addState("running", "running");
        addState("sprinting", "sprinting");
        
        Rectangle a = new Rectangle();
        a.setX((getWidth()/2)-(getWidth()/3/2));
        a.setY(0);
        a.setWidth(getWidth()/3);
        a.setHeight(getHeight());
        
        Rectangle b = new Rectangle ();
        b.setX(0);
        b.setY((getHeight()/2)-(getHeight()/2/2));
        b.setWidth(getWidth());
        b.setHeight(getWidth()/2);
        
        Rectangle c = new Rectangle();
        c.setX(0);
        c.setY(0);
        c.setWidth(getWidth());
        c.setHeight(getHeight());
        c.setOpacity(0.5);
        
        addShape(a);
        addShape(b);
        addShape(c);
        
        
        addShapeToGroup(a);
        addShapeToGroup(b);
        addShapeToGroup(c);
        
        
        
    }
}
