import java.util.ArrayList;

public class User {
	static int userCount = 0;

	static ArrayList<User> users = new ArrayList<User>();
	
	private int id;
	private String name;
	private String username;
	private String password;
	
	private User(String name, String username, String password){
		this.id = ++userCount;;
		this.name = name;
		this.username = username;
		this.password = password; 
	}
	public String toString() {
		return String.format("id:%d | username:%s | nome:%s | password:%s", this.id, this.name, this.username, this.password);
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
	static public void create(String name, String username, String password) {
		User newUser = new User(name, username, password);
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
	public static void main(String[] args) {
		
	}
}