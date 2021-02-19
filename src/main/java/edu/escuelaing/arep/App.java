package edu.escuelaing.arep;

import static spark.Spark.*;

public class App {
    
    public static void main( String[] args ){
        port(getPort());
        get("/", (req, res) -> {
            String valor =  req.queryParams("valor");
            String funcion = req.queryParams("funcion");
            String url= "https://powerful-eyrie-45259.herokuapp.com/?valor="+valor+"&funcion="+funcion;
            return ClienteHttp.getResponse(url);
        });
    }
    
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; 
    }
}
