import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

class Examen {
    String naam;
    int aantalvragen;
//    ArrayList<Vraag> alleVragenAK = initialiseerExamenVragenAK();
//    ArrayList<Vraag> alleVragenBIO = initialiseerExamenVragenBIO();
    //Hier worden de objecten van de examens aangemaakt
    static Examen aardrijkskundeExamen = new Examen("Aardrijkskunde", 5);
    static Examen biologieExamen = new Examen("Biologie", 5);

    public Examen(String naam, int aantalvragen) {
        this.naam = naam;
        this.aantalvragen = aantalvragen;
    }

    @Override
    public String toString() {
        return "Examen{" +
                "naam='" + naam + '\'' +
                ", aantalvragen=" + aantalvragen +
                '}';
    }

    //Hier word de methode aangemaakt met een arraylist alleVragenAK waarin de vragen van AK worden aangemaakt en opgeslagen
    //Dit word bovenin de class gekoppelt aan de arraylist alleVragenAK
    static ArrayList<Vraag> initialiseerExamenVragenAK() {
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
    static ArrayList<Vraag> initialiseerExamenVragenBIO() {
        ArrayList<Vraag> alleVragenBIO = new ArrayList<>();
        Vraag vraag1BIO = new Vraag("De hersenen bij mannen zijn groter dan bij vrouwen.  Vul in Ja of Nee?", true);
        Vraag vraag2BIO = new Vraag("De menstruatiecyclus duurt bij een vrouw altijd even lang.  Vul in Ja of Nee?", false);
        Vraag vraag3BIO = new Vraag("De capybara is de 's werelds grootste knaagdier.  Vul in Ja of Nee?", true);
        Vraag vraag4BIO = new Vraag("Een olifant kan springen. Vul in Ja of Nee?", false);
        Vraag vraag5BIO = new Vraag("Een pinguïn kan bijna twee meter hoog in de lucht springen. Vul in Ja of Nee?", true);
        alleVragenBIO.add(vraag1BIO);
        alleVragenBIO.add(vraag2BIO);
        alleVragenBIO.add(vraag3BIO);
        alleVragenBIO.add(vraag4BIO);
        alleVragenBIO.add(vraag5BIO);
        return alleVragenBIO;
    }

    //Examens worden meegegeven als een arraylist
    public static ArrayList<Examen> getAlleExamens() {
        ArrayList<Examen> alleExamens = new ArrayList<Examen>();
        alleExamens.add(aardrijkskundeExamen);
        alleExamens.add(biologieExamen);
        return alleExamens;
    }

    //Hier word de huidige lijst met examens geprint
    public static void getAlleExamenNamen() {
        System.out.println("De lijst met examens is: ");
        System.out.println(aardrijkskundeExamen.naam);
        System.out.println(biologieExamen.naam);
        System.out.println();
    }

    //Hier word met behulp van een for loop de toets AK afgenomen
    //Elke keer wanneer een antwoord goed is gaat counter omhoog met 1
    public static void printVragenAK(ArrayList<Vraag> alleVragenAK, Examen aardrijkskunde) {
        Scanner scanner = new Scanner(System.in);
        boolean gevonden = false;
        Student gekozenStudent = new Student(null);
        while (!gevonden) {
            System.out.println("Geef je studentnummer op: ");
            int studentnummer = scanner.nextInt();
            scanner.nextLine();
            ArrayList<Student> alleStudenten = Student.getAlleStudenten();
            for (Student student : alleStudenten) {
                if (student.getStudentnummer() == studentnummer) {
                    gekozenStudent = student;
                    gevonden = true;
                }
            }
        }
        String antwoordAK = "";
        String checkAntwoordAK = "";
        int counter = 0;
        for (Vraag vraag : alleVragenAK) {
            boolean correct = true;
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
        if (counter >= 3) {
            System.out.println("Je hebt " + counter + " goed.");
            System.out.println("Dit betekent dat je geslaagd bent voor dit examen");
            Result.registerResult(gekozenStudent, aardrijkskunde, true);
        } else {
            System.out.println("Je hebt " + counter + " goed");
            System.out.println("Dit bekent dat je niet geslaagd ben voor dit examen");
            Result.registerResult(gekozenStudent, aardrijkskunde, false);
        }
        System.out.println();
    }

    //Hier word met behulp van een for loop de toets BIO afgenomen
    //Elke keer wanneer een antwoord goed is gaat counter omhoog met 1
    public static void printVragenBIO(ArrayList<Vraag> alleVragenBIO, Examen biologie) {
        Scanner scanner = new Scanner(System.in);
        boolean gevonden = false;
        Student gekozenStudent = new Student(null);
        while (!gevonden) {
            System.out.println("Geef je studentnummer op: ");
            int studentnummer = scanner.nextInt();
            scanner.nextLine();
            ArrayList<Student> alleStudenten = Student.getAlleStudenten();
            for (Student student : alleStudenten) {
                if (student.getStudentnummer() == studentnummer) {
                    gekozenStudent = student;
                    gevonden = true;
                }
            }
        }
        String antwoordBIO = "";
        String checkAntwoordBIO = "";
        int counter = 0;
        for (Vraag vraag : alleVragenBIO) {
            Boolean correct = true;
            while (correct) {
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
                if (!antwoordBIO.equals(checkAntwoordBIO) && (antwoordBIO.equals("Ja") || antwoordBIO.equals("Nee"))) {
                    correct = false;
                }
            }
        }
        System.out.println("Bij dit examen heb je minimaal 3 goed nodig om een voldoende te halen");
        if (counter >= 3) {
            System.out.println("Je hebt " + counter + " goed.");
            System.out.println("Dit betekent dat je geslaagd bent voor dit examen");
            Result.registerResult(gekozenStudent, biologie, true);
        } else {
            System.out.println("Je hebt " + counter + " goed");
            System.out.println("Dit bekent dat je niet geslaagd ben voor dit examen");
            Result.registerResult(gekozenStudent, biologie, false);
        }
        System.out.println();
    }
}

//Dit is de class vraag die word gebruikt bij de class examen
class Vraag {
    String vraag;
    boolean antwoord;

    public Vraag(String vraag, boolean antwoord) {
        this.vraag = vraag;
        this.antwoord = antwoord;
    }

    @Override
    public String toString() {
        return "Vraag{" +
                "vraag='" + vraag + '\'' +
                ", antwoord=" + antwoord +
                '}';
    }
}

class Student {
    String naam;
    int studentnummer;
    static int volgendnummer = 1;
    static ArrayList<Student> alleStudenten = new ArrayList<Student>();

    Student(String naam) {
        this.naam = naam;
        this.studentnummer = volgendnummer;
        volgendnummer++;
    }

    public static void createStudent(String name) {
        alleStudenten.add(new Student(name));
    }

    public String getNaam() {
        return this.naam;
    }

    public int getStudentnummer() {
        return this.studentnummer;
    }

    public static ArrayList<Student> getAlleStudenten() {
        return alleStudenten;
    }
}

class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static void menu() {
        System.out.println("1) Lijst met examens");
        System.out.println("2) Lijst met studenten");
        System.out.println("3) Nieuwe student inschrijven");
        System.out.println("4) Student verwijderen");
        System.out.println("5) Examen afnemen");
        System.out.println("6) Is de student geslaagd voor een bepaald examen?");
        System.out.println("7) Welke examens heeft de student gehaald?");
        System.out.println("8) Welke student heeft de meeste examens gehaald?");
        System.out.println("0) Exit");
        System.out.println("Kies een getal van het menu: ");

        String keuze = scanner.nextLine();

        switch (keuze) {
            case "0" -> System.out.println("Exiting....");
            case "1" -> case1();
            case "2" -> case2();
            case "3" -> case3();
            case "4" -> case4();
            case "5" -> case5();
            case "6" -> case6();
            case "7" -> case7();
            case "8" -> case8();
            default -> {
                System.out.println("Voer een getal van 0 t/m 8: ");
                System.out.println();
                menu();
            }
        }
    }

    public static void case1() {
        //Hier word de huidige lijst van de examens doorgegeven
        Examen.getAlleExamenNamen();
        menu();
    }

    public static void case2() {
        ArrayList<Student> studenten = Student.getAlleStudenten();
        System.out.println("De lijst met studenten is: ");
        studenten.forEach(student -> {
            System.out.println("Student: " + student.getNaam() + " Studentnummer: " + student.getStudentnummer());
        });
        System.out.println();
        menu();
    }

    public static void case3() {
        ArrayList<Student> studenten = Student.getAlleStudenten();
        System.out.println("Geef de naam van de student: ");
        String name = scanner.nextLine();
        Student.createStudent(name);
        System.out.println();
        System.out.println("De student is ingeschreven");
        System.out.println("Uw studentnummer is: " + Student.alleStudenten.get(Student.alleStudenten.size() - 1).getStudentnummer());
        System.out.println();
        menu();
    }


    public static void case4() {
        System.out.println("Geef het nummer van de student die je wilt verwijderen:");
        int studentNummer = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Student> verwijderstudenten = new ArrayList<>();
        for (Student student : Student.alleStudenten) {
            if (student.getStudentnummer() == studentNummer) {
                verwijderstudenten.add(student);
                System.out.println("Student verwijderd");
            }
        }
        Student.alleStudenten.removeAll(verwijderstudenten);
        System.out.println();
        menu();
    }

    public static void case5() {
        //Er word hier een getal gekozen voor het examen
        System.out.println("Geef het getal van het examen dat je wilt afnemen: ");
        System.out.println("1. aardrijkskunde");
        System.out.println("2. biologie");
        String examenKeuze = scanner.nextLine();
        switch (examenKeuze) {
            //Wanneer 1 word getypt begint het AK examen
            case "1" -> Examen.getAlleExamens().get(0).printVragenAK(Examen.initialiseerExamenVragenAK(), Examen.getAlleExamens().get(0));
            //Wanneer 2 word getypt begint het BIO examen
            case "2" -> Examen.getAlleExamens().get(1).printVragenBIO(Examen.initialiseerExamenVragenBIO(), Examen.getAlleExamens().get(1));
            default -> System.out.println("Er is geen 1 of 2 getypt. Er word teruggegaan naar het begin van het menu.");
        }
        System.out.println();
        menu();
    }

    public static Student studentnum(int studentennummer) {
        for (Student student : Student.alleStudenten) {
            if (student.studentnummer == studentennummer) {
                return student;
            }
        }
        return null;
    }

    public static Examen exam(String naam) {
        if (naam.equals("Biologie")) {
            return Examen.getAlleExamens().get(1);
        } else {
            return Examen.getAlleExamens().get(0);
        }
    }

    public static void case6() {
        System.out.println("Geef het nummer van de student: ");
        int studentNummerCheck = scanner.nextInt();
        scanner.nextLine();
        for (Student student : Student.alleStudenten) {
//            while (student.studentnummer != studentNummerCheck){
//                System.out.println("Geef de nummer van de student");
//                studentNummerCheck = scanner.nextInt();
//            }
            if (student.studentnummer == studentNummerCheck) {
                String examen = "";
                while (!examen.equals("Biologie") && !examen.equals("Aardrijkskunde")) {
                    System.out.println("Geef het examen op: (Biologie of Aardrijkskunde) ");
                    examen = scanner.nextLine();
                }
                Result.getResult(studentnum(studentNummerCheck), exam(examen));
            }
        }
        System.out.println();
        menu();
    }

    public static void case7() {
        System.out.println("Geef het nummer van de student waarvan je alle geslaagde examens wilt:");
        int studentennummer = scanner.nextInt();
        scanner.nextLine();
        for (Result result : Result.allResults) {
            if (result.student.studentnummer == studentennummer) {
                if (result.result) {
                    System.out.println("De student is geslaagd voor: " + result.examen.naam);
                }
            }
        }
        System.out.println();
        menu();
    }

    public static void case8() {
        System.out.print("De student met de meest gehaalde examens is: ");
        Result.meestGeslaagdeStudent();
        System.out.println();
        menu();
    }

}

class Result {
    public Student student;
    public Examen examen;
    public boolean result;
    static ArrayList<Result> allResults = new ArrayList<Result>();

