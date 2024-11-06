package org.example.coleta_de_dados;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.example.classes.Planeta;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class API_Planeta {
    private static final String API = "https://dragonball-api.com/api/planets";

    public List<Planeta> getPlaneta(){
        List<Planeta> planetas = new ArrayList<>();
        try{
            URL url = new URL(API);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                InputStreamReader reader = new InputStreamReader(connection.getInputStream());
                Gson gson = new Gson();

                JsonObject response = gson.fromJson(reader, JsonObject.class);

                JsonArray listaPlaneta = response.getAsJsonArray("items");

                for(JsonElement element : listaPlaneta){
                    JsonObject json = element.getAsJsonObject();

                    Planeta planeta = new Planeta();
                    planeta.setId(json.get("id").getAsInt());
                    planeta.setNome(json.get("name").getAsString());
                    planeta.setDestruido(json.get("isDestroyed").getAsBoolean());
                    planeta.setDescricao(json.get("description").getAsString());

                    planetas.add(planeta);
                }
                reader.close();
            }
            else {
                System.out.println("Erro ao conectar: " + connection.getResponseCode());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return planetas;
    }

}
