package e2;

import java.util.Arrays;
public class SocialDistance {


    public static char[][] seatingPeople(char[][] layout) {
        char[][] copia= new char[layout.length][layout.length];

        if(layout==null){
            throw new IllegalArgumentException("A matriz e nula");
        }

        for(int i=0;i< layout.length;i++) {
            for (int j = 0; j < layout.length; j++) {
                if (layout[i].length != layout[i + 1].length && layout[j].length != layout[j + 1].length) {
                    throw new IllegalArgumentException("A matriz e irregular");
                }
            }
        }

        for(int i=0;i< layout.length;i++){
            for(int j=0; j< layout.length; j++){
                if(layout[i][j] != '.' && layout[i][j] != 'A' && layout[i][j] != '#'){
                    throw new IllegalArgumentException("Os elementos son incorrectos");
                }
            }
        }

       /*
        for (int i = 0; i < layout.length; i++) {
            for (int j = 0; j < layout.length; j++) {
                copia[i]=layout[i].clone();
                copia[j]=layout[j].clone();
            }
        }

        for (int i = 0; i < layout.length; i++) {
            for (int j = 0; j < layout.length; j++) {
                if (layout[i][j] == 'A') {
                    copia[i][j] = '#';
                }
            }
        }*/

        return layout;
    }
}

