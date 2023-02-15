import java.util.ArrayList;

public class User {
	static int userCount = 0;
	private static final int TRUE = 1;
    private static final int FALSE = 0;

	public static User auth = null;
	public static int logged = FALSE;

	static ArrayList<User> users = new ArrayList<User>();
	
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
}