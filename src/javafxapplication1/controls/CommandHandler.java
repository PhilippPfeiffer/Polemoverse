
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
