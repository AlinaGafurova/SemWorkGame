package com.gafurova.controllers;

import com.gafurova.engine.Game;
import com.gafurova.utils.GameContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.ImageView;

@Component
public class GameController {

    @Autowired
    public GameController(Game game) {
        GameContext.getInstance().setGame(game);
    }
}
