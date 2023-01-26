package gamebase;

public class Card {

    //    constants
//    variables
    public String suit;
    public String symbol;
    public int value;

    //    constructors
    public Card(String suit, String symbol, int value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;

    }

    //    getters and setters
    public String getSuit() {
        return this.suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public  int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
//    methods
//    toString

    public String toString() {
        return  "suit: " + this.suit +  " symbol: " + this.symbol + " value: " + this.value;
    }
}
