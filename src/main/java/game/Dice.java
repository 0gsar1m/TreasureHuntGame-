package game;

import java.util.Random;

public class Dice {

    private static Dice instance; //singleton kullanmayı tercih ettik
    private Random randomm; //constructor'da oluşturulan nesneyi Dice nesnesini çağırınca otomatik "randomm" değişkenine atıyoruz

    private Dice() {
        randomm = new Random(); //constructor çağrılınca random nesnesi oluşturulacak
    }

    public static Dice getInstance() {
        if (instance == null) {
            instance = new Dice(); // eğer nesne daha önce oluşturulmadıysa memoryde yeni nesne oluşturualcak
        }
        return instance; // daha önce oluşturulmuşsa memoryden daha önce üretilmiş nesne döndürülecek
    }

    public int rollDice() {
        return randomm.nextInt(6) + 1; //
    }
}
