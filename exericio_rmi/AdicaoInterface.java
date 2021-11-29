import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface da operação de adição
 */
public interface AdicaoInterface extends Remote {
    public long add(long a, long b) throws RemoteException;
}