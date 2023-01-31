package e2;

import java.util.*;

public abstract class Subject_alertas {
    private List<ObserverA> observerA = new ArrayList<>();
    public void attach(ObserverA oA){
        observerA.add(oA);
    }

    public void detach(ObserverA oA){
        observerA.remove(oA);
    }

    public void notifyObservers(){
        for(ObserverA oA : observerA){
            oA.update(this);
        }
    }
}
