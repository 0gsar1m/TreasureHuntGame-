package game;

import model.BST;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ScoreLoader {
    public static void loadScores(BST bst) {
        File scoreFile = new File("score.txt");

        // Eğer dosya yoksa hiçbir işlem yapma
        if (!scoreFile.exists()) {
            System.out.println("Score file not found. Proceeding with an empty BST.");
            return;
        }

        // Dosya varsa, veriyi yükleyelim
        try (BufferedReader reader = new BufferedReader(new FileReader("score.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\("); // Adım1: Parantezleri kullanarak parçalayalım
                if (parts.length < 2) continue; // Eğer geçerli formatta değilse geç

                String scoreStr = parts[0].trim(); // Skor kısmı, örneğin "20"
                String playerInfo = parts[1].split("\\)")[0].trim(); // Parantez içindeki kısmı al

                String[] playerParts = playerInfo.split(","); // Ad ve level kısmını ayır
                if (playerParts.length < 2) continue; // Eğer player adı veya level yoksa geç

                int score = Integer.parseInt(scoreStr);
                String playerName = playerParts[0].trim();

                // "level 1" kısmındaki "level " kelimesini temizleyip sadece sayıyı alıyoruz
                String levelStr = playerParts[1].trim().replace("level ", "");
                int level = Integer.parseInt(levelStr);

                // BST'ye ekleyelim
                bst.insert(score, playerName, level);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

