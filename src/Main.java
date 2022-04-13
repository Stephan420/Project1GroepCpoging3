import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

class Examen {
    String naam;
    int aantalvragen;
    ArrayList<Vraag> AlleVragenAK = initialiseerExamenVragenAK();
    ArrayList<Vraag> AlleVragenBIO = initialiseerExamenVragenBIO();

    public Examen(String naam, int aantalvragen){ //dit is de constructor van Examen
        this.naam = naam;
        this.aantalvragen = aantalvragen;
    }

    //Hier word de methode aangemaakt met een arraylist AlleVragenAK waarin de vragen van AK worden aangemaakt en opgeslagen
    //Dit word bovenin de class gekoppelt aan de arraylist AlleVragenAK
    static ArrayList<Vraag>initialiseerExamenVragenAK(){
        ArrayList<Vraag> AlleVragenAK = new ArrayList<>();
        Vraag vraag1AK = new Vraag("Is de aarde plat? Vul in Ja of Nee?", false);
        Vraag vraag2AK = new Vraag("Stoot waterkracht CO2 uit? Vul in Ja of Nee?", false);
        Vraag vraag3AK = new Vraag("Is steenkool een metamorf gesteente? Vul in Ja of Nee?", false);
        Vraag vraag4AK = new Vraag("Stoot biomassa CO2 uit als je het verbrandt? Vul in Ja of Nee?", true);
        Vraag vraag5AK = new Vraag("De langste plaatsnaam ter wereld heet 'Llanfairpwllgwyngyllgogerychwyrndrobwllllantysiliogogogoch' Vul in Ja of Nee?", true);
        AlleVragenAK.add(vraag1AK);
        AlleVragenAK.add(vraag2AK);
        AlleVragenAK.add(vraag3AK);
        AlleVragenAK.add(vraag4AK);
        AlleVragenAK.add(vraag5AK);
        return AlleVragenAK;
    }

    //Hier word de methode aangemaakt met een arraylist AlleVragenBIO waarin de vragen van BIO worden aangemaakt en opgeslagen
    //Dit word bovenin de class gekoppelt aan de arraylist AlleVragenBIO
    static ArrayList<Vraag>initialiseerExamenVragenBIO(){
        ArrayList<Vraag> AlleVragenBIO = new ArrayList<>();
        Vraag vraag1BIO = new Vraag("De hersenen bij mannen zijn groter dan bij vrouwen.  Vul in Ja of Nee?", true);
        Vraag vraag2BIO = new Vraag("De menstruatiecyclus duurt bij een vrouw altijd even lang.  Vul in Ja of Nee?", false);
        Vraag vraag3BIO = new Vraag("De capybara is de 's werelds grootste knaagdier.  Vul in Ja of Nee?", true);
        Vraag vraag4BIO = new Vraag("Een olifant kan springen. Vul in Ja of Nee?",false );
        Vraag vraag5BIO = new Vraag("Een pinguïn kan bijna twee meter hoog in de lucht springen. Vul in Ja of Nee?", true);
        AlleVragenBIO.add(vraag1BIO);
        AlleVragenBIO.add(vraag2BIO);
        AlleVragenBIO.add(vraag3BIO);
        AlleVragenBIO.add(vraag4BIO);
        AlleVragenBIO.add(vraag5BIO);
        return AlleVragenBIO;
    }

    //Hier word de huidige lijst met Examens geprint
    public static void getAllExamen(Examen aardrijkskundeExamen, Examen biologieExamen){
        System.out.println("De lijst met Examens is: ");
        System.out.println(aardrijkskundeExamen.naam);
        System.out.println(biologieExamen.naam);
        System.out.println();
    }

