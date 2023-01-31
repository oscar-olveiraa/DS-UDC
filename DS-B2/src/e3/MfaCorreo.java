package e3;

import java.util.concurrent.ThreadLocalRandom;

public class MfaCorreo implements MfaStrategy{
   /* String code;
    public MfaCorreo(String code){
        this.code = code;
    }*/

    public static int numeroAleatorioEnRango(int minimo, int maximo) {
        // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }
    @Override
    public String generateCode(){
            int longitud = 5;
            // Carácteres a seleccionar aleatoriamente, en este caso, carácteres en minúsculas
            String banco = "abcdefghijklmnopqrstuvwxyz";
            // Cadena donde añadiremos los carácteres aleatorios
            String cadena = "";

            for (int x = 0; x < longitud; x++) {
                int indiceAleatorio = numeroAleatorioEnRango(0, banco.length() - 1);
                char caracterAleatorio = banco.charAt(indiceAleatorio);
                cadena += caracterAleatorio;
            }
            return cadena;
        }
}


