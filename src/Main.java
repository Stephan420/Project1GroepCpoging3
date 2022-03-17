import java.util.ArrayList;

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

    Student(String naam, int nummer, ArrayList<Examens> GeslaagdeExamens,ArrayList<Examens> NietGeslaagdeExamens) {
        this.naam = naam;
        this.nummer = nummer;
        this.GeslaagdeExamens = GeslaagdeExamens;
        this.NietGeslaagdeExamens = NietGeslaagdeExamens;
    }

    public ArrayList<Examens> getGeslaagdeExamens(){
        return GeslaagdeExamens;
    }

    //public void IsStudentGeslaagdVoorExamen(Student student, Examens examen){}
    //public void BesteStudenten(){}
    //public void getAllStudents(){}


}
