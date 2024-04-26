package com.aluracursos.screenmatch.calculos;
import com.aluracursos.screenmatch.models.Title;

public class TimeCalculator {
    private int totalTime;
    public void incluye(Title title){
        totalTime += title.getDurationInMinutes();
    }
    public int getTotalTime() {
        return totalTime;
    }
}
