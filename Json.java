import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Json {

    public static void read() {
        try {
            String jsonStr = new String(Files.readAllBytes(Paths.get("historico_analitico.json")));
            JSONObject jsonObj = new JSONObject(jsonStr);
            Integer currentSemester = jsonObj.getInt("currentSemester");
            JSONArray subjectsArr = jsonObj.getJSONArray("subjects");
            System.out.println("Semestre Atual: " + currentSemester);
            System.out.println("Disciplinas Concluídas:");
            for (int i = 0; i < subjectsArr.length(); i++) {
                JSONObject subjectObj = subjectsArr.getJSONObject(i);
                String subjectName = subjectObj.getString("name");
                String subjectCode = subjectObj.getString("code");
                System.out.println(subjectName + " - " + subjectCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}