StyleVie = classe regroupant l'association de 3 abstractions complémentaires :
  - SeNourrir, Travailler , SeFairePlaisir
  
Implementations concrètes en arrière:
  - Alimentation( Omnivore , Vegetarien , ...)
  - Profession (Agriculteur, Informaticien, ...)
  - Loisir ( Ski , Baignade , ...)
  
Et bridge/pont entre les deux :
  - SeNourrirImpl --> Alimentation
  - (Travailler ou GagnerSaVie)Impl --> Profession
  - SeFairePlaisirImpl --> Loisir 
  
A faire en Tp :
  1) modélisation UML
  2) code java et test      