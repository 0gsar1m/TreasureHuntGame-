package model;

import utils.CELL_TYPE;

public class Board { //sınıfın amacı, LL yapısıyla oyun tahtasının yapısının kurulması

    private Node head;
    private int linkedListNodeCounter;


    public void createBoard(int numOfCells) {
        for (int i = 1; i <= numOfCells; i++) {
            CELL_TYPE cellType = randomCellType();
            Node newNode = new Node(i, cellType, 0);
            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.getNextNode() != null) {
                    temp = temp.getNextNode();
                }
                temp.setNextNode(newNode);
            }
            linkedListNodeCounter++;
        }
    }

    private CELL_TYPE randomCellType() {
        int luckPercentage = (int) (Math.random() * 100); // şans yüzdesi veriliyor

        if (luckPercentage < 30) { //Treasure hücresi için %30'luk bir oran koyduk
            return CELL_TYPE.TREASURE;
        } else if (luckPercentage < 45) { // %30'dan %45'e kadar %15'lik bir tuzak oranı var
            return CELL_TYPE.TRAP;
        } else if (luckPercentage < 50) { // %45'ten %50'ye sadece %5'lik bir büyük ödül oranı var (1 hücre).
            return CELL_TYPE.GRAND_TREASURE;
        } else {
            return CELL_TYPE.EMPTY; //%50'den %99'a hücrelerin yarısı boş olacak bir oran var
        }
    }

    public void printBoardTest() {
        if (head == null) {
            System.out.println("Linked-List is empty.");
        } else {
            Node temp = head;
            int nodeCounter = 1;
            while (temp != null) {
                System.out.println(
                        "Node" + nodeCounter +
                                " ID: " + temp.getId() +
                                " Type: " + temp.getCellType()
                );
                temp = temp.getNextNode();
                nodeCounter++;
            }
        }
    }
}
