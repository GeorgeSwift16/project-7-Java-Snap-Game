package gamebase;


import java.util.ArrayList;
import java.util.Scanner;

public class Snap extends CardGame {
    public Scanner input = new Scanner(System.in);

    public ArrayList<Player> playerList;
    public int gameLives = 0;
    public Card cardOnTable = new Card("K", "5", 6);
    public Card drawnCard = new Card("K", "5", 3);
    //    private Boolean isMatch = (this.cardOnTable.value == this.drawnCard.value);
    public final Boolean checkIfDeckEmpty = this.deckOfCards.size() == 0;

    public Snap(String gameName) {
        super(gameName);
        this.startGame();

    }

    public void setLives() {
        if (this.input.hasNextInt()) {
            this.gameLives = this.input.nextInt();

        } else {
            System.out.println("sorry please try entering a number not a letter");
            this.input.next();
        }
        System.out.println("enter a number between 1 and 5");
    }

    public void startGame() {
        System.out.println("welcome to snap, how many lives would you like to play? \n please enter a number between 1 and 5");
        while (this.gameLives <= 0 || this.gameLives > 5) {
            setLives();
        }

        System.out.println("Great you've selected " + this.gameLives + " lives");
        createDeck();
        shuffleDeck();
        gameOperation();

    }
//    this all needs refactoring to seperate functions and vars for better readability.


    public void gameOperation() {

        System.out.println("press enter to take a turn");
        this.cardOnTable = dealCard();
        while (this.gameLives > 0) {


            this.input.nextLine();
            this.drawnCard = dealCard();
            System.out.println(cardOnTable);
            System.out.println(drawnCard);

            if (this.cardOnTable.value == this.drawnCard.value) {
                this.gameLives -= 1;
                if (this.gameLives == 0) {
                    System.out.println("you win!");
                    break;
                }
                System.out.println("lives remaining " + this.gameLives);
            }
            if (this.checkIfDeckEmpty) {
                System.out.println("you lose no cards remain");
                break;
            }
            this.cardOnTable = this.drawnCard;

        }

    }


}
