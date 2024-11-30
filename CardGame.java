//package linkedLists;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Collections;
import java.util.Scanner;



public class CardGame {
	
	private static LinkList cardList = new LinkList();  // make list

	public static void main(String[] args) {

		// File name to read from
        String fileName = "cards.txt"; // Ensure the file is in the working directory or specify the full path

        // Read the file and create Card objects
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line into components
                String[] details = line.split(","); // Assuming comma-separated values
                if (details.length == 4) {
                    // Parse card details
                    String suit = details[0].trim();
                    String name = details[1].trim();
                    int value = Integer.parseInt(details[2].trim());
                    String pic = details[3].trim();

                    // Create a new Card object
                    Card card = new Card(suit, name, value, pic);

                    // Add the Card object to the list
                    cardList.add(card);
                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        // Print the loaded cards
        //System.out.println("Cards loaded:");
        //cardList.displayList();

        //shuffle the deck
        cardList.shuffle();
		
		Card[] playerHand = new Card[5];
        Card[] dealerHand = new Card[5];

		for(int i = 0; i < playerHand.length; i++){
            dealerHand[i] = cardList.getFirst();
			playerHand[i] = cardList.getFirst();
        }
		
		System.out.println("players hand");
        int playerScore =0;
		for(int i = 0; i < playerHand.length; i++){
			System.out.println(playerHand[i]);
            playerScore += playerHand[i].getCardValue();
        }
        System.out.println("Total value: " + playerScore);


        int dealerScore=0;
        System.out.println("dealers hand");
        for(int i = 0; i < dealerHand.length; i++){
            System.out.println(dealerHand[i]);
            dealerScore += dealerHand[i].getCardValue();
        }
		System.out.println("Total value: " + dealerScore);

        System.out.println("\nWinner:");
        if(playerScore>dealerScore){
            System.out.println("Player wins with a score of " + playerScore);
        }
        else if(dealerScore>playerScore){
            System.out.println("Dealer wins with a score of " + dealerScore);
        }
        else{
            System.out.println("ITS A TIE!! Both scored " + playerScore + "!");

        }
        
    
    



		//System.out.println();
		//System.out.println("the deck");
		//cardList.displayList();

	}//end main

}//end class
