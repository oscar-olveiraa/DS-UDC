package e2;

public class Sensores extends Subject_sensores {

    private String parametro;
    private double valor;
    static Tanques tanque;


    //Constructor
    public Sensores (String parametro, double valor, Tanques tanque){
        this.parametro = parametro;
        this.valor = valor;
        Sensores.tanque = tanque;
    }

    public double getValor() {return valor;}

    public String getParametro() {
        return parametro;
    }

    public String getUbi(){
        return tanque.getUbicacion();
    }

    public String getNombreT(){
        return tanque.getTanque();
    }

    public void setValor(double valor) {
        this.valor = valor;
        notifyObservers();
    }
}
