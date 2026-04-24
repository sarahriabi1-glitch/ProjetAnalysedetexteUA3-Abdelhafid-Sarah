package filter;

import java.io.BufferedReader; // Lecture efficace du texte (mémoire tampon)
import java.io.FileReader;     // Ouverture du fichier sur le chemin donné
import java.io.IOException;    // Gestion des erreurs d'entrée/sortie
import java.util.ArrayList;   // Liste dynamique (implémentation de List)
import java.util.HashSet;     // Ensemble d'éléments uniques (implémentation de Set)
import java.util.List;        // Contrat pour les listes (autorise les doublons)
import java.util.Set;         // Contrat pour les ensembles (interdit les doublons)


 // Classe concrète qui implémente MotFilter.
 // Principe S seul rôle : filtrer les stopwords.
 // Principe D on dépend de l'interface MotFilter.

public class StopwordFilter implements MotFilter {

    // Set stocke tous les stopwords chargés depuis le fichier
    // On utilise HashSet => recherche ultra rapide (O(1))
    private Set<String> stopwords;

    // Constructeur : charge les stopwords depuis un fichier.
    public StopwordFilter(String cheminStopwords) {

        // On initialise le Set vide
        stopwords = new HashSet<>();

        // On lit le fichier de stopwords ligne par ligne
        try (BufferedReader br = new BufferedReader(new FileReader(cheminStopwords))) {

            String ligne;
            while ((ligne = br.readLine()) != null) {
                // On met chaque stopword en minuscule pour la comparaison
                stopwords.add(ligne.trim().toLowerCase());
            }

        } catch (IOException e) {
            System.out.println("Fichier stopwords non trouvé : " + e.getMessage());
        }
    }

    // Filtre les stopwords de la liste de mots.
    @Override
    public List<String> filtrer(List<String> mots) {

        // Liste qui va stocker les mots filtrés
        List<String> motsFiltres = new ArrayList<>();

        for (String mot : mots) {
            // Si le mot n'est PAS un stopword → on le garde
            if (!stopwords.contains(mot.toLowerCase())) {
                motsFiltres.add(mot);
            }
        }

        return motsFiltres;
    }
}