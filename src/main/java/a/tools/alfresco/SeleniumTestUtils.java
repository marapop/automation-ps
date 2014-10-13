package a.tools.alfresco;

import java.io.File;



/**
 * This is a configuration class that switches the environment from "Jenkins" which is a linux machine and "local" which is a Windows machine.
 * This property can be defined at runtime adding "-Dproject.run=local" or "-Dproject.run=jenkins". Default is jenkins.
 * @author vladvoicu
 *
 */
public class SeleniumTestUtils {
    /**
     * Set this to true if you are running locally.
     * 
     */
    private static boolean local = true;
    
    public static String getAbsoluteFilePath(final String filename) {
    	String environment = System.getProperty("project.run");
    	if(environment.contentEquals(Constants.ENVIRONMENT_JENKINS)){
    		local = false;
    	}
    	
        final String absolutePath;
        
        if (local) {
            absolutePath = new File(Constants.TESTDATA_FILES_PATH, filename).getAbsolutePath();
        } else {
            absolutePath =  Constants.PUPPET_TEST_FILES_PATH + filename;
        }
        
        return absolutePath;

    }
    
    public static String getGlobalConfigTargetPath(){
    	String environment = System.getProperty("project.run");
    	String result;
    	
    	if(environment.contentEquals(Constants.ENVIRONMENT_JENKINS)){
    		local = false;
    	}
    	
    	if (!local) {
    		result = "target/test-classes/testdata/global-config.properties";
    	}else{
    		result = "target\\test-classes\\testdata\\global-config.properties";
    	}
    	
    	return result;
    }
    
    public static String getGlobalConfigSRCPath(){
    	String environment = System.getProperty("project.run");
    	String result;
    	
    	if(environment.contentEquals(Constants.ENVIRONMENT_JENKINS)){
    		local = false;
    	}
    	
    	if (!local) {
    		result = "src/test/resources/testdata/global-config.properties";
    	}else{
    		result = "src\\test\\resources\\testdata\\global-config.properties";
    	}
    	
    	return result;
    }
}
