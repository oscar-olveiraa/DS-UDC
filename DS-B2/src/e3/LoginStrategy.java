package e3;

public interface LoginStrategy {
    boolean validateId(String id);
    boolean validPassword(String id, String password);
}
