package com.company.DeckOfCards;

import java.util.Random;

public class DistributeCards {
    int[][] cards = new int[4][13];	//	array of cards

    /** Allot cards to one player **/
    void DistributeCard(int playerNumber) {
        for (int i = 0; i < 9; i++) {
            giveCard(playerNumber);
        }
    }

    /**	Allot only one card randomly **/
    void giveCard(int playerNumber) {
        Random random = new Random();

        int suit = random.nextInt(4);
        int rank = random.nextInt(13);

        if (cards[suit][rank] != 0) {
            giveCard(playerNumber);
        } else {
            cards[suit][rank] = playerNumber;
        }
    }

    /** Prints cards in ascending order **/
    void showCards(int playerNumber) {
        for(int suit = 0; suit < 4; suit++) {
            for(int rank = 0; rank < 13; rank++) {
                if(cards[suit][rank] == playerNumber) {
                    System.out.print(getSuit(suit) + " " + getRank(rank) + "\t");
                }
            }
        }
        System.out.println("\n");
    }

    /** return rank of the card from number **/
    String getRank(int rankNumber) {
        return switch (rankNumber) {
            case 0 -> "2";
            case 1 -> "3";
            case 2 -> "4";
            case 3 -> "5";
            case 4 -> "6";
            case 5 -> "7";
            case 6 -> "8";
            case 7 -> "9";
            case 8 -> "10";
            case 9 -> "Jack";
            case 10 -> "Queen";
            case 11 -> "King";
            case 12 -> "Ace";
            default -> "";
        };
    }

    /** return suit name from number */
    String getSuit(int suitNumber) {
        return switch (suitNumber) {
            case 0 -> "Clubs";
            case 1 -> "Diamonds";
            case 2 -> "Hearts";
            case 3 -> "Spades";
            default -> "";
        };
    }
}

