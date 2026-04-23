# $\color{red}{\text{Projet Analyse de Texte}}$
Projet réalisé dans le cadre du cours de programmation Java orientée Science et Analyse de Données.

## Description du projet
Dans le cadre de ce projet, nous avons développé une application Java capable d’analyser un fichier texte (.txt) afin de compter la fréquence d’apparition de chaque mot. Elle permet de :
- Lire un fichier texte
- Filtrer les mots courants (stopwords)
- Afficher les mots les plus fréquents
- Exporter les résultats dans un fichier externe (`resultats.txt`)

## Architecture globale
Le projet est organisé de manière structurée afin de séparer clairement les différentes responsabilités de l’application. À la racine, on retrouve le dossier principal contenant le code source (src) ainsi que les ressources utilisées. Le point d’entrée du programme se trouve dans la classe Main.java, qui coordonne l’exécution globale.

La lecture des fichiers est gérée dans le package reader, où une interface définit le comportement général et une implémentation permet de lire un fichier texte ligne par ligne. Ensuite, le traitement des mots passe par le package filter, qui contient les composants responsables du filtrage, notamment l’élimination des mots courants (stopwords).

L’analyse des données est centralisée dans le package analyzer, où les mots sont comptés et triés selon leur fréquence. Les résultats obtenus sont ensuite pris en charge par le package writer, qui permet soit de les afficher, soit de les enregistrer dans un fichier.

Enfin, un modèle de données simple est utilisé dans le package model pour stocker les résultats de l’analyse. À côté du code, un dossier ressources regroupe les fichiers nécessaires au fonctionnement du programme, comme le texte à analyser, la liste des mots à ignorer et le fichier de sortie généré automatiquement.

## Le principe SOLID: 
Notre projet respecte les 5 principes SOLID :

| Principe | Application dans le projet |
|----------|---------------------------|
| **S** — Single Responsibility | Chaque classe a un seul rôle (lecture, filtrage, analyse, écriture) |
| **O** — Open/Closed | On peut ajouter de nouvelles implémentations sans modifier le code existant |
| **L** — Liskov Substitution | Chaque classe concrète peut remplacer son interface sans casser le programme |
| **I** — Interface Segregation | Chaque interface contient une seule méthode ciblée |
| **D** — Dependency Inversion | On dépend des interfaces, pas des classes concrètes |

## Le principe de fonctionnement de notre projet : 
Le fonctionnement de l’application suit une série d’étapes bien définies. Tout commence par la lecture du fichier texte.txt à l’aide de la méthode lire() de la classe TexteFichierReader, qui parcourt le fichier ligne par ligne et retourne une liste de chaînes de caractères. Ces lignes sont ensuite transmises à l’analyseur, où la méthode analyser() de FrequenceAnalyseur découpe le texte en mots et nettoie la ponctuation pour faciliter le traitement.

Une fois cette première transformation effectuée, les mots passent par un filtre via StopwordFilter, qui supprime les mots courants comme “le”, “la”, “est” ou “de”, afin de ne garder que les termes pertinents. Les mots filtrés sont ensuite repris par FrequenceAnalyseur, qui compte le nombre d’occurrences de chaque mot, puis les trie selon leur fréquence.

Les résultats obtenus sont encapsulés dans un objet AnalyseResultat, qui regroupe les informations principales comme la fréquence des mots, les mots les plus fréquents et le nombre total de mots analysés. Enfin, ces résultats sont traités par FichierResultatWriter, qui les affiche dans la console et les enregistre automatiquement dans un fichier resultats.txt.