    //Hier word met behulp van een for loop de toets AK afgenomen
    //Elke keer wanneer een antwoord goed is gaat counter omhoog met 1
    public static void printVragenAK(ArrayList<Vraag> AlleVragenAK, Examen aardrijkskunde) {
        Scanner scanner = new Scanner(System.in);
        boolean gevonden = false;
        Student gekozenStudent = new Student(null);
        while(!gevonden){
            System.out.println("Geef je studentnummer op: ");
            int studentnummer = scanner.nextInt();
            scanner.nextLine();
            ArrayList<Student> AlleStudenten = Student.getAlleStudenten();
            for (Student student : AlleStudenten){
                if(student.getNumber() == studentnummer){
                    gekozenStudent = student;
                    gevonden = true;
                }
            }
        }
        String antwoordAK = "";
        String checkAntwoordAK = "";
        int counter = 0;
        for (Vraag vraag : AlleVragenAK) {
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
        System.out.println("Bij dit Examen heb je minimaal 3 goed nodig om een voldoende te halen");
        if (counter >=3){
            System.out.println("Je hebt " + counter + " goed.");
            System.out.println("Dit betekent dat je geslaagd bent voor dit Examen");
            Resultaat.registerResultaat(gekozenStudent, aardrijkskunde, true);
        }
        else{
            System.out.println("Je hebt " + counter + " goed");
            System.out.println("Dit bekent dat je niet geslaagd ben voor dit Examen");
            Resultaat.registerResultaat(gekozenStudent, aardrijkskunde, false);
        }

    }

    //Hier word met behulp van een for loop de toets BIO afgenomen
    //Elke keer wanneer een antwoord goed is gaat counter omhoog met 1
    public static void printVragenBIO(ArrayList<Vraag> AlleVragenBIO, Examen biologie){
        Scanner scanner = new Scanner(System.in);
        boolean gevonden = false;
        Student gekozenStudent = new Student(null);
        while(!gevonden){
            System.out.println("Geef je studentnummer op: ");
            int studentnummer = scanner.nextInt();
            scanner.nextLine();
            ArrayList<Student> AlleStudenten = Student.getAlleStudenten();
            for (Student student : AlleStudenten){
                if(student.getNumber() == studentnummer){
                    gekozenStudent = student;
                    gevonden = true;
                }
            }
        }
        String antwoordBIO = "";
        String checkAntwoordBIO = "";
        int counter = 0;
        for (Vraag vraag : AlleVragenBIO) {
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
        System.out.println("Bij dit Examen heb je minimaal 3 goed nodig om een voldoende te halen");
        if (counter >=3){
            System.out.println("Je hebt " + counter + " goed.");
            System.out.println("Dit betekent dat je geslaagd bent voor dit Examen");
            Resultaat.registerResultaat(gekozenStudent, biologie , true);
        }
        else{
            System.out.println("Je hebt " + counter + " goed");
            System.out.println("Dit bekent dat je niet geslaagd ben voor dit Examen");
            Resultaat.registerResultaat(gekozenStudent, biologie , false);
        }
    }

}

//Dit is de class vraag die word gebruikt bij de class Examen
class Vraag {
    String vraag;
    boolean antwoord;

    public Vraag(String vraag,boolean antwoord) { //dit is de constructor van Vraag
        this.vraag = vraag;
        this.antwoord = antwoord;
    }
}

class Student{
    String naam;
    int nummer;
    static int volgendnummer = 1;
    static ArrayList<Student> AlleStudenten = new ArrayList<Student>();

    Student(String naam) { //dit is de constructor van Student
        this.naam = naam;
        this.nummer = volgendnummer;
        volgendnummer++;
    }
    public static void MaakStudent(String name){ //maakt een student aan en voegt het toe aan de arraylist van allestudenten
        Student newStudent = new Student(name);
        AlleStudenten.add(newStudent);
    }
    public String getName(){
        return this.naam;
    }
    public int getNumber(){
        return this.nummer;
    }
    public static ArrayList<Student> getAlleStudenten(){
        return AlleStudenten;
    }
}

class Menu extends Main{
    public static void menu(){
        System.out.println("1) Lijst met Examens");
        System.out.println("2) Lijst met studenten");
        System.out.println("3) Nieuwe student inschrijven");
        System.out.println("4) Student verwijderen");
        System.out.println("5) Examen afnemen");
        System.out.println("6) Is student geslaagd voor test?");
        System.out.println("7) Welke Examens heeft student gehaald?");
        System.out.println("8) Welke student heeft de meeste Examens gehaald?");
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
            case 6 -> case6();
            case 7 -> case7();
            case 8 -> case8();
            default -> {
                System.out.println("Voer een getal van 0 t/m 8: ");
                menu();
            }
        }
        menu();
    }
    public static void case1() {
        //Hier word de huidige lijst van de Examens doorgegeven
        Examen.getAllExamen(aardrijkskundeExamen, biologieExamen);
        menu();
    }
    public static void case2() {
        ArrayList<Student> Studenten = Student.getAlleStudenten();
        Studenten.forEach(student -> {    //gaat langs alle studenten en print het nummer en de naam
            System.out.println(student.getNumber() + ") " + student.getName());
        });
        menu();
    }
    public static void case3() {
        System.out.println("Geef de naam van de student:");
        String name = scanner.nextLine();
        Student.MaakStudent(name);  //maakt een student aan
    }
    public static void case4() {
        System.out.println("Geef het nummer van de student die je wilt verwijderen:");
        int studentennummer = scanner.nextInt();
        ArrayList<Student> verwijderstudenten = new ArrayList<>(); //maak een arraylist aan van alle studenten die verwijderd gaan worden
        for (Student student : Student.AlleStudenten) { //gaat langs alle studenten
            if (student.getNumber() == studentennummer) { //zoekt door alle studenten voor het ingevoerde nummer
                verwijderstudenten.add(student);  //als de student is gevonden wordt die bij de arraylist van de studenten die verwijderd moeten worden toegevoegd
                System.out.println("Student verwijderd");
            }
        }
        Student.AlleStudenten.removeAll(verwijderstudenten); //verwijderd de student
    }
    public static void case5() {
        //Er word hier een getal gekozen voor het Examen
        System.out.println("Geef het getal van het Examen dat je wilt afnemen: ");
        System.out.println("1. aardrijkskunde");
        System.out.println("2. biologie");
        int ExamenKeuze = scanner.nextInt();
        scanner.nextLine();
        switch (ExamenKeuze){
            //Wanneer 1 word getypt begint het AK Examen
            case 1 -> aardrijkskundeExamen.printVragenAK(Examen.initialiseerExamenVragenAK(), aardrijkskundeExamen);
            //Wanneer 2 word getypt begint het BIO Examen
            case 2 -> biologieExamen.printVragenBIO(Examen.initialiseerExamenVragenBIO(), biologieExamen);
            default -> System.out.println("Er is geen 1 of 2 getypt. Er word teruggegaan naar het begin van het menu.");
        }
        menu();
    }
    public static Student studentnum(int studentennummer) { //zoekt de student van het meegegeven nummer
        for (Student student : Student.AlleStudenten) {
            if (student.nummer == studentennummer) {
                return student;
            }
        }
        return null;
    }
    public static Examen Examen(String naam) {
        if (naam.equals("Biologie")) {
            return biologieExamen;
        }
        else {
            return aardrijkskundeExamen;
        }
    }
    public static void case6() {
        System.out.println("Geef het nummer van de student");
        int studentennummer = scanner.nextInt();
        System.out.println("Geef het Examen");
        scanner.nextLine();
        String Examen = scanner.nextLine();
        Resultaat.getResultaat(studentnum(studentennummer),Examen(Examen)); //checkt of een student een Examen heeft gehaald
    }
    public static void case7() {
        System.out.println("Geef het nummer van de student waarvan je Alle geslaagde Examens wilt:");
        int studentennummer = scanner.nextInt();
        for (Resultaat Resultaat : Resultaat.AlleResultaataten) {
            if (Resultaat.student.nummer == studentennummer) {
                if (Resultaat.Resultaat) {
                    System.out.println(Resultaat.Examen.naam);
                }
            }
        }
    }

    public static void case8(){
        Resultaat.meestGeslaagdeStudent();
    }

}

class Resultaat{
    public Student student;
    public Examen Examen;
    public boolean Resultaat;
    static ArrayList<Resultaat> AlleResultaataten = new ArrayList<Resultaat>();

