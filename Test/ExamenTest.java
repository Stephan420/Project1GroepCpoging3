import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ExamenTest {
    @Test
    void checkCounterTestTrue(){
        Examen examen = new Examen("Nederlands", 5);
        int counter = 4;
        Student student = new Student("Devika");
        assertEquals(true,Examen.checkCounter(counter, student, examen));
    }
    @Test
    void checkCounterTestFalse(){
        Examen examen = new Examen("Nederlands", 5);
        int counter = 2;
        Student student = new Student("Devika");
        assertEquals(false,Examen.checkCounter(counter, student, examen));
    }
}