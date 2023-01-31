package e2;

import java.util.ArrayList;
import java.util.List;

public class Tanques{

    private final String tanque;
    private final String ubicacion;

    private List<Sensores> sensor = new ArrayList<>();

    public Tanques(String tanque, String ubicacion){
        this.tanque = tanque;
        this.ubicacion = ubicacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getTanque() {
        return tanque;
    }

    public void add_sensor(Sensores s) {
        sensor.add(s);
    }
}
