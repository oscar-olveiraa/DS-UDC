package e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class selectCandidatesTest {

    //Recorrido circular
    public static TVRealityList list0 = new TVRealityList(true);
    public static TVRealityList list1 = new TVRealityList(true);
    public static TVRealityList list2 = new TVRealityList(true);
    public static TVRealityList list3 = new TVRealityList(true);

    //Recorrido con rebote
    public static TVRealityList list4 = new TVRealityList(false);
    public static TVRealityList list5 = new TVRealityList(false);
    public static TVRealityList list6 = new TVRealityList(false);
    public static TVRealityList list7 = new TVRealityList(false);
    public static TVRealityList list8 = new TVRealityList(false);

    //Fallos
    public static TVRealityList fallocircular = new TVRealityList(true);
    public static TVRealityList fallorebote = new TVRealityList(false);



    //TEST Recorrido con rebote
    @Test
    void testRecorridoConRebote1(){
        //Probamos: Si k = 1 nos tiene que devolver el ultimo elemento
        //K = 1, size = 5
        Seleccion sel = new Seleccion();
        list8.insertarPersona("Martin");
        list8.insertarPersona("Alvaro");
        list8.insertarPersona("Jacobo");
        list8.insertarPersona("Manuel");
        list8.insertarPersona("Lola");

        assertEquals("Lola", sel.selectCandidates(1, list8));
    }

    @Test
    void testRecorridoConRebote2(){
        //Probamos: eliminar segundo (Alvaro), penúltimo(Manuel), en el medio(Jacobo), ultimo(Lola).
        //K = 2, size = 5
        Seleccion sel = new Seleccion();
        list5.insertarPersona("Martin");
        list5.insertarPersona("Alvaro");
        list5.insertarPersona("Jacobo");
        list5.insertarPersona("Manuel");
        list5.insertarPersona("Lola");

        assertEquals("Martin", sel.selectCandidates(2, list5));
    }

    @Test
    void testRecorridoConRebote3(){
        //Probamos: eliminar en el medio, (Jacobo), penúltimo (Manuel), segundo (Alvaro), ultimo (Lola).
        //K = 3, size = 5
        Seleccion sel = new Seleccion();
        list4.insertarPersona("Martin");
        list4.insertarPersona("Alvaro");
        list4.insertarPersona("Jacobo");
        list4.insertarPersona("Manuel");
        list4.insertarPersona("Lola");

        assertEquals("Martin", sel.selectCandidates(3, list4));
    }

    @Test
    void testRecorridoConRebote6(){
        //Probamos: eliminar penúltimo (Manuel), ultimo (Lola), segundo (alvaro), ultimo (Jacobo)
        //K = 6, size = 5;
        Seleccion sel = new Seleccion();
        list6.insertarPersona("Martin");
        list6.insertarPersona("Alvaro");
        list6.insertarPersona("Jacobo");
        list6.insertarPersona("Manuel");
        list6.insertarPersona("Lola");

        assertEquals("Martin", sel.selectCandidates(6, list6));
    }

    @Test
    void testRecorridoConRebote7(){
        //Probamos: eliminar ultimo (Jose), segundo (Alvaro), primero (Martin), medio (Manuel), primero (Jacobo)
        //K = 6, size = 6
        Seleccion sel = new Seleccion();
        list7.insertarPersona("Martin");
        list7.insertarPersona("Alvaro");
        list7.insertarPersona("Jacobo");
        list7.insertarPersona("Manuel");
        list7.insertarPersona("Lola");
        list7.insertarPersona("Jose");
        assertEquals("Lola", sel.selectCandidates(6, list7));
    }

   //TEST Recorrido circular

    @Test
    void testRecorridoCircular1() {
        Seleccion sel = new Seleccion();
        list1.insertarPersona("Martin");
        list1.insertarPersona("Alvaro");
        list1.insertarPersona("Jacobo");
        list1.insertarPersona("Manuel");
        list1.insertarPersona("Lola");

        assertEquals("Lola", sel.selectCandidates(1, list1));
    }
    @Test
    void testRecorridoCircular2(){
    Seleccion sel = new Seleccion();
        list0.insertarPersona("Martin");
        list0.insertarPersona("Alvaro");
        list0.insertarPersona("Jacobo");
        list0.insertarPersona("Manuel");
        list0.insertarPersona("Lola");

    assertEquals("Jacobo", sel.selectCandidates(2, list0));
}

    @Test
    void testRecorridoCircular3() {
        Seleccion sel2 = new Seleccion();
        list2.insertarPersona("Martin");
        list2.insertarPersona("Alvaro");
        list2.insertarPersona("Jacobo");
        list2.insertarPersona("Manuel");
        list2.insertarPersona("Lola");
        assertEquals("Manuel", sel2.selectCandidates(3, list2));
    }

    @Test
    void testRecorridoCircular5() {
        Seleccion sel = new Seleccion();
        list3.insertarPersona("Martin");
        list3.insertarPersona("Alvaro");
        list3.insertarPersona("Jacobo");
        list3.insertarPersona("Manuel");
        list3.insertarPersona("Lola");
        assertEquals("Alvaro",sel.selectCandidates(5,list3));
    }


    @Test
    void testFalloCircular(){
        Seleccion sel = new Seleccion();
        fallocircular.insertarPersona("Martin");
        fallocircular.insertarPersona("Alvaro");
        fallocircular.insertarPersona("Jacobo");
        fallocircular.insertarPersona("Manuel");
        fallocircular.insertarPersona("Lola");
        assertThrows(IllegalArgumentException.class, ()-> sel.selectCandidates(-1, fallocircular));
        assertThrows(IllegalArgumentException.class, ()-> sel.selectCandidates(0, fallocircular));
    }
    @Test
    void testFalloRebote(){
        Seleccion sel = new Seleccion();
        fallorebote.insertarPersona("Martin");
        fallorebote.insertarPersona("Alvaro");
        fallorebote.insertarPersona("Jacobo");
        fallorebote.insertarPersona("Manuel");
        fallorebote.insertarPersona("Lola");
        assertThrows(IllegalArgumentException.class, ()-> sel.selectCandidates(-1, fallorebote));
        assertThrows(IllegalArgumentException.class, ()-> sel.selectCandidates(0, fallorebote));
    }

}