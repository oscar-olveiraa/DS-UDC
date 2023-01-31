package e2;

import java.util.*;

public class Alertas extends Subject_alertas implements ObserverS  {
    //Valores correctos en los que no salta la alerta
    public final double OXFIJO = 5;
    public final double PHFIJO = 5;
    public final double TEMPFIJO = 5;
    //lista de alertas rojas y naranjas
    List<String> alertaR = new ArrayList<>();
    List<String> alertaN = new ArrayList<>();

    //Funcion auxiliar para comprobar el pH
    private void ComprobarPh(Sensores sp) {
        if(sp.getValor()> PHFIJO){
            alertaR.add(sp.getNombreT() + ", " + sp.getUbi() + "\n" +
                    "Control de "+ sp.getParametro() + " " + sp.getNombreT() + " : parametro " + sp.getParametro() + ", nivel " + sp.getValor() + "\n");
        }else if(sp.getValor()<PHFIJO){
            alertaN.add(sp.getNombreT() + ", " + sp.getUbi() + "\n" +
                    "Control de "+ sp.getParametro() + " " + sp.getNombreT() + " : parametro " + sp.getParametro() + ", nivel " + sp.getValor() + "\n");
        }
    }
    //Funcion auxiliar para comprobar el Oxigeno
    private void ComprobarOxigeno(Sensores sp) {
        if(sp.getValor()> OXFIJO){
            alertaR.add(sp.getNombreT() + ", " + sp.getUbi() + "\n" +
                    "Control de "+ sp.getParametro() + " " + sp.getNombreT() + " : parametro " + sp.getParametro() + ", nivel " + sp.getValor() + "\n");
        }else if(sp.getValor()<OXFIJO){
            alertaN.add(sp.getNombreT() + ", " + sp.getUbi() + "\n" +
                    "Control de "+ sp.getParametro() + " " + sp.getNombreT() + " : parametro " + sp.getParametro() + ", nivel " + sp.getValor() + "\n");
        }
    }
    //Funcion auxiliar para comprobar la temperatura
    private void ComprobarTemperatura(Sensores sp) {
        if (sp.getValor() > TEMPFIJO) {
            alertaR.add(sp.getNombreT() + ", " + sp.getUbi() + "\n" +
                    "Control de " + sp.getParametro() + " " + sp.getNombreT() +" : parametro " + sp.getParametro() + ", nivel " + sp.getValor() + "\n");
        } else if (sp.getValor() < TEMPFIJO) {
            alertaN.add(sp.getNombreT() + ", " + sp.getUbi() + "\n" +
                    "Control de " + sp.getParametro() + " " + sp.getNombreT() + " : parametro " + sp.getParametro() + ", nivel " + sp.getValor() + "\n");
        }
    }


    @Override
    public void update(Subject_sensores s) {
        Sensores sp = (Sensores) s;
        //Si el nombre del sensor coincide con el deseado, comprobamos sus parametros

        if(sp.getParametro().equals("Ox")){
            ComprobarOxigeno(sp);
        }

        else if(sp.getParametro().equals("pH")){
            ComprobarPh(sp);
        }
        else if(sp.getParametro().equals("Temp")){
            ComprobarTemperatura(sp);
        }
        else{
            throw new IllegalArgumentException("No hay sensores con ese parametro");
        }
        notifyObservers();
    }
}



