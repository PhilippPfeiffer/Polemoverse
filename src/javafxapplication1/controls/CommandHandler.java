/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1.controls;

import javafx.scene.input.KeyEvent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafxapplication1.entities.Figure;

/**
 *
 * @author Philipp
 */
public class CommandHandler {
    
    public CommandHandler() {  
    }
    
    public Scene setEventHandlers(Scene scene, Figure player) {
        scene.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode()==KeyCode.D) {
                player.moveRight();
            } else if (event.getCode() == KeyCode.A) {
                player.moveLeft();
            } else if (event.getCode() == KeyCode.SPACE) {
                player.jump();
            } else if (event.getCode() == KeyCode.SHIFT) {
                player.setSprinting(true);
            }
        });

        scene.setOnKeyReleased((KeyEvent event) -> {
            if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.A) {
                player.setMoving(false);
            } else if (event.getCode() == KeyCode.A && event.getCode() == KeyCode.D) {
                player.setMoving(false);
            } else if (event.getCode() == KeyCode.SPACE) {
                player.setJumping(false);
            } else if (event.getCode() == KeyCode.SHIFT) {
                player.setSprinting(false);
            }
        });
        
        return scene;
    }
    
}
