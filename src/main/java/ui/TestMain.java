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
        //--------------------oyun motoru ile başlatıyoruz------------------
        GameEngine game = new GameEngine();
        game.startGame();

    }
}
