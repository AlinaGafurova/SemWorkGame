package com.gafurova.utils;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ScreenUtils {

    private FXMLLoaderUtil fxmlLoaderUtil;

    public static final double DEF_WIDTH = 600;
    public static final double DEF_HEIGHT = 800;

    @Autowired
    public ScreenUtils(FXMLLoaderUtil fxmlLoaderUtil){
        this.fxmlLoaderUtil = fxmlLoaderUtil;
    }


    public void setScreen(String path) throws IOException {
        path = "/" + path + ".fxml";
        Parent parent = fxmlLoaderUtil.getLoader(path).load();
        StageUtils.getInstance().getStage().setScene(new Scene(parent, DEF_WIDTH, DEF_HEIGHT));
    }
}
