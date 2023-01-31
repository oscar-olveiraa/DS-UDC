package e3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Login{
    CorreoLogin correo = new CorreoLogin();
    TelfLogin telefono = new TelfLogin();
    IdLogin id = new IdLogin();
    MfaCorreo mfaC = new MfaCorreo();
    MfaTelf mfaT = new MfaTelf();
    MfaId mfaI = new MfaId();
    private String id1;
    private String password;
    private LoginStrategy login;
    private MfaStrategy mfa;
    //public HashMap<String, String> user = new HashMap<>();


    public Login (String id1, String password){
        this.id1 = id1;
        this.password = password;
        //user.put(id,password);
        setLoginStrategy(login);
        setMfaStrategy(mfa);
        if(id1.contains("@")){
            setLoginStrategy(correo);
            setMfaStrategy(mfaC);
           // correo.mapEmail.put(id1, password);
        }else if(id1.contains(".")){
            setLoginStrategy(id);
            setMfaStrategy(mfaI);
         //   id.mapId.put(id1,password);
        }else{
            throw new IllegalArgumentException("O id non e correcto");
        }
    }

    private static class User{
        public Map<String, String> mapEmail = new HashMap<>(); //Usuario, contraseña
        public HashMap<String, String> mapId = new HashMap<>();

    }

    public String getId(){
        return id1;
     }

     public String getPassword(){
        return password;
     }

    public LoginStrategy getLogin() {
        return login;
    }

     public void setId(String id1){
        this.id1 = id1;
     }

     public void setPassword(String password){
        this.password = password;
     }

    public void setLoginStrategy(LoginStrategy login){
        this.login = login;
     }

     public void setMfaStrategy(MfaStrategy mfa){
        this.mfa = mfa;
     }

     public String toString(){
        return "";
     }

}
