package writer;

import model.AnalyseResultat;
// Contrat : Reçoit le résultat + le chemin où sauvegarder, ne retourne rien
public interface ResultatWriter {
    void ecrire(AnalyseResultat resultat, String cheminFichier);
}