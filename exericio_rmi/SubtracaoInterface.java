import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SubtracaoInterface extends Remote
{
    public long subtracao(long a, long b) throws RemoteException;
}