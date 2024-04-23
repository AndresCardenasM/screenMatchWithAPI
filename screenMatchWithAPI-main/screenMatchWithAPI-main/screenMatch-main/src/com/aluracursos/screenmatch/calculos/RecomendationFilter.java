package com.aluracursos.screenmatch.calculos;

public class RecomendationFilter {
    public void filtra(Classification classification){
        if (classification.getClassification() >=4){
            System.out.println("Con buenas evaluaciones");
        } else if (classification.getClassification()<= 2) {
            System.out.println("Popular en el momento");
        }else {
            System.out.println("Para 'ver mas tarde'");
        }
    }
}
