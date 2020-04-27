import java.io.*;

public class TaskFile {
    String fileName, text;
    FileWriter fileWriter = null;

    private static TaskFile instance;

    public static TaskFile getInstance() {
        if(instance == null) {
            instance = new TaskFile();
        }
        return instance;
    }

    public TaskFile(){
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void createFile(String fileName) {
        try {
            fileWriter = new FileWriter(fileName + ".txt");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createTaskToCurrentFile(String task) {
        fileName = getFileName();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
            PrintWriter printWriter = new PrintWriter(fileOutputStream);
            printWriter.write(System.lineSeparator());
            printWriter.write(task);
            printWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createTask(String task) {
        fileName = getFileName();
        try {
            fileWriter.write(task);
            fileWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteFile(String fileName) {
        File file = new File("C:\\Users\\Steve Williams\\IdeaProjects\\TodoList\\" + fileName + ".txt");
        if(file.delete()) {
            System.out.println("Plik został usunięty");
        }
        else {
            System.out.println("Nie usunięto pliku, wpisz poprawną nazwę pliku(data)");
        }
    }

    public void readTaskList(String data) {
        try {
            FileReader fileReader = new FileReader(data);
            BufferedReader reader = new BufferedReader(fileReader);
            String readOneLine = reader.readLine();
            while(readOneLine != null) {
                System.out.println(readOneLine);
                readOneLine = reader.readLine();
            }
            fileReader.close();
            reader.close();
        }
        catch (IOException e) {
            System.out.println("Taki plik nie istnieje!");
        }
    }
}
