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
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafxapplication1.API.API;
import javafxapplication1.controls.CommandHandler;
import javafxapplication1.entities.Player;

/**
 *
 * @author Philipp
 */
public class JavaFXApplication1 extends Application {
    
        
    
    final double minX = 0;
    final double maxX = 1280;
    final double minY = 0;
    final double maxY = 800;
    final double speed = 100;
    Player player = new Player();
    
    final CommandHandler commandHandler = new CommandHandler();
    
    final DoubleProperty velocity = new SimpleDoubleProperty();
    final DoubleProperty verticalVelocity = new SimpleDoubleProperty();
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
                
                player.fall();
                
                velocity.set(player.getSpeed());
                verticalVelocity.set(player.getVerticalSpeed());
                if (lastUpdateTime.get() > 0) {
                    
                    final double elapsedSeconds = (timestamp - lastUpdateTime.get()) / 1_000_000_000.0 ;
                    final double deltaX = elapsedSeconds * velocity.get();
                    final double deltaY = elapsedSeconds * verticalVelocity.get();
                    final double oldX = player.getShape(0).getTranslateX();
                    final double oldY = player.getShape(0).getTranslateY();
                    final double newX = Math.max(minX, Math.min(maxX - 100.0, oldX + deltaX));
                    final double newY = Math.max(minY, Math.min(maxY - 600.0, oldY + deltaY));
                    player.getShape(0).setTranslateX(newX);
                    player.getShape(0).setTranslateY(newY);
                }
                lastUpdateTime.set(timestamp);
            }
        };
        
        animation.start();
        
        scene = commandHandler.setEventHandlers(scene, player);
        
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
