package com.gafurova.engine;

import javafx.scene.canvas.Canvas;

import javax.swing.*;

public abstract class Screen implements Runnable {

    private Canvas canvas;

    public boolean inGame;

    private long time;

    private long framingTime;
    private double frameTime;
    public double deltaTime;
    public float fps;

    public Screen(){
        inGame = true;
        time = System.nanoTime();
        fps = 60f;
        framingTime = System.nanoTime();
        frameTime = 0;
        deltaTime = 0;
        onCreated();
    }

    public abstract void onStart();

    public abstract void onCreated();

    @Override
    public void run() {
        while(true){
            frameTime += (System.nanoTime() - framingTime) / 1000000000d;
            framingTime = System.nanoTime();
            if(frameTime > 1f / fps) {
                frameTime = 0;
                onRender();
            }
        }
    }

    public void onRender(){
        deltaTime = (System.nanoTime() - time) / 1000000000d;
        time = System.nanoTime();
        Drawer.getInstance().clear();

    }

    public void onClear(){

    }

    public void onPause(){
        inGame = false;
    }

    public void onResume(){
        inGame = true;
    }

    public void onStop(){

    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }
}
