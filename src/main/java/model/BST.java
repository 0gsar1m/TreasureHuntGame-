package model;

public class BST {
    private BSTNode root;

    public BST() {
        this.root = null;
    }

    // Insert method (recursive)
    public void insert(int score, String username, int level) {
        root = insertRecursive(root, score, username, level);
    }

    private BSTNode insertRecursive(BSTNode root, int score, String username, int level) {
        if (root == null) {
            return new BSTNode(score, username, level);
        }

        if (score < root.score) {
            root.left = insertRecursive(root.left, score, username, level);
        } else if (score > root.score) {
            root.right = insertRecursive(root.right, score, username, level);
        } else {  // Equal scores go to the right
            root.right = insertRecursive(root.right, score, username, level);
        }

        return root;
    }

    // Traversal to print the BST in-order (sorted by score)
    public void inOrderTraversal(BSTNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.println("Username: " + root.playerName + " Score: " + root.score + " Level: " + root.level);
            inOrderTraversal(root.right);
        }
    }

    // Get the root node
    public BSTNode getRoot() {
        return root;
    }

    public BSTNode getMaxNode() {      // en sağ düğüm – global maksimum
        if (root == null) return null;
        BSTNode cur = root;
        while (cur.right != null) cur = cur.right;
        return cur;
    }

    public BSTNode getMinNode() {      // en sol düğüm – global minimum
        if (root == null) return null;
        BSTNode cur = root;
        while (cur.left != null) cur = cur.left;
        return cur;
    }

    // Function to get all scores (used for file writing)
    public void getAllScores(BSTNode root, StringBuilder scores) {
        if (root != null) {
            getAllScores(root.left, scores);
            scores.append(root.score).append(" (").append(root.playerName).append(", level ").append(root.level).append(")\n");
            getAllScores(root.right, scores);
        }
    }
}
