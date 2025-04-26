package ui;

import model.Board;

public class TestMain {
    public static void main(String[] args) {
        Board board = new Board(); //Nesne oluşturduk
        board.createBoard(30); // oyu ntahtasını oluşturuyoruz
        board.printBoardTest(); // tahta üzerindeki düğümleri bastırıyoruz
    }
}
