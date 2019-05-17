/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrew.arnoldclarkgame.Interfaces;

import com.andrew.arnoldclarkgame.Game.Play;
import com.andrew.arnoldclarkgame.Model.BaseGesture;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

/**
 *
 * @author Andrew Wright
 */
public class HomeController implements Initializable {
    
    @FXML
    private HBox optionBox;
    @FXML
    private HBox resultBox;
    
    private ArrayList<BaseGesture> options;
    private Label currentLabel;
    private int userScore;

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
        userScore =0;
        prepareOptions();
    }    
    
    private void prepareOptions()
    {
        options = new ArrayList<>();
        options.add( new BaseGesture("Rock",new ArrayList<>(Arrays.asList("Paper","Spock"))));
        options.add (new BaseGesture("Paper",new ArrayList<>(Arrays.asList("Scissors","Lizard"))));
        options.add( new BaseGesture("Scissors",new ArrayList<>(Arrays.asList("Rock","Spock"))));
        options.add( new BaseGesture("Lizard",new ArrayList<>(Arrays.asList("Scissors","Rock"))));
        options.add( new BaseGesture("Spock",new ArrayList<>(Arrays.asList("Paper","Lizard"))));
        
        
        for(BaseGesture current: options)
        {
            JFXButton currentButton = current.convertToDisplay(true);
            //Sets what is to happen when the user clicks on this button
            currentButton.setOnAction(event -> 
            {
                Play newPlay = new Play(current, options);
                if(optionBox.getChildren().contains(currentLabel))
                    optionBox.getChildren().remove(currentLabel);
                
                currentLabel = new Label (newPlay.result());
                currentLabel.setFont((new Font("System", 20)));
                
                
               // Label userScoreLabel = new Label ("User: "+String.valueOf(userScore)+" ");
                resultBox.getChildren().clear();
                
                resultBox.getChildren().add(newPlay.getComputerGesture().convertToDisplay(false));
                resultBox.getChildren().add(currentLabel);
            });
            optionBox.getChildren().add(currentButton);
        }
    }
    
}
