package e3;

public class MfaTelf implements MfaStrategy {
    @Override
    public String generateCode(){
        //Generamos un número aleatorio de 5 dígitos
        int valorEntero = (int) Math.floor(Math.random()*(99999-10000+1)+10000);
        return String.valueOf(valorEntero);
    }

}
