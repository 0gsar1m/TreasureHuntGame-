package game;

import model.BST;

import java.io.FileWriter;
import java.io.IOException;

public class ScoreWriter {

    public static void writeScoresToFile(BST bst) {
        try (FileWriter writer = new FileWriter("score.txt", true)) {
            StringBuilder sb = new StringBuilder();
            bst.getAllScores(bst.getRoot(), sb);
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
