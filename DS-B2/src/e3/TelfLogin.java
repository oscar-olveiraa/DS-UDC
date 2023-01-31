package e3;

import java.util.HashMap;

public class TelfLogin implements LoginStrategy {
    public HashMap<String, String> mapTelf = new HashMap<>();

    /*public TelfLogin(String id, String password) {
        super(id, password);
    }*/

    @Override
    public boolean validateId(String telefono) {
        //Si es un teléfono no valido
        if (telefono == null || telefono.length()!=9){
            return false;
        }
        //Comprobamos si es un teléfono válido
        for (int i = 0; i < telefono.length(); i++){
            char c = telefono.charAt(i);
            if (c < '0' || c > '9'){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean validPassword(String telefono, String password) {
        boolean isKeyExists = false;
        //Si no hay contraseña para ese usuario
        if (mapTelf.get(telefono) == null){
            throw new IllegalArgumentException("Teléfono incorrecta");
        }
        //Si la contraseña del teléfono coincide con la insertada por el usuario del telefono
        else if (mapTelf.get(telefono).equals(password)){
            isKeyExists = true;
        }
        return isKeyExists;
    }
}

