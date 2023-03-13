import java.util.ArrayList;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Course {
    static private Integer courseCount = 0;
    static private ArrayList<Course> courses = new ArrayList<Course>();

    // --- TODAS AS DISCIPLINAS OBRIGATÓRIAS  ---
    public ArrayList<Subject> subjects = new ArrayList<Subject>();

    // --- TODAS AS DISCIPLINAS ELETIVAS ---
    public ArrayList<Subject> optional_subjects = new ArrayList<Subject>();

    public int optionalWorkload;

    

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
                this.name);
    }

    static public void listAll() {
        if (courses.isEmpty()) {
            System.out.println("\nNÃO Há Cursos Cadastrados No Sistema\n");
        }
        Course.courses.forEach(course -> System.out.println(course));
    }

    static public void listAllWithSubjects() {
        System.out.println(courseCount);
        
        Course.courses.forEach(course -> {
            System.out.println(course.optionalWorkload);
            System.out.println(course);
            System.out.println("Disciplinas Obrigatórias: ");
            course.subjects.forEach(subject -> {
                System.out.println(subject);
            });

            System.out.println("Disciplinas Eletivas: ");
            course.optional_subjects.forEach(subject -> {
                System.out.println(subject);
            });
            System.out.println("---------------------------------------------");
        });
    }

    static public Course get(Integer id) {
        return courses.stream().filter(course -> course.id == id).findFirst().get();
    }

    static public Course getByName(String name) {
        return courses.stream().filter(course -> course.name.equals(name)).findFirst().get();
    }

    public void listCourseSubjects() {
        System.out.println("Disciplinas do curso: ");
        this.subjects.forEach(subject -> {
            System.out.println(subject);
        });
        System.out.println("Disciplinas Eletivas do curso: ");
        this.optional_subjects.forEach(subject -> {
            System.out.println(subject);
        });
        System.out.println("---------------------------------------------");
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
        if(subject.optional){
            this.optional_subjects.add(subject);
        }
        else{
            this.subjects.add(subject);
        }
    }
    public void addSubjectById(Integer subjectId) {
        Optional<Subject> subject = Subject.getSubjects().stream().filter(subject1 -> subject1.getId() == subjectId)
                .findFirst();

        if (!subject.isPresent()) {
            System.out.println("Matéria não encontrada");
            return;
        }

        this.subjects.add(subject.get());
    }

    public void removeSubject(Subject subject) {
        this.subjects.remove(subject);
    }

    public void removeSubjectById(Integer subjectId) {
        Optional<Subject> subject = this.subjects.stream().filter(subject1 -> subject1.getId() == subjectId)
                .findFirst();

        if (!subject.isPresent()) {
            System.out.println("Matéria não encontrada");
            return;
        }

        this.subjects.remove(subject.get());
    }

    public static void createCourseFromFile() {
        try {
            String jsonStr = new String(Files.readAllBytes(Paths.get("course.json")));
            JSONObject jsonObj = new JSONObject(jsonStr);

            String courseName = jsonObj.getString("name");
            Course newCourse = new Course(courseName);

            int courseOptionalWorkload = jsonObj.getInt("optional workload");
            newCourse.optionalWorkload = courseOptionalWorkload;

            JSONArray subjectsArr = jsonObj.getJSONArray("subjects");
            for (int i = 0; i < subjectsArr.length(); i++) {
                JSONObject subjectObj = subjectsArr.getJSONObject(i);

                Subject newSubject = new Subject(
                        subjectObj.getString("name"),
                        subjectObj.getString("code"),
                        subjectObj.getInt("semester"),
                        subjectObj.getInt("workload"),
                        subjectObj.getBoolean("optional")
                        );

                JSONArray subjectsArrRequirements = subjectObj.getJSONArray("requirements");

                System.out.print(subjectsArrRequirements);

                // --- ADICIONAR PRE-REQUISITOS ---
                for (int j = 0; j < subjectsArrRequirements.length(); j++) {
                    JSONObject subjectObjRequirements = subjectsArrRequirements.getJSONObject(j);
    
                    Subject newSubjectRequirements = new Subject(
                                subjectObjRequirements.getString("name"),
                                subjectObjRequirements.getString("code")
                            );
                    newSubject.addRequirements(newSubjectRequirements);
                    newSubjectRequirements.save();
                }

                newCourse.addSubject(newSubject);
                newSubject.save();
            }
            courses.add(newCourse);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}