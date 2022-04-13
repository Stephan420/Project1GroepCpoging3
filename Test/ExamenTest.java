//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ExamenTest {
//    @Test
//    void printVragenAKTest() {
//        Student student = new Student("Devika");
//        ArrayList<Vraag> vragenAK = Examen.initialiseerExamenVragenAK();
////        System.out.println(Examen.getAlleExamens().get(0).toString());
//        Examen examenAK = Examen.getAlleExamens().get(0);
//
////        Vraag vraag1 = vragenAK.get(0);
////        Vraag vraag2 = vragenAK.get(1);
////        Vraag vraag3 = vragenAK.get(2);
////        Vraag vraag4 = vragenAK.get(3);
////        Vraag vraag5 = vragenAK.get(4);
//
//
//        ArrayList<String> antwoorden = new ArrayList<>();
//        antwoorden.add("Nee");
//        antwoorden.add("Nee");
//        antwoorden.add("Nee");
//        antwoorden.add("Ja");
//        antwoorden.add("Ja");
//
//        int vragenGoed = 0;
//
//        for (Vraag vraag : vragenAK) {
//            for (String antwoord : antwoorden) {
//                boolean temp = antwoord.equals("Ja");
//                if (temp == vraag.antwoord) {
//                    vragenGoed++;
//                }
//            }
//        }
//
//        if (vragenGoed >= 3) {
//        Result result1 = new Result(student, examenAK, true);
//            assertTrue(result1.result);
//        } else {
//
//        }
//    }
//
//    @Test
//    public void testCollectionAdd() {
//
//    }
//}