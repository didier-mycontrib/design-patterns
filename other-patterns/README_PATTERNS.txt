Builder: sur tp.builder.SimpleMenuBuilder et 
             tp.structure
             tp.builder.TestSimpleMenuBuilder
             
Composite : sur Task , CompositeTask, ...

Flyweight : sur Figurine et décor (tp.decor , tp.decor.DecorMainWindowApp)

Memento   : tp.decor.AbstractFigurine , tp.decor.MyMemento , 
            tp.decor.PanelWithDecor.genererDecorAvecMemento()
            
TemplateMethod : tp.decor.AbstractFigurine.draw()
                 et .dessinerResteDuCorps() sur  AbstractFigurine , FigurineHomme , FigurineFemme           

Mediator : tp.mediator.RetransmitterMediator , tp.mediator.TestMediator
           tp.mediator2...
           
Bridge : tp.bridge           

State  : tp.phone.SmartPhone.alertUser() deleguant à 
         tp.phone.state.PhoneAlertState.alert()
         implémenté via VibratorState.alert() ou bien RingAlarmState.alert()
         selon l'état (le mode)  VIBRATOR ou bien  RING_ALARM 
         Test via tp.phone.TestPhoneState
         
Proxy : citer cas très concrets "reverse_proxy" , "remote_proxy" (proche business_delegate)
        plus exemple tp.proxy.Converter

Interpreter : tp.interpreter.ArbreEvaluationArithmethique (avec main())
              à peu être restructurer un peu ...          

Lien vers autres projets (illustration concrete de pattern):
Adapter (embryon de "bridge") ---> hexagonal
   https://github.com/didier-mycontrib/spring6plus/appliSpringHexagonal

             

                                    