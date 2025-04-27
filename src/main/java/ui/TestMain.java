package ui;

import game.Dice;
import model.Board;

public class TestMain {
    public static void main(String[] args) {

        //--------------------start of board creation test------------------
        Board board = new Board(); //Nesne oluşturduk
        board.createBoard(30); // oyu ntahtasını oluşturuyoruz
        board.printBoardTest(); // tahta üzerindeki düğümleri bastırıyoruz
        //--------------------end of board creation test------------------


        //--------------------start of dice roll test------------------
        Dice dice = Dice.getInstance(); //singleton tasarladık

        System.out.println("Zar Atma Testi 1: " + dice.rollDice());
        System.out.println("Zar Atma Testi 2: " + dice.rollDice());
        System.out.println("Zar Atma Testi 3: " + dice.rollDice());
        System.out.println("Zar Atma Testi 4: " + dice.rollDice());
        //--------------------end of dice roll test------------------
    }
}
