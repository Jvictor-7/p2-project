import java.util.ArrayList;

public class Subject {
    static int subjectCounter = 0;

    static private ArrayList<Subject> subjects = new ArrayList<Subject>();

    // --- DISCIPLINAS PRE-REQUISITADAS ---
    public ArrayList<Subject> requirements = new ArrayList<Subject>();

    public Integer id;
    public String name;
    public String code;
    public Integer semester;
    public Integer workload;
    public boolean optional;

    public Subject(String name, String code) {
        this.name = name;
        this.code = code;
        this.id = ++subjectCounter;
    }

    public Subject(String name, String code, Integer semester, Integer workload, boolean optional) {
        this.name = name;
        this.code = code;
        this.semester = semester;
        this.workload = workload;
        this.optional = optional;
        this.id = ++subjectCounter;
    }
    public Subject(String name, String code, Integer semester, Integer workload) {
        this.name = name;
        this.code = code;
        this.semester = semester;
        this.workload = workload;
        this.optional = optional;
        this.id = ++subjectCounter;
    }

    public String toString() {
        return String.format(
                "ID.: %d | Nome.: %s | Código.: %s | Semestre.: %s | Carga Horária.: %s | Eletiva.: %s",
                this.id,
                this.name,
                this.code,
                this.semester,
                this.workload,
                this.optional);
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

    public void addRequirements(Subject subject) {
        this.requirements.add(subject);
    }

    public Integer getId() {
        return this.id;
    }

    static public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void save() {
        subjects.add(this);
    }

    public void edit(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public void delete() {
        subjects.remove(this);
    }
}