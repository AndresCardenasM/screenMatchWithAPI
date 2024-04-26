package com.aluracursos.screenmatch.models;
//When Movie was moved to a new package, set access modifier (public,private)

import com.aluracursos.screenmatch.calculos.Classification;

public class Movie extends Title implements Classification {
    private  String director;

    public Movie(String name, int releaseDate) {
        super(name, releaseDate);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getClassification() {
        return (int) (calculaMedia() / 2);
    }

    @Override
    public String toString() {
        return "Pelicula: " + this.getName() + "(" + getReleaseDate() +")";
    }
}
