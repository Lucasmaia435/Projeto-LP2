package exception;

public class EntityNotFoundDAOException extends DAOException {
    EntityNotFoundException databaseException;

    public EntityNotFoundDAOException(String mensagem) {
        super(mensagem);
    }
}
