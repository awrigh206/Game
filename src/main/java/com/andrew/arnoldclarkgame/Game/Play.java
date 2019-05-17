/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrew.arnoldclarkgame.Game;

import com.andrew.arnoldclarkgame.Model.BaseGesture;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import javafx.scene.control.Label;

/**
 *
 * @author Andrew Wright
 */
public class Play 
{
    private final BaseGesture userGesture;
    private BaseGesture computerGesture;
    private ArrayList<BaseGesture> possibleGestures;
    
    public Play(BaseGesture userChoice, ArrayList<BaseGesture> gestures)
    {
        this.userGesture = userChoice;
        this.possibleGestures = gestures;
        selectGesture();
    }
    
    public void selectGesture()
    {
        int number = ThreadLocalRandom.current().nextInt(0, possibleGestures.size());
        computerGesture = possibleGestures.get(number);
    }
    
    public String result()
    {
        String text="";

        
        for (String current: userGesture.getBeatenBy())
        {
            if(current.equalsIgnoreCase(computerGesture.getName()))
            {
                //lose condition
                text= "You lost!";
            }
        }
        
        for (String current: computerGesture.getBeatenBy())
        {
            if (current.equalsIgnoreCase(userGesture.getName()))
            {
                //Win condition 
                text="You won!";
            }
        }
        
        if (text.isEmpty())
        {
            //draw condition
            text="It's a draw!";
        }
        

        return text;
    }

    public BaseGesture getComputerGesture() {
        return computerGesture;
    }
    
    
}
