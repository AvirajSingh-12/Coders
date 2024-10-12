/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Avneet,Mankirat,Aviraj
 */
import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. 
 * This class can be extended to support specific card games such as Blackjack, Poker, etc.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @modifier Mankirat,Avneet,Aviraj.
 * @date 2024-10-10
 */
public class GroupOfCards {

    // The group of cards, stored in an ArrayList
    private ArrayList<Card> cards;
    private int size; // the size of the grouping

    public GroupOfCards(int size) {
        this.size = size;
        this.cards = new ArrayList<>(size);
        populateDeck();
    }

    /**
     * A method to get the group of cards as an ArrayList.
     *
     * @return the group of cards.
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * A method to set the group of cards with a new set of cards.
     *
     * @param cards the new group of cards
     */
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    /**
     * A method to shuffle the group of cards randomly.
     */
    private void populateDeck() {
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new StandardCard(rank, suit));
            }
        }
    }
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * A method to deal a card from the group. Removes and returns the first card.
     *
     * @return the dealt card, or null if the group is empty.
     */
    public Card dealCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0); // Removes the first card from the list
        }
        return null; // Return null if no cards are available
    }

    /**
     * A method to add a card to the group, provided the group has space.
     *
     * @param card the card to add to the group
     */
    public void addCard(Card card) {
        if (cards.size() < size) {
            cards.add(card);
        } else {
            System.out.println("Cannot add card: Group is full.");
        }
    }

    /**
     * A method to remove a card from the group.
     *
     * @param card the card to remove from the group
     * @return true if the card was removed, false if the card was not found.
     */
    public boolean removeCard(Card card) {
        return cards.remove(card);
    }

    /**
     * A method to get the size of the group of cards.
     *
     * @return the size of the group of cards.
     */
    public int getSize() {
        return size;
    }

    /**
     * A method to set the size (maximum capacity) for the group of cards.
     *
     * @param size the maximum size for the group of cards.
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * A method to check if the group is empty.
     *
     * @return true if the group has no cards, false otherwise.
     */
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    /**
     * A method to check if the group is full (i.e., has reached its maximum size).
     *
     * @return true if the group is full, false otherwise.
     */
    public boolean isFull() {
        return cards.size() == size;
    }

    

}// end class
