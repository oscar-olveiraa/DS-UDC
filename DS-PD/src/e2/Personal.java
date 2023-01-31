package e2;

import java.util.*;

public class Personal implements ObserverA{
    //lista de informes
    List<String> informes = new ArrayList<>();


    public void update(Subject_alertas a){
        Alertas alerta = (Alertas) a;
        //Si la lista de alertas tiene por lo menos un elemento, añadiriamos el contenido al informe
       if(alerta.alertaR.size()>0){
            for (String s : alerta.alertaR) {
                informes.add("Alerta Roja:\n");
                informes.add(s);
            }
        }else{
           //Si no tiene alertas
           informes.add("Non hai alertas Rojas\n");

       }
        //Si la lista de alertas tiene por lo menos un elemento, añadiriamos el contenido al informe
        if(alerta.alertaN.size()>0){
            for (String s : alerta.alertaN) {
                informes.add("Alerta Naranja:\n");
                informes.add(s);
                informes.add("=======================================================================\n");
            }
        }else{
            //Si no tiene alertas
            informes.add("Non hai alertas Naranjas\n");
             informes.add("=======================================================================\n");
        }
}

    public String printInformes(){
        StringBuilder s = new StringBuilder();

        for(String a : informes){
            s.append(a);
        }
        return s.toString();
    }
}
