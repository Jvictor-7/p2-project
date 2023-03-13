import java.util.ArrayList;

public class AG extends Population{
    private ArrayList<ArrayList<Subject>> population = new ArrayList<ArrayList<Subject>>();
    private ArrayList<ArrayList<Subject>> children = new ArrayList<ArrayList<Subject>>();

    private ArrayList<Integer> fitness = new ArrayList<Integer>();
    
    static int POP_MAX = 10;
    static int POP_SIZE = 0;
    static int DESC_SIZE = 0;
    static int CROSS_RATE = 70;
    static int MUT_RATE = 95;

    static int MAX_LOOPS = 10000;

    private Population init_pop(Population population){
        Course course = Course.getByName(User.auth.course);
        course.listCourseSubjects();
        return population;
    }

    public void start() {
        // --- INICIAR POPULAÇÃO ---
        Population population = new Population();
        population.generation = 0;
        population = init_pop(population);
 
        // ---

        // --- CALCULAR ADAPTAÇÃO ---

        //---

        // --- ORDENAR POPULAÇÃO ---

        // ---

        while(generation < MAX_LOOPS){
            break;
        }
    }
}
