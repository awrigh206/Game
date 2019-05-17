/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrew.arnoldclarkgame.Game;

import com.andrew.arnoldclarkgame.Model.BaseGesture;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Models a "Play"/ when a user selects a gesture from those available
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
    
    /**
     * Select a gesture from those available by picking a random number in the correct range 
     */
    public void selectGesture()
    {
        int number = ThreadLocalRandom.current().nextInt(0, possibleGestures.size());
        computerGesture = possibleGestures.get(number);
    }
    
    /**
     * Calculates whether the user or the computer has won and returns a message
     * @return Returns a string with an appropriate message depending on the result
     */
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
