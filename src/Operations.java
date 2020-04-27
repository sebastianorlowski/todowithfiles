import java.util.Scanner;

public class Operations {
    static Validator validator = Validator.getInstance();
    static Scanner input = new Scanner(System.in);
    static TaskFile taskFile = TaskFile.getInstance();
    boolean appOn = true;

    private static Operations instance;

    public static Operations getInstance() {
        if(instance == null) {
            instance = new Operations();
        }
        return instance;
    }

    public Operations() {
    }

    public boolean isContinueAddTask(String isContinue) {
        return isContinue.equalsIgnoreCase("y");
    }

    public void menuTodo() {

        System.out.println("1. Dodaj zadanie");
        System.out.println("2. Wyświetl zadania z danego dnia");
        System.out.println("3. Usuń plik z zadaniami");
        System.out.println("4. Zakończ program");
        Integer optionNumber = input.nextInt();
        input.nextLine();
        switch(optionNumber) {
            case 1:
                createTask();
                break;
            case 2:
                System.out.println("Podaj datę (DD.MM.YYYY)");
                String fileName = input.nextLine();
                taskFile.readTaskList(fileName + ".txt");
                break;
            case 3:
                System.out.println("Podaj nazwę pliku (Data)");
                String fileDelete = input.nextLine();
                taskFile.deleteFile(fileDelete);
                break;
            case 4:
                System.exit(0);
        }
    }

    public void createTask() {
        do {
            System.out.println("Data (DD.MM.YYYY)");
            String date = input.nextLine();
            if (validator.checkDateFormat(date)) {
                break;
            } else {

                System.out.println("Czas (HH:MM)");
                String time = input.nextLine();
                if (validator.checkTimeFormat(time)) {
                    break;
                } else {

                    System.out.println("Zadanie ");
                    String task = input.nextLine();

                    System.out.println("Lokalizacja ");
                    String location = input.nextLine();

                    System.out.println("Imię i nazwisko");
                    String user = input.nextLine();

                    Tasks tasks = new Tasks.Builder()
                            .setDate(date)
                            .setTime(time)
                            .setTask(task)
                            .setLocation(location)
                            .setUser(user)
                            .build();
                    System.out.println(tasks.toString());

                    if (validator.fileIsExist(date + ".txt")) {
                        taskFile.setFileName(date + ".txt");
                        taskFile.createTaskToCurrentFile(tasks.toString());

                    }
                    else {
                        taskFile.createFile(date);
                        taskFile.createTask(tasks.toString());

                    }

                    System.out.println("Czy chcesz dodać kolejne zadanie? Y/N");
                    String isContinue = input.nextLine();
                    appOn = isContinueAddTask(isContinue);
                }
            }
        }
            while (appOn) ;
        }
    }

