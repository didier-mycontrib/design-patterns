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

                                           

