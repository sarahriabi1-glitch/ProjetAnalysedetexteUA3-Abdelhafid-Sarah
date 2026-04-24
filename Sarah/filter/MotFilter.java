package filter;
import java.util.List;

public interface MotFilter {
    // Contart : Reçoit une liste de mots → retourne une liste filtrée
    List<String> filtrer(List<String> mots);
}
