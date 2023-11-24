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

TP3 IOC / Injection de dépendance simple (en java)
===============================================================
La liaison entre le DAO (jdbc ou autre) et le composant "DataSource" en version "Param" ou "Jndi"
est maintenant gérée par le design pattern injection de dépendance (alias IOC).
Cette première version simple de "IOC" au niveau du TP3 ressemble un peu à l'esprit "Java Config" de Spring4
Première étape du TP3 = comprendre la nouvelle structure du code:
---------------------------------------------------------------
- certains fichiers de configurations ne sont plus utilisés : 
    produitDao.properties.withoutIoc.txt
- certaines classes (petites fabriques) ne sont plus utilisées:
   ProduitDaoFactory.java.withoutIoc.txt , DataSourceFactory.java.withoutIoc.txt
- la classe ProduitDaoJdbc n'initialise plus le dataSource via DataSourceFactory
- la nouvelle classe MySimpleJavaConfigIOC.txt pourrait être un nouveau coeur ultra simplifié
  de la nouvelle structure/configuration.
  
CEPENDANT, on va directement se baser 
sur un noyau d'injection de dépendances un peu plus sophistiqué:
   - L'annotation @MyInject (proche de @Autowired de spring  , de @Inject de CDI ou de @Resource)
     permet de demander une injection de dépendance automatique
     d'un composant compatible avec le type (souvent une interface)
   - La classe centrale tp.ioc.MyIocBeanFactory correspond à une méga-frabrique IOC (un peu comme spring)
       * Cette classe analyse le fichier beans-ioc.properties pour savoir quelles classes instancier
       * Cette classe analyse le fichier defaults-ioc.properties pour connaître les versions prioritaires
       * Cette classe relie automatiquement tous les composants entre eux 
         en analysant @MyInject
       * Cette classe permet d'accéder aux composants via .getBean(typeSouhaite) 
     

Première étape du TP3
-------------------------------------------------------------------------------------
* regarder (en diagonale) le code de tp.ioc.annot.MyInject
                                  et tp.ioc.MyIocBeanFactory
* analyser l'ensemble du code simple du package tp.ioc.exemple
* analyser les fichiers de configurations beans-ioc.properties et defaults-ioc.properties
* analyser le code de la classe de test CoordinateurTest
* lancer plusieurs fois ce test en effectuant 
  des modifications dans le fichier defaults-ioc.properties


Seconde étape du TP3
---------------------------------
* analyser l'ensemble du code simple du package tp.service
* analyser le code de la classe de test MyAppServiceTestWithIoc
* lancer une première fois ce test (qui échoue tant que le code et la config ne sont pas corrects)
* améliorer le code de tp.service.GestionProduitsImpl
* améliorer la configuration de beans-ioc.properties
* relancer le test MyAppServiceTestWithIoc qui devrait réussir
                                                
TP4: Facade pour ensemble de Services
=====================================

* Coder une facade de services (éventuellement "agnostique vis à vis de IOC") et la tester
  Concrètement : terminer la programmation des classes tp.service.MyFacadeImpl
                                                    et tp.test.MyAppFacadeTest
                                               

