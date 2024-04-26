package com.aluracursos.screenmatch.Main;

import com.aluracursos.screenmatch.exception.conversionErrorinRuntimeException;
import com.aluracursos.screenmatch.models.OMDbTitle;
import com.aluracursos.screenmatch.models.Title;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainWSearch {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        List<Title> titles = new ArrayList<>();
        Gson gson = new GsonBuilder().
                setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE) // Permite recibir mays incluso cuando la clase esta en mins
                .setPrettyPrinting() // Mejor visulizacion del .json
                .create();
        while (true) {
            System.out.println("Escriba el nombre de la pelicula: ");
            var search = lectura.nextLine();

            if (search.equalsIgnoreCase("salir")){
                break;
            }
            String link = "https://www.omdbapi.com/?t=" + search.replace(" ", "+") + "&apikey=33fb69eb";
            try { // Evita que se rompa el programa teniendo en cuenta el error en runtime
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(link))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                System.out.println(json);


                OMDbTitle omDbTitle = gson.fromJson(json, OMDbTitle.class);
                System.out.println(omDbTitle);

                Title miTitle = new Title(omDbTitle);
                System.out.println("Titulo ya convertido: " + miTitle);

                titles.add(miTitle);
            } catch (NumberFormatException e) {
                System.out.println("Error: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error en la URI, verifique la direccion");
            } catch (conversionErrorinRuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(titles);
        FileWriter writer = new FileWriter("movies.json");
        writer.write(gson.toJson(titles));
        writer.close();
        System.out.println("Programa finalizado.");
    }
}
