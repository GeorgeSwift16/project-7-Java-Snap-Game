package gamebase;

import java.util.ArrayList;
import java.util.Collections;

public class CardGame {

    //    constants
    private static final String[] suits = {"♥", "♠", "♣", "♦"};
    private static final String[] symbols = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q","K", "A"};
    private static final int[] value = {2,3,4,5,6,7,8,9,10,11,12,13,14};
    //    variables
    private String name;
    public ArrayList<Card> deckOfCards;



    //    constructors
    public CardGame(String name) {
        this.name = name;
        this.deckOfCards = new ArrayList<>();
        this.createDeck();
        this.shuffleDeck();
    }
    //    getters and setters


    //    methods
    public void removeCardFromDeck(Card card) {
        this.deckOfCards.remove(card);
    }
    public void addCardToDeck(Card card) {
        this.deckOfCards.add(card);
    }
    public void createDeck() {
        for (String suit: suits) {
            for (int i = 0; i < value.length; i++) {
                addCardToDeck(new Card(suit, symbols[i],value[i]));
            }

        }
    }
    public void shuffleDeck() {
        Collections.shuffle(this.deckOfCards);
    }
    public void getDeck() {

        for (Card card : this.deckOfCards) {
            System.out.println(card);
        }

    }

    public Card dealCard () {
        Card firstCard = this.deckOfCards.get(0);
        this.deckOfCards.remove(firstCard);
        return firstCard;
    }

    public void  sortDeckInNumberOrder() {
     Collections.sort(this.deckOfCards, (card1, card2) -> card1.value - card2.value );
    }
    public void  sortDeckInNumberOrderAndSuit() {
        Collections.sort(this.deckOfCards, (card1, card2) -> {
            int compareBySuit = card1.suit.compareTo(card2.suit);
            if (compareBySuit != 0) {
                return compareBySuit;
            }   else {
                return card1.value - card2.value;
            }
        });

    }
//    public Card dealCard() {
//
//    }
//    toString
    public String toString() {
      return  "there are " + this.deckOfCards.size() + " cards left in the deck";
    }
}
