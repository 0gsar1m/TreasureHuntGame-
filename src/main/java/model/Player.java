package model;

import game.Dice;
import utils.CELL_TYPE;

public class Player {
    String playerName;
    Board board;
    Node currentNode;
    int score;
    Dice dice;
    private int level;


    public Player(String playerName, Board board, int level) {
        this.playerName = playerName;
        this.board = board;
        this.currentNode = board.getHead(); // // currentNode head ile başlatılıyor
        this.score = 0;
        this.dice = Dice.getInstance(); // Singleton zar motoru
        this.level = level;
    }

    public boolean isAtEnd(){
        return currentNode.getNextNode() == null;
    }

    public void move() {

        System.out.println("Rolling the dice!!");
        int steps = dice.rollDice();
        System.out.println("It's " + steps + " !");

        System.out.println(playerName + " moves " + steps + " steps");

        for (int i = 0; i < steps; i++) {
            if (currentNode.getNextNode() != null) { // currentNode head ile başlatılıyor
                currentNode = currentNode.getNextNode(); // mevcut düğümü sonraki düğüme set ediyoruz
            } else {
                System.out.println(playerName + " is in the ending point!");
                return; // Board bitti, oyun bitti
            }
            System.out.println(playerName + " is at the " + currentNode.getId() + ". cell");


        }
        applyCellEffect(); // Hücrenin efektini uyguluyoruz
    }

    private void applyCellEffect() {
        CELL_TYPE cellEffect = currentNode.getCellType();
        if (level == 1) {
            switch (cellEffect) {
                case TREASURE:
                    score += 10;
                    System.out.println(playerName + " found a treasure! +10 points. " +
                            "Current score: " + score);
                    break;

                case TRAP:
                    score -= 10;
                    System.out.println("Oopsie! " + playerName + " fell into a trap! -10 points. " +
                            "Current score: " + score);
                    break;
                case EMPTY:
                    System.out.println(playerName + " is in an empty cell! Current score: " + score);
                    break;
                case GRAND_TREASURE:
                    score += 50;
                    System.out.println("Yahoo! " + playerName + " found a grand treasure! +50 points. " +
                            "Current score: " + score);
                    break;
                default:

                    break;
            }
        }
        if (level == 2) {
            switch (cellEffect) {
                case TREASURE:
                    score += 10;
                    System.out.println(playerName + " found a treasure! +10 points. " +
                            "Current score: " + score);
                    break;

                case TRAP:
                    score -= 10;
                    System.out.println("Oopsie! " + playerName + " fell into a trap! -10 points. " +
                            "Current score: " + score);
                    break;
                case EMPTY:
                    System.out.println(playerName + " is in an empty cell! Current score: " + score);
                    break;
                case GRAND_TREASURE:
                    score += 50;
                    System.out.println("Yahoo! " + playerName + " found a grand treasure! +50 points. " +
                            "Current score: " + score);
                    break;
                case MOVE_EFFECT:
                    int moveEffect = currentNode.getMoveEffect();
                    if (moveEffect > 0) {
                        System.out.println("Yahoo! " + playerName + " got a positive move effect! Move +" + moveEffect + " forward from your current cell!");
                        for (int i = 0; i < moveEffect; i++) { //move effect kadar ilerlemek üzere kontrol noktasına gir (96. satır)
                            if (currentNode.getNextNode() != null) { // tahta sonu kontrolü
                                currentNode = currentNode.getNextNode();
                            } else {
                                System.out.println(playerName + " is in the ending point!"); // tahta sonu ise uyar
                                break; //döngüden çık metodu bitir
                            }
                        }
                    } else if (moveEffect < 0) {
                        int targetId = currentNode.getId() + moveEffect; // moveEffect negatif zaten

                        // targetId 0'a veya negatif bir değere inerse 1'e sabitliyoruz
                        if (targetId <= 0) {
                            targetId = 1;
                        }

                        System.out.println(playerName + " got a negative move effect! Moving to cell " + targetId);

                        Node temp = board.getHead();
                        while (temp != null && temp.getId() != targetId) {
                            temp = temp.getNextNode(); // Negatif move effect ile geri gitmeye çalışıyoruz
                        }

                        if (temp != null) {
                            currentNode = temp; // sadece 1 hücre geri gitmesini sağlıyoruz
                            System.out.println(playerName + " moved backward to cell " + currentNode.getId());
                        } else {
                            System.out.println("Error: Could not move backward properly.");
                        }
                    }


            }

        }


    }

    public int getScore() {
        return score;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Node getCurrentNode() {
        return currentNode;
    }
}
