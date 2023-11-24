package tp.ioc;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import tp.ioc.annot.MyInject;
import tp.util.MyPropertiesUtil;

public  class MyIocBeanFactory {
	
public void registerSomeSpecificComponents() {
	//to  @Override in subclass
}
	
private static MyIocBeanFactory uniqueInstance = null;
	
	public synchronized static MyIocBeanFactory getInstance()
	{
		if(uniqueInstance==null)
		{
			//uniqueInstance=new MyIocBeanFactory();
			uniqueInstance=new MyIocBeanFactoryWithSpecificConfig();
		}
		return uniqueInstance;
	}
	
	public MyIocBeanFactory()	{
		super();
		registerComponentsFromProperties();//selon beans-ioc.properties
		registerSomeSpecificComponents();
		registerDefaultsAliasFromProperties();//selon defaults-ioc.properties
		doNecessaryInjections();
	}
	
	//NB:default qualifier is className or "default" alias (second special name , alias)
    public static final String DEFAULT_ALIAS="DEFAULT_ALIAS";//default alias qualifier
	
	private Map<Class,Map<String,Object>> 
	            mapTypeSubMapQualifierComponent = new HashMap<>();
	
	//utile que si plusieurs versions coexistent et pour préciser celle que l'on veut par defaut
	public void registerDefaultAliasForThisQualifier(Class type,String qualifier) {
		Map<String,Object> subMapQualifierComponent=mapTypeSubMapQualifierComponent.get(type);
		if(subMapQualifierComponent!=null) {
			Object component = subMapQualifierComponent.get(qualifier);
			if(component !=null) {
				subMapQualifierComponent.put(DEFAULT_ALIAS, component);
			}
		}
	}
	

	public void registerComponent(Class type,Object obj) {
		
		Map<String,Object> subMapQualifierComponent=mapTypeSubMapQualifierComponent.get(type);
		if(subMapQualifierComponent==null) {
			subMapQualifierComponent=new HashMap<String,Object>();
			mapTypeSubMapQualifierComponent.put(type, subMapQualifierComponent);
		}
		String qualifier=obj.getClass().getSimpleName();
		subMapQualifierComponent.put(qualifier, obj);
	}
	
	
	
	public <T> T getBean(Class<T> beanClass,String qualifier) {
		Map<String,Object> subMapQualifierComponent=mapTypeSubMapQualifierComponent.get(beanClass);
		if(subMapQualifierComponent==null) return null;
		return (T) subMapQualifierComponent.get(qualifier);
	}
	
	public <T> T getBean(Class<T> beanClass) {
		Map<String,Object> subMapQualifierComponent=mapTypeSubMapQualifierComponent.get(beanClass);
		if(subMapQualifierComponent==null) return null;
		if(subMapQualifierComponent.size()>1) {
		   // return component with DEFAULT_ALIAS of of collection of size>1
		   return (T) subMapQualifierComponent.get(DEFAULT_ALIAS);
		   }
		else {
			//return first of collection of size=1
			return (T) subMapQualifierComponent.values().iterator().next();
		}
	}
	

	public void registerComponentsFromProperties() {
		try {
			Properties props = MyPropertiesUtil.propertiesFromCPRelativePathFile("beans-ioc.properties");
			for( Map.Entry<Object,Object> propEntry : props.entrySet()) {
			   String componentImplClassName=propEntry.getKey().toString();
			   String componentInterfaceName=propEntry.getValue().toString();
			   Class type  = Class.forName(componentInterfaceName);
			   Class componentClass = Class.forName(componentImplClassName);
			   Object componentInstance = componentClass.getDeclaredConstructor().newInstance();
			   registerComponent(type, componentInstance);
			   }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void  registerDefaultsAliasFromProperties(){
		try {
			Properties props = MyPropertiesUtil.propertiesFromCPRelativePathFile("defaults-ioc.properties");
			for( Map.Entry<Object,Object> propEntry : props.entrySet()) {
			   String componentInterfaceName=propEntry.getKey().toString();
			   String componentImplClassName=propEntry.getValue().toString();
			   Class type  = Class.forName(componentInterfaceName);
			   String componentSimpleClassName = Class.forName(componentImplClassName).getSimpleName();
			   registerDefaultAliasForThisQualifier(type,componentSimpleClassName);
			   }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void doNecessaryInjections(){
		for(Map<String,Object> subMapQualifierComponent : mapTypeSubMapQualifierComponent.values()) {
		  for(Map.Entry<String,Object> subMapEntry : subMapQualifierComponent.entrySet() ) {
			if(DEFAULT_ALIAS.equals(subMapEntry.getKey())) continue;
			Object component = subMapQualifierComponent.get(subMapEntry.getKey());
			Class componentExactClass = component.getClass();
			for(Field f : componentExactClass.getDeclaredFields()) {
				MyInject myInjectAnnot = f.getAnnotation(MyInject.class);
				if(myInjectAnnot!=null) {
					//do injection:
					f.setAccessible(true);
					Object referenceToInject= null;
					if(DEFAULT_ALIAS.equals(myInjectAnnot.value())) 
						referenceToInject =  this.getBean(f.getType());//DEFAULT or UNIQUE VERSION
					else
						referenceToInject =  this.getBean(f.getType(),myInjectAnnot.value()); //CHOOSEN VERSION   
					try {
						f.set(component,referenceToInject);
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}//end for(Field f : componentExactClass.getDeclaredFields()) {
		  }//end for(...subMapQualifierComponent.entrySet())
		}//end for(...mapTypeSubMapQualifierComponent.values)
	}

}
