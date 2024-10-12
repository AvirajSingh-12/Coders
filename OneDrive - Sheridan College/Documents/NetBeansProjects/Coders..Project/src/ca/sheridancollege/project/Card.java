/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Mankirat,Avneet,Aviraj
 */
public abstract class Card {
    //default modifier for child classes
    private String rank;
    private String suit;
    
    public Card(String rank, String suit){

    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
        this.rank = rank;
        this.suit = suit;
    }
    @Override
    public String toString(){
        return rank + " of " + suit;
    }
    public String getRank(){
        return rank;
    }

}
