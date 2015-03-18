Plan TP Java EE
===================

Dans l'ensemble des TP, des tests unitaires ou d'intégrations sont donnés aux étudiants : leur travail consiste principalement à écrire le code permettant aux tests de passer.

TP1
-----
Introduction à Groovy.
Cible : tous les étudiants arrivent à l'exercice 5.

> **Note:**

> Il y a 8 exercices mais à partir du 6ème rien ne sera vraiment utilisé dans le cadre des TP Grails.

TP2
-----

- Prise en main de l'IDE
- Création des classes du domaine
- Scaffold dynamique et statique
- Création d'objets dans le Bootstrap.groovy

TP3
-----

- Gestion des relations to-one d'activité vers "propriétaire" de l'activité
- Création d'un service pour la création/modication/suppression d'une activité
- Gestion de la Classe Inscription gérant l'affectation des participants à une activité avec relations one-to-many d'inscription vers utilisateur et d'inscription vers activité
- Complétion du service pour assurer la gestion des inscriptions
- Création d'une situation permettant de vérifier qu'une méthode de services s'exécutent bien dans une transaction; comparer à ce qui se passe dans le Bootstrap.groovy

> **Note**

> La relation many-to-many n'est pas abordée car elle est très rarement utilisée concrètement : on a toujours besoin d'une
information complémentaire dans la table de jointure. Pour l'inscription, la date d'inscription par exemple.


