import java.util.ArrayList;
import java.util.Scanner;

class Examens {
    String naam;
    int aantalvragen;
    ArrayList<Vraag> alleVragenAK = initialiseerExamenVragenAK();
    ArrayList<Vraag> alleVragenBIO = initialiseerExamenVragenBIO();


    public Examens(String naam, int aantalvragen){
        this.naam = naam;
        this.aantalvragen = aantalvragen;
    }

    //Hier word de methode aangemaakt met een arraylist alleVragenAK waarin de vragen van AK worden aangemaakt en opgeslagen
    //Dit word bovenin de class gekoppelt aan de arraylist alleVragenAK
    static ArrayList<Vraag>initialiseerExamenVragenAK(){
        ArrayList<Vraag> alleVragenAK = new ArrayList<>();
        Vraag vraag1AK = new Vraag("Is de aarde plat? Vul in Ja of Nee?", false);
        Vraag vraag2AK = new Vraag("Stoot waterkracht CO2 uit? Vul in Ja of Nee?", false);
        Vraag vraag3AK = new Vraag("Is steenkool een metamorf gesteente? Vul in Ja of Nee?", false);
        Vraag vraag4AK = new Vraag("Stoot biomassa CO2 uit als je het verbrandt? Vul in Ja of Nee?", true);
        Vraag vraag5AK = new Vraag("De langste plaatsnaam ter wereld heet 'Llanfairpwllgwyngyllgogerychwyrndrobwllllantysiliogogogoch' Vul in Ja of Nee?", true);
        alleVragenAK.add(vraag1AK);
        alleVragenAK.add(vraag2AK);
        alleVragenAK.add(vraag3AK);
        alleVragenAK.add(vraag4AK);
        alleVragenAK.add(vraag5AK);
        return alleVragenAK;
    }

    //Hier word de methode aangemaakt met een arraylist alleVragenBIO waarin de vragen van BIO worden aangemaakt en opgeslagen
    //Dit word bovenin de class gekoppelt aan de arraylist alleVragenBIO
    static ArrayList<Vraag>initialiseerExamenVragenBIO(){
        ArrayList<Vraag> alleVragenBIO = new ArrayList<>();
        Vraag vraag1BIO = new Vraag("De hersenen bij mannen zijn groter dan bij vrouwen.  Vul in Ja of Nee?", true);
        Vraag vraag2BIO = new Vraag("De menstruatiecyclus duurt bij een vrouw altijd even lang.  Vul in Ja of Nee?", false);
        Vraag vraag3BIO = new Vraag("De capybara is de 's werelds grootste knaagdier.  Vul in Ja of Nee?", true);
        Vraag vraag4BIO = new Vraag("Een olifant kan springen. Vul in Ja of Nee?",false );
        Vraag vraag5BIO = new Vraag("Een pinguïn kan bijna twee meter hoog in de lucht springen. Vul in Ja of Nee?", true);
        alleVragenBIO.add(vraag1BIO);
        alleVragenBIO.add(vraag2BIO);
        alleVragenBIO.add(vraag3BIO);
        alleVragenBIO.add(vraag4BIO);
        alleVragenBIO.add(vraag5BIO);
        return alleVragenBIO;
    }

    //Hier word de huidige lijst met examens geprint
    public static void getAllExamens(Examens aardrijkskundeExamen, Examens biologieExamen){
        System.out.println("De lijst met examens is: ");
        System.out.println(aardrijkskundeExamen.naam);
        System.out.println(biologieExamen.naam);
        System.out.println();
    }

    //Hier word met behulp van een for loop de toets AK afgenomen
    //Elke keer wanneer een antwoord goed is gaat counter omhoog met 1
    public static void printVragenAK(ArrayList<Vraag> alleVragenAK) {
        Scanner scanner = new Scanner(System.in);
        String antwoordAK = "";
        String checkAntwoordAK = "";
        int counter = 0;
        for (Vraag vraag : alleVragenAK) {
            System.out.println(vraag.vraag);
            antwoordAK = scanner.nextLine();
            if (vraag.antwoord) {
                checkAntwoordAK = "Ja";
            } else {
                checkAntwoordAK = "Nee";
            }
            if (antwoordAK.equals(checkAntwoordAK)) {
                counter++;
            }
        }
    }

