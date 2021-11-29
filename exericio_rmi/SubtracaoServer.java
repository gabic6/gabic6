import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class SubtracaoServer {
    SubtracaoServer() {
        try {
            SubtracaoInterface c = new SubtracaoImple();
            LocateRegistry.createRegistry(3001);
            Naming.rebind("//localhost:3001/SubtracaoService", c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SubtracaoServer();
    }
}