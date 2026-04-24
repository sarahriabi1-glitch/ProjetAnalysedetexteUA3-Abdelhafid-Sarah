package analyzer;

import filter.MotFilter;
import model.AnalyseResultat;

import java.util.*;

// Classe concrète qui implémente TexteAnalyseur.
// Principe S un seul rôle : analyser la fréquence des mots.
// Principe D dépend de l'interface MotFilter pas de StopwordFilter directement

public class FrequenceAnalyseur implements TexteAnalyseur {

    private MotFilter filter;

    // Constructeur : on injecte le filtre via l'interface
    public FrequenceAnalyseur(MotFilter filter) {
        this.filter = filter;
    }

    //Analyse les lignes du texte et retourne les fréquences des mots.
    //En param les lignes lues depuis le fichier .txt
    //retourne un objet AnalyseResultat avec toutes les statistiques

    @Override
    public AnalyseResultat analyser(List<String> lignes) {

        // Map qui va stocker mot → nombre d'occurrences
        Map<String, Integer> frequenceMots = new HashMap<>();

        // Liste qui va stocker tous les mots du texte
        List<String> tousLesMots = new ArrayList<>();

        // Étape 1 : on découpe chaque ligne en mots
        for (String ligne : lignes) {

            // split("\\s+") → découpe par les espaces
            String[] mots = ligne.split("\\s+");

            for (String mot : mots) {

                // On nettoie le mot → on enlève la ponctuation  . ! ? 1 2 3 @ # ...
                String motNettoye = mot.replaceAll("[^a-zA-ZÀ-ÿ]", "")
                        .toLowerCase();

                // On ignore les mots vides après nettoyage
                if (!motNettoye.isEmpty()) {
                    tousLesMots.add(motNettoye);
                }
            }
        }

        // Étape 2 : on filtre les stopwords
        List<String> motsFiltres = filter.filtrer(tousLesMots);

        // Étape 3 : on compte les occurrences de chaque mot
        for (String mot : motsFiltres) {
            // getOrDefault → si le mot existe déjà => on ajoute 1
            //                si le mot n'existe pas => on commence à 0
            frequenceMots.put(mot, frequenceMots.getOrDefault(mot, 0) + 1);
        }

        // Étape 4 : on trie les mots par fréquence (du plus au moins fréquent)
        List<String> motsTries = new ArrayList<>(frequenceMots.keySet());
        motsTries.sort((m1, m2) -> frequenceMots.get(m2) - frequenceMots.get(m1));

        // Étape 5 : on retourne l'objet résultat
        return new AnalyseResultat(frequenceMots, motsTries, motsFiltres.size());
    }
}