import gamebase.CardGame;

public class Main {
    public static void main(String[] args) {

        CardGame game = new CardGame("snap");
        game.getDeck();
        game.shuffleDeck();
        game.sortDeckInNumberOrderAndSuit();
        game.getDeck();
        System.out.println("hello".compareTo("hi"));

    }
}
