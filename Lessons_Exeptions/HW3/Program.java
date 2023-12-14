import java.util.HashMap;

public class Program {
    public static void main(String[] args) {
        Parsing parsing = new Parsing();
        String file = null;
        WriteToFile writeFile = new WriteToFile();
        HashMap<String, Object> data = parsing.parsingUserInput();
        while (data.size() != 6) { // Ввод данных запускается, пока пользователь не введет нужное количество данных
            try {
                throw new DataException();
            } catch (DataException e) {
                data = parsing.parsingUserInput();
            }
        }

        file = data.get("lastName") + ".txt";
        StringBuilder sb = new StringBuilder();
        for (String str : data.keySet()) {
            sb.append(data.get(str));
            sb.append(" ");
        }

        System.out.println(data);
        String filePath = file;
        writeFile.writeToFile(String.valueOf(sb), filePath);
    }
}
