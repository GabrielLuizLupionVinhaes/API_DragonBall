package org.example.coleta_de_dados;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.example.classes.Personagem;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class API_Personagem {
    private static final String API = "https://dragonball-api.com/api/characters";

    // Metodo para consumir a API e retornar a lista de personagens
    public List<Personagem> getPersonagem() {
        List<Personagem> personagens = new ArrayList<>();
        try {
            // Criação do URL e conexão HTTP
            URL url = new URL(API);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET"); // Requisição GET

            // Verificar o código de resposta HTTP
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // Lê a resposta da API
                InputStreamReader reader = new InputStreamReader(connection.getInputStream());
                Gson gson = new Gson();

                // Converte a resposta JSON em um JsonObject
                JsonObject response = gson.fromJson(reader, JsonObject.class);

                // A resposta contém a chave "items" que é um array de personagens
                JsonArray listaPersonagens = response.getAsJsonArray("items");

                // Itera sobre o array de personagens e cria os objetos Character
                for (JsonElement element : listaPersonagens) {
                    JsonObject json = element.getAsJsonObject();

                    // Criando um objeto Character e populando com os dados da API
                    Personagem personagem = new Personagem();
                    personagem.setId(json.get("id").getAsInt());
                    personagem.setNome(json.get("name").getAsString());
                    personagem.setKi(json.get("ki").getAsString());
                    personagem.setMaxKi(json.get("maxKi").getAsString());
                    personagem.setRaca(json.get("race").getAsString());
                    personagem.setGenero(json.get("gender").getAsString());
                    personagem.setDescricao(json.get("description").getAsString());
                    personagem.setAfiliacao(json.get("affiliation").getAsString());

                    personagens.add(personagem);
                }
                reader.close();
            }
            else {
                System.out.println("Erro ao conectar: " + connection.getResponseCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return personagens;
    }
}
