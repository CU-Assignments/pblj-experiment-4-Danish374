import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

class Card {
    String symbol;
    String value;

    public Card(String symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getValue() {
        return value;
    }

    public void display() {
        System.out.println(value + " of " + symbol);
    }
}

class CardManagement {
    private Collection<Card> cards;

    public CardManagement() {
        cards = new ArrayList<>();
    }

    public void addCard(String symbol, String value) {
        Card card = new Card(symbol, value);
        cards.add(card);
        System.out.println("Card added: " + value + " of " + symbol);
    }

    public void findCardsBySymbol(String symbol) {
        boolean found = false;
        Iterator<Card> iterator = cards.iterator();
        while (iterator.hasNext()) {
            Card card = iterator.next();
            if (card.getSymbol().equalsIgnoreCase(symbol)) {
                card.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No cards found with symbol: " + symbol);
        }
    }

    public void displayAllCards() {
        if (cards.isEmpty()) {
            System.out.println("No cards to display.");
        } else {
            for (Card card : cards) {
                card.display();
            }
        }
    }
}

public class CardCollector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardManagement cardManagement = new CardManagement();
        int choice;

        do {
            System.out.println("\nCard Collection System");
            System.out.println("1. Add a Card");
            System.out.println("2. Find Cards by Symbol");
            System.out.println("3. Display All Cards");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the card symbol (e.g., hearts, spades, clubs, diamonds): ");
                    String symbol = scanner.nextLine();
                    System.out.print("Enter the card value (e.g., 2, 3, Ace, King, etc.): ");
                    String value = scanner.nextLine();
                    cardManagement.addCard(symbol, value);
                    break;

                case 2:
                    System.out.print("Enter the symbol of the cards you want to find: ");
                    String searchSymbol = scanner.nextLine();
                    cardManagement.findCardsBySymbol(searchSymbol);
                    break;

                case 3:
                    cardManagement.displayAllCards();
                    break;

                case 4:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
