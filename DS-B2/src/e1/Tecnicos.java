package e1;

public class Tecnicos extends Equipo {
    private float recaudacion;

    public Tecnicos(String nome, String apellidos, String dni, int telefono, String nacionalidad, int horas, float recaudacion) {
        super(nome, apellidos, dni, telefono, nacionalidad, horas);
        this.recaudacion=recaudacion;
    }

    public float getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(int cargo) {
        if (cargo == 0) {//Guionista
            this.recaudacion *= 0.05;
        } else if (cargo == 1){//Director
            this.recaudacion *=0.05;
        } else if (cargo== 2){//Musico
            this.recaudacion *=0.04;
        }else if (cargo == 3){//Productor
            this.recaudacion*=0.02;
        }
    }

}
