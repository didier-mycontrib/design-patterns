StyleVie = classe regroupant l'association de 3 abstractions complémentaires :
  - SeNourrir, GagnerSaVie ou Travailler , SeDivertir
  
Implementations concrètes en arrière:
  - Alimentation( Homnivore , Vegetarien , ...)
  - Profession (Agriculteur, Informaticien, ...)
  - Loisir ( Ski , Baignade , ...)
  
Et bridge/pont entre les deux :
  - SeNourrirImpl --> Alimentation
  - (GagnerSaVie ou Travailler)Impl --> Profession
  - SeDivertirImpl --> Loisir 
  
A faire en Tp :
  1) modélisation UML
  2) code java et test      