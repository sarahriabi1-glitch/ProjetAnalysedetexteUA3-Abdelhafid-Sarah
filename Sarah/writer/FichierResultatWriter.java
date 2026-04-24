package writer;

import model.AnalyseResultat; // Modèle contenant les stats finales

import java.io.BufferedWriter; // Écriture optimisée (mémoire tampon)
import java.io.FileWriter;     // Création/Édition du fichier de sortie
import java.io.IOException;    // Gestion des erreurs d'écriture
import java.util.List;        // Manipulation des listes de mots
import java.util.Map;         // Accès aux couples mot/fréquence


// Classe concrète qui implémente ResultatWriter.
// Principe S un seul rôle : écrire les résultats.
// Principe D dépend de l'interface ResultatWriter.

public class FichierResultatWriter implements ResultatWriter {

    // Affiche les résultats dans la console ET les sauvegarde dans un fichier.
    @Override
    public void ecrire(AnalyseResultat resultat, String cheminFichier) {

        // On récupère les données depuis l'objet AnalyseResultat
        Map<String, Integer> frequenceMots = resultat.getFrequenceMots();
        List<String> motsPlusFrequents = resultat.getMotsPlusFrequents();
        int totalMots = resultat.getTotalMots();


        // Étape 1 : affichage dans la console

        System.out.println("==============================");
        System.out.println("   RÉSULTATS DE L'ANALYSE    ");
        System.out.println("==============================");
        System.out.println("Total de mots : " + totalMots);
        System.out.println("------------------------------");
        System.out.println("Mots les plus fréquents :");

        // On affiche les 10 premiers mots les plus fréquents
        int limite = Math.min(10, motsPlusFrequents.size());
        for (int i = 0; i < limite; i++) {
            String mot = motsPlusFrequents.get(i);
            int freq = frequenceMots.get(mot);
            System.out.println((i + 1) + ". " + mot + " → " + freq + " fois");
        }
        System.out.println("==============================");

        // Étape 2 : sauvegarde dans un fichier (BONUS)

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(cheminFichier))) {

            // l'entête
            bw.write("RÉSULTATS DE L'ANALYSE");
            bw.newLine();
            bw.write("Total de mots : " + totalMots);
            bw.newLine();
            bw.write("------------------------------");
            bw.newLine();
            bw.write("Mots les plus fréquents :");
            bw.newLine();

            // chaque mot et sa fréquence
            for (int i = 0; i < limite; i++) {
                String mot = motsPlusFrequents.get(i);
                int freq = frequenceMots.get(mot);
                bw.write((i + 1) + ". " + mot + " → " + freq + " fois");
                bw.newLine();
            }

            System.out.println("Résultats sauvegardés dans : " + cheminFichier);

        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture : " + e.getMessage());
        }
    }
}