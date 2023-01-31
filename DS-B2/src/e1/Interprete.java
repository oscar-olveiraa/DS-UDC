package e1;

public class Interprete extends Artistas {
    private String rol;

    public Interprete(String nome, String apellidos, String dni, int telefono, String nacionalidad, int horas, String rol) {
        super(nome, apellidos, dni, telefono, nacionalidad, horas);
        this.setRol(rol);
        this.setJob(0);
        if(rol.equals("protagonist")){
            this.setSalario(1);
        }else if(rol.equals("secondary") || rol.equals("extra")){
            this.setSalario(0);
        }else{
            throw new IllegalArgumentException("Rol incorrecto");
        }

    }

    public String getRol(){
        return rol;
    }

    public void setRol(String rol){
        this.rol=rol;
    }

    @Override
    public String getSalarios(){
        StringBuilder datos = new StringBuilder();
        datos.append(this.getNome() + " " + this.getApellidos() + " (" + this.getJob() + " "  + this.getRol() + "): "
                + this.getSalario() + " euro");
        String data = datos.toString();
        return data;
    }
}
