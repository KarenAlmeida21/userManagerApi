package exceptions;

public class UserInexistente extends  RuntimeException{
    public UserInexistente(String message){
        super(message);
    }
}
