package e2;

import java.util.Iterator;

public class Seleccion {
    String nombre;

    public String selectCandidates(int k, TVRealityList list){
        Iterator<String> e = list.iterator();
        //Variable para controlar cuando eliminar
        int aux=0;
        //Si el salto es menor que 1 no tiene sentido el ejercicio
        if(k<1){
            throw  new IllegalArgumentException("O contador ten que ser igual ou maior que 1");
        }
        //Si el salto es uno siempre será ganador el último
        if(k==1){
            return nombre = list.collection.get(list.collection.size()-1);
        }
        //Bucle para recorrer e ir eliminando participantes
        while (e.hasNext()){
            nombre = e.next();
            aux++;
            //Cuando nuestro contador sea igual al salto, eliminamos y restablecemos el contador a 0
            if(aux == k) {
                e.remove();
                aux = 0;
            }

        }
        //Finalmente devolvemos el ganador
        return list.collection.get(0);
    }

}
