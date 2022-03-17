import java.util.ArrayList;
import java.util.Scanner;

class Examens {
    String naam;
    int aantalvragen;
    ArrayList<Vraag> vragen;

    //public void getAllExamens(){}

}

class Vraag {
    String vraag;
    boolean antwoord;

    public Vraag(String vraag,boolean antwoord) {
        this.vraag = vraag;
        this.antwoord = antwoord;
    }
}

class Student{
    String naam;
    int nummer;
    ArrayList<Examens> GeslaagdeExamens;
    ArrayList<Examens> NietGeslaagdeExamens;

    static ArrayList<Student> studenten = new ArrayList<>();

    Student(String naam, int nummer, ArrayList<Examens> GeslaagdeExamens,ArrayList<Examens> NietGeslaagdeExamens) {
        this.naam = naam;
        this.nummer = nummer;
        this.GeslaagdeExamens = GeslaagdeExamens;
        this.NietGeslaagdeExamens = NietGeslaagdeExamens;
    }

    public ArrayList<Examens> getGeslaagdeExamens(){
        return GeslaagdeExamens;
    }

    public void createstudent(String naam, int nummer, ArrayList<Examens> GeslaagdeExamens,ArrayList<Examens> NietGeslaagdeExamens){
        studenten.add(new Student(naam,nummer,GeslaagdeExamens,NietGeslaagdeExamens));
    }

    //public void IsStudentGeslaagdVoorExamen(Student student, Examens examen){}
    //public void BesteStudenten(){}
    public static void getAllStudents(){
        for(Student student : studenten) {
            System.out.println(student.naam);
            //yo
        }
    }

}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Examens> vragen = new ArrayList<>();

        System.out.println("Menu");
        System.out.println("1) Lijst met examens");
        System.out.println("2) Lijst met studenten");
        System.out.println("3) Nieuwe student inschrijven");
        System.out.println("4) Student verwijderen");
        System.out.println("5) Examen afnemen");
        System.out.println("6) Is student geslaagd voor test?");
        System.out.println("7) Welke examens heeft student gehaald?");
        System.out.println("8) Welke student heeft de meeste examens gehaald?");
        System.out.println("0) Exit");
        System.out.println("Kies een getal van het menu: ");
        int keuze = scanner.nextInt();
        switch (keuze) {
            case 1 -> System.out.println("Monday");
            case 2 -> Student.getAllStudents();
            default -> System.out.println("Voer een getal van 1 t/m 8 of 0: ");
        }
    }
}
