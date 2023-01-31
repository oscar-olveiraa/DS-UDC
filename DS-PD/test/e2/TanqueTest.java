package e2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TanqueTest {

        Tanques t = new Tanques("Piscina de focas", "exterior");
        Tanques t2 = new Tanques("Acuario de peixes", "interior");

        @Test
        void testTanque1(){
                Sensores s = new Sensores("pH", 5, t);
                Sensores s2 = new Sensores("pepe", 5, t);
                Sensores s3 = new Sensores("Temp", 5, t);


                Alertas apH = new Alertas();
                Alertas pepe = new Alertas();
                Alertas aTemp = new Alertas();


                Actuadores act = new Actuadores();
                Personal person1 = new Personal();
                Personal person2 = new Personal();
                Personal person3 = new Personal();


                t.add_sensor(s);
                s.attach(apH);
                s2.attach(pepe);
                s3.attach(aTemp);


                apH.attach(act);
                apH.attach(person1);
                aTemp.attach(person2);
                pepe.attach(person3);


                s.setValor(10);
                s3.setValor(8);
                s3.setValor(2);

                assertThrows(IllegalArgumentException.class, ()->s2.setValor(3));

                assertEquals("Alerta Roja:\n" +
                        "Piscina de focas, exterior\n" +
                        "Control de pH Piscina de focas : parametro pH, nivel 10.0\n" +
                        "Non hai alertas Naranjas\n" +
                        "=======================================================================\n", person1.printInformes());

                assertEquals("Alerta Roja:\n" +
                        "Piscina de focas, exterior\n" +
                        "Control de Temp Piscina de focas : parametro Temp, nivel 8.0\n" +
                        "Non hai alertas Naranjas\n" +
                        "=======================================================================\n" +
                        "Alerta Roja:\n" +
                        "Piscina de focas, exterior\n" +
                        "Control de Temp Piscina de focas : parametro Temp, nivel 8.0\n" +
                        "Alerta Naranja:\n" +
                        "Piscina de focas, exterior\n" +
                        "Control de Temp Piscina de focas : parametro Temp, nivel 2.0\n" +
                        "=======================================================================\n", person2.printInformes());


                assertEquals("Vamos a arreglar a alerta roja\n" +
                        "Non hai alertas Naranjas\n", act.printActuadores());


        }


        @Test
        void TestTanque2(){

                Sensores s1 = new Sensores("pH", 5, t2);
                Sensores s2 = new Sensores("Ox", 5, t2);
                Sensores s3 = new Sensores("Temp", 5, t2);
                Alertas a = new Alertas();
                Personal p1 = new Personal();

                t2.add_sensor(s1);
                t2.add_sensor(s2);
                t2.add_sensor(s3);
                s1.attach(a);
                s2.attach(a);
                s3.attach(a);
                a.attach(p1);

                s1.setValor(8);
                s2.setValor(2);
                s3.setValor(9);

                assertEquals("Alerta Roja:\n" +
                        "Acuario de peixes, interior\n" +
                        "Control de pH Acuario de peixes : parametro pH, nivel 8.0\n" +
                        "Non hai alertas Naranjas\n" +
                        "=======================================================================\n" +
                        "Alerta Roja:\n" +
                        "Acuario de peixes, interior\n" +
                        "Control de pH Acuario de peixes : parametro pH, nivel 8.0\n" +
                        "Alerta Naranja:\n" +
                        "Acuario de peixes, interior\n" +
                        "Control de Ox Acuario de peixes : parametro Ox, nivel 2.0\n"+
                        "=======================================================================\n" +
                        "Alerta Roja:\n" +
                        "Acuario de peixes, interior\n" +
                        "Control de pH Acuario de peixes : parametro pH, nivel 8.0\n" +
                         "Alerta Roja:\n" +
                        "Acuario de peixes, interior\n" +
                        "Control de Temp Acuario de peixes : parametro Temp, nivel 9.0\n" +
                        "Alerta Naranja:\n" +
                        "Acuario de peixes, interior\n" +
                        "Control de Ox Acuario de peixes : parametro Ox, nivel 2.0\n"+
                        "=======================================================================\n", p1.printInformes());
        }
}