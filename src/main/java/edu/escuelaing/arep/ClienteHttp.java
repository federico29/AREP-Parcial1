package edu.escuelaing.arep;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


public class ClienteHttp {

    public static String getResponse(String route) {
        try {
            HttpResponse<String> response = Unirest.get(route).asString();
            return response.getBody();
        } catch (UnirestException ex) {
            Logger.getLogger(ClienteHttp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}