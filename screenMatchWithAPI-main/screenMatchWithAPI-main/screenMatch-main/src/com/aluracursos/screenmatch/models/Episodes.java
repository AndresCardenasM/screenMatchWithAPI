package com.aluracursos.screenmatch.models;

import com.aluracursos.screenmatch.calculos.Classification;

public class Episodes implements Classification {
    private int Number;
    private String name;
    private Serie serie;
    private int totalVisualizaciones;

    public int getTotalVisualizaciones() {
        return totalVisualizaciones;
    }

    public void setTotalVisualizaciones(int totalVisualizaciones) {
        this.totalVisualizaciones = totalVisualizaciones;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    @Override
    public int getClassification() {
        if (totalVisualizaciones > 100){
            return 4;
        }else{
            return 2;
        }
    }
}
