package game;

import model.BST;
import model.BSTNode;
import model.Board;
import model.Player;

import java.util.Scanner;

public class GameEngine {
Scanner sc = new Scanner(System.in);
    public void startGame() {

        // Skorları Score.txt dosyasından yükle
        BST bst = new BST();
        ScoreLoader.loadScores(bst); // Eski skorları BST'ye yükler

        System.out.println("Welcome to the Treasure Hunt Game Pirate!");

        //Level 1 başlatılıyor:
        Board board1 = new Board();
        board1.createBoard(1); // parametre olarak seviye 1 verdik

        //Player çağrılıyor
        System.out.println("Please Enter your username");
        String playerName = sc.nextLine();
        Player player1 = new Player(playerName, board1, 1);
        playUntilEnd(player1);

        //bu kısmı gpt yazdı------vvv
        // Level 1 skoru BST'ye kaydet

        bst.insert(player1.getScore(), player1.getPlayerName(), 1);

        ScoreWriter.writeSingleScore(player1.getScore(),
                player1.getPlayerName(), 1);

        BSTNode max = bst.getMaxNode();
        BSTNode min = bst.getMinNode();

        //min ve max skorları yazıyor
        System.out.printf("Current MAX: %s: %d  –  Current MIN: %s: %d%n",
                max.getPlayerName(), max.getScore(), min.getPlayerName(), min.getScore());

        System.out.println("\n=== BST snapshot after Level-1 ===");
        bst.inOrderTraversal(bst.getRoot());          // ← tüm düğümleri sıralı basar
        //bu kısmı gpt yazdı------^^^


        System.out.println(player1.getPlayerName() + " finished level 1 with score of: " + player1.getScore());

        System.out.println("Do you want to continue to Level 2? (Yes: 1 / No: 0)"); // level 2'ye devam sorgusu
        int choice = sc.nextInt();
        sc.nextLine(); //satır sonunu bitiriyoruz ki 1/0 seçeneğini giren kullanıcı sorun yaşamasın


        if(choice == 1) {
            System.out.println("Level 2 is starting..");
            Board board2 = new Board();     // 2. seviye için tahta oluşturuluyor
            board2.createBoard(2);


            Player player2 = new Player(playerName, board2, 2); //seviye 2 için aynı oyuncu oluşturuluyor
            playUntilEnd(player2);

            //bu kısmı gpt yazdı------vvv

            // Level 2 skoru BST'ye kaydet
            bst.insert(player2.getScore(), player2.getPlayerName(), 2);

            // Skorları yaz
            ScoreWriter.writeSingleScore(player2.getScore(),
                    player2.getPlayerName(), 2);

            //min ve max skorları yazıyor
            System.out.printf("Current MAX: %s: %d  –  Current MIN: %s: %d%n",
                    max.getPlayerName(), max.getScore(), min.getPlayerName(), min.getScore());

            System.out.println("\n=== BST snapshot after Level-2 ===");
            bst.inOrderTraversal(bst.getRoot());          // ← tüm düğümleri sıralı basar
            //bu kısmı gpt yazdı------^^^

            System.out.println(player2.getPlayerName() + " finished level 2 with score of: " + player2.getScore());
            System.out.println("Thanks for completing the game!");
        }else{
            System.out.println("Thank you for playing");
        }

    }

    private void playUntilEnd(Player player) {
        while (!player.isAtEnd()) {
            System.out.printf("%s – Şu an hücre %d. Zar atmak için ENTER, çıkmak için q: ",
                    player.getPlayerName(), player.getCurrentNode().getId());
            String command = sc.nextLine().trim();

            if (command.equalsIgnoreCase("q")) {
                System.out.println("Oyundan çıktınız.");
                return;                         // döngü kırılır
            }


            System.out.println(player.getPlayerName() + " is rolling the dice..");
            player.move();
            System.out.println("-----------------------------------------------");
        }
    }


}
