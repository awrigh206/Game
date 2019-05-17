/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrew.arnoldclarkgame.Model;

import com.jfoenix.controls.JFXButton;



/**
 *
 * @author Andrew Wright
 * 
 * Implement this interface to display an object on the javafx stage
 */
public interface IScreenElement 
{
    public JFXButton convertToDisplay(boolean active);
}
