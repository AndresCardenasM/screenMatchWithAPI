package com.aluracursos.screenmatch.Main;

import com.aluracursos.screenmatch.models.Title;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainWSearch {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        System.out.println("Escriba el nombre de la pelicula: ");
        var search = lectura.nextLine();

        String link = "https://www.omdbapi.com/?t=" + search + "&apikey=33fb69eb";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(link))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        System.out.println(json);

        Gson gson = new Gson();
        Title miTitle = gson.fromJson(json, Title.class);
        System.out.println(miTitle);
    }
}
