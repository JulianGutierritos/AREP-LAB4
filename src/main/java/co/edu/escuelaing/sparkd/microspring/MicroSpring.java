package co.edu.escuelaing.sparkd.microspring;

import java.lang.reflect.Method;

import java.util.Map;

import co.edu.escuelaing.sparkd.httpserver.URIProcessor;

import java.util.HashMap;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MicroSpring implements URIProcessor {

    Map<String, Method> webServices = new HashMap<>();


    public void mapService(String componentName) throws Exception {
        int nMethods = 0;
        for (Method m : Class.forName(componentName).getMethods()) {
            if (m.isAnnotationPresent(RequestMapping.class)) {
                RequestMapping rm = m.getAnnotation(RequestMapping.class);
                webServices.put(rm.value() , m);
                m.invoke(null);
                nMethods++;
            }    
        }
 
        System.out.printf("Number of web services: %d %n", nMethods);
 
    }

    public String executeService(String theurl) {
        try{
            return webServices.get(theurl).invoke(null).toString();
        }catch(Exception e) {
            Logger.getLogger(MicroSpring.class.getName()).log(Level.SEVERE, null, e);
            return "error";
        }

    }

}