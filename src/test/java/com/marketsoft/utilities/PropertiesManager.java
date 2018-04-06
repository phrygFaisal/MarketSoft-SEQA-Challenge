package com.marketsoft.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {


    InputStream inputStream;

    private String testProperties= "test.properties";


    /*
    READS the test.properties file and extracts the corresponding property key value pair.
    @Param:
        STRING propertyKey points to the property to be extracted
     */
    public String getTestProperties(String propertyKey) throws IOException{

        String propertyValue = "";


        try{
            Properties prop = new Properties();


            inputStream = getClass().getClassLoader().getResourceAsStream(testProperties);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + testProperties + "' not found in the classpath");
            }

            propertyValue = prop.getProperty(propertyValue);
        }
        catch (Exception e){
            System.out.println("Exception: " +e);
        }
        finally {
            inputStream.close();
        }



        return propertyValue;

    }
}
