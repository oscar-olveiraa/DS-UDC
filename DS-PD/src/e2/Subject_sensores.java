package e2;
import java.util.*;
public abstract class Subject_sensores{
    private List<ObserverS> observerS = new ArrayList<>();

    public void attach(ObserverS oS) {
        observerS.add(oS);
    }
    public void detach(ObserverS oS) {
        observerS.remove(oS);
    }

    public void notifyObservers(){
        for (ObserverS oS : observerS){
            oS.update(this);
        }
    }
}
