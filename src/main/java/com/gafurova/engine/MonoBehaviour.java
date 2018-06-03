package com.gafurova.engine;

import com.gafurova.utils.GameContext;

public abstract class MonoBehaviour  {

    public boolean enable;
    public boolean destroy;

    public MonoBehaviour(){
        enable = true;
        destroy = false;
        GameContext.getInstance().getGame().monoBehaviours.add(this);
    }

    public abstract void update(double deltaTime);
    public abstract Sprite getSprite();
    public void destroy(){
        destroy = true;
    }

}
