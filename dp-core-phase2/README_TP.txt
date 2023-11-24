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
