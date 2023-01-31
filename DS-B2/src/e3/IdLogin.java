package e3;

import java.util.HashMap;

public class IdLogin implements LoginStrategy {
   /* public NameLogin(String id, String password) {
        super(id, password);
    }*/

    @Override
    public boolean validateId(String id) {
        int contador = 0;
        boolean valid = false;
        char principio = id.charAt(0);
        char last = id.charAt(id.length());
        if (id.contains(".")) {
            //si el usuario contiene un . en la primera o ultima posición, no sería valido
            if(principio == '.' || last == '.'){
                throw new IllegalArgumentException("Posición del . no valida");
            }
            else {
                for (int i = 0; i < id.length(); i++) {
                    char c = id.charAt(i);
                    if (c == '.') {
                        contador++;
                    }
                    //Si el usuario contiene carácteres no validos (caracteres diferentes de "a" a "z" minuscula)
                    //NO ESTOY SEGURO SI COGE EL . COMO CARACTER INVALIDO
                   /*
                   if (c != '.' ||c < 'a' || c > 'z'){
                        throw new IllegalArgumentException("Carácter no válido");
                    }*/


                }
            }
            if (contador == 1) {
                valid = true;
            }
        }
        return valid;
    }
    @Override
    public boolean validPassword(String id, String password) {
    return true;
    }
}
