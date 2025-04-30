package ui;

import game.Dice;
import game.Game;
import game.GameEngine;
import game.ScoreWriter;
import model.BST;
import model.Board;
import model.Player;

public class TestMain {
    public static void main(String[] args) {

        //--------------------start of board creation test------------------
        /*
        Board board = new Board(); //Nesne oluşturduk
        board.createBoard(); // oyu ntahtasını oluşturuyoruz
        board.printBoardTest(); // tahta üzerindeki düğümleri bastırıyoruz
        */
        //--------------------end of board creation test------------------


        //--------------------start of dice roll test------------------
        /*Dice dice = Dice.getInstance(); //singleton tasarladık

        System.out.println("Zar Atma Testi 1: " + dice.rollDice());
        System.out.println("Zar Atma Testi 2: " + dice.rollDice());
        System.out.println("Zar Atma Testi 3: " + dice.rollDice());
        System.out.println("Zar Atma Testi 4: " + dice.rollDice());*/
        //--------------------end of dice roll test------------------

        //--------------------Player.move metodu ve Player.applyCellEffect metodu testi başlangıcı------------------
        /*Board board = new Board();
        board.createBoard(); // createBoard'ın, parametre alabilen halinden önce test edilmiş bir kod bloğudur

        Player player1 = new Player("ogsar", board, 2);

        for (int i = 1; i <= 30; i++) {
            System.out.printf("%s is rolling the %d. dice\n", player1, i);
            player1.move();
            System.out.println("--------------------------------------");
        }

        System.out.println("--------------------------------------\ntable is like this:");
        board.printBoardTest();
        */

        //--------------------Player.move metodu ve Player.applyCellEffect metodu testi başlangıcı------------------

        //--------------------oyun motoru testi başlangıcı------------------
        GameEngine game = new GameEngine();
        game.startGame();


        //--------------------oyun motoru testi bitişi----------------------


    }
}
