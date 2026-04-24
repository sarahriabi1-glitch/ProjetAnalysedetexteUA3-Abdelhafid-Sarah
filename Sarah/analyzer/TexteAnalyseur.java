package analyzer;

import model.AnalyseResultat;
import java.util.List;

// Contrat : Prend en entrée les lignes du fichier et retourne un objet AnalyseResultat
public interface TexteAnalyseur {
    AnalyseResultat analyser(List<String> lignes);
}
