import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

class Examen {
    String naam;
    int aantalvragen;
    ArrayList<Vraag> alleVragenAK = initialiseerExamenVragenAK();
    ArrayList<Vraag> alleVragenBIO = initialiseerExamenVragenBIO();

    public Examen(String naam, int aantalvragen){
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
    public static void getAllExamen(Examen aardrijkskundeExamen, Examen biologieExamen){
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
            Boolean correct = true;
            while (correct) {
                System.out.println(vraag.vraag);
                antwoordAK = scanner.nextLine();
                if (vraag.antwoord) {
                    checkAntwoordAK = "Ja";
                } else {
                    checkAntwoordAK = "Nee";
                }
                if (antwoordAK.equals(checkAntwoordAK)) {
                    correct = false;
                    counter++;
                }
                if (!antwoordAK.equals(checkAntwoordAK) && (antwoordAK.equals("Ja") || antwoordAK.equals("Nee"))) {
                    correct = false;
                }
            }

        }
        System.out.println("Bij dit examen heb je minimaal 3 goed nodig om een voldoende te halen");
        if (counter >=3){
            System.out.println("Je hebt " + counter + " goed.");
            System.out.println("Dit betekent dat je geslaagd bent voor dit examen");
        }
        else{
            System.out.println("Je hebt " + counter + " goed");
            System.out.println("Dit bekent dat je niet geslaagd ben voor dit examen");
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
            Boolean correct = true;
            while(correct){
                System.out.println(vraag.vraag);
                antwoordBIO = scanner.nextLine();
                if (vraag.antwoord) {
                    checkAntwoordBIO = "Ja";
                } else {
                    checkAntwoordBIO = "Nee";
                }
                if (antwoordBIO.equals(checkAntwoordBIO)) {
                    correct = false;
                    counter++;
                }
                if(!antwoordBIO.equals(checkAntwoordBIO) && (antwoordBIO.equals("Ja") || antwoordBIO.equals("Nee"))){
                    correct = false;
                }
            }
        }
        System.out.println("Bij dit examen heb je minimaal 3 goed nodig om een voldoende te halen");
        if (counter >=3){
            System.out.println("Je hebt " + counter + " goed.");
            System.out.println("Dit betekent dat je geslaagd bent voor dit examen");
        }
        else{
            System.out.println("Je hebt " + counter + " goed");
            System.out.println("Dit bekent dat je niet geslaagd ben voor dit examen");
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
    static int volgendnummer = 973645;
    static ArrayList<Student> allStudents = new ArrayList<Student>();

    Student(String naam) {
        this.naam = naam;
        this.nummer = volgendnummer;
        volgendnummer++;
    }
    public static void createStudent(String name){
        Student newStudent = new Student(name);
        allStudents.add(newStudent);
    }
    public String getName(){
        return this.naam;
    }
    public int getNumber(){
        return this.nummer;
    }
    public static ArrayList<Student> getAllStudents(){
        return allStudents;
    }
}

class Menu extends Main{
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
            case 4 -> case4();
            case 5 -> case5();
            case 6 -> System.out.println(Student.getAllStudents()); //bullshit
            case 7 -> case7();
            case 8 -> System.out.println(Student.getAllStudents()); //bullshit
            default -> {
                System.out.println("Voer een getal van 0 t/m 8: ");
                menu();
            }
        }
        menu();
    }
    public static void case1() {
        //Hier word de huidige lijst van de examens doorgegeven
        Examen.getAllExamen(aardrijkskundeExamen, biologieExamen);
        menu();
    }
    public static void case2() {
        ArrayList<Student> students = Student.getAllStudents();
        students.forEach(student -> {
            System.out.println(student.getNumber() + ") " + student.getName());
        });
        menu();
    }
    public static void case3() {
        System.out.println("Geef de naam van de student:");
        String name = scanner.nextLine();
        Student.createStudent(name);
    }
    public static void case4() {
        System.out.println("Geef het nummer van de student die je wilt verwijderen:");
        int studentennummer = scanner.nextInt();
        for (Student student : Student.allStudents) {
            if (student.nummer == studentennummer) {
                Student.allStudents.remove(student);
                System.out.println("Student verwijderd");
            }
        }

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
            case 1 -> aardrijkskundeExamen.printVragenAK(Examen.initialiseerExamenVragenAK());
            //Wanneer 2 word getypt begint het BIO examen
            case 2 -> biologieExamen.printVragenBIO(Examen.initialiseerExamenVragenBIO());
            default -> System.out.println("Er is geen 1 of 2 getypt. Er word teruggegaan naar het begin van het menu.");
        }
        menu();
    }
    public static void case7() {
        System.out.println("Geef het nummer van de student waarvan je alle geslaagde examens wilt:");
        int studentennummer = scanner.nextInt();
        for (Result result : Result.allResults) {
            if (result.student.nummer == studentennummer) {
                if (result.result) {
                    System.out.println(result.examen.naam);
                }
            }
        }
    }

}

class Result{
    public Student student;
    public Examen examen;
    public boolean result;
    static ArrayList<Result> allResults = new ArrayList<Result>();

    public Result(Student student,Examen examen, boolean result) {
        this.student = student;
        this.examen = examen;
        this.result = result;
    }

    public static void registerResult(Student student, Examen examen, boolean value){
        Result result = new Result(student, examen, value);
        allResults.add(result);
    }

    public static void getResult(Student student, Examen examen){
        allResults.forEach( result -> {
                if(student == result.student && examen == result.examen){
                    if(result.result){
                        System.out.println("Je hebt het examen gehaald");
                    } else {
                        System.out.println("Je hebt het examen niet gehaald");
                    }
                }
            }
        );
    }

//    public Student meestGeslaagdeStudent(){
//        Integer count = 0;
//        Student.getAllStudents().forEach((chosenStudent) -> {
//                    allResults.forEach((chosenResult) -> {
//                        if(chosenResult.student.equals(chosenStudent)){
//                            count++;
//                        }
//                    });
//                }
//        );
//        return winner;
//    }
}

class Main {
    static Scanner scanner = new Scanner(System.in);
    //Hier worden de objecten van de examens aangemaakt
    static Examen aardrijkskundeExamen = new Examen("Aardrijkskunde", 5);
    static Examen biologieExamen = new Examen("Biologie", 5);

    static ArrayList<Examen> examens = new ArrayList<>();

    public static void main(String[] args) {
        // hardcoded studenten toevoegen.
        Student.createStudent("Jeroen");
        Student.createStudent("Pim");

        // hardcoded resultaten:
        var alleStudenten = Student.getAllStudents();
        alleStudenten.forEach(student -> {
            // gehaalde aardrijkskunde examens
            Result.registerResult(student, aardrijkskundeExamen, true);
        });
        alleStudenten.forEach(student -> {
            // niet behaalde biologie examens
            Result.registerResult(student, biologieExamen, false);
        });

        System.out.println("Menu");
        Menu.menu();
    }
}
