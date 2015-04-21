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
import platforms.Floor_1;
import platforms.Platform;
import platforms.Wall_1;

/**
 *
 * @author Philipp
 */
public class Game extends Application {
    
        
    
    final double minX = 0;
    final double maxX = 1280;
    final double minY = 0;
    final double maxY = 800;
    final double speed = 100;
    Player player = new Player(250, 400);
    Platform wall_1 = new Wall_1(0,0,50,500,0);
    Platform floor_1 = new Floor_1(0,maxY-50.0,500,50,0);
    
    final CommandHandler commandHandler = new CommandHandler();
    
    final DoubleProperty velocity = new SimpleDoubleProperty();
    final DoubleProperty verticalVelocity = new SimpleDoubleProperty();
    final LongProperty lastUpdateTime = new SimpleLongProperty();
    final API api = new API();
    
    @Override
    public void start(Stage primaryStage) {

        
        api.addFigure(player);
        //api.addPlatform(wall_1);
        api.addPlatform(floor_1);
            
        Pane root = new Pane();
        root = api.addToPane(root);
        
        player.setAPI(api);
        
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
                
                player.checkbounds();
                
                velocity.set(player.getSpeed());
                verticalVelocity.set(player.getVerticalSpeed());
                if (lastUpdateTime.get() > 0) {
                    
                    final double elapsedSeconds = (timestamp - lastUpdateTime.get()) / 1_000_000_000.0 ;
                    final double deltaX = elapsedSeconds * velocity.get();
                    final double deltaY = elapsedSeconds * verticalVelocity.get();
                    final double oldX = player.getPositionX();
                    final double oldY = player.getPositionY();
                    final double newX = Math.max(minX, Math.min(maxX - player.getWidth(), oldX + deltaX));
                    final double newY = Math.max(minY, Math.min(maxY - player.getHeight(), oldY + deltaY));
                    player.setPosition(newX, newY);
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
    
    public API getAPI() {
        return api;
    }
    
}