package e1;

public class Equipo {
    private final String nome;
    private final String apellidos;
    private final String dni;
    private final int telefono;
    private final String nacionalidad;
    private int horas;
    private String job;
    private int salario;

    public Equipo(String nome, String apellidos, String dni, int telefono, String nacionalidad, int horas){
        this.nome=nome;
        this.apellidos=apellidos;
        this.dni=dni;
        this.telefono=telefono;
        this.nacionalidad=nacionalidad;
        this.horas=horas;
    }

    public String getNome(){
        return nome;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDni() {return dni;}

    public int getTelefono(){
        return telefono;
    }

    public String getNacionalidad(){
        return nacionalidad;
    }

    public int getHoras(){
        return horas;
    }

    public String getJob() {
        return job;
    }

    public String getRoyalties(){
        return "";
    }

    public String getSalarios(){
        return "";
    }

    public float getSalario(){
        return salario;
    }

    public int getSalarioA(){
        return 0;
    }

    public void setSalario(int cargo) {
        if (cargo==0) {//interpretes
            this.salario = horas * 200;
        } else if (cargo==1){//interpretes protagonistas
            this.salario  = (horas * 200)*3;
        } else if (cargo==2){//especialista
            this.salario  = horas * 40;
        } else if (cargo==3){//especialista con escena peligrosa
            this.salario  = (horas * 40) + 1000;
        } else if (cargo==4){//guionista
            this.salario  = horas * 70;
        } else if (cargo==5){//guionista guion original
            this.salario  = (horas * 70) + 4000;
        } else if (cargo==6){//musico
            this.salario  = horas * 60;
        } else if (cargo==7){//dobladores
            this.salario  = horas * 20;
        }else if (cargo==8){//productor
            this.salario  = horas * 90;
        }else if (cargo==9){//director
            this.salario  = horas * 100;
        }
    }

    public void setJob(int cargo) {
        if (cargo==0) {//interpretes
            this.job = "Actor";
        } else if (cargo==1){//especialista
            this.job = "performer";
        } else if (cargo==2){//guionista
            this.job = "Screenwriter";
        } else if (cargo==3){//musico
            this.job = "Musician";
        } else if (cargo==4){//dobladores
            this.job = "Dubber";
        } else if (cargo==5){//productor
            this.job = "Producer";
       } else if (cargo==6){//director
            this.job= "Director";
        }
    }
}
