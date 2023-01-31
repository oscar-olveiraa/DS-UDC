package e1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MovieTest {
    private final Movie movie = new Movie("Alcarras", 300000);

    @Test
    void testSalario(){
        movie.addEspecialista("Josep", "Abad", "00000000A", 123322113, "español", 100, "danger");
        movie.addInterprete("Ainet", "Jounou", "22222222A", 777777777, "española", 90, "protagonist");
        movie.addInterprete("Xenia", "Roset", "33333333A", 345658790, "española", 50, "secondary");
        movie.addDoblador("Cristina", "Puig", "11111111B", 234433424, "española", 20);
        movie.addDirector("Carla", "Simon", "99999999A", 333221100, "inglesa", 500, 7, 300000);
        movie.addProductor("Maria", "Zamora", "11111111A", 123312332, "española", 100, 300000);
        movie.addMusico("Andrea", "Koch", "22222222A", 111111111, "alemana", 200, 300000);
        movie.addGuionista("Arnau", "Vilaro", "33333333B", 333333333, "español", 300, "original",300000);

        assertEquals("Josep Abad (Stunt performer with extra for danger): 5000.0 euro" + "\n" +
                "Ainet Jounou (Actor protagonist): 54000.0 euro" + "\n" +
                "Xenia Roset (Actor secondary): 10000.0 euro" + "\n" +
                "Cristina Puig (Dubber): 400.0 euro" + "\n" +
                "Carla Simon (Director, 7 years of experience): 57000.0 euro" + "\n" +
                "Maria Zamora (Producer): 9000.0 euro" + "\n" +
                "Andrea Koch (Musician): 12000.0 euro" + "\n" +
                "Arnau Vilaro (Screenwriter, original screenplay): 25000.0 euro" + "\n" +
                "The total payroll for Alcarras is 172400.0 euro", movie.printSalaries());
    }

    @Test
    void testRoyalties(){
        movie.addDirector("Karla", "Simon", "99999999A", 333221100, "inglesa", 500, 7, 300000);
        movie.addProductor("Maria", "Zamora", "11111111A", 123312332, "española", 100, 300000);
        movie.addGuionista("Arnau", "Vilaro", "33333333B", 333333333, "español", 300, "original",300000);
        movie.addMusico("Andrea", "Koch", "22222222A", 111111111, "alemana", 200,300000);

        assertEquals("Karla Simon (Director): 15000.0 euro" + "\n" +
                "Maria Zamora (Producer): 6000.0 euro" + "\n" +
                "Arnau Vilaro (Screenwriter): 15000.0 euro" + "\n" +
                "Andrea Koch (Musician): 12000.0 euro" + "\n", movie.printRoyalties());

    }

    @Test
    void testFallos(){
        assertThrows(IllegalArgumentException.class, ()->movie.addEspecialista("Josep", "Abad", "00000000A", 123322113, "español", 100, "normal"));
        assertThrows(IllegalArgumentException.class, ()->movie.addInterprete("Ainet", "Jounou", "22222222A", 777777777, "española", 90, "antagonista"));
        assertThrows(IllegalArgumentException.class, ()->movie.addGuionista("Arnau", "Vilaro", "33333333B", 333333333, "español", 300, "copy", 300000));
        assertThrows(IllegalArgumentException.class, ()->movie.addDirector("Karla", "Simon", "99999999A", 333221100, "inglesa", 500, -7, 300000));

    }

    @Test
    void testFallosSalario(){
        movie.addInterprete("Ainet", "Jounou", "22222222A", 777777777, "española", 90, "protagonist");

        Movie peli = new Movie("Fast & Furious", 1500000);
        peli.addInterprete("Ainet", "Jounou", "22222222A", 777777777, "española", 90, "extra");

        Movie pelicula = new Movie("Viernes 13", 500000);
        pelicula.addInterprete("Ainet", "Jounou", "33333333A", 345658790, "española", 90, "extra");

        assertNotEquals(movie.printSalaries(), peli.printSalaries());
        assertEquals(peli.printSalaries(), pelicula.printSalaries());

    }
    @Test
    void testAdicionales(){
        assertEquals("Non hai membros no equipo", movie.printSalaries());
        assertEquals("Non hai membros no equipo", movie.printRoyalties());
    }


}