import java.util.ArrayList;
// import java.util.Optional;

public class Course {
    static private Integer courseCount = 0;
    static private ArrayList<Course> courses = new ArrayList<Course>();
    private ArrayList<Subject> subjects = new ArrayList<Subject>();

    private Integer id;
    private String name;

    private Course(String name) {
        this.name = name;
        this.id = ++courseCount;
    }

    public String toString() {
        return String.format(
            "ID.: %d | Nome.: %s ",
            this.id,
            this.name
        );
    }

    static public void listAll() {
        if (courses.isEmpty()) {
            System.out.println("\nNÃO Há Cursos Cadastrados No Sistema\n");
        }
        Course.courses.forEach(course -> System.out.println(course));
    }

    static public Course get(Integer id) {
        return courses.stream().filter(course -> course.id == id).findFirst().get();
    }

    static public void create(String name) {
        Course newCourse = new Course(name);
        courses.add(newCourse);
    }

    public void edit(String name) {
        this.name = name;
    }

    public void delete() {
        courses.remove(this);
    }

    public void listSubjects() {
        if (subjects.isEmpty()) {
            System.out.println("\nNÃO Há Disciplinas Pertecentens Neste Curso\n");
        }
        this.subjects.forEach(subject -> System.out.println(subject));
    }

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

    public void removeSubject(Subject subject) {
        this.subjects.remove(subject);
    }
}