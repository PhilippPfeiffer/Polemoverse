/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafxapplication1.API.API;
import javafxapplication1.entities.Player;

/**
 *
 * @author Philipp
 */
public class JavaFXApplication1 extends Application {
    
        
    
    final double minX = 0;
    final double maxX = 1280;
    final double minY = 0;
    final double maxY = 900;
    final double speed = 100;
    Player player = new Player();
    
    final DoubleProperty velocity = new SimpleDoubleProperty();
    final LongProperty lastUpdateTime = new SimpleLongProperty();
    
    
    
    
    @Override
    public void start(Stage primaryStage) {
        
        API api = new API();
        
        api.addFigure(player);
            
        Pane root = new Pane();
        root = api.addToPane(root);
        
        Scene scene = new Scene(root, maxX, maxY);
        
        AnimationTimer animation = new AnimationTimer() {
            @Override
            public void handle(long timestamp) {
                
                if(player.getMoving() == false) {
                    player.decreaseSpeed();
                } else if(player.getMoving() == true) {
                    player.increaseSpeed();
                }
                velocity.set(player.getSpeed());
                if (lastUpdateTime.get() > 0) {
                    
                    final double elapsedSeconds = (timestamp - lastUpdateTime.get()) / 1_000_000_000.0 ;
                    final double deltaX = elapsedSeconds * velocity.get();
                    final double oldX = player.getShape(0).getTranslateX();
                    final double newX = Math.max(minX, Math.min(maxX, oldX + deltaX));
                    player.getShape(0).setTranslateX(newX);
                }
                lastUpdateTime.set(timestamp);
            }
        };
        
        animation.start();
        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode()==KeyCode.D) {
                    player.moveRight();
                } else if (event.getCode() == KeyCode.A) {
                    player.moveLeft();
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.A) {
                player.setMoving(false);
                } else if (event.getCode() == KeyCode.A && event.getCode() == KeyCode.D) {
                player.setMoving(false);
                }
            }
        });
        
//        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
//                
//        }
        
        primaryStage.setTitle("Box Test");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
