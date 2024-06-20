package exception;

public class EntityAlreadyCreatedException extends DAOException {

    public EntityAlreadyCreatedException(String mensagem) {
        super(mensagem);
    }
}