    public Result(Student student, Examen examen, boolean result) {
        this.student = student;
        this.examen = examen;
        this.result = result;
    }

    public static void registerResult(Student student, Examen examen, boolean value) {
        Result result = new Result(student, examen, value);
        allResults.add(result);
    }

    public static ArrayList<Result> getAllResults() {
        return allResults;
    }

    public static void getResult(Student student, Examen examen) {
        allResults.forEach(result -> {
                    if (student == result.student && examen == result.examen) {
                        if (result.result) {
                            System.out.println("De student " + student.naam + " heeft het examen " + examen.naam + " gehaald");
                        } else {
                            System.out.println("De student " + student.naam + " heeft het examen " + examen.naam + " niet gehaald");
                        }
                    }
                }
        );
    }

    public static void meestGeslaagdeStudent() {
        // set variabelen
        int hoogsteScore = 0;
        int counter = 0;
        Student besteStudent = null;

        ArrayList<Student> studenten = Student.getAlleStudenten();
        ArrayList<Result> resultaten = getAllResults();

        for (Student student : studenten) {
            counter = 0;
            for (Result resultaat : resultaten) {
                if (resultaat.student.equals(student)) {
                    if (resultaat.result) {
                        counter++;
                    }
                }
                if (counter >= hoogsteScore) {
                    besteStudent = student;
                }
            }
        }
        System.out.println(besteStudent.getNaam());
    }
}

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static ArrayList<Examen> examens = new ArrayList<>();

    public static void main(String[] args) {
        // hardcoded studenten toevoegen.
        Student.createStudent("Jeroen");
        Student.createStudent("Pim");

        // hardcoded resultaten:
        var alleStudenten = Student.getAlleStudenten();
        alleStudenten.forEach(student -> {
            // gehaalde aardrijkskunde examens
            Result.registerResult(student, Examen.getAlleExamens().get(0), false);
        });
        alleStudenten.forEach(student -> {
            // niet behaalde biologie examens
            Result.registerResult(student, Examen.getAlleExamens().get(1), true);
        });

        System.out.println("Menu");
        Menu.menu();
    }
}
