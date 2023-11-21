import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
public class TaskFileHandler {
    private final String filePath;
    public TaskFileHandler(String filePath) {
        this.filePath = filePath;
    }
    public List<Task> readTasksFromFile() {
        try {
            createFileIfNotExists();
            String jsonContent = Files.readString(Path.of(filePath));
            return new Gson().fromJson(jsonContent, new TypeToken<List<Task>>() {}.getType());
        } catch (IOException e) {
            handleFileException(e);
            return List.of();
        }
    }
    public void writeTasksToFile(List<Task> tasks) {
        try {
            createFileIfNotExists();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonContent = gson.toJson(tasks);
            Files.write(Path.of(filePath), jsonContent.getBytes());
        } catch (IOException e) {
            handleFileException(e);
        }
    }
    private void createFileIfNotExists() throws IOException {
        if (!Files.exists(Path.of(filePath))) {
            Files.createFile(Path.of(filePath));
        }
    }

    private void handleFileException(IOException e) {
        e.printStackTrace();
    }
}
