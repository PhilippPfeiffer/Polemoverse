/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1.entities;

import weapons.Pistol;

/**
 * 
 * @author Philipp
 */
public class Player extends Infantry {
    
    public Player(double positionX, double positionY) {
                
        setPosition(positionX, positionY);
        
        setWidth(150);
        setHeight(200);
        
        initializeStates();
        
        initializeBoxes();
    }
}
