import java.util.Scanner;

public class Q10_DeckOfCards {
    static String[] initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
                "Jack", "Queen", "King", "Ace"};

        String[] deck = new String[suits.length * ranks.length];
        int index = 0;

        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    static String[] shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int)(Math.random() * (n - i));
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        return deck;
    }

    static String[][] distribute(String[] deck, int cards, int players) {
        if (cards <= 0 || players <= 0 || cards * players > deck.length) return null;

        String[][] result = new String[players][cards];
        int index = 0;

        for (int player = 0; player < players; player++) {
            for (int card = 0; card < cards; card++) {
                result[player][card] = deck[index++];
            }
        }
        return result;
    }

    static void printPlayers(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.println("\nPlayer " + (i + 1) + ":");
            for (String card : players[i]) System.out.println("  " + card);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] deck = initializeDeck();
        shuffleDeck(deck);

        System.out.print("Enter number of players: ");
        int players = sc.nextInt();
        System.out.print("Enter cards per player: ");
        int cards = sc.nextInt();

        if (players <= 0 || cards <= 0 || players * cards > deck.length) {
            System.out.println("Cards cannot be distributed equally with these values.");
            return;
        }

        String[][] result = distribute(deck, cards, players);
        printPlayers(result);
    }
}
