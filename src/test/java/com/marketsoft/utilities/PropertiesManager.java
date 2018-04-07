package com.marketsoft.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class PropertiesManager {


    InputStream inputStream;

    private String testProperties= "test.properties";
    private String homepageProperties = "homepage.properties";


    public String propertyValue="";


    /*
      METHOD to retrieve value from test property file using key
      PARAMETERs for input are
          String propertyKey specifying the key to be used to retrieve the corresponding value.
      RETURNs String property value
       */
    public String getTestProperties(String propertyKey) throws IOException{

        retrieveProperty(testProperties,propertyKey);

        return propertyValue;

    }

    /*
    METHOD to retrieve value from homepage property file using key
    PARAMETERs for input are
        String propertyKey specifying the key to be used to retrieve the corresponding value.
    RETURNs String property value
     */
    public final String getHomepageProperties(String propertyKey) throws IOException{

        retrieveProperty(homepageProperties, propertyKey);

        return propertyValue;
    }

    public Map<String,String> getHomepageProperties(Map<String,String> m) throws IOException{

        return retrieveProperty(homepageProperties, m);

    }


    /*
    METHOD to retrieve value from specified property file using key
    PARAMETERs for input are
        String propertyfile specifying name of the file to parse
        String propertyKey specifying the key to be used to retrieve the corresponding value.
    SETs the value of the public string propertyValue to the retrieved property
    RETURNs void
     */
    public void retrieveProperty(String propertyFile, String propertyKey) throws IOException {

        try{

            Properties prop = new Properties();

            inputStream = getClass().getClassLoader().getResourceAsStream(propertyFile);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propertyFile + "' not found in the classpath");
            }

            propertyValue = prop.getProperty(propertyKey);
        }
        catch (Exception e){
            System.out.println("Exception: " +e);
        }
        finally {
            inputStream.close();
        }

    }

    public Map<String,String> retrieveProperty(String propertyFile, Map<String, String> m) throws IOException {


        m = new HashMap();


        try{

            Properties prop = new Properties();

            inputStream = getClass().getClassLoader().getResourceAsStream(propertyFile);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propertyFile + "' not found in the classpath");
            }



            for(Map.Entry<Object,Object> entry : prop.entrySet()){
                m.put((String) entry.getKey(),(String)entry.getValue());
            }

//            propertyValue = prop.getProperty(propertyKey);
        }
        catch (Exception e){
            System.out.println("Exception: " +e);
        }
        finally {
            inputStream.close();
        }
        return m;
    }


}
