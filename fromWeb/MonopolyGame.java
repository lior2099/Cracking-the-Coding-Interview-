package fromWeb;

import java.util.*;

class Square {
    String name;
    int cost;
    int rent;
    Player owner;

    Square(String name, int cost, int rent) {
        this.name = name;
        this.cost = cost;
        this.rent = rent;
        this.owner = null;
    }
}

class Card {
    String action;
    int targetIndex;

    Card(String action, int targetIndex) {
        this.action = action;
        this.targetIndex = targetIndex;
    }
}

class Player {
    String name;
    int money;
    int position;
    int jailTurns;
    int freeParkingTurns;

    Player(String name, int startingMoney) {
        this.name = name;
        this.money = startingMoney;
        this.position = 0;
        this.jailTurns = 0;
        this.freeParkingTurns = 0;
    }

    boolean decideToBuy(Square square) {
        return money >= square.cost; // Simple decision: buy if they can afford it
    }
}

class MonopolyGame {
    Square[] board;
    List<Player> players;
    Queue<Card> cards;
    Random random;

    public MonopolyGame() {
        random = new Random();
        board = new Square[40];
        players = new ArrayList<>();
        cards = new LinkedList<>();

        initializeBoard();
        initializeCards();
    }

    private void initializeBoard() {
        board[0] = new Square("Start", 0, 0);
        board[10] = new Square("Jail", 0, 0);
        board[20] = new Square("Free Parking", 0, 0);
        board[30] = new Square("Card", 0, 0);

        for (int i = 1; i < 40; i++) {
            if (board[i] == null) {
                board[i] = new Square("Property" + i, 100 + (i * 10), 10 + i);
            }
        }
    }

    private void initializeCards() {
        cards.add(new Card("GO_TO_JAIL", 10));
        cards.add(new Card("MOVE_TO_START", 0));
        cards.add(new Card("COLLECT_200", -1));
        cards.add(new Card("PAY_50", -1));
    }

    public void addPlayer(String name) {
        players.add(new Player(name, 500));
    }

    public void playRound() {
        for (Player player : players) {
            if (player.jailTurns > 0) {
                handleJail(player);
                continue;
            }

            if (player.freeParkingTurns > 0) {
                player.freeParkingTurns--;
                System.out.println(player.name + " is waiting on Free Parking.");
                continue;
            }

            int diceRoll = random.nextInt(6) + 1 + random.nextInt(6) + 1;
            player.position = (player.position + diceRoll) % 40;
            System.out.println(player.name + " rolled " + diceRoll + " and moved to " + board[player.position].name + ".");

            if (player.position == 0) {
                player.money += 400;
                System.out.println(player.name + " landed on Start and collected $400.");
            } else if (player.position == 20) {
                player.freeParkingTurns = 2;
                System.out.println(player.name + " landed on Free Parking and will wait for 2 turns.");
            } else if (player.position == 30) {
                drawCard(player);
            } else {
                handleProperty(player);
            }

            player.money += 200; // End of round bonus
        }
    }

    private void handleJail(Player player) {
        System.out.println(player.name + " is in Jail for " + player.jailTurns + " more turns.");
        if (player.money >= 100) {
            System.out.println(player.name + " chooses to pay $100 to get out of Jail.");
            player.money -= 100;
            player.jailTurns = 0;
        } else {
            player.jailTurns--;
        }
    }

    private void drawCard(Player player) {
        Card card = cards.poll();
        cards.add(card); // Put the card back to the end of the queue

        switch (card.action) {
            case "GO_TO_JAIL":
                player.position = card.targetIndex;
                player.jailTurns = 3;
                System.out.println(player.name + " drew 'Go to Jail' and is now in Jail.");
                break;
            case "MOVE_TO_START":
                player.position = card.targetIndex;
                System.out.println(player.name + " drew 'Move to Start' and moved to Start.");
                break;
            case "COLLECT_200":
                player.money += 200;
                System.out.println(player.name + " drew 'Collect $200'.");
                break;
            case "PAY_50":
                player.money -= 50;
                System.out.println(player.name + " drew 'Pay $50'.");
                break;
        }
    }

    private void handleProperty(Player player) {
        Square square = board[player.position];
        if (square.owner == null && square.cost > 0) {
            if (player.decideToBuy(square)) {
                square.owner = player;
                player.money -= square.cost;
                System.out.println(player.name + " bought " + square.name + " for $" + square.cost + ".");
            } else {
                System.out.println(player.name + " decided not to buy " + square.name + ".");
            }
        } else if (square.owner != null && square.owner != player) {
            player.money -= square.rent;
            square.owner.money += square.rent;
            System.out.println(player.name + " paid rent of $" + square.rent + " to " + square.owner.name + ".");
        }
    }

    public static void main(String[] args) {
        MonopolyGame game = new MonopolyGame();
        game.addPlayer("Alice");
        game.addPlayer("Bob");
        game.addPlayer("Charlie");

        for (int i = 1; i <= 100; i++) {
            System.out.println("\nRound " + i + ":");
            game.playRound();
        }
    }
}