    public Resultaat(Student student,Examen Examen, boolean Resultaat) {
        this.student = student;
        this.Examen = Examen;
        this.Resultaat = Resultaat;
    }

    public static void registerResultaat(Student student, Examen Examen, boolean value){
        Resultaat Resultaat = new Resultaat(student, Examen, value);
        AlleResultaataten.add(Resultaat);
    }

    public static ArrayList<Resultaat> getAlleResultaataten(){
        return AlleResultaataten;
    }

    public static void getResultaat(Student student, Examen Examen){
        System.out.println(student.naam + " " + Examen.naam);
        AlleResultaataten.forEach( Resultaat -> { //gaat langs alle resultaten en zoekt voor het examen en de student die zijn meegegeven
                if(student == Resultaat.student && Examen == Resultaat.Examen){
                    if(Resultaat.Resultaat){     //hier kijkt die of het resultaat gehaald is
                        System.out.println("Deze student heeft het Examen gehaald");
                    } else {
                        System.out.println("Deze student heeft het Examen niet gehaald");
                    }
                }
            }
        );
    }

    public static void meestGeslaagdeStudent(){
        // set variabelen
        int hoogsteScore = 0;
        int optelNummer = 0;
        Student besteStudent = null;

        ArrayList<Student> studenten = Student.getAlleStudenten();
        ArrayList<Resultaat> Resultaataten = getAlleResultaataten();

        for (Student student : studenten){
            optelNummer = 0;
            for (Resultaat Resultaataat : Resultaataten){
                if (Resultaataat.student.equals(student)){
                    if(Resultaataat.Resultaat){
                        optelNummer++;
                    }
                }
                if (optelNummer >= hoogsteScore) {
                    besteStudent = student;
                }
            }
        }
        System.out.println(besteStudent.getName());
    }
}

class Main {
    static Scanner scanner = new Scanner(System.in);
    //Hier worden de objecten van de Examens aangemaakt
    static Examen aardrijkskundeExamen = new Examen("Aardrijkskunde", 5);
    static Examen biologieExamen = new Examen("Biologie", 5);

    static ArrayList<Examen> Examens = new ArrayList<>();

    public static void main(String[] args) {
        // hardcoded studenten toevoegen.
        Student.MaakStudent("Jeroen");
        Student.MaakStudent("Pim");

        // hardcoded Resultaataten:
        var AlleStudenten = Student.getAlleStudenten();
        AlleStudenten.forEach(student -> {
            // gehaalde aardrijkskunde Examens
            Resultaat.registerResultaat(student, aardrijkskundeExamen, false);
        });
        AlleStudenten.forEach(student -> {
            // niet behaalde biologie Examens
            Resultaat.registerResultaat(student, biologieExamen, true);
        });

        System.out.println("Menu");
        Menu.menu();
    }
}
