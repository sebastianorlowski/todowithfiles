/*
Napisz program, który przyjmuje zadania do wykonania. Zadania wyślij do listy, niech uwzględniają czas, co jest do zrobienia i
gdzie, przez kogo. Zadanie zapisuj do pliku z datą kiedy to ma być zrobione.
 */

import java.util.Scanner;

public class main {
    static TaskFile taskFile = TaskFile.getInstance();
    static Validator validator = Validator.getInstance();
    static Operations operations = Operations.getInstance();

    public static void main(String[] args) {
        System.out.println("Witaj w to-do liście!");
        System.out.println("Twoje zadania będą przechowywane w pliku");
        System.out.println("Wpisz odpowiedni numer by wybrać akcję: ");
        while(true) {
            operations.menuTodo();
        }
    }
}
