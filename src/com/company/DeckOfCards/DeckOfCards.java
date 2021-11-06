package com.company.DeckOfCards;

public class DeckOfCards {

    public static void main(String[] args) {

        DistributeCards dc = new DistributeCards();	//	class object

        //	allot cards for each player
        for (int playerNumber = 1; playerNumber <= 4; playerNumber++) {
            dc.DistributeCard(playerNumber);
            System.out.println("Player "  + playerNumber + "'s cards:");
            //print cards of respective player
            dc.showCards(playerNumber);
        }
    }
}
