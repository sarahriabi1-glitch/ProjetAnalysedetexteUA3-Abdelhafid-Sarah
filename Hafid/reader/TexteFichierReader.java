package reader;

import java.io.BufferedReader; // Lecture efficace du texte (mémoire tampon)
import java.io.FileReader;     // Ouverture du fichier sur le chemin donné
import java.io.IOException;    // Gestion des erreurs d'entrée/sortie
import java.util.ArrayList;   // Liste dynamique (implémentation)
import java.util.List;        // Contrat pour les listes (interface)

// Classe concrète qui implémente FichierReader.
// Principe S de SOLID : lire un fichier .txt ligne par ligne
// Principe D de SOLID : on dépend de l'interface FichierReader

public class TexteFichierReader implements FichierReader {

    //Lit un fichier et retourne toutes ses lignes dans une List.

    @Override
    public List<String> lire(String cheminFichier) {

        // On crée une liste vide qui va stocker les lignes
        List<String> lignes = new ArrayList<>();

        // le try-with-resources ferme automatiquement le fichier après lecture
        try (BufferedReader br = new BufferedReader(new FileReader(cheminFichier))) {

            String ligne;

            // Tant qu'il y a des lignes à lire => on les ajoute à la liste
            while ((ligne = br.readLine()) != null) {
                lignes.add(ligne);
            }

        } catch (IOException e) {
            // Si le fichier n'existe pas ou est illisible => on affiche erreur
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }

        // On retourne la liste complète des lignes
        return lignes;
    }
}