    //Hier word met behulp van een for loop de toets BIO afgenomen
    //Elke keer wanneer een antwoord goed is gaat counter omhoog met 1
    public static void printVragenBIO(ArrayList<Vraag> alleVragenBIO){
        Scanner scanner = new Scanner(System.in);
        String antwoordBIO = "";
        String checkAntwoordBIO = "";
        int counter = 0;
        for (Vraag vraag : alleVragenBIO) {
            System.out.println(vraag.vraag);
            antwoordBIO = scanner.nextLine();
            if (vraag.antwoord) {
                checkAntwoordBIO = "Ja";
            } else {
                checkAntwoordBIO = "Nee";
            }
            if (antwoordBIO.equals(checkAntwoordBIO)) {
                counter++;
            }
        }
    }

}


//Dit is de class vraag die word gebruikt bij de class examen
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
    static int volgendnummer = 1;
    ArrayList<Examens> GeslaagdeExamens;
    ArrayList<Examens> NietGeslaagdeExamens;

    static ArrayList<Student> studenten = new ArrayList<>();

    Student(String naam, ArrayList<Examens> GeslaagdeExamens,ArrayList<Examens> NietGeslaagdeExamens) {
        this.naam = naam;
        this.nummer = volgendnummer;
        this.GeslaagdeExamens = GeslaagdeExamens;
        this.NietGeslaagdeExamens = NietGeslaagdeExamens;
        volgendnummer = volgendnummer + 1;
    }

    public ArrayList<Examens> getGeslaagdeExamens(){
        return GeslaagdeExamens;
    }

    public static void createstudent(String naam,ArrayList<Examens> GeslaagdeExamens,ArrayList<Examens> NietGeslaagdeExamens){
        studenten.add(new Student(naam,GeslaagdeExamens,NietGeslaagdeExamens));
    }

    //public void IsStudentGeslaagdVoorExamen(Student student, Examens examen){}
    //public void BesteStudenten(){}
    public static ArrayList<Student> getAllStudents(){
        return studenten;
    }

}

class Main {
    static Scanner scanner = new Scanner(System.in);


    //Hier worden de objecten van de examens aangemaakt
    static Examens aardrijkskundeExamen = new Examens("Aardrijkskunde", 5);
    static Examens biologieExamen = new Examens("Biologie", 5);

    static ArrayList<Examens> examens = new ArrayList<>();

    Student Jeroen = new Student("Jeroen",examens,examens);
    Student Pim = new Student("Pim",examens,examens);



    public static void menu(){

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
        scanner.nextLine();



        switch (keuze) {
            case 0 -> System.out.println("Exiting....");
            case 1 -> case1();
            case 2 -> case2();
            case 3 -> case3();
            case 4 -> System.out.println(Student.getAllStudents()); //bullshit
            case 5 -> case5();
            case 6 -> System.out.println(Student.getAllStudents()); //bullshit
            case 7 -> System.out.println(Student.getAllStudents()); //bullshit
            case 8 -> System.out.println(Student.getAllStudents()); //bullshit
            default -> {
                System.out.println("Voer een getal van 0 t/m 8: ");
                menu();
            }
        }
    }
    public static void case1() {
        //Hier word de huidige lijst van de examens doorgegeven
        Examens.getAllExamens(aardrijkskundeExamen, biologieExamen);
        menu();
    }
    public static void case2() {
        if (Student.getAllStudents().size() == 0) {
            System.out.println("Er zijn geen studenten");
        }
        else {
            for (Student students:Student.getAllStudents()) {
                System.out.println(students.naam);
            }
        }
        menu();
    }
    public static void case3() {
        System.out.println("Geef de naam van de student:");
        String naam = scanner.nextLine();
        Student.createstudent(naam,examens,examens);
        //TODO dit nog ff fixen
        System.out.println("Student aangemaakt");
        System.out.println("Naam: " + naam);
        System.out.println("Nummer: " + Student.studenten.get(Student.studenten.size()-1).nummer);
        menu();
    }
    public static void case5() {
        //Er word hier een getal gekozen voor het examen
        System.out.println("Geef het getal van het examen dat je wilt afnemen: ");
        System.out.println("1. aardrijkskunde");
        System.out.println("2. biologie");
        int examenKeuze = scanner.nextInt();
        scanner.nextLine();
        switch (examenKeuze){
            //Wanneer 1 word getypt begint het AK examen
            case 1 -> aardrijkskundeExamen.printVragenAK(Examens.initialiseerExamenVragenAK());
            //Wanneer 2 word getypt begint het BIO examen
            case 2 -> biologieExamen.printVragenBIO(Examens.initialiseerExamenVragenBIO());
        }
        menu();
    }
    public static void main(String[] args) {
        System.out.println("Menu");
        menu();

    }
}
