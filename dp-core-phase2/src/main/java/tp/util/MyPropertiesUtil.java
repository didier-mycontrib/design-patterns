package tp.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyPropertiesUtil {
	
	public static Properties propertiesFromCPRelativePathFile(String relativePathFile)
	{
		Properties props = new Properties();
		try {
			InputStream inStream =  Thread.currentThread().getContextClassLoader().getResourceAsStream(relativePathFile);
			props.load(inStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props;
	}
	
	public static String propertyValueFromEntryOfPropertyFile(String relativePathPropertyFile,String propertyName)
	{
		String propValue=null;
		Properties props = propertiesFromCPRelativePathFile(relativePathPropertyFile);
		propValue=props.getProperty(propertyName);
		return propValue;
	}


}
