public class Subject {
    static int subjectCounter = 0;

    private Integer id;
    private String name;
    private String code;
    
    public Subject(String name, String code) {
        this.name = name;
        this.code = code;
        this.id = ++subjectCounter;
    }

    public edit(String name, String code) {
        this.name = name;
        this.code = code;   
    }

    public delete(String name, String code) {

    }

    public int getId() {
        return this.id;
    }

}
