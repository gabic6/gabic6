import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SubtracaoImple extends UnicastRemoteObject implements SubtracaoInterface {
    protected SubtracaoImple() throws RemoteException {
        super();
    }

    public long subtracao(long a, long b) throws RemoteException {
        return a - b;
    }
}