package model;

import utils.CELL_TYPE;

import java.util.Random;
import java.util.Scanner;

public class Board { //sınıfın amacı, LL yapısıyla oyun tahtasının yapısının kurulması

    private Node head;
    private int linkedListNodeCounter;
    Scanner scanner = new Scanner(System.in);



    public void createBoard(int level) {
        System.out.println("Welcome to the Board! Enter your cell number: ");
        int numOfCells = scanner.nextInt();

        // numOfCells en az 30 olacak şekilde kısıtlıyoruz
        while (numOfCells < 30) {
            System.out.println("Cell number must be at least 30, try again!");
            numOfCells = scanner.nextInt(); // tekrar sayı iste
        }

        System.out.println("Cell number is valid, generating the board!");

        for (int i = 1; i <= numOfCells; i++) {
            CELL_TYPE cellType = randomCellType(level);
            int moveEffect = 0;

            if (cellType == CELL_TYPE.MOVE_EFFECT) {
                Random random = new Random();
                moveEffect = random.nextInt(3) + 1; //1 ila 3 arası bir adım (0 + 1 < x < 2 + 1)

                if (random.nextBoolean()) {
                    moveEffect *= -1; /* tahta üzerinde
                     gelen sayı akdar ileri ya da geri olması için
                     sayıyı %50 ihtimalle negatif yap*/
                }
            }
            Node newNode = new Node(i, cellType, moveEffect); /* gelen moveEffect'i
             parametre olarak düğüm oluştururken kullan*/

            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.getNextNode() != null) {
                    temp = temp.getNextNode();
                }
                temp.setNextNode(newNode); // yeni node'yi parametre almış (42. satır) newNode nesnesiyle oluştur
            }

            linkedListNodeCounter++;
        }
    }


    private CELL_TYPE randomCellType(int level) {
        if (level == 1) {
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
        }else{
            int luckPercentage = (int) (Math.random() * 100);

            if (luckPercentage < 25) {
                return CELL_TYPE.TREASURE;
            } else if (luckPercentage < 40) {
                return CELL_TYPE.TRAP;
            } else if (luckPercentage < 50) {
                return CELL_TYPE.GRAND_TREASURE;
            } else if (luckPercentage < 70) {
                return CELL_TYPE.MOVE_EFFECT;
            } else {
                return CELL_TYPE.EMPTY;
            }
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

    Node getHead() {
        return head;
    }

}
