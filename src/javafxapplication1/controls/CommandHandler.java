
package javafxapplication1.controls;

import javafx.scene.input.KeyEvent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafxapplication1.API.API;
import javafxapplication1.entities.Figure;

/**
 *
 * @author Philipp
 */
public class CommandHandler {
    
    public CommandHandler() {  
    }
    
    public Scene setEventHandlers(Scene scene, Figure player, API api) {
        scene.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode()==KeyCode.D) {
                player.moveRight();
            } else if (event.getCode() == KeyCode.A) {
                player.moveLeft();
            } else if (event.getCode() == KeyCode.SPACE) {
                player.jump();
            } else if (event.getCode() == KeyCode.SHIFT) {
                player.setSprinting(true);
            } else if (event.getCode() == KeyCode.DIGIT1) {
                player.changeWeaponSlot(0);
                player.setShooting(false);
            } else if (event.getCode() == KeyCode.DIGIT2) {
                player.changeWeaponSlot(1);
                player.setShooting(false);
            } else if (event.getCode() == KeyCode.DIGIT3) {
                player.changeWeaponSlot(2);
                player.setShooting(false);
            } else if (event.getCode() == KeyCode.DIGIT4) {
                player.changeWeaponSlot(3);
                player.setShooting(false);
            } else if (event.getCode() == KeyCode.R) {
                player.reload();
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
            } else if (event.getCode() == KeyCode.DIGIT1) {
                player.changeWeaponSlot(0);
                player.setShooting(false);
            } else if (event.getCode() == KeyCode.DIGIT2) {
                player.changeWeaponSlot(1);
                player.setShooting(false);
            } else if (event.getCode() == KeyCode.DIGIT3) {
                player.changeWeaponSlot(2);
                player.setShooting(false);
            } else if (event.getCode() == KeyCode.DIGIT4) {
                player.changeWeaponSlot(3);
                player.setShooting(false);
            }
        });
        
        scene.setOnMouseMoved((MouseEvent event) -> {
            double[] cursorPos = {event.getX(),event.getY()};
            api.getCursor().setPos(cursorPos);
        });
        
        scene.setOnMouseDragged((MouseEvent event) -> {
            double[] cursorPos = {event.getX(),event.getY()};
            api.getCursor().setPos(cursorPos);
        });
        
        scene.setOnMousePressed((MouseEvent event) -> {
            player.setShooting(true);
        });
        
        scene.setOnMouseReleased((MouseEvent event) -> {
            player.setShooting(false);
        });
        
        return scene;
    }
    
}
