import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AdicaoImple extends UnicastRemoteObject implements AdicaoInterface {
    protected AdicaoImple() throws RemoteException {
        super();
    }

    public long add(long a, long b) throws RemoteException {
        return a + b;
    }
}