import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class AdicaoServer {
    AdicaoServer() {
        try {
            AdicaoInterface c = new AdicaoImple();
            LocateRegistry.createRegistry(3000);
            Naming.rebind("//localhost:3000/AdicaoService", c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AdicaoServer();
    }
}