package model;

import utils.CELL_TYPE;

public class Node{

    private int id; //düğüm no
    private CELL_TYPE cellType; //düğümün türü
    private Node next; //LL'de sonraki düğüm
    private int moveEffect; //hareket düğümünün operasyonu (+ - ilerleme)


    public Node(int id, CELL_TYPE cellType, int moveEffect) {

        this.id = id;
        this.cellType = cellType;
        this.moveEffect = moveEffect;
        this.next = null; //burayı setNextNode metoduyla atayacağız
    }

    public void setNextNode(Node next) { //Düğümün bağlı olduğu sonraki düğümü set ediyoruz
        this.next = next;
    }

    public Node getNextNode() {
        return next;
    }

    public int getId(){
        return id;
    }

    public CELL_TYPE getCellType(){
        return cellType;
    }

    public int getMoveEffect(){
        return moveEffect;
    }

}
