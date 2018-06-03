package com.gafurova.engine;

import javafx.application.Application;
import javafx.scene.image.Image;

import javax.swing.text.html.ImageView;

public class ResourcesHandler {

    public Image spaceBackground;

    public Image spaceShip;
    public Image enemyShip;

    public Image laser;
    public Image health;

    private static  ResourcesHandler resourcesHandler =  new ResourcesHandler();
    private ResourcesHandler(){}

    public void setApplication(Application application){

        spaceBackground = new Image(application.getClass().getResourceAsStream("/images/space.jpg"));
        spaceShip = new Image(application.getClass().getResourceAsStream("/images/spaceShip.png"));
        enemyShip = new Image(application.getClass().getResourceAsStream("/images/enemy.png"));
        laser = new Image(application.getClass().getResourceAsStream("/images/laser.png"));
        health = new Image(application.getClass().getResourceAsStream("/images/health.png"));
    }

    public static ResourcesHandler getInstance(){
        return resourcesHandler;
    }
}
