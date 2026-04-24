# $\color{red}{\text{Projet Analyse de Texte}}$
Projet réalisé dans le cadre du cours de programmation Java orientée Science et Analyse de Données.

## Membres du groupe
- Abdelhafid Al Ahian
- Sarah Riabi

## Description du projet
Dans le cadre de ce projet, nous avons développé une application Java capable d’analyser un fichier texte (.txt) afin de compter la fréquence d’apparition de chaque mot. Elle permet de :
- Lire un fichier texte
- Filtrer les mots courants (stopwords)
- Afficher les mots les plus fréquents
- Exporter les résultats dans un fichier externe (`resultats.txt`)

## Architecture globale
Le projet est organisé de manière structurée afin de séparer clairement les différentes responsabilités de l’application. À la racine, on retrouve le dossier principal contenant le code source ainsi que les ressources utilisées. Le point d’entrée du programme se trouve dans la classe Main.java, qui coordonne l’exécution globale.

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

## Le processus d'implementation :
### Creation des interfaces:
Une fois l'architecture globale de notre projet valider. On a  passer à l'analyse des fonctionnalités demandées dans le sujet, nous avons alors identifié 4 actions distinctes et indépendantes comme suit : lire un fichier en format texte, filtrer les mots, analyser les fréquences et enregistrer les résultats. 

Puisque chaque action a un rôle différent et peut évoluer séparément, nous nous etions mis d'accord sur le fait de créer une interface par action, sans trop charger ni compliquer l'architecture de notre application. 

Ce choix respecte les principes S et I de SOLID — chaque interface a une seule responsabilité et une seule méthode. Il nous offre aussi la flexibilité d'ajouter de nouvelles implémentations dans le futur sans avoir besoin de toucher au code déjà existant, ce qui correspond au principe O.
### Creation des classes: 
Une fois les interfaces mises en place, nous sommes passés à l’implémentation des classes concrètes.
- La classe TexteFichierReader : lit le fichier texte ligne par ligne pour récupérer son contenu.
- La classe StopwordFilter : charge une liste de mots à ignorer depuis un fichier et les garde en mémoire pour les exclure facilement lors de l’analyse.
- La classe FrequenceAnalyseur : traite le texte en le découpant en mots, enlève la ponctuation et compte combien de fois chaque mot apparaît.
- La classe FichierResultatWriter : affiche les résultats à l’écran et les enregistre dans un fichier pour les garder.
- La classe AnalyseResultat : sert à stocker les résultats de l’analyse et à les transporter entre les différentes étapes sans les modifier.
- La classe Main : relie toutes les classes ensemble et lance le programme en suivant trois étapes simples : lire, analyser, écrire.

## Instructions d'exécution
1.Télécharger le projet depuis GitHub sur votre ordinateur en copiant le lien du repository.
2. Ouvrir le projet dans IntelliJ IDEA
3. Lancer `Main.java` → clic droit → Run 'Main'
4. Consulter les résultats :
   - Dans la **console** IntelliJ
   - Dans le fichier **`ressources/resultats.txt`** généré automatiquement
   
## Conclusion: 
Ce projet nous a permis de mettre en pratique les principes fondamentaux de la programmation orientée objet en Java, notamment à travers l'application des principes SOLID. En développant une application d'analyse de texte structurée et modulaire, nous avons appris à séparer les responsabilités, à coder contre des abstractions et à organiser un projet de manière professionnelle.
Au-delà des aspects techniques, ce projet nous a également sensibilisés à l'importance de la phase de conception avant le codage. Définir l'architecture et les interfaces en premier nous a permis de travailler de façon méthodique et d'éviter les erreurs de conception difficiles à corriger par la suite.
Enfin, la gestion du projet via GitHub nous a initiés aux bonnes pratiques de collaboration en équipe, notamment la répartition claire des tâches et le suivi des contributions. L'ensemble de ces apprentissages constitue une base solide pour nos futurs projets de développement Java.
