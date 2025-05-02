package game;

import model.BST;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ScoreWriter {

    /*public static void writeScoresToFile(BST bst) {
        File scoreFile = new File("score.txt");

        // Eğer dosya yoksa oluşturuluyor
        try {
            if (!scoreFile.exists()) {
                scoreFile.createNewFile(); // Dosya oluşturuluyor
            }

            List<String> existingScores = loadExistingScores();

            // Dosyaya yazmadan önce duplikasyonu engelliyoruz
            try (FileWriter writer = new FileWriter("score.txt")) {
                StringBuilder sb = new StringBuilder();
                bst.getAllScores(bst.getRoot(), sb);  // BST'deki tüm düğümleri alıyoruz

                // Yeni skorları ekliyoruz
                String[] newScores = sb.toString().split("\n");

                // Dosyadaki mevcut verilerle karşılaştırma yaparak yeni skoru yazıyoruz
                for (String newScore : newScores) {
                    if (!existingScores.contains(newScore)) {
                        writer.write(newScore + "\n");  // Yeni skoru yaz
                    }
                }

                // Eski verileri dosyaya yazıyoruz
                for (String existingScore : existingScores) {
                    writer.write(existingScore + "\n");  // Mevcut skoru yaz
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    private static List<String> loadExistingScores() {
        List<String> scores = new ArrayList<>();
        File scoreFile = new File("score.txt");

        // Dosyadan eski verileri okuma
        try (BufferedReader reader = new BufferedReader(new FileReader(scoreFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                scores.add(line);  // Her satırı listeye ekliyoruz
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return scores;
    }

    public static void writeSingleScore(int score, String user, int level) {
        String newLine = score + " (" + user + ", level " + level + ")\n";

        // Dosya yoksa doğrudan yaz
        File f = new File("score.txt");
        if (!f.exists()) {
            try (FileWriter w = new FileWriter(f)) { w.write(newLine); }
            catch (IOException e) { e.printStackTrace(); }
            return;
        }

        // Dosya varsa – aynı satır zaten var mı?
        try (BufferedReader r = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = r.readLine()) != null)
                if (line.equals(newLine.trim())) return;   // duplicate -> yazma
        } catch (IOException e) { e.printStackTrace(); }

        // Ek satır
        try (FileWriter w = new FileWriter(f, true)) { w.write(newLine); }
        catch (IOException e) { e.printStackTrace(); }
    }
}
