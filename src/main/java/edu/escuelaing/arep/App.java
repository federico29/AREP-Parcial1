package edu.escuelaing.arep;

import static spark.Spark.*;

import spark.Request;
import spark.Response;

public class App {
    
    public static void main( String[] args ){
        port(getPort());
        get("/hello", (req, res) -> 
                "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h1>Calculadora Trigonometrica</h1>"
                + "<p> Ingrese la funcion trigonometrica y el valor: <br> " 
                + "<form action=\"/respuesta\">"
                + "  Funcion:<br>"
                + "  <input type=\"text\" name=\"data\" >"
                + "  <br>"
                + "  Valor:<br>"
                + "  <input type=\"text\" name=\"value\">"
                + "  <br>"
                + "  <br>"
                + "  <input type=\"submit\" value=\"Calcular\">"
                + "</form>"
                + "</body>"
                + "</html>");
        notFound("<html><body><h1>Error 404: Página no encontrada</h1></body></html>");
    }
    
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set(i.e. on localhost)
    }
}
