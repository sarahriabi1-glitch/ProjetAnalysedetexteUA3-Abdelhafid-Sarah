package model;

import java.util.List;
import java.util.Map;

// Comme le rôle de notre class est fixe et qu'il n'y a pas de comportement variable à définir on a pas besoin de creer une interface
// Classe Model : STOCKER les résultats de l'analyse du texte.
// Principe S de SOLID → elle a UN seul rôle : contenir les données.

public class AnalyseResultat {

    // Map qui associe chaque mot à son nombre d'apparitions
    private Map<String, Integer> frequenceMots;

    // Liste des mots triés du plus fréquent au moins fréquent
    private List<String> motsPlusFrequents;

    // Nombre total de mots trouvés dans le fichier texte
    private int totalMots;


    // Constructeur : on passe toutes les données à la création de l'objet.
    // Une fois créé => on ne peut que LIRE l'objet , pas modifier.

    public AnalyseResultat(Map<String, Integer> frequenceMots,
                           List<String> motsPlusFrequents,
                           int totalMots) {
        this.frequenceMots = frequenceMots;
        this.motsPlusFrequents = motsPlusFrequents;
        this.totalMots = totalMots;
    }

    // Retourne la map complète mot
    // Utilisé par l'analyseur et le writer pour afficher les résultats.

    public Map<String, Integer> getFrequenceMots() {
        return frequenceMots;
    }

     // Retourne la liste des mots les plus fréquents (déjà triée).
     // Utilisé pour afficher le classement des mots.

    public List<String> getMotsPlusFrequents() {
        return motsPlusFrequents;
    }


     // Retourne le nombre total de mots dans le texte analysé.
    public int getTotalMots() {
        return totalMots;
    }
}