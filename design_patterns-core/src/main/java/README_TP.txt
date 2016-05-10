Préparations préliminaires:
==========================
* lancer si besoin sous eclipse un "maven / update project" pour récupérer les ".jar"
* modifier la valeur de la variable MVN_REPOSITORY du fichier src/main/config/database/set_env.bat
  selon la configuration de l'ordinateur (adapter le chemin selon le système de fichiers)
* lancer le script "create_h2_database.bat" via "open with..." / "system Editor"
* lancer le test unitaire "tp.test.MyAppTest" (dans src/test/java)
* regarder la structure globale du code (tp.entity , tp.dao , ...)

TP1
===
partie A / Singleton
--------------------
Programmer le design pattern "Singleton" sur la classe tp.dao.ProduitDaoFactory
et tester celui-ci en adaptant les méthodes "testSingleton" et "subTestSingleton" de "MyAppTest"

partie B / Factory Method
-------------------------
Programmer le design pattern "factoty method" sur la classe tp.dao.ProduitDaoFactory
et tester celui-ci en adaptant la méthode "setUp" de "MyAppTest"


TP2 Design pattern strategie / DataSource
=========================================
L'objectif du TP2 consiste à "sortir" de la classe "ProduitDaoJdbc" le code de connection à la base de données
de façon à ce que la connexion puisse prendre pluieurs formes différentes (plusieurs STRATEGIES possibles).

Le nouveau composant responsable d'établir la connexion jdbc est de type prédéfini "javax.sql.DataSource"
et "tp.ds.MyJndiDataSource" est une implementation qui ne fonctionne qu'avec un serveur JEE
et "tp.ds.MyParamDataSource" est un début d'implémentation utilisable en test/développement .

La classe "DataSourceFactory" (avec un Singleton) comporte une méthode
de fabrication "getDataSource()" qui tente d'abord la version tp.ds.MyJndiDataSource
et qui se replie vers la version tp.ds.MyParamDataSource si la première ne fonctionne pas.

Les fichiers à modifier (en tenant compte des commentaires) pour le TP2 sont :
* tp.ds.MyParamDataSource.java
* tp.dao.ProduitDaoJdbc.java

