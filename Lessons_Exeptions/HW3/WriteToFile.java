import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public void writeToFile(String data, String path){
        System.out.println(path);
        System.out.println(path.getClass().getSimpleName());
        try(FileWriter file = new FileWriter(path, true)) {
            file.append(data);
            file.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
