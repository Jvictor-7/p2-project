import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;


public class User {
	static int userCount = 0;
	private static final int TRUE = 1;
    private static final int FALSE = 0;

	public static User auth = null;
	public static int logged = FALSE;

	static ArrayList<User> users = new ArrayList<User>();

	private int currentSemester;
	private String course;
	public String historic;

	// --- ARRAYLIST DAS DISCIPLINAS PAGAS PELO ALUNO ---
	public ArrayList<Subject> discipline_list = new ArrayList<Subject>();

	private int id;
	public String name;
	public String role;
	public String username;
	public String password;
	
	private User(String name, String role, String username, String password){
		this.id = ++userCount;;
		this.name = name;
		this.role = role;
		this.username = username;
		this.password = password; 
	}
	public String toString() {
		return String.format("id:%d | name:%s | role:%s | usernome:%s | password:%s", this.id, this.name, this.role, this.username, this.password);
	}
	static public void all() {
        if (users.isEmpty()) {
            System.out.println("\nNÃO Há Usuários Cadastrados No Sistema\n");
        }
		users.forEach(user -> System.out.println(user));
	}
	static public User get(Integer id) {
		return users.stream().filter(user -> user.id == id).findFirst().get();
	}
	static public void create(String name, String role, String username, String password) {
		User newUser = new User(name, role, username, password);
		users.add(newUser);
		
	}
	
	public void edit(String name, String username, String password) {
		this.name = name;
		this.username = username;
		this.password = password;
	}
	public void delete() {
		users.remove(this);
	}
	// --- CHECAR AUTENTICAÇÃO ---
	static public int auth_check(String username, String password) {
		// --- SE INFORMAÇÕES CONFERE, return TRUE ---
		for(int i = 0 ; i < users.size(); i++){
            if(users.get(i).username.equals(username) && users.get(i).password.equals(password)){
				User.auth = users.get(i);
				User.logged = TRUE;
				return TRUE;
			}
        }
		// --- SE NÃO, FALSE ---
		return FALSE;
	}

	// -- RECUPERAR SENHA ---
    static public void recuperarSenha(String username){
        for(int i = 0 ; i < users.size(); i++){
            if(users.get(i).username.equals(username)){
                String password = (users.stream().filter(user -> user.username.equals(username)).findFirst().get()).password;
                System.out.print("senha : ");
                System.out.println(password);
                return;
            }
        }
        System.out.print(" Usuário não encontrado!\n");
    }

	public static void historic_read() {
        try {
            String jsonStr = new String(Files.readAllBytes(Paths.get("historico_analitico.json")));
            JSONObject jsonObj = new JSONObject(jsonStr);
                     
            Integer currentSemester = jsonObj.getInt("currentSemester");
            JSONArray subjectsArr = jsonObj.getJSONArray("subjects");
            String course = jsonObj.getString("course");
            
            for (int i = 0; i < subjectsArr.length(); i++) {
                JSONObject subjectObj = subjectsArr.getJSONObject(i);

                Subject aux = new Subject(
					subjectObj.getString("name"),
					subjectObj.getString("code")
					);

				auth.discipline_list.add(aux);
            }
			User.auth.historic = jsonStr;
			User.auth.currentSemester = currentSemester;
			User.auth.course = course;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public void list_historic() {
        if (this.historic == null) {
            System.out.println("\nHistórico não cadastrado\n");
        }
		else{
			try {
				System.out.print(auth.discipline_list);
				FileWriter file = new FileWriter("seu_histórico.json");
				file.write(User.auth.historic);
				file.flush();
				file.close();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
    }

    public void report_generate(){
		File arquivo = new File("relatorio.json");
		try {
			if (!arquivo.exists()) {
				arquivo.createNewFile();
			}
		
			String jsonStr = new String(Files.readAllBytes(Paths.get("test.json")));
			//escreve no arquivo
			FileWriter fw = new FileWriter(arquivo);
			fw.write(jsonStr);
			// bw.newLine();
			// bw.close();
			fw.close();


		} catch (IOException ex) {
			ex.printStackTrace();
		}
 
    }

	
}