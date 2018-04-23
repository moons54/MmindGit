PRESENTATION APPLICATION 

MASTERMIND/ COMBINAISON +et-


Demarrage du jeu :
Lancer Demarrage.java dans package par defaut
l'ensemble de l'application se déroule dans system.output

Deux Applications en une :

Le jeu du plus et du moins : trouver la combinaison secrete à l'aide des indication +/- donnée
Mastermind : recherche d'une combinaison sercrete grace a la reponse donnée bien placé et mal placé. 


Mode de jeu :
Trois modes de jeu disponibles :DEFENSEUR//CHALLENGER//MODE DUEL
Defenseur : L'ordinateur vous demande de trouver sa combinaison secrete

Challenger : vous demander à l'ordinateur de trouver la combinaison secrete

Duel : il s'agit d'un mode tour a tour pour lequel vous devez trouver le code secret avant l'ordinateur.

Niveau de difficulté :

Celui ci est reglable par le biais du fichier parametre 
possibilité dans ce cas de modifier le nombre de case secrete, le nombre d'essais possibles
 
plus spécifiquement pour Mastermind : le nombre de couleur.

point clé Stratégie :

Il est possible de choisir entre deux algorithmes parametrable dans config.properties: 
choix 1 : algorithme de knuth ( permet d'obtenir sur 5 chiffres et 4 boutons le meilleur resultat possible en nombre de coup.
choix 2 : algorithme simple ( permet d'aller au dela de 4 boutons 6 chiffres mais presente plus de coup en dessous de ce seuil.


Indication complementaire concernant config.propertie

nombre de couleur parametrable par nbchiffre
correspond au nombre de couleur dans le jeu mastermind 

nombre de bouton parametrable par taillecode
correspond au nombre de bouton 

nombre de coup parametrable par nbcoup  
il s'agit du nombre de tour par partie




