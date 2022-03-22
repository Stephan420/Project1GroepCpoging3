import java.util.ArrayList;
import java.util.Scanner;

class Examens {
    String naam;
    int aantalvragen;
    ArrayList<Vraag> alleVragen = initialiseerExamenVragen();

    public Examens(String naam, int aantalvragen, ArrayList<Vraag> alleVragen){

        this.naam = naam;
        this.aantalvragen = aantalvragen;
        this.alleVragen = alleVragen;
    }

    static ArrayList<Vraag>initialiseerExamenVragen(){
        ArrayList<Vraag> alleVragen = new ArrayList<Vraag>();
        Vraag vraag1AK = new Vraag("Is de aarde plat?", false);
        Vraag vraag2AK = new Vraag("Stoot waterkracht CO2 uit?", false);
        Vraag vraag3AK = new Vraag("Is steenkool een metamorf gesteente?", false);
        Vraag vraag4AK = new Vraag("Stoot biomassa CO2 uit als je het verbrandt?", true);
        Vraag vraag5AK = new Vraag("De langste plaatsnaam ter wereld heet 'Llanfairpwllgwyngyllgogerychwyrndrobwllllantysiliogogogoch'", true);
        alleVragen.add(vraag1AK);
        alleVragen.add(vraag2AK);
        alleVragen.add(vraag3AK);
        alleVragen.add(vraag4AK);
        alleVragen.add(vraag5AK);
        return alleVragen;
    }

//    public static ArrayList<Examens> getAllExamens(ArrayList<Vraag>alleVragen){
//        System.out.println();
//        return naam;
    }


    //toetsvragen: aardrijkskunde: is de aarde plat?
    // weegt de aarde 5,972E24 kg?
    // is pluto een planeet?
    //toetsvragen: biologie: is de mytochondria de kern van de cel?
    // draagt bigfoot schoenmaat 420?
    // hoort bigfoot niet de naam te hebben bigfeet?

//}

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

        ArrayList<String> vragen = new ArrayList<>();
        ArrayList<String> aardrijkskunde = new ArrayList<>();
        aardrijkskunde.add("Is de aarde plat?");
        Examens aardrijkskundeExamen = new Examens("Aardrijkskunde", 5, null);

        ArrayList<Vraag> biologie = new ArrayList<>();

        switch (keuze) {
            case 0 -> System.out.println("Exiting....");
            case 1 -> System.out.println(aardrijkskunde);

            case 2 -> System.out.println(Student.getAllStudents());
            case 3 -> System.out.println(Student.getAllStudents()); //bullshit
            case 4 -> System.out.println(Student.getAllStudents()); //bullshit
            case 5 -> System.out.println(Student.getAllStudents()); //bullshit
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
