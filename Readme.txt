# Projet ToDoList

Ce projet ToDoList a été lancé mai 2019. Il a pour but de pouvoir offrir à l'utilisateur la possibilité de gérer son emploi du temps. On peut y planifier des tâches ou des choses à faire facilement que l'on ai internet ou non. Cette application est disponible et fonctionne sur téléphone.

## Gide de démarrage 

#### Pour développeur :
Le projet est développé avec **Android Studio** en **Java**.
Pour la partie **graphique**, elle est faite avec du **XML**.
On a une base de donnée en **NoSql**, c'est une **FireBase**. Elle nous permet de pouvoir utiliser l'application en **mode hors ligne** en stockant les données et de pouvoir attendre une reconnexion à internet pour pouvoir les stocker dans cette base de données.

Il faut dans un premier temps avoir **Android Studio** : [https://developer.android.com/studio](https://developer.android.com/studio)
De plus il faut installer cette dépendance sur Andoid Studio : **Android SDK Platform 26**

Voici le lien vers le **Git du projet** : [https://github.com/RemiLou/ToDoList](https://github.com/RemiLou/ToDoList)
Il faut le cloner dans un dossier local à l'aide de ce lien : https://github.com/RemiLou/ToDoList.git
On installe **Git Bash** : [https://gitforwindows.org/](https://gitforwindows.org/)
Et on l'ouvre dans le dossier local et on tape cette commande : 
> clone https://github.com/RemiLou/ToDoList.git

#### Pour utilisateur :
Il faut tout simplement récupérer le fichier APK généré et le transférer sur le téléphone.

Voici un lien vers le dernier APK généré : [https://github.com/RemiLou/ToDoList/blob/master/ToDoList.apk](https://github.com/RemiLou/ToDoList/blob/master/ToDoList.apk)

*L'application sera bientôt disponible sur le Play Store d'android*


## Structure du projet

Le projet se structure de cette façon :
* Model
* Vue

On utilise des Adapter pour retranscrire les tâches.
On a les classes dans le dossier **Java > epsi.fr.applicationtitre** et les vues dans **res > layout**


[Schéma de navigation](https://github.com/RemiLou/ToDoList/blob/master/Capture.PNG)


## Configuration avancée

Pour la gestion de la base de données, il faut envoyer un mail à **remi.loubiou@epsi.fr**.
Un droit d'accès vous sera accordé. Il faudra transmettre le mail avec lequel on veut se connecter à la base de données.
Cette gestion se fait sur [https://console.firebase.google.com/](https://console.firebase.google.com/)
La base de données se trouve dans l'onglet DataBase > RealTime DataBase.
On peut y exporter les données sous différents formats

## Extension personnalisée

Les fonctionnalités prévues sont les suivantes :
		* Pouvoir afficher un emploi du temps complet avec les dates et les jours
		* Pouvoir faire des sous tâches
		* Pouvoir classer par type et par couleur les tâches
		* Pouvoir envoyer une notification lorsqu'on arrive a la même date que la tâche

Il faut se servir de la classe **Task** pour pouvoir manipuler les tâches.
Il faut revoir la partie graphique au niveau de la page qui permet de visionner les tâches. Il se trouve dans le dossier **res > layout > view**.

Si on doit ajouter un module externe, il faut l'utiliser via une classe **Utils**.

## Crédit

Développé par Rémi LOUBIOU
Rédigé par Rémi LOUBIOU
