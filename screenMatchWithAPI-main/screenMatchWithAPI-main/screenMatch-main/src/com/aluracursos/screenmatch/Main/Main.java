package com.aluracursos.screenmatch.Main;
import com.aluracursos.screenmatch.calculos.RecomendationFilter;
import com.aluracursos.screenmatch.calculos.TimeCalculator;
import com.aluracursos.screenmatch.models.Episodes;
import com.aluracursos.screenmatch.models.Movie;
import com.aluracursos.screenmatch.models.Serie;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Movie miMovie = new Movie("The Dark Knight", 2008);
        miMovie.setDurationInMinutes(152);
        miMovie.setIncludedInThePlan(true);

        miMovie.showDataSheet();
        miMovie.evalua(3);
        miMovie.evalua(6);
        miMovie.evalua(10);
        System.out.println(miMovie.getEvaluationsTotal());
        System.out.println("Média de evaluaciones de la película: " +miMovie.calculaMedia());

        Serie breakingBad = new Serie("Breaking Bad", 2008);
        breakingBad.setTemporadas(5);
        breakingBad.setMinutosPorEpisodio(21);
        breakingBad.setEpisodiosPorTemporada(10);
        System.out.println(breakingBad.getDurationInMinutes());
        breakingBad.showDataSheet();

        Movie otherMovie = new Movie("Forrest Gump",1994);
        otherMovie.setDurationInMinutes(178);

        TimeCalculator calculator = new TimeCalculator();
        calculator.incluye(miMovie);
        calculator.incluye(breakingBad);
        calculator.incluye(otherMovie);
        System.out.println("Tiempo necesario para ver todos los titulos de la lista: " +
                calculator.getTotalTime() + " minutos.");

        RecomendationFilter recomendationFilter = new RecomendationFilter();
        recomendationFilter.filtra(miMovie);

        Episodes episodes = new Episodes();
        episodes.setNumber(1);
        episodes.setName("Pilot");
        episodes.setSerie(breakingBad);
        episodes.setTotalVisualizaciones(300);

        recomendationFilter.filtra(episodes);

        var andresMovie = new Movie("Lord of the rings",2001);
        andresMovie.setDurationInMinutes(180);

        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(andresMovie);
        movieList.add(miMovie);
        movieList.add(otherMovie);

        System.out.println("Tamaño de la lista: " + movieList.size());
        System.out.println("La primera pelicula de la lista es: " + movieList.get(0).getName());
        System.out.println("La ultima pelicula de la lista es: " + movieList.get(2).getName());

        System.out.println("toString de la pelicula: " + movieList.get(0).toString());


    }
}
