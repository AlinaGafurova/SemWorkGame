package com.gafurova.entities;

import com.gafurova.engine.MonoBehaviour;
import com.gafurova.engine.ResourcesHandler;
import com.gafurova.engine.Sprite;

public class Health extends MonoBehaviour {

    private Sprite sprite;
    private float speed;

    public Health(){
        sprite = new Sprite(ResourcesHandler.getInstance().health);
        speed = 100f;
    }

    @Override
    public void update(double deltaTime) {
        sprite.setY(sprite.getY() + speed * deltaTime);
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }
}
