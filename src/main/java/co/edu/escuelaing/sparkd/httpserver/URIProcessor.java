package co.edu.escuelaing.sparkd.httpserver; 

public interface URIProcessor{

    public void mapService(String componentName) throws Exception; 

    public String executeService(String theurl);



}


