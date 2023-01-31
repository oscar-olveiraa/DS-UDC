package e3;

import java.util.HashMap;
import java.util.Map;

public class CorreoLogin implements  LoginStrategy{ //
    /*public EmailLogin(String id, String password) {
        super(id, password);
    }*/

    @Override
    public boolean validateId(String id) {
        int contador = 0;
        boolean valid = false;
        char principio = id.charAt(0);
        char last = id.charAt(id.length());
        //Miramos si el email contiene un @
        if (id.contains("@")) {
            //si el email contiene un @ en la primera o ultima posición, no sería valido
            if(principio == '@' || last == '@'){
                throw new IllegalArgumentException("Posición del @ no valida");
            }else {
                //Si contiene al menos un @, miramos si tiene mas de 1
                for (int i = 0; i < id.length(); i++) {
                    char c = id.charAt(i);
                    if (c == '@') {
                        contador++;
                    }
                }
            }
            if (contador < 1) {
                valid = true;
            }
        }
        return valid;
    }

    @Override
    public boolean validPassword(String id, String password){
        //map<hola,123>
        //map<hey,123>
        /*boolean isKeyExists = false;
        if (mapEmail.get(id) == null){ //Si no hay contraseña para ese usuario
            throw new IllegalArgumentException("Correo incorrecto");
        }

        else if (mapEmail.get(id).equals(password)){ //Si la contraseña del usuario coincide con la insertada por el usuario
            isKeyExists = true;
        }
            return isKeyExists;*/
            return true;
    }
}
