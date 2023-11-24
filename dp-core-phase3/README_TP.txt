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
                                               
