package e1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Movie {
    private final String title;
    private final float dereitos;

    public HashSet<Doblador> Doblador = new HashSet<>();
    public HashSet<Especialista> Especialista = new HashSet<>();
    public HashSet<Interprete> Interprete = new HashSet<>();
    public HashSet<Musico> Musico = new HashSet<>();
    public HashSet<Productor> Productor = new HashSet<>();
    public HashSet<Guionista> Guionista = new HashSet<>();
    public HashSet<Director> Director = new HashSet<>();

    public List<Equipo> equipo = new ArrayList<>();

    Movie(String title, float dereitos){
        this.title=title;
        this.dereitos=dereitos;
    }


    public void addGuionista(String nome, String apellidos, String dni, int telefono, String nacionalidad, int horas, String state, float dereitos){
        if(state.equals("original") || state.equals("no original")){
            Guionista guionista = new Guionista(nome, apellidos, dni, telefono, nacionalidad, horas, state, dereitos);
            equipo.add(guionista);
        }else{
            throw new IllegalArgumentException("O estado non e correcto");
        }
    }

    public void addDoblador(String nome, String apellidos, String dni, int telefono, String nacionalidad, int horas){
        Doblador doblador = new Doblador(nome, apellidos, dni, telefono, nacionalidad, horas);
        equipo.add(doblador);
    }

    public void addInterprete(String nome, String apellidos, String dni, int telefono, String nacionalidad, int horas, String rol){
        if(rol.equals("protagonist") || rol.equals("secondary") ||rol.equals("extra")){
            Interprete interprete = new Interprete(nome, apellidos, dni, telefono, nacionalidad, horas, rol);
            equipo.add(interprete);
        }else{
            throw new IllegalArgumentException("O rol non e correcto");
        }
    }

    public void addEspecialista(String nome, String apellidos, String dni, int telefono, String nacionalidad, int horas, String scene){
        if(scene.equals("danger") || scene.equals(" ")){
            Especialista especialista = new Especialista(nome,apellidos,dni,telefono,nacionalidad,horas,scene);
            equipo.add(especialista);
        }else{
            throw new IllegalArgumentException("A tipo de escena non e correcta");
        }
    }

    public void addMusico(String nome, String apellidos, String dni, int telefono, String nacionalidad, int horas, float dereitos){
        Musico musico = new Musico(nome, apellidos, dni, telefono, nacionalidad,horas, dereitos);
        equipo.add(musico);
    }

    public void addProductor(String nome, String apellidos, String dni, int telefono, String nacionalidad, int horas, float dereitos){
        Productor productor = new Productor(nome, apellidos, dni, telefono, nacionalidad, horas, dereitos);
        equipo.add(productor);
    }

    public void addDirector(String nome, String apellidos, String dni, int telefono, String nacionalidad, int horas, int ano, float dereitos){
        if(ano>=0) {
            Director director = new Director(nome, apellidos, dni, telefono, nacionalidad, horas, ano, dereitos);
            equipo.add(director);
        }else{
            throw new IllegalArgumentException("O numero de anos e negativo");
        }
    }

    public float SalarioTotal(){
        int salarioT = 0;
        float aux;

        for(Equipo a : equipo){
            aux =  a.getSalario() + a.getSalarioA();
            salarioT += aux;
        }
        return salarioT;
    }

    public String printRoyalties(){
        StringBuilder recompensa = new StringBuilder();
        String royalty;
        if(equipo.isEmpty()){
            royalty = "Non hai membros no equipo";
        }else{
            for(Equipo e : equipo){
                royalty = e.getRoyalties();
                recompensa.append(royalty);
                recompensa.append("\n");
            }
            royalty=recompensa.toString();
        }
        return royalty;
    }

    public String printSalaries(){
        StringBuilder salaries = new StringBuilder();
        String salario;
        float salarioT;
        if(equipo.isEmpty()){
            salario = "Non hai membros no equipo";
        }else{
            for (Equipo e : equipo){
                salario = e.getSalarios();
                salaries.append(salario);
                salaries.append("\n");
            }
            salarioT = SalarioTotal();
            salaries.append("The total payroll for Alcarras is ");
            salaries.append(salarioT);
            salaries.append(" euro");

            salario = salaries.toString();
        }
        return salario;
    }

}
