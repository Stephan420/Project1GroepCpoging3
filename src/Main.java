import java.util.ArrayList;
import java.util.Scanner;

class Examens {
    String naam;
    int aantalvragen;
    ArrayList<Vraag> alleVragenAK = initialiseerExamenVragenAK();
    ArrayList<Vraag> alleVragenBIO = initialiseerExamenVragenBIO();


    public Examens(String naam, int aantalvragen, ArrayList<Vraag> alleVragen){

        this.naam = naam;
        this.aantalvragen = aantalvragen;
        this.alleVragenAK = alleVragenAK;
        this.alleVragenBIO = alleVragenBIO;
    }

    static ArrayList<Vraag>initialiseerExamenVragenAK(){
        ArrayList<Vraag> alleVragenAK = new ArrayList<>();
        Vraag vraag1AK = new Vraag("Is de aarde plat?", false);
        Vraag vraag2AK = new Vraag("Stoot waterkracht CO2 uit?", false);
        Vraag vraag3AK = new Vraag("Is steenkool een metamorf gesteente?", false);
        Vraag vraag4AK = new Vraag("Stoot biomassa CO2 uit als je het verbrandt?", true);
        Vraag vraag5AK = new Vraag("De langste plaatsnaam ter wereld heet 'Llanfairpwllgwyngyllgogerychwyrndrobwllllantysiliogogogoch'", true);
        alleVragenAK.add(vraag1AK);
        alleVragenAK.add(vraag2AK);
        alleVragenAK.add(vraag3AK);
        alleVragenAK.add(vraag4AK);
        alleVragenAK.add(vraag5AK);
        return alleVragenAK;
    }

    static ArrayList<Vraag>initialiseerExamenVragenBIO(){
        ArrayList<Vraag> alleVragenBIO = new ArrayList<>();
        Vraag vraag1BIO = new Vraag("De hersenen bij mannen zijn groter dan bij vrouwen. Klopt dit?", true);
        Vraag vraag2BIO = new Vraag("De menstruatiecyclus duurt bij een vrouw altijd even lang. Klopt dit?", false);
        Vraag vraag3BIO = new Vraag("De capybara is de 's werelds grootste knaagdier. Klopt dit?", true);
        Vraag vraag4BIO = new Vraag("Een olifant kan springen. Klopt deze bewering?",false );
        Vraag vraag5BIO = new Vraag("Een pinguin kan bijna twee meter hoog in de lucht springen. Klopt deze bewering?", true);
        alleVragenBIO.add(vraag1BIO);
        alleVragenBIO.add(vraag2BIO);
        alleVragenBIO.add(vraag3BIO);
        alleVragenBIO.add(vraag4BIO);
        alleVragenBIO.add(vraag5BIO);
        return alleVragenBIO;
    }

    public static void getAllExamens(Examens aardrijkskundeExamen, Examens biologieExamen){
        System.out.println("De lijst met examens is: ");
        System.out.println(aardrijkskundeExamen.naam);
        System.out.println(biologieExamen.naam);
        System.out.println();
    }

    public static void printVragenAK(ArrayList<Vraag> alleVragenAK) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < alleVragenAK.size(); i++) {
            System.out.println(alleVragenAK.get(i).vraag);
            scanner.nextLine();
        }
    }
    public static void printVragenBIO(ArrayList<Vraag> alleVragenBIO){
        Scanner scanner = new Scanner(System.in);
        for(int j=0; j<alleVragenBIO.size(); j++){
            System.out.println(alleVragenBIO.get(j).vraag);
            scanner.nextLine();
        }
    }

}



    //toetsvragen: aardrijkskunde: is de aarde plat?
    // weegt de aarde 5,972E24 kg?
    // is pluto een planeet?
    //toetsvragen: biologie: is de mytochondria de kern van de cel?
    // draagt bigfoot schoenmaat 420?
    // hoort bigfoot niet de naam te hebben bigfeet?



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

    public void createstudent(String naam,ArrayList<Examens> GeslaagdeExamens,ArrayList<Examens> NietGeslaagdeExamens){
        studenten.add(new Student(naam,GeslaagdeExamens,NietGeslaagdeExamens));
    }

    //public void IsStudentGeslaagdVoorExamen(Student student, Examens examen){}
    //public void BesteStudenten(){}
    public static ArrayList<Student> getAllStudents(){
        return studenten;
    }

}

class Main {
    public static void menu(){
        Scanner scanner = new Scanner(System.in);
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


        Examens aardrijkskundeExamen = new Examens("Aardrijkskunde", 5, Examens.initialiseerExamenVragenAK());
        Examens biologieExamen = new Examens("Biologie", 5, Examens.initialiseerExamenVragenBIO());


        switch (keuze) {
            case 0 -> System.out.println("Exiting....");
            case 1 -> {
                Examens.getAllExamens(aardrijkskundeExamen, biologieExamen);
                menu();
            }
            case 2 -> System.out.println(Student.getAllStudents());
            case 3 -> System.out.println(Student.getAllStudents()); //bullshit
            case 4 -> System.out.println(Student.getAllStudents()); //bullshit
            case 5 -> {
                System.out.println("Geef het getal van het examen dat je wilt afnemen: ");
                System.out.println("1. aardrijkskunde");
                System.out.println("2. biologie");
                int examenKeuze =scanner.nextInt();
                scanner.nextLine();
                switch (examenKeuze){
                    case 1 -> aardrijkskundeExamen.printVragenAK(Examens.initialiseerExamenVragenAK());
                    case 2 -> biologieExamen.printVragenBIO(Examens.initialiseerExamenVragenBIO());
                }
                menu();
            }
            case 6 -> System.out.println(Student.getAllStudents()); //bullshit
            case 7 -> System.out.println(Student.getAllStudents()); //bullshit
            case 8 -> System.out.println(Student.getAllStudents()); //bullshit
            default -> {
                System.out.println("Voer een getal van 0 t/m 8: ");
                menu();
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Menu");
        menu();
    }
}
