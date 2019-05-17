/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrew.arnoldclarkgame.Model;

import com.jfoenix.controls.JFXButton;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 *
 * @author Andrew Wright
 */
public class BaseGesture implements IScreenElement
{
    private String name;
    private ArrayList<String> beatenBy;

    public BaseGesture(String name, ArrayList<String> beatenBy) {
        this.name = name;
        this.beatenBy = beatenBy;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getBeatenBy() {
        return beatenBy;
    }

    public void setBeatenBy(ArrayList<String> beatenBy) {
        this.beatenBy = beatenBy;
    }
    
    /**
     * Convert the object into something which can be displayed on the javafx stage
     * @return 
     */
    public JFXButton convertToDisplay(boolean active)
    {
        JFXButton button = new JFXButton(name);
        try
        {
            Image image = new Image("/Images/"+name.toLowerCase() + ".png");
            ImageView view = new ImageView (image);
            view.setPreserveRatio(true);
            view.setFitHeight(150);
            view.setFitWidth(150);
            button.setGraphic(view);
            button.setDisable(!active);
            button.setContentDisplay(ContentDisplay.TOP);
            
        }
        
        catch(Exception e)
        {
            System.out.println("error");
            //Means there is not an image for this specific type so show the default.
            //It could also mean the proper image is missing
        }
            
        button.setPadding(new Insets(10, 10, 10, 10));
        return button;
    }

    @Override
    public String toString() {
        return "Name:" + name + "Beaten by: " + beatenBy;
    }   
    
    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof BaseGesture)) {
            return false;
        }

        BaseGesture gesture = (BaseGesture) o;

        return gesture.name.equals(name);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        return result;
    }
    
    
    
    
}
