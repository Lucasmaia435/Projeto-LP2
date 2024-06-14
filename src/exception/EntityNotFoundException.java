package exception;

public class EntityNotFoundException extends DatabaseException {
    public EntityNotFoundException(String mensagem) {
        super(mensagem);
    }
}