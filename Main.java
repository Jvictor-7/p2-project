import java.util.Scanner;

public class Main {
    public static final int TRUE = 1;
    public static final int FALSE = 0;

    public static void admin_view() {

        Scanner input = new Scanner(System.in);

        while (User.logged == TRUE) {
            System.out.print("\n##--Menu--##\n\n");
            System.out.print("|---------------------------------------------|\n");
            System.out.print("| Opção 1 - Listar Todos Os Cursos            |\n");
            System.out.print("| Opção 2 - Criar Curso                       |\n");
            System.out.print("| Opção 3 - Criar Curso Por Arquivo           |\n");
            System.out.print("| Opção 4 - Editar Curso                      |\n");
            System.out.print("| Opção 5 - Deletar Curso                     |\n");
            System.out.print("| Opção 6 - Listar Todas As Disciplinas       |\n");
            System.out.print("| Opção 7 - Criar Disciplina                  |\n");
            System.out.print("| Opção 8 - Editar Disciplina                 |\n");
            System.out.print("| Opção 9 - Deletar Disciplina                |\n");
            System.out.print("| Opção 10 - Listar Todos Os Usuários         |\n");
            System.out.print("| Opção 11 - Criar Usuário                    |\n");
            System.out.print("| Opção 12 - Editar Usuário                   |\n");
            System.out.print("| Opção 13 - Deletar Usuário                  |\n");
            System.out.print("| Opção 14 - Logout                           |\n");
            System.out.print("|---------------------------------------------|\n");
            System.out.print("Digite uma opção: ");

            int opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("\nOpção Listar Todos Os Cursos\n");
                    System.out.print("\nLista de Cursos:\n");
                    Course.listAllWithSubjects();

                    break;
                case 2:
                    System.out.print("\nOpção Criar Curso Selecionada");
                    System.out.print("\nDigite O Nome Do Curso A Ser Criado\n");
                    String nameCourse = input.nextLine();
                    Course.create(nameCourse);

                    break;
                case 3:
                    System.out.print("\nOpção Criar Curso Por Arquivo\n");
                    System.out.print("\nRenomeie o arquivo para \"course.json\" e pressione ENTER\n");
                    input.nextLine();
                    Course.createCourseFromFile();
                    System.out.println("Curso Adicionado Com Sucesso");

                    break;
                case 4:
                    System.out.print("\nOpção Editar Curso Selecionada\n");

                    System.out.print("\nLista de Cursos:\n");
                    Course.listAll();

                    System.out.print("\nDigite O Id Do Curso A Ser Editado\n");
                    Integer idCourse = input.nextInt();
                    input.nextLine();
                    Course course = Course.get(idCourse);

                    System.out.print("| Opção 1 - Editar Nome do Curso\n");
                    System.out.print("| Opção 2 - Adicionar Matéria\n");
                    System.out.print("| Opção 3 - Remover Matéria\n");
                    System.out.print("| Opção 4 - Sair\n\n");
                    Integer editCourseOption = input.nextInt();
                    input.nextLine();

                    switch (editCourseOption) {
                        case 1:
                            System.out.print("\nDigite O Novo Nome Do Curso\n");
                            String nameEditCourse = input.nextLine();
                            course.edit(nameEditCourse);
                            break;
                        case 2:
                            course.listCourseSubjects();
                            System.out.println("\nDisciplinas no Sistema:");
                            Subject.listAll();
                            System.out.println("Selecione o ID da disciplina a ser adicionada: ");
                            Integer subjectId = input.nextInt();
                            input.nextLine();
                            course.addSubjectById(subjectId);

                            break;
                        case 3:
                            course.listCourseSubjects();
                            System.out.println("Selecione o ID da disciplina a ser removida: ");
                            Integer subjectToRemoveId = input.nextInt();
                            input.nextLine();
                            course.removeSubjectById(subjectToRemoveId);

                            break;
                        default:
                            System.out.println("Nenhuma ação selecionada.");
                    }
                    break;
                case 5:
                    System.out.print("\nOpção Deletar Curso\n");

                    System.out.print("\nLista de Cursos:\n");
                    Course.listAll();

                    System.out.print("\nDigite O Id Do Curso A Ser Deletado\n");
                    idCourse = input.nextInt();
                    input.nextLine();
                    course = Course.get(idCourse);
                    course.delete();

                    break;
                case 6:
                    System.out.print("\nOpção Listar Todas As Disciplinas\n");

                    System.out.print("\nLista de Disciplinas:\n");
                    Subject.listAll();
                    break;
                case 7:
                    System.out.print("\nOpção Criar Disciplina Selecionada");

                    System.out.print("\nDigite O Nome Da Disciplina A Ser Criada\n");
                    String nameSubject = input.nextLine();
                    String codeSubject = input.nextLine();
                    Subject.create(nameSubject, codeSubject);

                    break;
                case 8:
                    System.out.print("\nOpção Editar Disciplina Selecionada");

                    System.out.print("\nLista de Disciplinas:\n");
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
                case 9:
                    System.out.print("\nOpção Deletar Disciplina\n");

                    System.out.print("\nLista de Disciplinas:\n");
                    Subject.listAll();

                    System.out.print("\nDigite O Id Da Disciplina A Ser Deletada\n");
                    idSubject = input.nextInt();
                    input.nextLine();
                    subject = Subject.get(idSubject);
                    subject.delete();

                    break;
                case 10:
                    System.out.print("\nOpção Listar Todos Os Usuários\n");

                    System.out.print("\nLista de Usuários:");
                    User.all();

                    break;
                case 11:
                    System.out.print("\nOpção Criar Usuário Selecionada\n");

                    System.out.println(
                            "Digite as informações do usuário a ser criado no seguinte formato: nome, role, username, senha");
                    String nameUser = input.nextLine();
                    String roleUser = input.nextLine();
                    String username = input.nextLine();
                    String password = input.nextLine();

                    User.create(nameUser, roleUser, username, password);
                    break;
                case 12:
                    System.out.print("\nOpção Editar Usuário Selecionada\n");

                    System.out.print("\nLista de Usuários:\n");
                    User.all();

                    System.out.print("\nDigite O Id Do Usuário A Ser Editado\n");
                    Integer idUser = input.nextInt();
                    input.nextLine();
                    User user = User.get(idUser);

                    System.out.print("\nDigite O Novo Nome, Nickname e Senha do usuário, nessa ordem\n");
                    String nameUser1 = input.nextLine();
                    String nickname1 = input.nextLine();
                    String passwordUser1 = input.nextLine();

                    user.edit(nameUser1, nickname1, passwordUser1);

                    break;
                case 13:
                    System.out.print("\nOpção Deletar Usuário\n");
                    System.out.print("\nLista de Usuários:");
                    User.all();

                    System.out.print("\nDigite O Id Do Curso A Ser Deletado\n");
                    Integer idUser1 = input.nextInt();
                    input.nextLine();
                    User user1 = User.get(idUser1);
                    user1.delete();

                    break;
                case 14:
                    User.logged = FALSE;
                    User.auth = null;
                    input.close();
                    break;

                default:
                    System.out.print("\nOpção Inválida!");
                    break;
            }
        }
    }

    public static void student_view() {
        Scanner input = new Scanner(System.in);

        while (User.logged == TRUE) {
            System.out.print("\n##--Menu--##\n\n");
            System.out.print("|---------------------------------------------|\n");
            System.out.print("| Opção 1 - Aconselhamento                    |\n");
            System.out.print("| Opção 2 - Submeter histórico                |\n");
            System.out.print("| Opção 3 - Ver histórico                     |\n");
            System.out.print("| Opção 4 - Ver Relatório                     |\n");
            System.out.print("| Opção 5 - Logout                            |\n");
            System.out.print("|---------------------------------------------|\n");
            System.out.print("Digite uma opção: ");

            int opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1:
                    System.out.print("\nEM ANDAMENTO...\n");
                    
                    break;
                case 2:
                    System.out.print("\n");
                    System.out.print("--- CONCLUIDO! ---");
                    System.out.print("\n\n");
                    User.historic_read();
                    System.out.print("\n");

                    break;
                case 3:

                    System.out.print("\n");
                    User.auth.list_historic();
                    System.out.print("\n");

                    break;
                case 4:

                    System.out.print("\n");
                    User.auth.report_generate();
                    System.out.print("\n");

                    break;
                case 5:
                    User.logged = FALSE;
                    User.auth = null;
                    input.close();

                    break;
                default:
                    System.out.print("\nOpção Inválida!");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        // --- CRIAR USUÁRIO ADMIN ---
        User.create("Fabiano", "admin", "teste", "teste");
        User.create("Aluno", "aluno", "aluno", "aluno");

        Scanner input2 = new Scanner(System.in);

        int end = FALSE;
        int opcao = 0;

        while (end != TRUE) {
            System.out.print("##--Menu--##\n\n");
            System.out.print("| Opção 1 - Entrar\n");
            System.out.print("| Opção 2 - Esqueci a senha\n");
            System.out.print("| Opção 3 - Sair\n\n");

            opcao = input2.nextInt();
            input2.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("\nDigite o username:\n\n");
                    String usernameAuth = input2.nextLine();
                    System.out.print("\nDigite a senha:\n\n");
                    String passwordAuth = input2.nextLine();

                    // --- SE DADOS CONFEREM, AUTENTICADO ---
                    if (User.auth_check(usernameAuth, passwordAuth) == TRUE) {

                        System.out.print("AUTH SUCCESSFULLY\n\n");

                        if (User.auth.role.equals("admin")) {
                            admin_view();
                        } else {
                            student_view();
                        }

                        System.out.print("Logout.\n\n");
                        
                        end = TRUE;

                    } else {
                        System.out.print("DADOS NÃO CONFEREM\n\n");
                    }

                    break;
                case 2:
                    System.out.print("\noption 2\n\n");
                    System.out.print("\nDigite o username:\n\n");
                    String usernamePassword = input2.nextLine();
                    User.recuperarSenha(usernamePassword);
                    break;

                case 3:
                    System.out.print("\nAté logo!");
                    end = TRUE;
                    input2.close();
                    break;

                default:
                    System.out.print("\nOpção Inválida!");
                    break;
            }
        }    
    }
}