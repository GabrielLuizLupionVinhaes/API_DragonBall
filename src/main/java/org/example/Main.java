package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.example.classes.Personagem;
import org.example.classes.Planeta;
import org.example.coleta_de_dados.API_Personagem;
import org.example.coleta_de_dados.API_Planeta;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        API_Personagem api_personagem = new API_Personagem();
        API_Planeta api_planeta = new API_Planeta();

        List<Personagem> persnagens = api_personagem.getPersonagem();
        List<Planeta> planetas = api_planeta.getPlaneta();

        for (Personagem personagem : persnagens) {
            System.out.println(personagem);
        }
        System.out.println("-------------------------------");
        for (Planeta planeta : planetas) {
            System.out.println(planeta);
        }
    }

}
