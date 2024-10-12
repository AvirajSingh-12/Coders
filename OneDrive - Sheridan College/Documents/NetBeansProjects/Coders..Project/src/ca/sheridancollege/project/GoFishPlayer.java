/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Aviraj,Avneet,Mankirat
 */
import java.util.Scanner;

public class GoFishPlayer extends Player {
    private Scanner scanner;

    public GoFishPlayer(String name) {
        super(name);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void play() {
        // Implement player logic here if needed for more complex interactions
    }

    public String askForCard() {
        System.out.print(getName() + ", ask for a card rank (2-10, J, Q, K, A): ");
        return scanner.nextLine();
    }
}