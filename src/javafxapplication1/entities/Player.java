/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1.entities;

import javafx.scene.shape.*;
import java.util.ArrayList;

/**
 * 
 * @author Philipp
 */
public class Player extends Infantry {
    
        
    public Player() {
        
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
        a.setX(0);
        a.setY(400);
        a.setWidth(100);
        a.setHeight(200);
        a.setArcWidth(20);
        a.setArcHeight(20);
        
        addShape(a);
        
    }
}
