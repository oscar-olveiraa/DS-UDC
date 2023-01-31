package e1;

public class Doblador extends Artistas {

    public Doblador(String nome, String apellidos, String dni, int telefono, String nacionalidad, int horas) {
        super(nome, apellidos, dni, telefono, nacionalidad, horas);
        this.setSalario(7);
        this.setJob(4);
    }

    @Override
    public String getSalarios(){
        StringBuilder datos = new StringBuilder();
        datos.append(this.getNome() + " " + this.getApellidos() + " (" + this.getJob() + "): "
                + this.getSalario() + " euro");
        String data = datos.toString();
        return data;
    }
}
