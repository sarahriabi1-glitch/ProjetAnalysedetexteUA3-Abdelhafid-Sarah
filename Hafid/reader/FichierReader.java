package reader;
import java.util.List;

public interface FichierReader {
    // Contrat : On retourne une liste de lignes du fichier - prend le chemin du fichier en parametre
    List<String> lire(String cheminFichier);
}
