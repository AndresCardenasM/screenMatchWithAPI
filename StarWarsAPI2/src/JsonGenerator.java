import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class JsonGenerator {
    public void saveJson(Movie movie) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter writer = new FileWriter(movie.title()+".json");
        writer.write(gson.toJson(movie));
        writer.close();
    }
}
