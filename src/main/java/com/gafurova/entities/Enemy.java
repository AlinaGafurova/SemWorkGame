package com.gafurova.entities;

import com.gafurova.engine.MonoBehaviour;
import com.gafurova.engine.Sprite;
import javafx.scene.image.Image;

import java.util.Random;


public class Enemy extends MonoBehaviour {

    private Sprite sprite;

    private float speed;
    public int health;
    public boolean attack;

    private float laserGenerateTime;
    private float laserGeneratedLeftTime;

    public Enemy(Image image, int health){
        sprite = new Sprite(image);
        this.health = health;

        speed = new Random().nextInt(50) + 50;
        laserGenerateTime = 2f;
        laserGeneratedLeftTime = 0;
    }


    @Override
    public void update(double deltaTime) {
        sprite.setY(sprite.getY() + speed * deltaTime);

        if(!attack) {
            if (laserGeneratedLeftTime > laserGenerateTime) {
                laserGeneratedLeftTime = 0;
                attack = true;
            } else {
                laserGeneratedLeftTime += deltaTime;
            }
        }
    }

    @Override
    public Sprite getSprite() {
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
