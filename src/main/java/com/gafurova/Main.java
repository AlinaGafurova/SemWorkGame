package com.gafurova;

import com.gafurova.config.SpringConfig;
import com.gafurova.engine.ResourcesHandler;
import com.gafurova.utils.ScreenUtils;
import com.gafurova.utils.StageUtils;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Game");
        StageUtils.getInstance().setStage(primaryStage);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        context.getBean(ScreenUtils.class).setScreen("main");
        ResourcesHandler.getInstance().setApplication(this);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
