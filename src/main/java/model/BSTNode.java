package model;

public class BSTNode {
    int score;
    String playerName;
    int level;
    BSTNode left, right;

    public BSTNode(int score, String playerName, int level) {
        this.score = score;
        this.playerName = playerName;
        this.level = level;
        left = right = null;
    }

    // ---- getter metodlar ----
    public int getScore()        { return score; }
    public String getPlayerName(){ return playerName; }
    public int getLevel()        { return level; }
}
