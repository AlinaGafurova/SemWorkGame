package com.gafurova.engine;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import org.springframework.stereotype.Component;

@Component
public class Input {

    private Scene scene;

    private double mouseX;
    private double mouseY;

    public Input(){}

    public void setScene(Scene scene){
        this.scene = scene;
        this.scene.setOnMouseMoved(event -> {
            mouseX = event.getSceneX();
            mouseY = event.getSceneY();
        });
    }

    public double getMouseX(){
        return mouseX;
    }

    public double getMouseY(){
        return mouseY;
    }
}
