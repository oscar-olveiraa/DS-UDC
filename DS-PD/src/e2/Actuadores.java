package e2;
import java.util.*;
public class Actuadores implements ObserverA {
    List<String> actuadores =  new ArrayList<>();
    public void update(Subject_alertas a) {
        StringBuilder actuador = new StringBuilder();
        Alertas alerta = (Alertas) a;
        if (alerta.alertaR.size() > 0) {
            actuadores.add("Vamos a arreglar a alerta roja\n");

        } else {
            //Si no tiene alertas
            actuadores.add("Non hai alertas\n");
        }
        //Si la lista de alertas tiene por lo menos un elemento, añadiriamos el contenido al informe
        if (alerta.alertaN.size() > 0) {
            actuadores.add("Vamos a arreglar a alerta naranja\n");

        } else {
            //Si no tiene alertas
            actuadores.add("Non hai alertas Naranjas\n");
        }
    }

    public String printActuadores(){
        StringBuilder s = new StringBuilder();

        for(String a : actuadores){
            s.append(a);
        }
        return s.toString();
    }
}
