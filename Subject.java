import java.util.ArrayList;

public class Subject {
    static int subjectCounter = 0;

    static private ArrayList<Subject> subjects = new ArrayList<Subject>();

    private Integer id;
    private String name;
    private String code;

    private Subject(String name, String code) {
        this.name = name;
        this.code = code;
        this.id = ++subjectCounter;
    }

    public String toString() {
        return String.format(
            "ID.: %d | Nome.: %s | Código.: %s",
            this.id,
            this.name,
            this.code
        );
    }

    static public void listAll() {
        if (subjects.isEmpty()) {
            System.out.println("\nNÃO Há Disciplinas Cadastradas No Sistema\n");
        }

        Subject.subjects.forEach(subject -> System.out.println(subject));
    }

    static public Subject get(Integer id) {
        return subjects.stream().filter(subject -> subject.id == id).findFirst().get();
    }

    static public void create(String name, String code) {
        Subject newSubject = new Subject(name, code);
        subjects.add(newSubject);
    }

    public void edit(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public void delete() {
        subjects.remove(this);
    }
}