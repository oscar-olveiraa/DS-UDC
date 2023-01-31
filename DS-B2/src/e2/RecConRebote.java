package e2;

import java.util.*;


public class RecConRebote implements Iterator<String> {
    private  List<String> candidatos;
    private int pos;
    public boolean derecha = true; //Variable para controlar el sentido

    public RecConRebote(List<String> candidatos) {
        this.candidatos = candidatos;
        pos = 0;
    }

    @Override
    public boolean hasNext() {
        //Si la lista está vacia o unicamente hay un elemento, devolvemos false
        if (candidatos.isEmpty() || (candidatos.size() == 1)) {
            return false;
        } else {

            return true;
        }
    }

    @Override
    public String next() {
        String nombre;
        //Si estamos yendo hacia la derecha y la posición no es la ultima sumamos una posición
        if (pos < candidatos.size() - 1 && derecha) {
            pos++;
        }
        //Si estamos yendo a la izquierda y la posición no es la ultima
        else if (pos < candidatos.size() - 1 && !derecha) {
            //si estamos en la primera posición yendo a la izquierda; cambiamos de sentido y nos movemos a la siguiente hacia la derecha
            if (pos == 0) {
                derecha = true;
                pos++;
            }
            //Si es la última posición, nos movemos hacia la izquierda
            else {
                pos--;
            }
        }
        //Si no es ninguno de esos casos, actualizamos el valor del sentido y nos movemos una posición a la izquierda
        else {
            derecha = false;
            pos--;
        }
        //Obtenemos la posicion y la devolvemos
        nombre = this.candidatos.get(pos);
        return nombre;
    }

    @Override
    public void remove() {
        //Si estamos yendo a la derecha y no en última posición
        if (derecha && pos < candidatos.size() - 1) {
            candidatos.remove(pos - 1);
            pos--;
        }
        //Si estamos yendo a la derecha y en la última posición
        else if (derecha && pos == candidatos.size() - 1) {
            candidatos.remove(pos - 1);
            pos--;
            derecha = false;
        }
        //Si estamos yendo a la izquierda y no en la primera posición
        else if (!derecha && pos > 0) {
            candidatos.remove(pos + 1);
        }
        //Si estamos yendo a la izquierda y en la primera posición
        else if (!derecha && pos == 0) {
            candidatos.remove(pos + 1);
            derecha = true;
        }
    }
}


