## Ce que j'ai mis en place: 
- Interface TexteAnalyseur et classe FrequenceAnalyseur : nettoie le texte, compte les occurrences de chaque mot et les trie du plus fréquent au moins fréquent.
- Classe StopwordFilter : filtre les mots courants comme "le" ou "de" avant l'analyse pour éviter qu'ils ne faussent les résultats.
- Classe FichierResultatWriter : affiche le top 10 des mots les plus fréquents dans la console et sauvegarde les résultats dans resultats.txt.
- Dossier ressources : contient stopwords.txt et texte.txt pour tester le programme.
