package tp.ioc;

public class MyIocBeanFactoryWithSpecificConfig extends MyIocBeanFactory{

    @Override
	public void registerSomeSpecificComponents() {
		//this.registerComponent(InterfaceXy.class,new Class1ImplementantInterfaceXy());
		//this.registerComponent(InterfaceXy.class,new Class2ImplementantInterfaceXy());
		
		//registerDefaultAliasForThisQualifier(InterfaceXy.class,"SimpleClassNameOfDeaultImplementation");
	}

		
}
