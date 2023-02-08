import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner (System.in);

        while(true) {
            System.out.print("##--Menu--##\n\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("| Opção 1 - Criar Curso       |\n");
            System.out.print("| Opção 2 - Editar Curso          |\n");
            System.out.print("| Opção 3 - Deletar Curso          |\n");
            System.out.print("| Opção 4 - Criar Disciplina     |\n");
            System.out.print("| Opção 5 - Editar Disciplina          |\n");
            System.out.print("| Opção 6 - Deletar Disciplina          |\n");
            System.out.print("| Opção 7 - Listar Todos Os Cursos     |\n");
            System.out.print("| Opção 8 - Listar Todas As Disciplinas          |\n");
            // System.out.print("| Opção 9 - Listar Disciplinas Pertencentes Ao Curso          |\n");
            System.out.print("| Opção 9 - Sair                            |\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("Digite uma opção: ");

            int opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("\nOpção Criar Curso Selecionada");
                    System.out.print("\nDigite O Nome Do Curso A Ser Criado\n");
                    String nameCourse = input.nextLine();
                    Course.create(nameCourse);
                    break;
                case 2:
                    System.out.print("\nOpção Editar Curso Selecionada\n");

                    System.out.print("\nLista de Cursos:");
                    Course.listAll();

                    System.out.print("\nDigite O Id Do Curso A Ser Editado\n");
                    Integer idCourse = input.nextInt();
                    input.nextLine();
                    Course course = Course.get(idCourse);

                    System.out.print("\nDigite O Novo Nome Do Curso\n");
                    String nameEditCourse = input.nextLine();
                    course.edit(nameEditCourse);
                    break;
                case 3:
                    System.out.print("\nOpção Deletar Curso\n");

                    System.out.print("\nLista de Cursos:");
                    Course.listAll();

                    System.out.print("\nDigite O Id Do Curso A Ser Deletado\n");
                    idCourse = input.nextInt();
                    input.nextLine();
                    course = Course.get(idCourse);
                    course.delete();

                    break;

                case 4:
                    System.out.print("\nOpção Criar Disciplina Selecionada");

                    System.out.print("\nDigite O Nome Da Disciplina A Ser Criada\n");
                    String nameSubject = input.nextLine();
                    String codeSubject = input.nextLine();
                    Subject.create(nameSubject, codeSubject);

                    break;

                case 5:
                    System.out.print("\nOpção Editar Disciplina Selecionada");

                    System.out.print("\nLista de Disciplinas:");
                    Subject.listAll();

                    System.out.print("\nDigite O Id Da Disciplina A Ser Editada\n");
                    Integer idSubject = input.nextInt();
                    input.nextLine();
                    Subject subject = Subject.get(idSubject);

                    System.out.print("\nDigite O Novo Nome e Código Da Disciplina\n");
                    nameSubject = input.nextLine();
                    codeSubject = input.nextLine();

                    subject.edit(nameSubject, codeSubject);

                    break;

                case 6:
                    System.out.print("\nOpção Deletar Disciplina\n");

                    System.out.print("\nLista de Disciplinas:");
                    Subject.listAll();

                    System.out.print("\nDigite O Id Da Disciplina A Ser Deletada\n");
                    idSubject = input.nextInt();
                    input.nextLine();
                    subject = Subject.get(idSubject);
                    subject.delete();

                    break;
                case 7:
                    System.out.print("\nOpção Listar Todos Os Cursos\n");

                    System.out.print("\nLista de Cursos:");
                    Course.listAll();

                    break;
                case 8:
                    System.out.print("\nOpção Listar Todas As Disciplinas\n");

                    System.out.print("\nLista de Disciplinas:");
                    Subject.listAll();

                    break;

                // case 9:
                //     System.out.print("\nOpção Listar Disciplinas Pertencentes Ao Curso\n");

                //     System.out.println("\nDigite o ID do Curso");
                //     Integer courseId = input.nextInt();
                //     input.nextLine();
                //     Course course1 = Course.get(courseId);
                //     course1.listSubjects();

                //     break;

                default:
                    System.out.print("\nOpção Inválida!");
                    break;

                case 9:
                    System.out.print("\nAté logo!");
                    input.close();
            }
        }
    }
}