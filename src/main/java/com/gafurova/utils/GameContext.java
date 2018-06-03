package com.gafurova.utils;

import com.gafurova.engine.Game;

public class GameContext {

    private Game game;

    private static GameContext gameContext = new GameContext();

    private GameContext(){}

    public static GameContext getInstance(){
        return gameContext;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game){
        this.game = game;
    }
}
