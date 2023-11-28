Variante du médiator (V2)
abstract/interface MyEventListener
                        .onEvent(String eventType,Object eventValue);

abstract/interface EventMediator .fireEvent(Object source,String eventType,Object eventValue)
							     .addEventListener(String eventType,MyEventlistener eventListener);
ConcreteEventMediator implements EventMediator
   codant .addEventListener via list<registeredListener>
              ou bien map<eventType,list<registeredListener>>
          .fireEvent balayant list<registeredListener>
            et appelant en boucle .onEvent(String eventType,Object eventValue);

En exemple , LightV2 , ControlV2 , ...            