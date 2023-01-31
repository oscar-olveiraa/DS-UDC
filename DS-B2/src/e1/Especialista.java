package e1;

public class Especialista extends Artistas{
    private String scene;
    String c;//determina si ten ou no escenas peligrosas

    public Especialista(String nome, String apellidos, String dni, int telefono, String nacionalidad, int horas, String scene) {
        super(nome, apellidos, dni, telefono, nacionalidad, horas);
        this.setScene(scene);
        this.setJob(1);
        if(scene.equals("danger")){
            this.setSalario(3);
        }else{
            this.setSalario(2);
        }
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    @Override
    public String getSalarios(){
        StringBuilder datos = new StringBuilder();
        datos.append(this.getNome() + " " + this.getApellidos() + " (Stunt " + this.getJob() + (c=(scene.equals("danger"))?" with ":"without ") + "extra for " +
                this.getScene() + "): " + this.getSalario() + " euro");
        String data = datos.toString();
        return data;
    }
}
