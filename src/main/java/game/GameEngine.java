package game;

import model.BST;
import model.Board;
import model.Player;

import java.util.Scanner;

public class GameEngine {
Scanner sc = new Scanner(System.in);
    public void startGame() {
        System.out.println("Welcome to the Treasure Hunt Game Pirate!");

        //Level 1 başlatılıyor:
        Board board = new Board();
        board.createBoard(1); // parametre olarak seviye 1 verdik

        //Player çağrılıyor
        Player player1 = new Player("nurullah", board, 1);
        playUntilEnd(player1);

        //bu kısmı gpt yazdı------
        // Level 1 skoru BST'ye kaydet
        BST bst = new BST();
        bst.insert(player1.getScore(), player1.getPlayerName(), 1);
        // Skorları yaz
        ScoreWriter.writeScoresToFile(bst);
        //bu kısmı gpt yazdı------


        System.out.println(player1.getPlayerName() + " finished level 1 with score of: " + player1.getScore());

        System.out.println("Do you want to continue to Level 2? (Yes: 1 / No: 0)"); // level 2'ye devam sorgusu
        int choice = sc.nextInt();

        if(choice == 1) {
            System.out.println("Level 2 is starting..");
            Board board2 = new Board();     // 2. seviye için tahta oluşturuluyor
            board2.createBoard(2);


            Player player2 = new Player("recep", board2, 2); //seviye 2 için oyuncu oluşturuluyor
            playUntilEnd(player2);

            //bu kısmı gpt yazdı------

            // Level 2 skoru BST'ye kaydet
            bst.insert(player1.getScore(), player1.getPlayerName(), 2);

            // Skorları yaz
            ScoreWriter.writeScoresToFile(bst);

            //bu kısmı gpt yazdı------

            System.out.println(player1.getPlayerName() + " finished level 2 with score of: " + player1.getScore());
            System.out.println("Thanks for completing the game!");
        }else{
            System.out.println("Thank you for playing");
        }

    }

    private void playUntilEnd(Player player) {
        while (!player.isAtEnd()) {
            System.out.println(player.getPlayerName() + " is rolling the dice..");
            player.move();
            System.out.println("-----------------------------------------------");
        }
    }


}
