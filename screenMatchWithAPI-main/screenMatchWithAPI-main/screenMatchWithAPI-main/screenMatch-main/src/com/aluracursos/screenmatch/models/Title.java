package com.aluracursos.screenmatch.models;

import com.aluracursos.screenmatch.exception.conversionErrorinRuntimeException;
import com.google.gson.annotations.SerializedName;

public class Title implements Comparable<Title> {
    @SerializedName("Title")
    private String name;
    @SerializedName("Year")
    private int releaseDate;
    private int durationInMinutes;

    private boolean includedInThePlan;
    private double evaluationsSum; //Se cambia los modificadores de acceso
    private int evaluationsTotal;

    public Title(String name, int releaseDate) {
        this.name = name;
        this.releaseDate = releaseDate;
    }

    public Title(OMDbTitle myOmDbTitle){
        this.name = myOmDbTitle.title();
        this.releaseDate = Integer.valueOf(myOmDbTitle.year());
        if (myOmDbTitle.runtime().contains("N/A")){
            throw new conversionErrorinRuntimeException ("No hay informacion de la duracion de esta pelicula");
        }
        this.durationInMinutes = Integer.valueOf(myOmDbTitle.runtime().
                substring(0,3).replace(" ", ""));
    }

    public void setName(String name) { // Nuevo metodo
        this.name = name;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public void setIncludedInThePlan(boolean includedInThePlan) {
        this.includedInThePlan = includedInThePlan;
    }

    public String getName() {
        return name;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public boolean isIncludedInThePlan() {
        return includedInThePlan;
    }

    public int getEvaluationsTotal(){
        return evaluationsTotal;
    }

    public void showDataSheet(){
        System.out.println("El nombre de la pelicula es: "+ name);
        System.out.println("Su fecha de lanzamiento  fue: "+ releaseDate);
        System.out.println("Duracion en minutos de la pelicula: " + getDurationInMinutes());
    }
    public void evalua(double nota){
        evaluationsSum += nota;
        evaluationsTotal++;
    }
    public double calculaMedia(){
        return evaluationsSum / evaluationsTotal;
    }

    @Override
    public int compareTo(Title otherTitle) {
        return this.getName().compareTo(otherTitle.getName()); // Connected w/ MainWClasses line 42
    }

    @Override
    public String toString() {
        return "Name= " + name + '\'' +
                ", Released= " + releaseDate +
                ", Runtime= " + durationInMinutes;
    }
}
