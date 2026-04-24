import analyzer.FrequenceAnalyseur;
import filter.StopwordFilter;
import model.AnalyseResultat;
import reader.FichierReader;
import reader.TexteFichierReader;
import writer.FichierResultatWriter;
import writer.ResultatWriter;
import analyzer.TexteAnalyseur;

import java.util.List;

// Notre classe principale : assemble toutes les classes et lance le programme.
// Principe D de SOLID : on dépend des interfaces, pas des implémentations.

public class Main {

    public static void main(String[] args) {

        // Étape 1 : définir les chemins des fichiers

        // Le fichier texte à analyser
        String cheminTexte = "Sarah/ressources/texte.txt";

        // Le fichier des stopwords
        String cheminStopwords = "Sarah/ressources/stopwords.txt";

        // Le fichier de sortie pour les résultats
        String cheminResultats = "Sarah/ressources/resultats.txt";


        // Étape 2 : créer les objets via les INTERFACES

        // On crée le reader : lit le fichier texte
        FichierReader reader = new TexteFichierReader();

        // On crée le filtre : charge les stopwords depuis le fichier
        StopwordFilter filter = new StopwordFilter(cheminStopwords);

        // On crée l'analyseur : on lui injecte le filtre
        // Principe D : FrequenceAnalyseur reçoit MotFilter, pas StopwordFilter
        TexteAnalyseur analyseur = new FrequenceAnalyseur(filter);

        // On crée le writer : écrit les résultats
        ResultatWriter writer = new FichierResultatWriter();


        // Étape 3 : lancer le programme

        // On lit le fichier texte : on obtient les lignes
        List<String> lignes = reader.lire(cheminTexte);

        // On vérifie que le fichier n'est pas vide
        if (lignes.isEmpty()) {
            System.out.println("Le fichier texte est vide ou introuvable !");
            return;
        }

        // On analyse les lignes : on obtient les résultats
        AnalyseResultat resultat = analyseur.analyser(lignes);

        // On écrit les résultats : console + fichier
        writer.ecrire(resultat, cheminResultats);
    }
}
