package com.gafurova.utils;

import javafx.stage.Stage;

public class StageUtils {

    private static  StageUtils stageUtils = new StageUtils();
    private Stage stage;

    private StageUtils(){}

    public static StageUtils getInstance(){
        return stageUtils;
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }

    public Stage getStage(){
        return stage;
    }

}
