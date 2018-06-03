package com.gafurova.engine;

import com.gafurova.utils.ScreenUtils;
import com.gafurova.utils.StageUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public  class Game  {

    public Screen screen;

    private Canvas canvas;
    private Group group;

    private GraphicsContext graphicsContext;

    public List<MonoBehaviour> monoBehaviours;

    public Game(){
        monoBehaviours = new ArrayList<>();
    }

    public void start(){
        group = new Group();

        canvas = new Canvas(ScreenUtils.DEF_WIDTH, ScreenUtils.DEF_HEIGHT);
        graphicsContext = canvas.getGraphicsContext2D();
        Drawer.getInstance().setGraphicsContext(graphicsContext);
        group.getChildren().add(canvas);

        StageUtils.getInstance().getStage().setScene(new Scene(group));
        StageUtils.getInstance().getStage().show();
        StageUtils.getInstance().getStage().setTitle("GAME");
    }


    public void setScreen(Screen screen){
        this.screen = screen;
        screen.setCanvas(canvas);
        new Thread(screen).start();
    }

    public Group getGroup() {
        return group;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }

}
