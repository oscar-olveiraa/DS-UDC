package e2;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class TVRealityList implements Iterable<String>{
    public boolean aux;
    List<String> collection = new ArrayList<>();

    TVRealityList(boolean aux){
        this.aux = aux;
    }

    @Override
    public Iterator<String> iterator(){
        if (aux){
            return new RecCircular(collection);
        }else{
            return new RecConRebote(collection);
        }
    }

    public void insertarPersona(String persona) {
        collection.add(persona);
    }
}
