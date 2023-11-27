Builder: sur tp.builder.SimpleMenuBuilder et 
             tp.structure
             tp.builder.TestSimpleMenuBuilder
             
A ajouter (selon temps disponible):

Composite : sur Task , CompositeTask, ...
Flyweight : sur Figurine et décor
Memento   : complément sur Figurine

Mediator : sur Restransmetteur entre commande et lumière(s)

State  : sur SmartPhone.alert() deleguant à VibratorState.alert() ou RingAlarmState.alert()
         selon l'état "Vibrator" , "Silent" , "Ring"
Proxy : pas de code java , mais cas très concret "reverse_proxy"
Interpreter : eventuel interpréteur basic addition(a,b) , NumberVar(varName) avec Map<varName,varValue>
              in contetxt             

Lien vers autres projets (illustration concrete de pattern):
Adapter (embryon de "bridge") ---> hexagonal
   https://github.com/didier-mycontrib/spring6plus/appliSpringHexagonal

             

                                    