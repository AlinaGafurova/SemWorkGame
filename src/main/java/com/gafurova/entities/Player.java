package com.gafurova.entities;

import com.gafurova.engine.MonoBehaviour;
import com.gafurova.engine.Sprite;
import javafx.scene.image.Image;

public class Player extends MonoBehaviour{

    private Sprite sprite;
    public int health;
    public float regeneraionTime;
    public float regTime;


    public Player(Image image){
        sprite = new Sprite(image);
        health = 5;
        regeneraionTime = 5f;
        regTime = 0;
    }


    @Override
    public void update(double deltaTime) {
        if(health < 5) {
            if (regTime > regeneraionTime) {
                health++;
                regTime = 0;
                System.out.println("Regeneration health: " + health);
            } else {
                regTime += deltaTime;
            }
        }

    }

    public Sprite getSprite(){
        return sprite;
    }

    public void setPosition(double x, double y){
        sprite.setPosition(x, y);
    }

    public double getPositionX(){
        return sprite.getX();
    }

    public double getPositionY(){
        return sprite.getY();
    }
}
