import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reading = new Scanner(System.in);
        System.out.println("""
                **************************************************
                Chose the Star Wars movie you want to consult:
                                    
                1- "A new hope"
                2- "The Empire Strikes Back"
                3- "Return of the Jedi"
                4- "The Phantom Menace"
                5- "Attack of the Clones"
                6- "Revenge of the Sith"
                7- "The Force Awakens"
                                    
                **************************************************
                """);

        MovieConsult consult = new MovieConsult();
        try {
            var movieNumber = Integer.valueOf(reading.nextLine());
            Movie movie = consult.MovieSearch(movieNumber);
            System.out.println(movie);
            JsonGenerator generator = new JsonGenerator();
            generator.saveJson(movie);
        } catch (NumberFormatException e) {
            System.out.println("Opcion de pelicula no valida " + e.getMessage());
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Busqueda finalizada");
        }
    }
}