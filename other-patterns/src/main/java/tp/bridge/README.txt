StyleVie = classe regroupant l'association de 3 abstractions complémentaires :
  - SeNourrir, Occupation , SeFairePlaisir
  
Implementations concrètes en arrière:
  - Alimentation( Omnivore , Vegetarien , ...)
  - Profession (Agriculteur, Informaticien, ...)
  - TachePrivee (FaireMenage, GererEnfants, ...)
  - Loisir ( Ski , Baignade , Lecture, ...)
  
Et bridge/pont entre les deux :
  - SeNourrir --> Alimentation
  - Occupation:
     OccupationPro --> Profession
     OccupationPriv --> TachePriv
  - SeFairePlaisir --> Loisir 
  
A faire en Tp :
  1) éventuelle modélisation UML
  2) analyser code java et test      