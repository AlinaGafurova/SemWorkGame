package com.gafurova.utils;

import javafx.fxml.FXMLLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class FXMLLoaderUtil {

    private AnnotationConfigApplicationContext context;

    @Autowired
    public FXMLLoaderUtil(AnnotationConfigApplicationContext context){
        this.context = context;
    }

    public FXMLLoader getLoader(String path){
        FXMLLoader loader = new FXMLLoader();
        loader.setControllerFactory(param -> context.getBean(param));
        loader.setLocation(getClass().getResource(path));
        return loader;
    }
}
