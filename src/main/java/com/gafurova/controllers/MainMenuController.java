package com.gafurova.controllers;

import com.gafurova.screens.GameScreen;
import com.gafurova.utils.GameContext;
import com.gafurova.utils.ScreenUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class MainMenuController implements Initializable{

    private ScreenUtils screenUtils;

    private GameScreen gameScreen;

    @FXML private Button start;

    @Autowired
    public MainMenuController(ScreenUtils screenUtils, GameScreen gameScreen){
        this.screenUtils = screenUtils;
        this.gameScreen = gameScreen;
    }

    public void onCreate(){
        start.setOnAction(event -> {
            try {
                screenUtils.setScreen("game");
                GameContext.getInstance().getGame().start();

                gameScreen.onStart();
                GameContext.getInstance().getGame().setScreen(gameScreen);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        onCreate();
    }
}
