package gamebase;


import java.util.ArrayList;
import java.util.Scanner;

public class Snap extends CardGame {
    public Scanner input = new Scanner(System.in);

    public boolean playerOneTurn = true;

    public ArrayList<Player> playerList = new ArrayList<>();
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
        System.out.println("how many lives would you like to play? \n please enter 1");
        while (this.gameLives != 1) {
            setLives();
        }
        System.out.println("how many players are going to play 1 or 2?");
        int numberOfPlayers = input.nextInt();
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("please enter a player name");
            this.playerList.add(new Player(input.next(), this.gameLives));
        }
        System.out.println(this.playerList.get(1).playerName);
        createDeck();
        shuffleDeck();
        gameOperation(playerList);

    }
//    this all needs refactoring to seperate functions and vars for better readability.


    public void gameOperation(ArrayList<Player> playerList) {

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
