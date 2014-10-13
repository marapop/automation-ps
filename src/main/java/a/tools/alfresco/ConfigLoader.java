package a.tools.alfresco;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



/**
 * This handles the reading of config file properties. Files have the -config.properties suffix
 * @author vladvoicu
 *
 */
public class ConfigLoader {
	
	private static ConfigLoader configLoader;
	public static ConfigLoader getInstance() {
		
		if (configLoader == null) {
			configLoader = new ConfigLoader();
		}

		return configLoader;
	}
	public Properties getProperties(String environment) throws IOException {
		InputStream in = getClass().getResourceAsStream(environment + Constants.PROPERTY_FILE_SUFFIX);
		Properties properties = new Properties();
		properties.load(in);
		in.close();

		return properties;
	}
	
}
