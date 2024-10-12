/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Mankirat,Avneet,Aviraj
 */
import java.util.Scanner;

public class GoFishGame extends Game {
    private GroupOfCards deck;
    private Player player1;
    private Player player2;
    private Scanner scanner;

    
    public GoFishGame() {
        super("Go Fish");
        this.scanner = new Scanner(System.in);
    }
    private void setUp() {
        this.deck = new GroupOfCards(52);
        deck.shuffle(); // Shuffle the deck

        setUpPlayers(); // Set up player names
        dealCards();    // Deal initial cards to players
    }
    
    private void dealCards() {
        for (int i = 0; i < 5; i++) { // Deal 5 cards to each player
            player1.addCard(deck.dealCard());
            player2.addCard(deck.dealCard());
        }
    }
    
    private void setUpPlayers(){
        System.out.print("Enter name for Player 1: ");
        String name1 = scanner.nextLine();
        player1 = new GoFishPlayer(name1);

        System.out.print("Enter name for Player 2: ");
        String name2 = scanner.nextLine();
        player2 = new GoFishPlayer(name2);
    }

    @Override
    public void play() {
        System.out.println("Welcome to Go Fish!");

        boolean gameInProgress = true;

        while (gameInProgress) {
            // Player 1's turn
            playerTurn(player1, player2);
            if (checkWinCondition(player1)) {
                declareWinner(player1);
                gameInProgress = false;
                break;
            }

            // Player 2's turn
            playerTurn(player2, player1);
            if (checkWinCondition(player2)) {
                declareWinner(player2);
                gameInProgress = false;
                break;
            }
        }
        
    }
    private void playerTurn(Player currentPlayer, Player opponent) {
        String requestedRank = ((GoFishPlayer) currentPlayer).askForCard();
        Card foundCard = null;

        // Check if the opponent has the requested card
        for (Card card : opponent.getHand()) {
            if (card.getRank().equals(requestedRank)) {
                foundCard = card;
                break;
            }
        }

        if (foundCard != null) {
            System.out.println(opponent.getName() + " has the " + requestedRank + "!");
            currentPlayer.addCard(foundCard);
            opponent.removeCard(foundCard);
        } else {
            System.out.println("Go Fish! Drawing a card.");
            Card drawnCard = deck.dealCard();
            if (drawnCard != null) {
                currentPlayer.addCard(drawnCard);
                System.out.println(currentPlayer.getName() + " drew a " + drawnCard);
            } else {
                System.out.println("No more cards in the deck to draw.");
            }
        }
    }

    private boolean checkWinCondition(Player player) {
        return player.getHand().size() >= 7; // Example winning condition (7 cards)
    }
   
    public void declareWinner(Player player) {
        System.out.println(player.getName() + " wins!");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            GoFishGame game = new GoFishGame();
            game.setUp(); // Call setUp to initialize the game components
            game.play(); // Start the game

            // Ask if players want to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.nextLine();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    @Override
    public void declareWinner() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}