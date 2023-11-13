import java.rmi.Naming;

public class KeyValueStoreServer {
    public KeyValueStoreServer() {
        try {
            KeyValueStore keyValueStore = new KeyValueStoreImpl();
            Naming.rebind("rmi://localhost:1099/KeyValueStoreService", keyValueStore);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new KeyValueStoreServer();
    }
}
