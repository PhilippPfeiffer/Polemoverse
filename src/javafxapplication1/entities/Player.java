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
        Rectangle a = new Rectangle();
        a.setX(50);
        a.setY(50);
        a.setWidth(200);
        a.setHeight(100);
        a.setArcWidth(20);
        a.setArcHeight(20);
        
        addShape(a);
        
        Rectangle b = new Rectangle();
        b.setX(250);
        b.setY(400);
        b.setWidth(100);
        b.setHeight(100);
        b.setArcWidth(20);
        b.setArcHeight(20);
        
        addShape(b);
    }
}
