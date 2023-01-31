package e2;

import java.util.*;

public class RecCircular implements Iterator<String> {
        private List<String> candidatos;
        private int pos;

        public RecCircular (List<String> candidatos){
            this.candidatos = candidatos;
            pos = 0;
        }

        @Override
        public boolean hasNext(){
            //Si la lista está vacia o unicamente hay un elemento, devolvemos false
            if(candidatos.isEmpty() || (candidatos.size()==1)){
                return false;
            }else {
                return true;
            }
        }
        
        @Override
        public String next(){
            String nombre;
            nombre = candidatos.get(pos);
            //Si estamos en la última posición, nos situamos en la primera
            if(pos == candidatos.size()-1){
                pos = 0;
            //Si no incrementamos la posicion
            }else{
                pos ++;
            }

            return nombre;
        }

        @Override
        public void remove(){
            //Si estamos en la primera posición, eliminamos la última (por como hemos implementado el next)
            if (pos == 0){
                candidatos.remove(candidatos.size()-1);
            }
            //Si no eliminaremos la anterior y nos situaremos una atrás
            else{
                candidatos.remove(pos-1);
                pos--;
            }
        }

}




