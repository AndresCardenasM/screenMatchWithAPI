package com.aluracursos.screenmatch.Main;
import com.aluracursos.screenmatch.models.Movie;
import com.aluracursos.screenmatch.models.Serie;
import com.aluracursos.screenmatch.models.Title;

import java.util.*;

public class MainWClasses {
    public static void main(String[] args) {
        Movie miMovie = new Movie("The Dark Knight ", 2008);
        Movie otherMovie = new Movie("Forrest Gump ",1994);
        var andresMovie = new Movie("Lord of the rings ",2001);
        Serie breakingBad = new Serie("Breaking Bad ", 2008);
        miMovie.evalua(8);

        List<Title> list = new ArrayList<>();
        list.add(miMovie);
        list.add(otherMovie);
        list.add(andresMovie);
        list.add(breakingBad);

        for (Title item:list){
            System.out.println(item.getName());
            if (item instanceof  Movie movie && movie.getClassification() >3 ){
                System.out.println(movie.getClassification());
            }
        }

        List<String>artistList = new ArrayList<>();
        artistList.add("Serj Tankian");
        artistList.add("Chester Bennington");
        artistList.add("Eminem");
        System.out.println("Lista de artistas NO ordenada: " + artistList);

        Collections.sort(artistList);
        System.out.println("Lista de artistas organizada: " + artistList);

        Collections.sort(list);
        System.out.println("Lista de los titulos organizada: " + list);

        list.sort(Comparator.comparing(Title::getReleaseDate));
        System.out.println("Lista ordenada por fecha de lanzamiento: " + list);

    }
}
